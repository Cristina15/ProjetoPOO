/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Matheus Maia
 */
public class Arbusto extends Planta{

    private String Podar;
    
    
    
    @Override
    public void tempRegar(){
    int delay = 10000;   // delay padrão de 10 seg.
    int interval = 10000;  // intervalo padrão de 10 seg.
    Timer timer = new Timer();
    
    timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                setEstado(!getEstado());
            }
        }, delay, interval);
    }
    
    public String getPoudar() {
        return Podar;
    }

    public void setPoudar(String Poudar) {
        this.Podar = Poudar;
    }

    @Override
    public void salvar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
