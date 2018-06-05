/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jopo.Arbusto;
import jopo.Planta;
import static jopo.Planta.obterConexao;

/**
 *
 * @author Matheus Maia
 */
public class daoArbusto {
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/botanica", "root", "");
        return conn;
    }
    
      public static void salvar(Arbusto p) throws ClassNotFoundException {
            try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO botanica.Arbusto (id_nome, Podar) "
                            + "VALUES (?,?)")) {
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getPodar());
                

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            
        }
    }

    public static void atualizar(Arbusto p) {
        try {
            
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Planta SET "
                    + " Podar = ?"
                    + " WHERE id_nome = ? ");
            stmt.setString(1, p.getPodar());
            stmt.setInt(2, p.getId());

            stmt.executeUpdate();

            conn.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void deletar(int id) {
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE botanica.Arbusto  WHERE id_nome = ? ")) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    

    public static List<Arbusto>  getAll() throws ClassNotFoundException, SQLException {
        
        List<Arbusto> lista = new ArrayList<Arbusto>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, porte, estado, Podar"
                        + " FROM botanica.Planta a inner join botanica.Arbusto b on a.Id = b.id_nome ");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String porte = resultados.getString("porte");
                boolean estado = resultados.getBoolean("estado");
                String podar = resultados.getString("Podar");

               Arbusto p = new Arbusto();
                p.setId(id);
                p.setNome(nome);
                p.setPorte(porte);
                p.setEstado(estado);
                p.setPodar(podar);

                lista.add(p);

            }
        }
        return lista;
    }
}
