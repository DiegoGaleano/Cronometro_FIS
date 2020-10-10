/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import cronometro.logica.Cronometro;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Estudiantes
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        final int a = 0;

        Timer timer = new Timer();

        TimerTask task;
        task = new TimerTask() {
            int contador = 0;

            @Override
            public void run() {
                c.avanzar();
                System.out.println(c.obtenerTiempo());
                contador++;
                if (contador % 100 == 0) {
                    c.guardarMemoria();
                }
            }
        };

        TimerTask task2;
        task2 = new TimerTask() {
            int contador = 0;

            @Override
            public void run() {
                c.retroceder();
                System.out.println(c.obtenerTiempo());
            }
        };

        timer.scheduleAtFixedRate(task, 0, 100);
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
        }
        task.cancel();

        System.out.println("Memorias:");
        c.mostrarMemorias();

        System.out.println("Retrocediendo:");
        timer.scheduleAtFixedRate(task2, 0, 100);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        task2.cancel();
        timer.cancel();
    }
}
