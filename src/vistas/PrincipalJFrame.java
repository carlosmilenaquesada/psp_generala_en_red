package vistas;

import controladores.Imagenes;
import controladores.Rectangles.*;
import static controladores.Rectangles.rectanglesElementos;
import controladores.Textos;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import modelos.datos.DadosPartida;
import modelos.gui.CeldaDePanel;
import modelos.gui.Dado;
import modelos.gui.Dado.Valor;
import modelos.datos.Jugador;
import modelos.gui.Panel;
import modelos.gui.PanelPuntos;
import modelos.datos.PartidaLocal;
import modelos.datos.PerfilJugador;
import modelos.datos.PuntosPrevios;
import modelos.flujo.serializaciones.SerializacionPartida;
import modelos.flujo.ObjetoDato;
import modelos.flujo.serializaciones.SerializacionDados;

public class PrincipalJFrame extends javax.swing.JFrame {

    private Jugador jugadorLocal;
    private Jugador jugadorRemoto;
    private ArrayList<Dado> dados;
    private PanelPuntos panelPuntosSuperior;
    private PanelPuntos panelPuntosInferior;

    private Panel panelBonus;

    private PartidaLocal partidaLocal;

    private DadosPartida dadosPartida;
    private EleccionPersonajeJDialog eleccionPersonajeLocalJDialog;

    public PrincipalJFrame() {
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        crearPerfilJugadorLocal();
        crearPerfilJugadorRemoto( eleccionPersonajeLocalJDialog.getPerfilJugadorRemoto());
        
        
        dadosPartida = new DadosPartida();
        dados = new ArrayList<>() {
            {
                add(new Dado(jlDadoCero, RectanglesDados.PRIMERA_TAP, getDadosPartida()));
                add(new Dado(jlDadoUno, RectanglesDados.SEGUNDA_TAP, getDadosPartida()));
                add(new Dado(jlDadoDos, RectanglesDados.TERCERA_TAP, getDadosPartida()));
                add(new Dado(jlDadoTres, RectanglesDados.CUARTA_TAP, getDadosPartida()));
                add(new Dado(jlDadoCuatro, RectanglesDados.QUINTA_TAP, getDadosPartida()));

            }
        };
        dadosPartida.setDados(dados);

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

        partidaLocal = new PartidaLocal(jugadorLocal, jugadorRemoto, dadosPartida);

    }
    
    private void crearPerfilJugadorLocal(){
        eleccionPersonajeLocalJDialog = new EleccionPersonajeJDialog(this, true);        
        jugadorLocal = new Jugador(eleccionPersonajeLocalJDialog.getPerfilJugadorLocal().getNombreJugador());
        Image image = new ImageIcon(getClass().getResource("/media/perfiles/" + eleccionPersonajeLocalJDialog.getPerfilJugadorLocal().getIdImagenPerfil() + ".jpg")).getImage().getScaledInstance(66, 80, Image.SCALE_SMOOTH);
        jlImagenJugadorLocal.setIcon(new ImageIcon(image));
        jlNombreJugadorLocal.setText(jugadorLocal.getNombre());    
    }
    
    public void crearPerfilJugadorRemoto(PerfilJugador perfilJugadorRemoto){
        jugadorRemoto = new Jugador(eleccionPersonajeLocalJDialog.getPerfilJugadorRemoto().getNombreJugador());
        Image image = new ImageIcon(getClass().getResource("/media/perfiles/" + eleccionPersonajeLocalJDialog.getPerfilJugadorRemoto().getIdImagenPerfil() + ".jpg")).getImage().getScaledInstance(66, 80, Image.SCALE_SMOOTH);
        jlImagenJugadorRemoto.setIcon(new ImageIcon(image));
        jlNombreJugadorRemoto.setText(jugadorRemoto.getNombre());    
    }

    public void actualizarPuntosPreviosJugadorLocal(PuntosPrevios puntosPrevios) {
        //recorre las categorias de la tabla superior, y a las que no tienen
        //puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getPuntuacionJugador().getConseguidasSuperior().size(); i++) {
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasSuperior().get(i)) {
                this.panelPuntosSuperior.setValorEnMatriz(puntosPrevios.getPuntosSuperiorPrevios().get(i), i, 1);
                ((CeldaDePanel) this.panelPuntosSuperior.getCelda(i, 1)).setEstaEnPrevioPuntos(true);
            }
        }

        //recorre las categorias de la tabla inferior, y a las que no tienen puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorLocal.getPuntuacionJugador().getConseguidasInferior().size(); i++) {
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasInferior().get(i)) {
                this.panelPuntosInferior.setValorEnMatriz(puntosPrevios.getPuntosInferiorPrevios().get(i), i, 1);
                ((CeldaDePanel) this.panelPuntosInferior.getCelda(i, 1)).setEstaEnPrevioPuntos(true);
            }
        }
    }

    public void actualizarPuntosPreviosJugadorRemoto(PuntosPrevios puntosPrevios) {
        //recorre las categorias de la tabla superior, y a las que no tienen
        //puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorRemoto.getPuntuacionJugador().getConseguidasSuperior().size(); i++) {
            if (!jugadorRemoto.getPuntuacionJugador().getConseguidasSuperior().get(i)) {
                this.panelPuntosSuperior.setValorEnMatriz(puntosPrevios.getPuntosSuperiorPrevios().get(i), i, 2);
                ((CeldaDePanel) this.panelPuntosSuperior.getCelda(i, 2)).setEstaEnPrevioPuntos(true);
            }
        }

        //recorre las categorias de la tabla inferior, y a las que no tienen puntuación, les pone pre-puntuación
        for (int i = 0; i < jugadorRemoto.getPuntuacionJugador().getConseguidasInferior().size(); i++) {
            if (!jugadorRemoto.getPuntuacionJugador().getConseguidasInferior().get(i)) {
                this.panelPuntosInferior.setValorEnMatriz(puntosPrevios.getPuntosInferiorPrevios().get(i), i, 2);
                ((CeldaDePanel) this.panelPuntosInferior.getCelda(i, 2)).setEstaEnPrevioPuntos(true);
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
        jlImagenJugadorLocal = new javax.swing.JLabel();
        jlImagenJugadorRemoto = new javax.swing.JLabel();
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

        jlImagenJugadorLocal.setToolTipText("");
        jlImagenJugadorLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpPuntos.add(jlImagenJugadorLocal);
        jlImagenJugadorLocal.setBounds(175, 20, 66, 80);

        jlImagenJugadorRemoto.setToolTipText("");
        jlImagenJugadorRemoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpPuntos.add(jlImagenJugadorRemoto);
        jlImagenJugadorRemoto.setBounds(250, 20, 66, 80);

        jlNombreJugadorLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombreJugadorLocal.setToolTipText("");
        jlNombreJugadorLocal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpPuntos.add(jlNombreJugadorLocal);
        jlNombreJugadorLocal.setBounds(175, 105, 66, 20);

        jlNombreJugadorRemoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombreJugadorRemoto.setToolTipText("");
        jlNombreJugadorRemoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpPuntos.add(jlNombreJugadorRemoto);
        jlNombreJugadorRemoto.setBounds(250, 105, 66, 20);

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
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            dadosPartida.getDados().get(i).setClickable(false);
            if (dadosPartida.getDados().get(i).getEstado().equals(Dado.Estado.EN_TAPETE)) {
                dadosPartida.getDados().get(i).getjLabel().setIcon(Imagenes.imagenesDado.get(Valor.INTERROGACION));
            }
        }
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            for (int i = 0; i < dadosPartida.getDados().size(); i++) {
                if (dadosPartida.getDados().get(i).getEstado().equals(Dado.Estado.EN_TAPETE)) {
                    dadosPartida.getDados().get(i).setValor(Valor.values()[(int) (Math.random() * 6) + 1]);
                    dadosPartida.getDados().get(i).getjLabel().setIcon(Imagenes.imagenesDado.get(dadosPartida.getDados().get(i).getValor()));
                }
                dadosPartida.getDados().get(i).setClickable(true);
            }
            actualizarPuntosPreviosJugadorLocal(partidaLocal.getPuntosPreviosJugadorLocal());
            this.jbMezclar.setEnabled(true);
            ArrayList<Integer> indexRectanglesEnumDados = new ArrayList<>();
            ArrayList<Integer> indexValorEnumDados = new ArrayList<>();

            for (int i = 0; i < dadosPartida.getDados().size(); i++) {
                indexRectanglesEnumDados.add(dadosPartida.getDados().get(i).getPosicion().ordinal());
                indexValorEnumDados.add(dadosPartida.getDados().get(i).getValor().ordinal());
            }

            conexion.ConexionCliente.objetoDato = new ObjetoDato(
                    ObjetoDato.DATOS_PARTIDA, new SerializacionPartida(
                            new SerializacionDados(new ArrayList<>(indexRectanglesEnumDados), new ArrayList<>(indexValorEnumDados)),
                            partidaLocal.getPuntosPreviosJugadorLocal(), null, null
                    ));
        }).start();
    }//GEN-LAST:event_jbMezclarActionPerformed

    public void limpiarColumnaDeCeldas(int indexColumna) {
        Jugador jugador = indexColumna == 1 ? jugadorLocal : jugadorRemoto;
        for (int i = 0; i < jugador.getPuntuacionJugador().getConseguidasSuperior().size(); i++) {
            ((CeldaDePanel) panelPuntosSuperior.getCelda(i, indexColumna)).setEstaEnSeleccion(false);
            ((CeldaDePanel) panelPuntosSuperior.getCelda(i, indexColumna)).setEstaEnPrevioPuntos(false);
            if (jugador.getPuntuacionJugador().getConseguidasSuperior().get(i).equals(false)) {
                panelPuntosSuperior.getCelda(i, indexColumna).setText("");
            }
        }
        for (int i = 0; i < jugador.getPuntuacionJugador().getConseguidasInferior().size(); i++) {
            ((CeldaDePanel) panelPuntosInferior.getCelda(i, indexColumna)).setEstaEnSeleccion(false);
            ((CeldaDePanel) panelPuntosInferior.getCelda(i, indexColumna)).setEstaEnPrevioPuntos(false);
            if (jugador.getPuntuacionJugador().getConseguidasInferior().get(i).equals(false)) {
                panelPuntosInferior.getCelda(i, indexColumna).setText("");
            }
        }

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
    private javax.swing.JLabel jlImagenJugadorLocal;
    private javax.swing.JLabel jlImagenJugadorRemoto;
    private javax.swing.JLabel jlNombreJugadorLocal;
    private javax.swing.JLabel jlNombreJugadorRemoto;
    private javax.swing.JLabel jlTurno;
    private javax.swing.JPanel jpPuntos;
    private javax.swing.JPanel jpTablero;
    // End of variables declaration//GEN-END:variables

    public PanelPuntos getPanelPuntosSuperior() {
        return panelPuntosSuperior;
    }

    public PanelPuntos getPanelPuntosInferior() {
        return panelPuntosInferior;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public Jugador getJugadorRemoto() {
        return jugadorRemoto;
    }

    public DadosPartida getDadosPartida() {
        return dadosPartida;
    }

    public void setDadosPartida(DadosPartida dadosPartida) {
        this.dadosPartida = dadosPartida;
    }

    public EleccionPersonajeJDialog getEleccionPersonajeLocalJDialog() {
        return eleccionPersonajeLocalJDialog;
    }

    public void setEleccionPersonajeLocalJDialog(EleccionPersonajeJDialog eleccionPersonajeLocalJDialog) {
        this.eleccionPersonajeLocalJDialog = eleccionPersonajeLocalJDialog;
    }

}
