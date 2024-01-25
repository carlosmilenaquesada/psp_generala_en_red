package modelos.flujo;

import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Rectangle;
import modelos.datos.DadosPartida;
import modelos.gui.Dado.Valor;
import vistas.Main;

public class RecepcionDatos {
    public static void gestionarDatos(ObjetoDato objetoDato) {
        System.out.println(objetoDato);
        String clave = objetoDato.getClave();
        switch (clave) {
            case ObjetoDato.DATOS_PARTIDA:
                SerializacionPartida serializacionPartida = (SerializacionPartida) objetoDato.getValor();
                //DADOS
                SerializacionPartida.DadosSerializados dadosSerializados = serializacionPartida.getDadosSerializados();
                
                DadosPartida dadosPartida = Main.getPrincipalJFrame().getDadosPartida();
                for (int i = 0; i < dadosPartida.getDados().size(); i++) {
                    System.out.println(RectanglesDados.values()[dadosSerializados.getIndexRectanglesEnumDados().get(i)]);
                    
                    dadosPartida.getDados().get(i).getjLabel().setBounds(Rectangles.rectanglesDados.get(RectanglesDados.values()[dadosSerializados.getIndexRectanglesEnumDados().get(i)]));
                    
                    dadosPartida.getDados().get(i).setValor(Valor.values()[dadosSerializados.getIndexValorEnumDados().get(i)]);NO VA ESTA LÍNEA
                    

                }
                Main.getPrincipalJFrame().setDadosPartida(dadosPartida);

                break;
            case ObjetoDato.MENSAJE_CHAT:
                MensajeChat mensajeChat = (MensajeChat) objetoDato.getValor();

                break;

            default:
                throw new AssertionError();
        }

    }

}
