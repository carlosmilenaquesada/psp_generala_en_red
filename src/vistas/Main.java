package vistas;

public class Main {
    
    private static PrincipalJFrame principalJFrame;
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            principalJFrame = new PrincipalJFrame();
            principalJFrame.setVisible(true);
        });
        
    }

    public static PrincipalJFrame getPrincipalJFrame() {
        return principalJFrame;
    }
    
    
}
