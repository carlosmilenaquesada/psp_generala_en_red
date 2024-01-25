package modelos.datos;

import controladores.Rectangles;
import java.util.ArrayList;
import modelos.gui.Dado;

public class DadosPartida {

    private ArrayList<Dado> dados;
    private ArrayList<Boolean> reservaOcupadas;
    private ArrayList<Boolean> tapeteOcupadas;

    public DadosPartida() {
        this.reservaOcupadas = rellenarOcupadas(false);
        this.tapeteOcupadas = rellenarOcupadas(true);
    }

    public DadosPartida(ArrayList<Dado> dados) {
        this.dados = dados;

    }

    public DadosPartida(ArrayList<Dado> dados, ArrayList<Boolean> reservaOcupadas, ArrayList<Boolean> tapeteOcupadas) {
        this.dados = dados;
        this.reservaOcupadas = reservaOcupadas;
        this.tapeteOcupadas = tapeteOcupadas;
    }

    private ArrayList<Boolean> rellenarOcupadas(boolean valorInicial) {
        ArrayList<Boolean> arrayOcupadas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayOcupadas.add(valorInicial);
        }
        return arrayOcupadas;
    }

    public Rectangles.RectanglesDados primeraPosicionLibreReserva() {
        return Rectangles.RectanglesDados.values()[reservaOcupadas.indexOf(false)];
    }

    public void ocuparPosicionReserva(Rectangles.RectanglesDados posicion) {
        reservaOcupadas.set(posicion.ordinal(), true);
    }

    public void desocuparPosicionReserva(Rectangles.RectanglesDados posicion) {
        reservaOcupadas.set(posicion.ordinal(), false);
    }

    public Rectangles.RectanglesDados primeraPosionLibreTapete() {
        return Rectangles.RectanglesDados.values()[tapeteOcupadas.indexOf(false) + 5];
    }

    public void ocuparPosicionTapete(Rectangles.RectanglesDados posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, true);
    }

    public void desocuparPosicionTapete(Rectangles.RectanglesDados posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, false);
    }

    public ArrayList<Dado> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Dado> dados) {
        this.dados = dados;
    }

}
