package modelos.conexion;

import static controladores.ClavesEnvio.*;
import modelos.Dado;
import modelos.Jugador;

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
                
                break;
            case PREVIA_PUNTOS_SUPERIOR:
                int[] puntosSuperiorPrevios = (int[]) this.objetoDato.getValor();
                
                break;
            case PREVIA_PUNTOS_INFERIOR:
                int[] puntosInferiorPrevios = (int[]) this.objetoDato.getValor();
                
                break;
            case JUGADOR:
                Jugador jugador = (Jugador) this.objetoDato.getValor();
                
                break;
            default:
                throw new AssertionError();
        }

    }
}
