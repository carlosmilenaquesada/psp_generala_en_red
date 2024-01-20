package controladores;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import modelos.Dado.Valor;

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
        imagenes.add(new ImageIcon("").getImage());
        imagenes.add(new ImageIcon("./src/media/interrogacion.png").getImage());
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
        coleccion.put(Valor.INTERROGACION, new ImageIcon(imagenesRepositorio.get(7)));
        return coleccion;
    }

}
