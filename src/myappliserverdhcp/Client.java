/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.awt.Color;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Madickeb Diop
 */
public class Client extends javax.swing.JFrame {
    
    Socket server=null;
    

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        btn_connect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_recMsg = new javax.swing.JTextArea();
        btn_receive = new javax.swing.JButton();
        txt_msg = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(null);

        btn_connect.setText("se connecter");
        btn_connect.setBackground(Color.green);
        btn_connect.setOpaque(true);
        btn_connect.setBorderPainted(false);
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });
        getContentPane().add(btn_connect);
        btn_connect.setBounds(24, 71, 100, 23);

        txt_recMsg.setColumns(20);
        txt_recMsg.setRows(5);
        jScrollPane1.setViewportView(txt_recMsg);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 164, 413, 131);

        btn_receive.setText("recevoir");
        btn_receive.setBackground(Color.green);
        btn_receive.setOpaque(true);
        btn_receive.setBorderPainted(false);
        btn_receive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_receiveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_receiveMouseEntered(evt);
            }
        });
        btn_receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_receiveActionPerformed(evt);
            }
        });
        btn_receive.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btn_receivePropertyChange(evt);
            }
        });
        getContentPane().add(btn_receive);
        btn_receive.setBounds(511, 211, 80, 23);

        txt_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_msgActionPerformed(evt);
            }
        });
        getContentPane().add(txt_msg);
        txt_msg.setBounds(10, 394, 273, 30);

        btn_send.setText("envoyer");
        btn_send.setBackground(Color.green);
        btn_send.setOpaque(true);
        btn_send.setBorderPainted(false);
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });
        getContentPane().add(btn_send);
        btn_send.setBounds(511, 393, 80, 23);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Client_DHCP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(201, 0, 240, 43);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myappliserverdhcp/téléchargement.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 610, 440);

        setBounds(0, 0, 627, 482);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        try {
            // TODO add your handling code here:
            server=new Socket("127.0.0.1",2000);
            JOptionPane.showMessageDialog(null,"demande de connexion ");
            DataOutputStream dos= null;
            DataInputStream dis= null;
            dis= new DataInputStream(server.getInputStream());
            dos=new DataOutputStream(server.getOutputStream());
            
            ReceiveMessage serverThread2= new ReceiveMessage(dis,txt_recMsg);
            serverThread2.setDaemon(true);
            serverThread2.setName(" DHCPACK: demande acceptée");
            serverThread2.start(); 
            
             ReceiveMessage clientThread1 =new ReceiveMessage(dis,txt_recMsg);
            clientThread1.setDaemon(true);            
             ArrayList<Adresse> a=new Test2().liste();
             for(int i=0;i<a.size();i++){
                
            clientThread1.setName("DHCPOFFER:\n"+a.get(i).getAdd()+" "+a.get(i).getMask()+" "+a.get(i).getPass()+"\n\n\n");
            
                               //clientThread1.start();
            
                         
                           }   
              clientThread1.start();
            
            
            
            
           
            

            
           


            
             
            
            
            
                        
            
                       
            
                         
                                                  

            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"La connexion a échouée");
            
        }
        
        
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_receiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_receiveActionPerformed
        // TODO add your handling code here:
        DataInputStream dis= null;
        try {
            dis= new DataInputStream(server.getInputStream());
            String msg = dis.readUTF();
            txt_recMsg.append("\n"+msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

      
        
        
        
    }//GEN-LAST:event_btn_receiveActionPerformed

    private void txt_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_msgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_msgActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        // TODO add your handling code here:
        
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(server.getOutputStream());
            dos.writeUTF(txt_msg.getText());
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_receiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_receiveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_receiveMouseClicked

    private void btn_receiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_receiveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_receiveMouseEntered

    private void btn_receivePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btn_receivePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_receivePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
                new Client().setTitle("ClientDHCP");
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_receive;
    private javax.swing.JButton btn_send;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_msg;
    private javax.swing.JTextArea txt_recMsg;
    // End of variables declaration//GEN-END:variables

    private void setPrise(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

