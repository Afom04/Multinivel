package vista;

import controlador.Mascota;
import modelo.modelMascota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class frmPrincipal {
    private JPanel ventanaPrincipal;
    private JTabbedPane panelGrupo;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JFormattedTextField txtAnalisis;
    private JTextField txtEdad;
    private JButton btnGuardar;
    private JTextField txtId;
    private JTextField txtNombreOwner;
    private JTextField txtCelular;
    private JTextField txtEmail;
    private JTextField txtIdEdit;
    private JButton btnConsultarEdit;
    private JTextField txtNombreMascotaEdit;
    private JTextField txtEdadEdit;
    private JTextField txtDescripcionEdit;
    private JTextField txtAnalisisEdit;
    private JTextField txtNombreOwnerEdit;
    private JTextField txtCelularEdit;
    private JTextField txtEmailEdit;
    private JButton btnEditar;
    private JTextField txtIdEliminar;
    private JButton btnEliminar;
    private JList lstMascotas;
    private JTable tabla;

    //ATRIBUTOS GENERALES
    LinkedList<Mascota> mascotaLista = new LinkedList<>();
    modelMascota mdMascota = new modelMascota();
    Mascota mascota;


    public frmPrincipal() {
        this.mascotaLista = mdMascota.listaMascota();
        this.listaMascota();


        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(txtId.getText().equals("") || txtNombre.getText().equals("") || txtEdad.getText().equals("") || txtDescripcion.getText().equals("") || txtAnalisis.getText().equals("") || txtNombreOwner.getText().equals("") || txtCelular.getText().equals("") || txtEmail.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "TODOS LOS DATOS SON OBLIGATORIOS");
                    }else{
                        //VALIDACION ID
                        mascota = mdMascota.validarId(txtId.getText());
                        if(mascota != null){
                            JOptionPane.showMessageDialog(null, "El ID " + txtId.getText() + " ya existe y le pertenece a: \n" +mascota.getNombreMascota());
                        }else {
                            if(mdMascota.crearMascota(Integer.valueOf(txtId.getText()), txtNombre.getText(), Integer.valueOf(txtEdad.getText()), txtDescripcion.getText(), txtAnalisis.getText(), txtNombreOwner.getText(), txtCelular.getText(), txtEmail.getText())) {

                                JOptionPane.showMessageDialog(null, "Mascota agregada exitosamente: \n" + txtNombre.getText());

                                txtId.setText("");
                                txtNombre.setText("");
                                txtEdad.setText("");
                                txtDescripcion.setText("");
                                txtAnalisis.setText("");
                                txtNombreOwner.setText("");
                                txtCelular.setText("");
                                txtEmail.setText("");
                                actVistaMascota();
                            }else{
                                JOptionPane.showMessageDialog(null, "Mascota NO guardado, intente de nuevo: \n" + txtNombre.getText());
                            }
                        }
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Error en el ingreso de datos");
                    System.out.println("Error: " + exception.getMessage());
                }
            }
        });
        btnConsultarEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascota = mdMascota.consultaMascotaId(txtIdEdit.getText());

                if(mascota != null){
                    txtNombreMascotaEdit.setText(mascota.getNombreMascota());
                    txtEdadEdit.setText(String.valueOf(mascota.getEdad()));
                    txtDescripcionEdit.setText(mascota.getDescripcion());
                    txtAnalisisEdit.setText(mascota.getAnalisisConsulta());
                    txtNombreOwnerEdit.setText(mascota.getNombreOwner());
                    txtCelularEdit.setText(mascota.getCelular());
                    txtEmailEdit.setText(mascota.getEmail());
                }else{
                    JOptionPane.showMessageDialog(null, "Mascota NO existente");
                    txtNombreMascotaEdit.setText("");
                    txtEdadEdit.setText("");
                    txtDescripcionEdit.setText("");
                    txtAnalisisEdit.setText("");
                    txtNombreOwnerEdit.setText("");
                    txtCelularEdit.setText("");
                    txtEmailEdit.setText("");
                }
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if(txtNombreMascotaEdit.getText().equals("") || txtEdadEdit.getText().equals("") || txtDescripcionEdit.getText().equals("") || txtAnalisisEdit.getText().equals("") || txtNombreOwnerEdit.getText().equals("") || txtCelularEdit.getText().equals("") || txtEmailEdit.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"TODOS LOS DATOS SON OBLIGATORIOS");
                    }else{
                        if(mdMascota.editarMascota(Integer.valueOf(txtIdEdit.getText()), txtNombreMascotaEdit.getText(), Integer.valueOf(txtEdadEdit.getText()), txtDescripcionEdit.getText(), txtAnalisisEdit.getText(), txtNombreOwnerEdit.getText(), txtCelularEdit.getText(), txtEmailEdit.getText())){
                            JOptionPane.showMessageDialog(null, "Mascota editada correctamente: \n" + txtNombreMascotaEdit.getText());

                            txtIdEdit.setText("");
                            txtNombreMascotaEdit.setText("");
                            txtEdadEdit.setText("");
                            txtDescripcionEdit.setText("");
                            txtAnalisisEdit.setText("");
                            txtNombreOwnerEdit.setText("");
                            txtCelularEdit.setText("");
                            txtEmailEdit.setText("");
                            actVistaMascota();
                        }else {
                            JOptionPane.showMessageDialog(null, "Mascota NO guardado, intente de nuevo: \n" + txtNombre.getText());
                        }
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "ERROR AL EDITAR LOS DATOS");
                }

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirmacion = JOptionPane.showConfirmDialog(null, "Dese eliminar la Mascota con Id:\n" +  txtIdEliminar.getText());

                System.out.println("Confirmacion: " + confirmacion);

                if(confirmacion == JOptionPane.YES_OPTION){
                    if(mdMascota.eliminarMascota(txtIdEliminar.getText())){
                        JOptionPane.showMessageDialog(null,"Mascota Eliminada Correctamente!");
                        txtIdEliminar.setText("");
                        actVistaMascota();
                    }else {
                        JOptionPane.showMessageDialog(null,"Mascota No Existente");
                        txtIdEliminar.setText("");
                    }
                }else {
                    if(confirmacion == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Mascota No Eliminada");
                        txtIdEliminar.setText("");
                    }
                }
            }
        });
    }


    //MOSTRAR LISTA DE EMPLEADOS EN LA VISTA
    private void listaMascota(){
        DefaultListModel model = new DefaultListModel();

        int index = 0;
        for(Mascota mascota : mascotaLista){
            String data = (index + 1) + ") ID: " + mascota.getId() + " - Nombre: " + mascota.getNombreMascota() + " - Edad: " + mascota.getEdad();
            model.add(index, data);
            index++;
        }
        lstMascotas.setModel(model);
    }

    private void actVistaMascota(){
        this.mascotaLista = mdMascota.listaMascota();
        this.listaMascota();
    }

    public JPanel getVentanaPrincipal() {
        return ventanaPrincipal;
    }

}
