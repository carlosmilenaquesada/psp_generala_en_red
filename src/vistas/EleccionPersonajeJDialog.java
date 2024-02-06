package vistas;

import java.awt.Frame;
import javax.swing.*;
import modelos.gui.CeldaPerfilPersonaje;

public class EleccionPersonajeJDialog extends JDialog {

    private JButton jButton1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JLabel jlEligePerfil;

    private CeldaPerfilPersonaje[] celdaPerfilPersonajes;

    private int idPersonaSeleccionado;
    private String nombreUsuario;

    public EleccionPersonajeJDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        this.idPersonaSeleccionado = -1;
        this.nombreUsuario = "";
        celdaPerfilPersonajes = new CeldaPerfilPersonaje[10];
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jlEligePerfil = new JLabel();
        this.setVisible(true);
        
        for (int i = 0; i < celdaPerfilPersonajes.length; i++) {
            celdaPerfilPersonajes[i] = new CeldaPerfilPersonaje(i, new ImageIcon(getClass().getResource("/media/perfiles/" + i + ".jpg")));
            jPanel1.add(celdaPerfilPersonajes[i]);
            if (i < 5) {
                celdaPerfilPersonajes[i].setBounds((i * 100) + 20, 70, 80, 100);
            } else {
                celdaPerfilPersonajes[i].setBounds(((i - 5) * 100) + 20, 120 + 70, 80, 100);
            }
            celdaPerfilPersonajes[i].setVisible(true);

        }
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jlEligePerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlEligePerfil.setText("Elige tu perfil");
        jPanel1.add(jlEligePerfil);
        jlEligePerfil.setBounds(20, 20, 140, 30);


        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(170, 310, 210, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Comenzar");
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 310, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Introduce tu nombre");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 310, 140, 30);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    public int getIdPersonaSeleccionado() {
        return idPersonaSeleccionado;
    }

    public void setIdPersonaSeleccionado(int idPersonaSeleccionado) {
        this.idPersonaSeleccionado = idPersonaSeleccionado;
    }

}
