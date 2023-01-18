package com.simuladorhuerto.clases;

import com.simuladorhuerto.huerto.Huerto;
public class Granjero extends Thread{
    private String nombre;
    private int elementosMaximos;
    private int tiempoCrecimiento;
    private Huerto huerto;

    public Granjero(String nombre, int elementosMaximos, int tiempoCrecimiento, Huerto huerto) {
        this.nombre = nombre;
        this.elementosMaximos = elementosMaximos;
        this.tiempoCrecimiento = tiempoCrecimiento;
        this.huerto = huerto;
    }

    private String obtenerElemento() {
        String[] elementos = {"lettuce",  "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
        return elementos[(int) (Math.random() * (elementos.length - 1))];
    }

    private long tiempoEnCrecer() {
        return (long) (Math.random() * (this.tiempoCrecimiento - 1)) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.elementosMaximos; i++) {
            try {
                String verduraAProducir = this.obtenerElemento();
                long tiempoCrecimiento = this.tiempoEnCrecer();
                Thread.sleep(tiempoCrecimiento * 1000);
                this.huerto.anadir(this.nombre, verduraAProducir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
