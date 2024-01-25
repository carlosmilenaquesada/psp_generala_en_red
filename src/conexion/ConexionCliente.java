package conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.flujo.EmisionDatos;

public class ConexionCliente {

    private static Socket socketCliente = null;

    public static void main(String[] args) {
        String hostServidorRemoto = "localhost";
        int puertoServidorRemoto = 10000;

        try {
            socketCliente = new Socket(hostServidorRemoto, puertoServidorRemoto);
            System.out.println("Conexión establecida con el servidor.");

            // Streams de objetos para enviar y recibir mensajes
            ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());

            // Enviar un mensaje al servidor
            String mensaje = "Hola, soy el cliente.";

            // Código del cliente
            while (true) {
                // Enviar objeto al servidor
                out.writeObject(mensaje);
                out.flush();

                // Recibir objeto del servidor
                String objetoRecibido = (String) in.readObject();

                // Realizar acciones con el objeto recibido
                System.out.println("Mensaje recibido del servidor: " + objetoRecibido);
                Thread.sleep(1000);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
