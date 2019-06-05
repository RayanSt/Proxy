package proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        //Host del servidor
        
        //Puerto del servidor
        Conexion a = Conexion.getInstace(null, 0);

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(a.getHOST(), a.getPUERTO());
            System.out.println("cliente");

            a.setIn(new DataInputStream(sc.getInputStream()));
            a.setOut(new DataOutputStream(sc.getOutputStream()));

            //Recibo el mensaje del servidor
            //recibo el mensaje ""envieme un numero para hacer una operacion
            String mensaje = a.getIn().readUTF();
            System.out.println(mensaje);
            String num1 = a.getCc().nextLine();
            a.getOut().writeUTF(num1);
            //recibo mensaje de digita una opcion para haer la operacion
            String men = a.getIn().readUTF();
            System.out.println(men);
            String opc = a.getCc().nextLine();
            a.getOut().writeUTF(opc);
            //recibo el resultado de la operacion
            String resultado = a.getIn().readUTF();
            

           

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
