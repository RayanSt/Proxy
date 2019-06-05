/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bparr
 */
public class Conexion {
    
Scanner cc = new Scanner(System.in);
private int PUERTO;
private String HOST;
DataInputStream in;
DataOutputStream out;

private static Conexion miconexion;

public  static Conexion getInstace(String HOST, int PUERTO) {
 if (miconexion==null) {
 miconexion = new Conexion(HOST,PUERTO);
 }
 return miconexion;
 }
    
private Conexion(String HOST, int PUERTO) {
        this.HOST = HOST;
        //Puerto del servidor
        this.PUERTO = PUERTO;
        cc.useDelimiter("\n");
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public String getHOST() {
        return HOST;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public Scanner getCc() {
        return cc;
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }
    
    

    
   
    
}
