/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro.logica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Estudiantes
 */
public class Cronometro {

    private UnidadTiempo decimas;
    private UnidadTiempo segundos;
    private UnidadTiempo minutos;
    private UnidadTiempo horas;

    private ArrayList<Memoria> memorias;

    public Cronometro() {
        decimas = new UnidadTiempo(10);
        segundos = new UnidadTiempo(60);
        minutos = new UnidadTiempo(60);
        horas = new UnidadTiempo(24);
        memorias = new ArrayList<Memoria>();
    }

    public UnidadTiempo getDecimas() {
        return decimas;
    }

    public void setDecimas(UnidadTiempo decimas) {
        this.decimas = decimas;
    }

    public UnidadTiempo getSegundos() {
        return segundos;
    }

    public void setSegundos(UnidadTiempo segundos) {
        this.segundos = segundos;
    }

    public UnidadTiempo getMinutos() {
        return minutos;
    }

    public void setMinutos(UnidadTiempo minutos) {
        this.minutos = minutos;
    }

    public UnidadTiempo getHoras() {
        return horas;
    }

    public void setHoras(UnidadTiempo horas) {
        this.horas = horas;
    }

    public void avanzar() {
        decimas.avanzar();
        if (decimas.getValor() == 0) {
            segundos.avanzar();
            if (segundos.getValor() == 0) {
                minutos.avanzar();
                if (minutos.getValor() == 0) {
                    horas.avanzar();
                }
            }
        }
    }

    public void retroceder() {
        decimas.retroceder();
        if (decimas.getValor() == decimas.getTope()-1) {
            segundos.retroceder();
            if (segundos.getValor() == segundos.getTope()-1) {
                minutos.retroceder();
                if (minutos.getValor() == minutos.getTope()-1) {
                    horas.retroceder();
                }
            }
        }
    }
    
    public String obtenerTiempo() {
        return horas.obtenerValorFormateado() + " : "
                + minutos.obtenerValorFormateado() + " : "
                + segundos.obtenerValorFormateado() + " : "
                + decimas.obtenerValorFormateado();
    }

    public void guardarMemoria() {
        Memoria m = new Memoria();
        
        m.setValorDecimas(decimas.getValor());
        m.setValorSegundos(segundos.getValor());
        m.setValorMinutos(minutos.getValor());
        m.setValorHoras(horas.getValor());
        
        memorias.add(m);
        
    }

    public void mostrarMemorias() {
        for (Memoria memoria : memorias) {
            System.out.println("Memoria: " + memoria.obtenerTiempo());
        }
    }
    public String mostrarMemoriasGUI() {
        String a = "";
        for (Memoria memoria : memorias) {
            a = (a+memoria.obtenerTiempo()+"\n");
        }
        return a;
    }
}
