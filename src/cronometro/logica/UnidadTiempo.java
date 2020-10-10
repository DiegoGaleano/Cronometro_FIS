/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro.logica;

/**
 *
 * @author Estudiantes
 */
public class UnidadTiempo {

    private int tope;
    private int valor;

    public UnidadTiempo(int tope) {
        this.tope = tope;
        this.valor = 0;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String obtenerValorFormateado() {
        if (this.valor < 10 && this.tope > 10) {
            return "0" + this.valor;
        } else {
            return String.valueOf(this.valor);
        }
    }

    public void avanzar() {
        valor++;
        if (valor == tope) {
            valor = 0;
        }
    }
    
    public void retroceder() {
        valor--;
        if (valor < 0) {
            valor = tope-1;
        }
    }
}
