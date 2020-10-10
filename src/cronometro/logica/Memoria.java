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
public class Memoria {
    private UnidadTiempo decimas;
    private UnidadTiempo segundos;
    private UnidadTiempo minutos;
    private UnidadTiempo horas;

    public Memoria() {
        decimas = new UnidadTiempo(10);
        segundos = new UnidadTiempo(60);
        minutos = new UnidadTiempo(60);
        horas = new UnidadTiempo(24);
    }  
    
    public void setValorDecimas(int valor){
        decimas.setValor(valor);
    }
    
    public void setValorSegundos(int valor){
        segundos.setValor(valor);
    }
    
    public void setValorMinutos(int valor){
        minutos.setValor(valor);
    }
    
    public void setValorHoras(int valor){
        horas.setValor(valor);
    }
    
    public String obtenerTiempo(){
        return horas.obtenerValorFormateado()+ " : " +
                minutos.obtenerValorFormateado()+ " : " +
                segundos.obtenerValorFormateado()+ " : " +
                decimas.obtenerValorFormateado();
    }
    
        
}
