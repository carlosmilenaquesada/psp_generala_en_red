package modelos.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JLabel;
import vistas.EleccionPersonajeJDialog;

public class CeldaPerfilPersonaje extends JLabel {
    
    private int id;
    
    public CeldaPerfilPersonaje(int id, Icon image) {
        super(image);
        this.id = id;
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((EleccionPersonajeJDialog) getParent()).setIdPersonaSeleccionado(getId());
            }
        });
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
