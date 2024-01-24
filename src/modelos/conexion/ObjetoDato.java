package modelos.conexion;

public class ObjetoDato {

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

    
    
}
