package vistas;

public class Main {
    
    private static PrincipalJFrame principalJFrame;
    
    public static void main(String[] args) {
        
        principalJFrame = new PrincipalJFrame();
        principalJFrame.setVisible(true);
        conexion.ConexionCliente.main(null);
        
        
    }
    
    public static PrincipalJFrame getPrincipalJFrame() {
        return principalJFrame;
    }
    
}
