/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serpientesyescaleras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Andrey Orozco
 */
public class Vista extends JFrame implements ActionListener{
    JLabel casillas[]=new JLabel[64];
    Color casilla,jugador1,jugador2,fondo;
    JButton movimiento;
    int dado1,dado2, player;
    public Vista(){
        super("Serpientes y Escaleras");
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero();
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);
        
    }
    public void tablero(){
        casilla=new Color(0,152,70);
        fondo=new Color(237,182,111);
        jugador1=new Color(128,57,30);
        jugador2=new Color(10,95,252,255);
        movimiento= new JButton("LANZAR");
        for(int i=0;i<64;i++){
          casillas[i]=new JLabel(String.valueOf(i+1));
        }
        this.setLayout(null);
        int x=20,y=560;
        for(int i=0;i<64;i++){
          casillas[i].setBounds(x,y,60,60);
          casillas[i].setOpaque(true);
          casillas[i].setBackground(casilla);
          this.add(casillas[i]);
          /*if((i+1)<9 || (i+1)>17 || (i+1)>33 || (i+1)>49){ 
            x+=70;
          }else if((i+1)>9 || (i+1)>25 || (i+1)>41 || (i+1)>57){
            x-=70;
          }*/
          x+=70;
          if((i+1)%8==0){
            x=20;
            y-=70;  
           /* if((i+1)==16 || (i+1)==32 || (i+1)==48){
              x=20;
            }*/
          }
          }
        movimiento.setBounds(650, 150, 100, 100);
        movimiento.addActionListener(this);
        this.add(movimiento);
        }

    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==movimiento){
            dado1=(int)((Math.random())*6)+1;
            dado2=(int)((Math.random())*6)+1;
            String lanzamiento1= String.valueOf(dado1);
            String lanzamiento2=String.valueOf(dado2);
            String lanzamiento="El valor de los dados es "+lanzamiento1+"  "+lanzamiento2;
            JOptionPane.showMessageDialog(null, lanzamiento);
            
        }
    }
}