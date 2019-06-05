/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.logging.Logger;

/**
 *
 * @author bparr
 */
public class ConexionProxy implements Iconexion {
    
    

    private Iconexion cuentaReal;
	private final static Logger LOGGER = Logger.getLogger(ConexionProxy.class.getName());

	public ConexionProxy(Iconexion cuentaReal) {
		this.cuentaReal = cuentaReal;
	}	

    @Override
    public Conexion Conectar(Conexion conexion) {
        LOGGER.info("----Conexion Proxy - Conectar----");
		if (cuentaReal == null) {
			cuentaReal = (Iconexion) new ConexionA();
			return cuentaReal.Conectar(conexion);
		} else {
			return cuentaReal.Conectar(conexion);
		}
    }
    
    
}
