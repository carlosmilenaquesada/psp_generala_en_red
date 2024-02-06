package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import javax.swing.*;
import jdk.dynalink.linker.support.Guards;
import modelos.gui.CeldaPerfilPersonaje;

public class EleccionPersonajeJDialog extends JDialog {

    private int idPersonaSeleccionado;
    private String nombreJugador;
    private CeldaPerfilPersonaje[] celdaPerfilPersonajes;

    private JLabel jlEligePerfil;
    private JLabel jlIntroduceNombre;
    private JTextField jtfNombreJugador;
    private JButton jbComenzar;

    public EleccionPersonajeJDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        this.idPersonaSeleccionado = -1;
        this.nombreJugador = "";
        celdaPerfilPersonajes = new CeldaPerfilPersonaje[10];
        for (int i = 0; i < celdaPerfilPersonajes.length; i++) {
            celdaPerfilPersonajes[i] = new CeldaPerfilPersonaje(new ImageIcon(getClass().getResource("/media/perfiles/" + i + ".jpg")), i, this);
            celdaPerfilPersonajes[i].setBackground(Color.ORANGE);
            this.add(celdaPerfilPersonajes[i]);
            if (i < 5) {
                celdaPerfilPersonajes[i].setBounds((i * 100) + 20, 70, 90, 110);
            } else {
                celdaPerfilPersonajes[i].setBounds(((i - 5) * 100) + 20, 120 + 70, 90, 110);
            }
            celdaPerfilPersonajes[i].setVisible(true);
        }

        jlEligePerfil = new JLabel("Elige tu perfil");
        jlEligePerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
        jlEligePerfil.setForeground(Color.WHITE);
        jlEligePerfil.setBounds(20, 20, 140, 30);
        this.add(jlEligePerfil);

        jlIntroduceNombre = new JLabel("Introduce tu nombre");
        jlIntroduceNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
        jlIntroduceNombre.setForeground(Color.WHITE);
        jlIntroduceNombre.setBounds(20, 310, 150, 30);
        this.add(jlIntroduceNombre);

        jtfNombreJugador = new JTextField();
        jtfNombreJugador.setFont(new Font("Tahoma", 0, 14));
        jtfNombreJugador.setBounds(180, 310, 200, 30);
        this.add(jtfNombreJugador);

        jbComenzar = new JButton("Comenzar");
        jbComenzar.setFont(new Font("Tahoma", 0, 14));
        jbComenzar.setBounds(400, 310, 100, 30);
        this.add(jbComenzar);
        jbComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ArrayList<String> errores = new ArrayList<>();
                if (getIdPersonaSeleccionado() == -1) {
                    errores.add("Seleccione un personaje.");
                }
                String nombreJugadorAux = jtfNombreJugador.getText();
                if (nombreJugadorAux.length() > 8 || nombreJugadorAux.length() < 3) {
                    errores.add("Introduce un nombre de jugador válido (de 3 a 8 caracteres)");
                }
                if (!errores.isEmpty()) {
                    JOptionPane.showMessageDialog(jbComenzar.getParent(), String.join("\n", errores), "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
                } else {
                    setNombreJugador(nombreJugadorAux);
                    dispose();
                }
            }
        });
        this.setResizable(false);
        this.setSize(540, 400);
        this.setLocation(getParent().getX() + ((getParent().getWidth() - this.getWidth()) / 2), getParent().getY() + ((getParent().getHeight() - this.getHeight()) / 2));
        this.add(new JLabel(new ImageIcon(getClass().getResource("/media/perfiles/personajes_background.png"))));
        this.setVisible(true);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pack();
    }

    public int getIdPersonaSeleccionado() {
        return idPersonaSeleccionado;
    }

    public void setIdPersonaSeleccionado(int idPersonaSeleccionado) {
        this.idPersonaSeleccionado = idPersonaSeleccionado;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void resetBordeImagenes() {
        for (int i = 0; i < celdaPerfilPersonajes.length; i++) {
            celdaPerfilPersonajes[i].setOpaque(false);
            this.repaint();
        }
    }

}
