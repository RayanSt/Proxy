/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author bparr
 */
public class ConexionB implements Iconexion{

    @Override
    public Conexion Conectar(Conexion conexion) {
        conexion.setPUERTO(5500);
		System.out.println("Nuevo PUERTO: " + conexion.getPUERTO());
		return conexion;
    }
    
}
