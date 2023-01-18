package com.simuladorhuerto.clases;

import com.simuladorhuerto.huerto.Huerto;

public class Consumidor extends Thread{

    private String nombreString;
    private Huerto huerto;
    private int elementosAConsumir;
    private final long tiempoConsumo;

    public Consumidor(String nombreString, int elementosAConsumir, int tiempoConsumo, Huerto huerto) {
        this.nombreString = nombreString;
        this.elementosAConsumir = elementosAConsumir;
        this.huerto = huerto;
        this.tiempoConsumo = tiempoConsumo * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.elementosAConsumir; i++) {
            try {
                String verduraAConsumir = this.huerto.consumir(this.nombreString);
                Thread.sleep(this.tiempoConsumo);
                System.out.println(this.nombreString + " ha consumido --> " + verduraAConsumir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
