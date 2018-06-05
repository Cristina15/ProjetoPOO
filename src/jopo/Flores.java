/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jopo.Planta.obterConexao;

/**
 *
 * @author Matheus Maia and Vitoria Cristina
 */
public class Flores extends Planta {

    private String cor;

    @Override
    public void tempRegar(Planta p) {
        int delay = 4000;   // delay padrão de 4 seg.
        int interval = 4000;  // intervalo padrão de 4 seg.
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }



}
