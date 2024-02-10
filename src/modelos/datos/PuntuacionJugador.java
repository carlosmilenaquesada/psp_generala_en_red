package modelos.datos;

import java.io.Serializable;
import java.util.ArrayList;

public class PuntuacionJugador implements Serializable {

    private ArrayList<Boolean> conseguidasSuperior;
    private ArrayList<Boolean> conseguidasInferior;
    private ArrayList<Integer> puntosSuperior;
    private ArrayList<Integer> puntosInferior;
    private int bonus;

    public PuntuacionJugador() {
        this.conseguidasSuperior = rellenarConseguidasDefecto(false);
        this.conseguidasInferior = rellenarConseguidasDefecto(false);
        this.puntosSuperior = rellenarPuntosDefecto(0);
        this.puntosInferior = rellenarPuntosDefecto(0);
        this.bonus = 0;
    }

    public PuntuacionJugador(ArrayList<Boolean> conseguidasSuperior, ArrayList<Boolean> conseguidasInferior, ArrayList<Integer> puntosSuperior, ArrayList<Integer> puntosInferior, int bonus) {
        this.conseguidasSuperior = conseguidasSuperior;
        this.conseguidasInferior = conseguidasInferior;
        this.puntosSuperior = puntosSuperior;
        this.puntosInferior = puntosInferior;
        this.bonus = bonus;
    }

    private ArrayList<Integer> rellenarPuntosDefecto(Integer valorDefecto) {
        ArrayList<Integer> arrayDefecto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayDefecto.add(valorDefecto);
        }
        return arrayDefecto;
    }

    private ArrayList<Boolean> rellenarConseguidasDefecto(boolean valorInicial) {
        ArrayList<Boolean> arrayOcupadas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayOcupadas.add(valorInicial);
        }
        return arrayOcupadas;
    }

    public int getCalculoPuntosTotales() {
        int puntosTotales = 0;
        for (int i = 0; i < 6; i++) {
            puntosTotales += this.puntosSuperior.get(i);
            puntosTotales += this.puntosInferior.get(i);
        }

        puntosTotales = puntosTotales + (this.bonus >= 63 ? 35 : 0);
        return puntosTotales;
    }

    public ArrayList<Boolean> getConseguidasSuperior() {
        return conseguidasSuperior;
    }

    public void setConseguidasSuperior(ArrayList<Boolean> conseguidasSuperior) {
        this.conseguidasSuperior = conseguidasSuperior;
    }

    public void setConseguidaSuperior(int index, boolean valor) {
        this.conseguidasSuperior.set(index, valor);

    }

    public ArrayList<Boolean> getConseguidasInferior() {
        return conseguidasInferior;
    }

    public void setConseguidasInferior(ArrayList<Boolean> conseguidasInferior) {
        this.conseguidasInferior = conseguidasInferior;
    }

    public void setConseguidaInferior(int index, boolean valor) {
        this.conseguidasInferior.set(index, valor);

    }

    public ArrayList<Integer> getPuntosSuperior() {
        return puntosSuperior;
    }

    public void setPuntosSuperior(ArrayList<Integer> puntosSuperior) {
        this.puntosSuperior = puntosSuperior;
    }

    public void setPuntoSuperior(int index, int valor) {

        this.puntosSuperior.set(index, valor);

    }

    public ArrayList<Integer> getPuntosInferior() {
        return puntosInferior;
    }

    public void setPuntosInferior(ArrayList<Integer> puntosInferior) {
        this.puntosInferior = puntosInferior;
    }

    public void setPuntoInferior(int index, int valor) {
        this.puntosInferior.set(index, valor);

    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "PuntuacionJugador{" + "conseguidasSuperior=" + conseguidasSuperior + ", conseguidasInferior=" + conseguidasInferior + ", puntosSuperior=" + puntosSuperior + ", puntosInferior=" + puntosInferior + ", bonus=" + bonus + '}';
    }

}
