import vista.frmPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Programa Veterinaria");
        frmPrincipal miPrograma = new frmPrincipal();
        frame.setContentPane(miPrograma.getVentanaPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,500);
        frame.setVisible(true);
    }
}