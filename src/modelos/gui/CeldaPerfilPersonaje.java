package modelos.gui;

import controladores.Colores;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import vistas.EleccionPersonajeJDialog;

public class CeldaPerfilPersonaje extends JLabel {

    private final int id;
    private final EleccionPersonajeJDialog parent;

    public CeldaPerfilPersonaje(Icon image, int id, EleccionPersonajeJDialog parent) {
        super(image);
        this.id = id;
        this.parent = parent;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getParent().getPerfilJugadorLocal().setIdImagenPerfil(getId());
                getParent().resetBordeImagenes();               
                setOpaque(true);

            }
        });
    }

    public int getId() {
        return id;
    }

    @Override
    public EleccionPersonajeJDialog getParent() {
        return parent;
    }

}
