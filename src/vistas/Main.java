package vistas;

import modelos.flujo.EmisionDatos;

public class Main {
    
    private static PrincipalJFrame principalJFrame;
    
    public static void main(String[] args) {

        try {
            java.awt.EventQueue.invokeLater(() -> {
                principalJFrame = new PrincipalJFrame();
                principalJFrame.setVisible(true);
            });
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        
    }
    
    public static PrincipalJFrame getPrincipalJFrame() {
        return principalJFrame;
    }
    
}
