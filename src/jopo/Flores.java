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
import static jopo.Planta.obterConexao;

/**
 *
 * @author Matheus Maia
 */
public class Flores extends Planta {

    private String cor;

    @Override
    public void tempRegar() {
        int delay = 4000;   // delay padrão de 4 seg.
        int interval = 4000;  // intervalo padrão de 4 seg.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                setEstado(!getEstado());
            }
        }, delay, interval);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    
    public void salvar(Flores p) throws ClassNotFoundException, SQLException {
    
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO botanica.Flores (cor"
                            + "VALUES (?)")) {
                stmt.setString(1, p.getCor());
                

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }
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
        Flores flor = new Flores();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * FROM botanica.Flores WHERE id_carro = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                String cor = resultados.getString("cor");
                
                flor.setCor(cor);

            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return cor;
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
