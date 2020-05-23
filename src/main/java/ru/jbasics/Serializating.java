/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.yanchenko
 */
public class Serializating {
    
    Serialize srl;

    public void doSerialize(Serialize srl) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("temp.out");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file !");
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.writeObject(srl);
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Serialize deSerialize() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("temp.out");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        Serialize srl = null;
        try {
            srl = (Serialize) oin.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializating.class.getName()).log(Level.SEVERE, null, ex);
        }
        return srl;
    }
    
    public Serializating() {
        doSerialize(new Serialize());
        srl = deSerialize();
        System.out.println("x = " + srl.x);
    }
}

// Class to be serialized and deserialized.
class Serialize implements Serializable {

    int x = 0;
    String str = "Hello";
}
