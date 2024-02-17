package conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import modelos.flujo.ObjetoDato;
import modelos.flujo.recepcion.RecepcionDatos;

public class ConexionCliente {

    private static Socket socketCliente = null;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    public static void cerrarPrograma() {
        try {
            out.close();
            in.close();
            socketCliente.close();
        } catch (IOException ex1) {

        } 
    }

    public static void enviarObjeto(ObjetoDato objetoDato) {
        try {
            out.writeObject(objetoDato);
            out.flush();
        } catch (IOException ex) {
            cerrarPrograma();
            System.exit(0);
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
            cerrarPrograma();
            System.exit(0);
        }

        new Thread(() -> {
            while (true) {
                // Recibir objeto del servidor
                ObjetoDato objetoRecibido;
                try {
                    objetoRecibido = (ObjetoDato) in.readObject();
                    RecepcionDatos.gestionarDatos(objetoRecibido);
                } catch (Exception ex) {
                    cerrarPrograma();
                    System.exit(0);

                }
            }
        }).start();

    }

}
