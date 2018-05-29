/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Matheus Maia
 */
public abstract class Planta implements dao{
   
    private String nome;
    private String porte;
    private boolean estado;

    public void tempRegar(){
    int delay = 5000;   // delay padrão de 5 seg.
    int interval = 1000;  // intervalo padrão de 1 seg.
    Timer timer = new Timer();
    
    timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                estado = (!estado);
            }
        }, delay, interval);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
