package vistas;

import controladores.Imagenes;
import controladores.Rectangles.*;
import static controladores.Rectangles.rectanglesElementos;
import controladores.Textos;
import java.awt.Image;
import modelos.CeldaDePanel;
import modelos.Dado;
import modelos.Dado.Valor;
import modelos.Jugador;
import modelos.Panel;

import modelos.PanelPuntos;
import modelos.Partida;

public class PrincipalJFrame extends javax.swing.JFrame {

    private Jugador jugadorLocal;
    private Dado[] dados = new Dado[5];

    private PanelPuntos panelPuntosSuperior;
    private PanelPuntos panelPuntosInferior;

    private Panel panelBonus;

    private Partida partida;

    public PrincipalJFrame() {
        initComponents();

        initConfiguracion();
    }

    private void initConfiguracion() {

        dados[0] = new Dado(jlDadoCero, RectanglesDados.PRIMERA_TAP);
        dados[1] = new Dado(jlDadoUno, RectanglesDados.SEGUNDA_TAP);
        dados[2] = new Dado(jlDadoDos, RectanglesDados.TERCERA_TAP);
        dados[3] = new Dado(jlDadoTres, RectanglesDados.CUARTA_TAP);
        dados[4] = new Dado(jlDadoCuatro, RectanglesDados.QUINTA_TAP);

        panelPuntosSuperior = new PanelPuntos(
                Textos.categoriasPuntosSuperior,
                rectanglesElementos.get(RectanglesElementos.PANEL_CAT_SUPERIOR),
                Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]),
                6, 3, "superior"
        );
        panelPuntosSuperior.rellenarMatrizCeldas();

        panelPuntosInferior = new PanelPuntos(
                Textos.categoriasPuntosInferior,
                rectanglesElementos.get(RectanglesElementos.PANEL_CAT_INFERIOR),
                Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]),
                6, 3, "inferior"
        );
        panelPuntosInferior.rellenarMatrizCeldas();

        panelBonus = new Panel(Textos.categoriaBonus,
                rectanglesElementos.get(RectanglesElementos.PANEL_CAT_BONUS), 1, 3);
        panelBonus.rellenarMatrizCeldas();

        this.jpPuntos.add(panelPuntosSuperior);
        this.jpPuntos.add(panelPuntosInferior);
        this.jpPuntos.add(panelBonus);

        jugadorLocal = new Jugador("JUGADOR 1");
        jlNombreJugadorLocal.setText(jugadorLocal.getNombre());
        partida = new Partida(jugadorLocal, dados);
    }

    public void actualizarPuntosPrevios(int[] puntosSuperiorPrevios, int[] puntosInferiorPrevios) {
        //MOSTRAR---------------------------------------------------------------
        //recorre las categorias de la tabla superior, y a las que no tienen
        //puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getConseguidasSuperior().length; i++) {
            if (!jugadorLocal.getConseguidasSuperior()[i]) {
                this.panelPuntosSuperior.setValorEnMatriz(puntosSuperiorPrevios[i], i, 1);
                ((CeldaDePanel) this.panelPuntosSuperior.getCelda(i, 1)).setEstaEnPrevioPuntos(true);
            }
        }

        //recorre las categorias de la tabla inferior, y a las que no tienen puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getConseguidasInferior().length; i++) {
            if (!jugadorLocal.getConseguidasInferior()[i]) {
                this.panelPuntosInferior.setValorEnMatriz(puntosInferiorPrevios[i], i, 1);
                ((CeldaDePanel) this.panelPuntosInferior.getCelda(i, 1)).setEstaEnPrevioPuntos(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPuntos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlTurno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlNombreJugadorLocal = new javax.swing.JLabel();
        jlNombreJugadorRemoto = new javax.swing.JLabel();
        jpTablero = new javax.swing.JPanel();
        jlDadoCero = new javax.swing.JLabel();
        jlDadoUno = new javax.swing.JLabel();
        jlDadoDos = new javax.swing.JLabel();
        jlDadoTres = new javax.swing.JLabel();
        jlDadoCuatro = new javax.swing.JLabel();
        jbMezclar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JpChat = new javax.swing.JPanel();
        jlBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(860, 639));
        setMinimumSize(new java.awt.Dimension(860, 639));
        setPreferredSize(new java.awt.Dimension(860, 639));
        setResizable(false);
        setSize(new java.awt.Dimension(860, 639));
        getContentPane().setLayout(null);

        jpPuntos.setBackground(new java.awt.Color(232, 232, 220));
        jpPuntos.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(70, 71, 73));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Turno");
        jpPuntos.add(jLabel4);
        jLabel4.setBounds(20, 20, 150, 30);

        jlTurno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTurno.setForeground(new java.awt.Color(70, 71, 73));
        jlTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTurno.setText("0/12");
        jpPuntos.add(jlTurno);
        jlTurno.setBounds(20, 60, 150, 30);

        jLabel2.setBackground(new java.awt.Color(70, 71, 73));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 232, 220));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categorías");
        jLabel2.setOpaque(true);
        jpPuntos.add(jLabel2);
        jLabel2.setBounds(20, 100, 150, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bonus si 1 - 6 supera 63 puntos");
        jpPuntos.add(jLabel1);
        jLabel1.setBounds(20, 340, 300, 30);

        jlNombreJugadorLocal.setText("jLabel3");
        jlNombreJugadorLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlNombreJugadorLocal.setOpaque(true);
        jpPuntos.add(jlNombreJugadorLocal);
        jlNombreJugadorLocal.setBounds(170, 20, 75, 110);

        jlNombreJugadorRemoto.setText("jLabel3");
        jlNombreJugadorRemoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlNombreJugadorRemoto.setOpaque(true);
        jpPuntos.add(jlNombreJugadorRemoto);
        jlNombreJugadorRemoto.setBounds(245, 20, 75, 110);

        getContentPane().add(jpPuntos);
        jpPuntos.setBounds(40, 0, 340, 600);

        jpTablero.setBackground(new java.awt.Color(57, 43, 43));
        jpTablero.setOpaque(false);
        jpTablero.setLayout(null);

        jlDadoCero.setText("RCero");
        jlDadoCero.setOpaque(true);
        jpTablero.add(jlDadoCero);
        jlDadoCero.setBounds(10, 180, 60, 60);

        jlDadoUno.setText("RUno");
        jlDadoUno.setOpaque(true);
        jpTablero.add(jlDadoUno);
        jlDadoUno.setBounds(100, 200, 60, 60);

        jlDadoDos.setText("RDos");
        jlDadoDos.setOpaque(true);
        jpTablero.add(jlDadoDos);
        jlDadoDos.setBounds(160, 130, 60, 60);

        jlDadoTres.setText("RTres");
        jlDadoTres.setOpaque(true);
        jpTablero.add(jlDadoTres);
        jlDadoTres.setBounds(210, 240, 60, 60);

        jlDadoCuatro.setText("RCuatro");
        jlDadoCuatro.setOpaque(true);
        jpTablero.add(jlDadoCuatro);
        jlDadoCuatro.setBounds(280, 140, 60, 60);

        jbMezclar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbMezclar.setText("Mezclar");
        jbMezclar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMezclarActionPerformed(evt);
            }
        });
        jpTablero.add(jbMezclar);
        jbMezclar.setBounds(190, 360, 100, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/tablero.png"))); // NOI18N
        jpTablero.add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 400);

        getContentPane().add(jpTablero);
        jpTablero.setBounds(420, 40, 400, 400);

        javax.swing.GroupLayout JpChatLayout = new javax.swing.GroupLayout(JpChat);
        JpChat.setLayout(JpChatLayout);
        JpChatLayout.setHorizontalGroup(
            JpChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        JpChatLayout.setVerticalGroup(
            JpChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(JpChat);
        JpChat.setBounds(420, 480, 400, 100);

        jlBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/background.jpg"))); // NOI18N
        getContentPane().add(jlBackground);
        jlBackground.setBounds(0, 0, 860, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbMezclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMezclarActionPerformed
        this.jbMezclar.setEnabled(false);
        for (int i = 0; i < dados.length; i++) {
            dados[i].setClickable(false);
            if (dados[i].getEstado().equals(Dado.Estado.EN_TAPETE)) {
                dados[i].getjLabel().setIcon(Imagenes.imagenesDado.get(Valor.INTERROGACION));
            }
        }
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            for (int i = 0; i < dados.length; i++) {
                if (dados[i].getEstado().equals(Dado.Estado.EN_TAPETE)) {
                    dados[i].setValor(Valor.values()[(int) (Math.random() * 6) + 1]);
                    dados[i].getjLabel().setIcon(Imagenes.imagenesDado.get(dados[i].getValor()));
                }
                dados[i].setClickable(true);
            }
            partida.calcularPrePuntuacion();
            actualizarPuntosPrevios(partida.getPuntosSuperiorPrevios(), partida.getPuntosInferiorPrevios());
            this.jbMezclar.setEnabled(true);
        }).start();
    }//GEN-LAST:event_jbMezclarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpChat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbMezclar;
    private javax.swing.JLabel jlBackground;
    private javax.swing.JLabel jlDadoCero;
    private javax.swing.JLabel jlDadoCuatro;
    private javax.swing.JLabel jlDadoDos;
    private javax.swing.JLabel jlDadoTres;
    private javax.swing.JLabel jlDadoUno;
    private javax.swing.JLabel jlNombreJugadorLocal;
    private javax.swing.JLabel jlNombreJugadorRemoto;
    private javax.swing.JLabel jlTurno;
    private javax.swing.JPanel jpPuntos;
    private javax.swing.JPanel jpTablero;
    // End of variables declaration//GEN-END:variables

    public Dado[] getDados() {
        return dados;
    }


    public PanelPuntos getPanelPuntosSuperior() {
        return panelPuntosSuperior;
    }

    public PanelPuntos getPanelPuntosInferior() {
        return panelPuntosInferior;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

}
