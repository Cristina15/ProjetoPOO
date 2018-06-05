/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Maia and Vitoria Cristina
 */
public class Arvores extends Planta{
    private String fruto;
    private String altura;

    @Override
    public void tempRegar(Planta p){
    int delay = 20000;   // delay padrão de 20 seg.
    int interval = 20000;  // intervalo padrão de 20 seg.
    Timer timer = new Timer();
    
    timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                p.setEstado(!(p.getEstado()));
                try {
                    atualizar(p);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Planta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Planta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, delay, interval);
    }
    
    public String getFruto() {
        return fruto;
    }

    public void setFruto(String fruto) {
        this.fruto = fruto;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

     }


    

