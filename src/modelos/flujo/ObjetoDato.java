package modelos.flujo;

import java.io.Serializable;

public class ObjetoDato implements Serializable {

    public static final String DATOS_PARTIDA = "controladores.ClavesEnvio.DADOS_PARTIDA";
    public static final String MENSAJE_CHAT = "controladores.ClavesEnvio.PUNTOS_PREVIOS";

    private String clave;
    private Object valor;

    public ObjetoDato(String clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ObjetoDato{" + "clave=" + clave + ", valor=" + valor + '}';
    }

}
