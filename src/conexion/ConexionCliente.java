package conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.flujo.ObjetoDato;
import modelos.flujo.RecepcionDatos;

public class ConexionCliente {

    private static Socket socketCliente = null;
    public static ObjetoDato objetoDato;

    public static void main(String[] args) {
        String hostServidorRemoto = "localhost";
        int puertoServidorRemoto = 10000;

        try {
            socketCliente = new Socket(hostServidorRemoto, puertoServidorRemoto);
            System.out.println("Conexión establecida con el servidor.");

            // Streams de objetos para enviar y recibir mensajes
            ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());

            // Código del cliente
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (ConexionCliente.objetoDato != null) {
                            try {
                                // Enviar objeto al servidor                                
                                out.writeObject(ConexionCliente.objetoDato);
                                out.flush();
                                ConexionCliente.objetoDato = null;
                            } catch (Exception ex) {
                                Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("esperando datos");
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        // Recibir objeto del servidor
                        ObjetoDato objetoRecibido;
                        try {
                            System.out.println("recepcion objeto");
                            objetoRecibido = (ObjetoDato) in.readObject();
                            // Realizar acciones con el objeto recibido
                            System.out.println("Objeto recibido del servidor: " + objetoRecibido);
                            RecepcionDatos.gestionarDatos(objetoRecibido);
                        } catch (Exception ex) {
                            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            ).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
