/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Madickeb Diop
 */
public class IP {
    
    // cette classe permette d'afficher toutes  les @ip qui sont en ligne 
	
	public static void main(String[] args) throws IOException {
        InetAddress localhost = InetAddress.getLocalHost();
        // this code assumes IPv4 is used   
        byte[] ip = localhost.getAddress();
        for (int i = 1; i <= 254; i++)
        {
            ip[3] = (byte)i;
            InetAddress address = InetAddress.getByAddress(ip);
            
            System.out.println(address+"/255.255.255.0");
    
        }
        }
    
    
}
