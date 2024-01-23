package vistas;

import controladores.Imagenes;
import controladores.Posiciones.Posicion;
import controladores.Textos;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.*;
import modelos.Celda;
import modelos.Dado;
import modelos.Dado.Valor;
import modelos.Jugador;

import modelos.PanelPuntos;

public class PrincipalJFrame extends javax.swing.JFrame {

    private Jugador jugadorLocal;
    private Dado[] dados = new Dado[5];

    public ArrayList<Boolean> reservaOcupadas;
    public ArrayList<Boolean> tapeteOcupadas;

    private int[] puntosSuperiorPrevios = new int[6];
    private int[] puntosInferiorPrevios = new int[6];

    private PanelPuntos panelPuntosSuperior;
    private PanelPuntos panelPuntosInferior;
    private JPanel panelPuntosBonus;

    public PrincipalJFrame() {
        initComponents();

        initConfiguracion();
    }

    private void initConfiguracion() {
        jugadorLocal = new Jugador("JUGADOR 1");
        reservaOcupadas = new ArrayList<>();
        tapeteOcupadas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            reservaOcupadas.add(false);
            tapeteOcupadas.add(true);

        }

        dados[0] = new Dado(jlDadoCero, Posicion.PRIMERA_TAP);
        dados[1] = new Dado(jlDadoUno, Posicion.SEGUNDA_TAP);
        dados[2] = new Dado(jlDadoDos, Posicion.TERCERA_TAP);
        dados[3] = new Dado(jlDadoTres, Posicion.CUARTA_TAP);
        dados[4] = new Dado(jlDadoCuatro, Posicion.QUINTA_TAP);

        panelPuntosSuperior = new PanelPuntos(Textos.categoriasPuntosSuperior, Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]), new Rectangle(20, 130, 300, 180), 6, 3, "superior");
        panelPuntosInferior = new PanelPuntos(Textos.categoriasPuntosInferior, Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]), new Rectangle(20, 370, 300, 180), 6, 3, "inferior");
        panelPuntosBonus = crearPanelBonus();

        this.jpPuntos.add(panelPuntosSuperior);
        this.jpPuntos.add(panelPuntosInferior);
        this.jpPuntos.add(panelPuntosBonus);
    }

    private JPanel crearPanelBonus() {
        JPanel jp = new JPanel(null);
        jp.setBounds(
                panelPuntosSuperior.getX(),
                panelPuntosSuperior.getY() + panelPuntosSuperior.getHeight(),
                panelPuntosSuperior.getWidth(), 30);
        for (int columna = 0; columna < 3; columna++) {
            jp.add(new Celda(0, columna).setText(Textos.categoriaBonus[columna]));
        }
        jp.setVisible(true);
        return jp;
    }

    public void calcularPrePuntuacion() {
        //CALCULAR CATEGORÍA SUPERIOR Y LIBRE-----------------------------------
        puntosSuperiorPrevios = new int[6];
        puntosInferiorPrevios = new int[6];
        for (int i = 0; i < dados.length; i++) {
            //Categorías superior (suma de los puntos de los dados, agrapados por número) 
            int ordinal = dados[i].getValor().ordinal();//el ordinal es el valor del dado

            if (!jugadorLocal.getConseguidasSuperior()[ordinal - 1]) {//conseguidasSuperior es una colección de boolean que nos dice si una categoría ya ha puntuado o no
                puntosSuperiorPrevios[ordinal - 1] += ordinal;
            }
            //Categoría libre (la suma de todos los puntos, de cualquier de dados)
            if (!jugadorLocal.getConseguidasInferior()[0]) {
                puntosInferiorPrevios[0] += ordinal;
            }

        }

        //CALCULAR CATEGORÍA INFERIOR-------------------------------------------        
        //Póker (la suma de los puntos de al menos cuatro dados iguales)
        int[] auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;

        }
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 4) {
                puntosInferiorPrevios[1] = 4 * (i + 1);

            }
        }
        //Full (la suma de los puntos de una pareja de dados de igual número + un trio de dados igual número)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;
        }
        int pareja = 0;
        int trio = 0;
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] == 2) {
                pareja = 2 * (i + 1);
            }
            if (auxFrecuenciaNumeros[i] == 3) {
                trio = 3 * (i + 1);
            }
        }
        if (pareja > 0 && trio > 0) {
            puntosInferiorPrevios[2] = pareja + trio;
        }

        //escalera corta (una fila de al menos cuatro números sucesivos)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();

            auxFrecuenciaNumeros[ordinal - 1]++;

        }

        int contadorSucesivos = 0;
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 1) {
                contadorSucesivos++;
            } else {
                if (contadorSucesivos < 4) {
                    contadorSucesivos = 0;
                }
            }
        }
        if (contadorSucesivos >= 4) {
            puntosInferiorPrevios[3] = 15;
        }
        //escalera larga (una fila de cinco números sucesivos)
        if (contadorSucesivos == 5) {
            puntosInferiorPrevios[4] = 30;
        }

        //generala (cinco números iguales)
        boolean sonIguales = true;
        int ordinal = dados[0].getValor().ordinal();
        for (int i = 1; i < dados.length && sonIguales; i++) {
            if (ordinal != dados[i].getValor().ordinal()) {
                sonIguales = false;
            }
        }

        if (sonIguales) {
            puntosInferiorPrevios[5] = 50;
        }
        //MOSTRAR---------------------------------------------------------------
        //recorre las categorias de la tabla superior, y a las que no tienen
        //puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getConseguidasSuperior().length; i++) {
            if (!jugadorLocal.getConseguidasSuperior()[i]) {
                this.panelPuntosSuperior.setValorEnMatriz(puntosSuperiorPrevios[i], i, 1);
                this.panelPuntosSuperior.getCelda(i, 1).setEstaEnPrevioPuntos(true);
            }
        }

        //recorre las categorias de la tabla inferior, y a las que no tienen puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getConseguidasInferior().length; i++) {
            if (!jugadorLocal.getConseguidasInferior()[i]) {
                this.panelPuntosInferior.setValorEnMatriz(puntosInferiorPrevios[i], i, 1);
                this.panelPuntosInferior.getCelda(i, 1).setEstaEnPrevioPuntos(true);
            }
        }

    }

    public Posicion primeraPosionLibreReserva() {
        return Posicion.values()[reservaOcupadas.indexOf(false)];
    }

    public void ocuparPosicionReserva(Posicion posicion) {
        reservaOcupadas.set(posicion.ordinal(), true);
    }

    public void desocuparPosicionReserva(Posicion posicion) {
        reservaOcupadas.set(posicion.ordinal(), false);
    }

    public Posicion primeraPosionLibreTapete() {
        return Posicion.values()[tapeteOcupadas.indexOf(false) + 5];
    }

    public void ocuparPosicionTapete(Posicion posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, true);
    }

    public void desocuparPosicionTapete(Posicion posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPuntos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlTurno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlYo = new javax.swing.JLabel();
        lbRival = new javax.swing.JLabel();
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

        jlYo.setText("jLabel3");
        jlYo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlYo.setOpaque(true);
        jpPuntos.add(jlYo);
        jlYo.setBounds(170, 20, 75, 110);

        lbRival.setText("jLabel3");
        lbRival.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbRival.setOpaque(true);
        jpPuntos.add(lbRival);
        lbRival.setBounds(245, 20, 75, 110);

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
            calcularPrePuntuacion();
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
    private javax.swing.JLabel jlTurno;
    private javax.swing.JLabel jlYo;
    private javax.swing.JPanel jpPuntos;
    private javax.swing.JPanel jpTablero;
    private javax.swing.JLabel lbRival;
    // End of variables declaration//GEN-END:variables

    public Dado[] getDados() {
        return dados;
    }

    public void setDados(Dado[] dados) {
        this.dados = dados;
    }

    public int[] getPuntosSuperiorPrevios() {
        return puntosSuperiorPrevios;
    }

    public void setPuntosSuperiorPrevios(int[] puntosSuperiorPrevios) {
        this.puntosSuperiorPrevios = puntosSuperiorPrevios;
    }

    public int[] getPuntosInferiorPrevios() {
        return puntosInferiorPrevios;
    }

    public void setPuntosInferiorPrevios(int[] puntosInferiorPrevios) {
        this.puntosInferiorPrevios = puntosInferiorPrevios;
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
