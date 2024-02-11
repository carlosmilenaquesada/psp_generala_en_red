package controladores;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import modelos.gui.Dado.Valor;

public class Imagenes{

    public final static ArrayList<Image> imagenesRepositorio = crearRepositorioImagenes();

    private static ArrayList<Image> crearRepositorioImagenes() {
        ArrayList<Image> imagenes = new ArrayList<>();
        imagenes.add(new ImageIcon("./src/media/dados/dado_uno.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/dado_dos.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/dado_tres.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/dado_cuatro.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/dado_cinco.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/dado_seis.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dados/interrogacion.gif").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/libre.png").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/poker.png").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/full.png").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/escalera_corta.png").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/escalera_larga.png").getImage());
        imagenes.add(new ImageIcon("./src/media/categorias/generala.png").getImage());

        
        return imagenes;
    }

    public final static HashMap<Valor, ImageIcon> imagenesDado = imagenesEstadosDado();

    private static HashMap<Valor, ImageIcon> imagenesEstadosDado() {
        HashMap<Valor, ImageIcon> coleccion = new HashMap<>();
        coleccion.put(Valor.UNO, new ImageIcon(imagenesRepositorio.get(0)));
        coleccion.put(Valor.DOS, new ImageIcon(imagenesRepositorio.get(1)));
        coleccion.put(Valor.TRES, new ImageIcon(imagenesRepositorio.get(2)));
        coleccion.put(Valor.CUATRO, new ImageIcon(imagenesRepositorio.get(3)));
        coleccion.put(Valor.CINCO, new ImageIcon(imagenesRepositorio.get(4)));
        coleccion.put(Valor.SEIS, new ImageIcon(imagenesRepositorio.get(5)));
        coleccion.put(Valor.INTERROGACION, new ImageIcon(imagenesRepositorio.get(6)));
        return coleccion;
    }
    
     
    

}
