package com.simuladorhuerto.huerto;
import java.util.ArrayList;

public class Huerto {
    private int capacidad;
    private ArrayList<String> cesta = new ArrayList<String>();

    public Huerto(int capacidadHuerto) {
        this.capacidad = capacidadHuerto;
    }

    synchronized public void anadir(String nombreGranjero, String nuevaVerdura) throws InterruptedException {
        while (this.cesta.size() >= this.capacidad) {
            wait();
        }
        this.cesta.add(nuevaVerdura);
        System.out.println(nombreGranjero + " ha producido --> " + nuevaVerdura);
        notifyAll();
    }

    synchronized public String consumir(String clientName) throws InterruptedException {
        while (this.cesta.size() == 0) {
            wait();
        }
        String verduraAConsumir = this.cesta.remove(0);
        notifyAll();
        return verduraAConsumir;
    }
}