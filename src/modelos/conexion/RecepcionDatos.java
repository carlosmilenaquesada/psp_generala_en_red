package modelos.conexion;

import static controladores.ClavesEnvio.*;
import modelos.Dado;
import modelos.Jugador;
import vistas.Main;

public class RecepcionDatos {

    private ObjetoDato objetoDato;

    public RecepcionDatos() {
        this.objetoDato = null;
    }

    public void recibirDatos(ObjetoDato objetoDato) {
        this.objetoDato = objetoDato;
    }

    public void gestionarDatosRecibidos() {
        String clave = this.objetoDato.getClave();
        switch (clave) {
            case DADOS:
                Dado[] dados = (Dado[]) this.objetoDato.getValor();
                Main.getPrincipalJFrame().setDados(dados);
                break;
            case PREVIA_PUNTOS:
                int[][] puntosPrevios = (int[][]) this.objetoDato.getValor();                
                int[] puntosInferiorPrevios = puntosPrevios[0];
                int[] puntosSuperiorPrevios = puntosPrevios[1];
                Main.getPrincipalJFrame().actualizarPuntosPreviosRemoto(puntosInferiorPrevios, puntosSuperiorPrevios);
                break;
            case JUGADOR:
                Jugador jugador = (Jugador) this.objetoDato.getValor();
                
                break;
            default:
                throw new AssertionError();
        }

    }
}
