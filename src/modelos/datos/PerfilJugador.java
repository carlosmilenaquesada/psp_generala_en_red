package modelos.datos;

import java.io.Serializable;

public class PerfilJugador implements Serializable{
    private int idImagenPerfil;
    private String nombreJugador;

    public PerfilJugador(int idImagenPerfil, String nombreJugador) {
        this.idImagenPerfil = idImagenPerfil;
        this.nombreJugador = nombreJugador;
    }

    public int getIdImagenPerfil() {
        return idImagenPerfil;
    }

    public void setIdImagenPerfil(int idImagenPerfil) {
        this.idImagenPerfil = idImagenPerfil;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
}
