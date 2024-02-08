package conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.flujo.ObjetoDato;
import modelos.flujo.recepcion.RecepcionDatos;

public class ConexionCliente {

    private static Socket socketCliente = null;

    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    public static void enviarObjeto(ObjetoDato objetoDato) {
        try {

            out.writeObject(objetoDato);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static void main(String[] args) {
        String hostServidorRemoto = "localhost";
        int puertoServidorRemoto = 10000;

        try {
            socketCliente = new Socket(hostServidorRemoto, puertoServidorRemoto);
            // Streams de objetos para enviar y recibir objetos
            out = new ObjectOutputStream(socketCliente.getOutputStream());
            in = new ObjectInputStream(socketCliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Código del cliente
        /*new Thread(new Runnable() {
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
                        
                    }
                }
            }).start();*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // Recibir objeto del servidor
                    ObjetoDato objetoRecibido;
                    try {
                        objetoRecibido = (ObjetoDato) in.readObject();
                        RecepcionDatos.gestionarDatos(objetoRecibido);
                    } catch (Exception ex) {
                        Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ).start();

    }
}
