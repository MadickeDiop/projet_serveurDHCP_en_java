/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myappliserverdhcp;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Madickeb Diop
 */
public class Adresse {
    private String add;
    private String mask;
    private String pass;
     boolean prise;

    public Adresse(String add, String mask, String pass, boolean prise) {
        this.add = add;
        this.mask = mask;
        this.pass = pass;
        this.prise = prise;
    }

    public Adresse(){
        
    }
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isPrise() {
        return prise;
    }

    public void setPrise(boolean prise) {
        this.prise = prise;
    }
    
    
    public void test(){
        String a="Je vais à lecole";
        //StringTokenizer st=new StringTokenizer(a);
        String[] l=a.split(" ");
        System.out.println(l[0]);
        System.out.println(l[1]);
    }
    
    public static void main(String[] a){
        new Adresse().test();
    }
}
