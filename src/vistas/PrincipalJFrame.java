package vistas;

import controladores.Imagenes;
import controladores.Textos;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.DadoDefecto;
import modelos.DadoDefecto.Estado;
import modelos.PanelPuntos;

public class PrincipalJFrame extends javax.swing.JFrame {

    DadoDefecto[] dadosReserva = new DadoDefecto[5];
    DadoDefecto[] dadosTapete = new DadoDefecto[5];

    boolean[] conseguidasSuperior = new boolean[6];
    boolean[] conseguidasInferior = new boolean[6];
    int[] puntosSuperior = new int[6];
    int[] puntosInferior = new int[6];

    PanelPuntos panelPuntosSuperior;
    PanelPuntos panelPuntosInferior;

    public PrincipalJFrame() {
        initComponents();

        initConfiguracion();
    }

    private void initConfiguracion() {
        dadosReserva[0] = new DadoDefecto(Estado.VACIO, jlHuecoCero);
        dadosReserva[1] = new DadoDefecto(Estado.VACIO, jlHuecoUno);
        dadosReserva[2] = new DadoDefecto(Estado.VACIO, jlHuecoDos);
        dadosReserva[3] = new DadoDefecto(Estado.VACIO, jlHuecoTres);
        dadosReserva[4] = new DadoDefecto(Estado.VACIO, jlHuecoCuatro);

        dadosTapete[0] = new DadoDefecto(Estado.SEIS, jlDadoCero);
        dadosTapete[1] = new DadoDefecto(Estado.SEIS, jlDadoUno);
        dadosTapete[2] = new DadoDefecto(Estado.SEIS, jlDadoDos);
        dadosTapete[3] = new DadoDefecto(Estado.SEIS, jlDadoTres);
        dadosTapete[4] = new DadoDefecto(Estado.SEIS, jlDadoCuatro);

        for (int i = 0; i < dadosReserva.length; i++) {
            dadosReserva[i].setDadoEspejo(dadosTapete[i]);
            dadosTapete[i].setDadoEspejo(dadosReserva[i]);
        }

        panelPuntosSuperior = new PanelPuntos(Textos.categoriasPuntosSuperior, Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]), new Rectangle(20, 130, 300, 180), 6, 3);
        panelPuntosInferior = new PanelPuntos(Textos.categoriasPuntosInferior, Imagenes.imagenesRepositorio.subList(0, 6).toArray(new Image[6]), new Rectangle(20, 340, 300, 180), 6, 3);
        
        this.jpPuntos.add(panelPuntosSuperior);
        this.jpPuntos.add(panelPuntosInferior);
    }

    public void calcularPrePuntuacion() {
        //SUPERIOR

        for (int i = 0; i < dadosReserva.length; i++) {
            int ordinal = dadosReserva[i].getEstado().ordinal();
            if (ordinal >= 1 && ordinal <= 6) {
                if (!conseguidasSuperior[ordinal - 1]) {
                    puntosSuperior[ordinal - 1] += ordinal;
                }
            }
        }
        /*for (int i = 0; i < conseguidasSuperior.length; i++) {
            this.ppSuperior.getCelda(i, 1).estaEnSeleccion(true);
            if (!conseguidasSuperior[i]) {
                this.ppSuperior.setValorEnMatriz(puntosSuperior[i], i, 1);
                this.ppSuperior.getCelda(i, 1).estaEnPrevioPuntos(true);
            }
        }
        
        for (int i = 0; i < conseguidasSuperior.length; i++) {
           if (!conseguidasSuperior[i]) {
               puntosSuperior[i] = 0;
           }
        }*/

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
        jpMesa = new javax.swing.JPanel();
        jpTablero = new javax.swing.JPanel();
        jpHuecos = new javax.swing.JPanel();
        jlHuecoCero = new javax.swing.JLabel();
        jlHuecoUno = new javax.swing.JLabel();
        jlHuecoDos = new javax.swing.JLabel();
        jlHuecoTres = new javax.swing.JLabel();
        jlHuecoCuatro = new javax.swing.JLabel();
        jpTapete = new javax.swing.JPanel();
        jpDados = new javax.swing.JPanel();
        jlDadoCero = new javax.swing.JLabel();
        jlDadoUno = new javax.swing.JLabel();
        jlDadoDos = new javax.swing.JLabel();
        jlDadoTres = new javax.swing.JLabel();
        jlDadoCuatro = new javax.swing.JLabel();
        jbMezclar = new javax.swing.JButton();
        JpChat = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 624));
        setSize(new java.awt.Dimension(750, 600));
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
        jLabel1.setBounds(20, 310, 300, 30);

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
        jpPuntos.setBounds(0, 0, 340, 570);

        jpMesa.setBackground(new java.awt.Color(184, 153, 107));

        jpTablero.setBackground(new java.awt.Color(57, 43, 43));

        jpHuecos.setBackground(new java.awt.Color(51, 255, 51));

        jlHuecoCero.setText("RCero");
        jlHuecoCero.setOpaque(true);

        jlHuecoUno.setText("RUno");
        jlHuecoUno.setOpaque(true);

        jlHuecoDos.setText("RDos");
        jlHuecoDos.setOpaque(true);

        jlHuecoTres.setText("RTres");
        jlHuecoTres.setOpaque(true);

        jlHuecoCuatro.setText("RCuatro");
        jlHuecoCuatro.setOpaque(true);

        javax.swing.GroupLayout jpHuecosLayout = new javax.swing.GroupLayout(jpHuecos);
        jpHuecos.setLayout(jpHuecosLayout);
        jpHuecosLayout.setHorizontalGroup(
            jpHuecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHuecosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlHuecoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHuecoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHuecoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHuecoTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlHuecoCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jpHuecosLayout.setVerticalGroup(
            jpHuecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHuecosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpHuecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHuecoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHuecoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHuecoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHuecoTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHuecoCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jpTapete.setBackground(new java.awt.Color(134, 51, 45));
        jpTapete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpTapete.setPreferredSize(new java.awt.Dimension(409, 409));

        jpDados.setOpaque(false);
        jpDados.setPreferredSize(new java.awt.Dimension(352, 84));

        jlDadoCero.setText("TCero");
        jlDadoCero.setOpaque(true);

        jlDadoUno.setText("TDos");
        jlDadoUno.setOpaque(true);

        jlDadoDos.setText("TTres");
        jlDadoDos.setOpaque(true);

        jlDadoTres.setText("TCuatro");
        jlDadoTres.setOpaque(true);

        jlDadoCuatro.setText("TCinco");
        jlDadoCuatro.setOpaque(true);

        javax.swing.GroupLayout jpDadosLayout = new javax.swing.GroupLayout(jpDados);
        jpDados.setLayout(jpDadosLayout);
        jpDadosLayout.setHorizontalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlDadoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDadoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDadoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDadoTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDadoCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jpDadosLayout.setVerticalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDadoCero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDadoUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDadoDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDadoTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDadoCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jbMezclar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbMezclar.setText("Mezclar");
        jbMezclar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMezclarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTapeteLayout = new javax.swing.GroupLayout(jpTapete);
        jpTapete.setLayout(jpTapeteLayout);
        jpTapeteLayout.setHorizontalGroup(
            jpTapeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTapeteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbMezclar)
                .addContainerGap())
        );
        jpTapeteLayout.setVerticalGroup(
            jpTapeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTapeteLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbMezclar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpTableroLayout = new javax.swing.GroupLayout(jpTablero);
        jpTablero.setLayout(jpTableroLayout);
        jpTableroLayout.setHorizontalGroup(
            jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTapete, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpTableroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpHuecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpTableroLayout.setVerticalGroup(
            jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTableroLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jpTapete, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jpTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpTableroLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpHuecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(489, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpMesaLayout = new javax.swing.GroupLayout(jpMesa);
        jpMesa.setLayout(jpMesaLayout);
        jpMesaLayout.setHorizontalGroup(
            jpMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMesaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jpMesaLayout.setVerticalGroup(
            jpMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMesaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jpMesa);
        jpMesa.setBounds(340, 0, 414, 624);

        javax.swing.GroupLayout JpChatLayout = new javax.swing.GroupLayout(JpChat);
        JpChat.setLayout(JpChatLayout);
        JpChatLayout.setHorizontalGroup(
            JpChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        JpChatLayout.setVerticalGroup(
            JpChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(JpChat);
        JpChat.setBounds(770, 160, 100, 100);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbMezclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMezclarActionPerformed
        for (int i = 0; i < dadosTapete.length; i++) {
            if (!dadosTapete[i].getEstado().equals(Estado.VACIO)) {
                dadosTapete[i].cambiarEstado(Estado.INTERROGACION);
                dadosTapete[i].setClickable(false);
            }
            if (!dadosReserva[i].getEstado().equals(Estado.VACIO)) {
                dadosReserva[i].setClickable(false);
            }
        }

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < dadosTapete.length; i++) {
                if (dadosTapete[i].getEstado().equals(Estado.INTERROGACION)) {
                    dadosTapete[i].setClickable(true);
                    dadosTapete[i].cambiarEstado(Estado.values()[(int) (Math.random() * 6) + 1]);
                }
                if (!dadosReserva[i].getEstado().equals(Estado.VACIO)) {
                    dadosReserva[i].setClickable(true);

                }
            }
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbMezclar;
    private javax.swing.JLabel jlDadoCero;
    private javax.swing.JLabel jlDadoCuatro;
    private javax.swing.JLabel jlDadoDos;
    private javax.swing.JLabel jlDadoTres;
    private javax.swing.JLabel jlDadoUno;
    private javax.swing.JLabel jlHuecoCero;
    private javax.swing.JLabel jlHuecoCuatro;
    private javax.swing.JLabel jlHuecoDos;
    private javax.swing.JLabel jlHuecoTres;
    private javax.swing.JLabel jlHuecoUno;
    private javax.swing.JLabel jlTurno;
    private javax.swing.JLabel jlYo;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpHuecos;
    private javax.swing.JPanel jpMesa;
    private javax.swing.JPanel jpPuntos;
    private javax.swing.JPanel jpTablero;
    private javax.swing.JPanel jpTapete;
    private javax.swing.JLabel lbRival;
    // End of variables declaration//GEN-END:variables
}
