/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import static dao.daoArbusto.obterConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Maia and Vitoria Cristina
 */
public abstract class Planta implements crud {
    private int id;
    private String nome;
    private String porte;
    private boolean estado;

    public void tempRegar(Planta p) {
        int delay = 5000;   // delay padrão de 5 seg.
        int interval = 1000;  // intervalo padrão de 1 seg.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                p.setEstado(!estado);
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

    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/botanica", "root", "");
        return conn;
    }

    public void salvar(Planta p) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO botanica.Planta (nome, porte, estado) "
                            + "VALUES (?,?,?)")) {
                stmt.setString(1, p.getNome());
                stmt.setString(2, p.getPorte());
                stmt.setBoolean(3, p.getEstado());

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }

    }

    public void atualizar(Planta P) throws ClassNotFoundException, SQLException {
        try {
            
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Planta SET "
                    + " nome = ?, porte =?, Estado =?"
                    + " WHERE id = ? ");
            stmt.setString(1, P.getNome());
            stmt.setString(2, P.getPorte());
            stmt.setBoolean(3, P.getEstado());

            stmt.executeUpdate();

            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void deletar(Planta p) throws ClassNotFoundException, SQLException {
         try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE botanica.Planta  WHERE id_nome = ? ")) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
    
    }

    public List<Planta> listar() throws ClassNotFoundException, SQLException {

        List<Planta> lista = new ArrayList<Planta>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, porte, estado"
                        + " FROM botanica.Planta");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String porte = resultados.getString("porte");
                boolean estado = resultados.getBoolean("estado");

// chamar classe planta? da erro
// Planta p = new Planta();
// fiz assim por que estava dando erro de inicialização
                Planta p = null;

                p.setNome(nome);
                p.setPorte(porte);
                p.setEstado(estado);

                lista.add(p);

            }
        }
        return lista;
    }

    public Object getById(int id) {
//         public Carro select(int id) throws ClassNotFoundException, SQLException {
//
//        Carro carro = new Carro();
    
            Planta p = null;
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT * FROM botanica.Planta WHERE id = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                String nome = resultados.getString("nome");
                String porte = resultados.getString("porte");
                Boolean estado = resultados.getBoolean("estado");
               
                p.setNome(nome);
                p.setPorte(porte);
                p.setEstado(estado);
               
            }
            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
