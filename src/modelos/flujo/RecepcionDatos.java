package modelos.flujo;


public class RecepcionDatos {

    private ObjetoDato objetoDato;

    public RecepcionDatos() {
        this.objetoDato = null;
    }

    public void gestionarDatosRecibidos() {
        String clave = this.objetoDato.getClave();
        switch (clave) {
            case ObjetoDato.DATOS_PARTIDA:
                DatosPartida datosPartida = (DatosPartida) this.objetoDato.getValor();
                
                break;
            case ObjetoDato.MENSAJE_CHAT:
                MensajeChat mensajeChat = (MensajeChat) this.objetoDato.getValor();
               
                break;

            default:
                throw new AssertionError();
        }

    }

    public ObjetoDato getObjetoDato() {
        return objetoDato;
    }

    public void setObjetoDato(ObjetoDato objetoDato) {
        this.objetoDato = objetoDato;
    }
    
    
}
