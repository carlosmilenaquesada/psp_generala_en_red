package controladores;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import modelos.DadoDefecto.Estado;

public class Imagenes {

    public final static ArrayList<Image> imagenesRepositorio = crearRepositorioImagenes();

    private static ArrayList<Image> crearRepositorioImagenes() {
        ArrayList<Image> imagenes = new ArrayList<>();
        imagenes.add(new ImageIcon("./src/media/dado_uno.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dado_dos.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dado_tres.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dado_cuatro.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dado_cinco.png").getImage());
        imagenes.add(new ImageIcon("./src/media/dado_seis.png").getImage());
        imagenes.add(new ImageIcon("./src/media/interrogacion.png").getImage());
        return imagenes;
    }

    public final static HashMap<Estado, ImageIcon> imagenesDado = imagenesEstadosDado();

    private static HashMap<Estado, ImageIcon> imagenesEstadosDado() {
        HashMap<Estado, ImageIcon> coleccion = new HashMap<>();
        coleccion.put(Estado.VACIO, new ImageIcon());
        coleccion.put(Estado.UNO, new ImageIcon(imagenesRepositorio.get(0)));
        coleccion.put(Estado.DOS, new ImageIcon(imagenesRepositorio.get(1)));
        coleccion.put(Estado.TRES, new ImageIcon(imagenesRepositorio.get(2)));
        coleccion.put(Estado.CUATRO, new ImageIcon(imagenesRepositorio.get(3)));
        coleccion.put(Estado.CINCO, new ImageIcon(imagenesRepositorio.get(4)));
        coleccion.put(Estado.SEIS, new ImageIcon(imagenesRepositorio.get(5)));
        coleccion.put(Estado.INTERROGACION, new ImageIcon(imagenesRepositorio.get(6)));
        return coleccion;
    }

}
