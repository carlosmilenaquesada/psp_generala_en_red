package vistas;

public class Main {
    
    private static PrincipalJFrame principalJFrame;
    
    public static void main(String[] args) {
        conexion.ConexionCliente.main(null);
        principalJFrame = new PrincipalJFrame();
        principalJFrame.setVisible(true);
        
        
        
    }
    
    public static PrincipalJFrame getPrincipalJFrame() {
        return principalJFrame;
    }
    
}
