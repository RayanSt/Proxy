package proxy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        
        Conexion c = Conexion.getInstace("192.168.0.14", 5000);
		
		Iconexion conexionProxy = new ConexionProxy((Iconexion) new ConexionB());
		conexionProxy.Conectar(c);

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        BufferedReader entrada;

        //puerto de nuestro servidor
        int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket( PUERTO);
            System.out.println("servidor");
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Leo el mensaje que me envia
//                String mensaje = in.readUTF();
//
//                System.out.println(mensaje);
                //Le envio un mensaje
                Scanner a = new Scanner(System.in);
                double entero;
                do{
                out.writeUTF(a.nextLine());
                String num1 = in.readUTF();
                
                System.out.println("hola");
                entero = Double.valueOf(num1);

                }while(entero!=0);

                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
