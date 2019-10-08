/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Madickeb Diop
 */
public class ReceiveMessage extends Thread {
    String msg="";
    DataInputStream dis= null;
    JTextArea txt_area= null;
    
        
    
    public  ReceiveMessage(DataInputStream d, JTextArea a){
        
           this.dis= d;
           this.txt_area= a;
           
           
}
    public void run(){
      
          while(true){
               try {
                   
                   
                   msg =dis.readUTF();
                   txt_area.append("\n"+this.getName()+msg);
                   
                   
                   
               } catch (IOException ex) {
                  Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
          
          
}
}
