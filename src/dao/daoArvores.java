/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.daoArbusto.obterConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jopo.Arbusto;
import jopo.Arvores;
import static jopo.Planta.obterConexao;

/**
 *
 * @author Matheus Maia
 */
public class daoArvores {
     
    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/botanica", "root", "");
        return conn;
    }
    
       
    public void salvar(Arvores p) throws ClassNotFoundException {
         try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO botanica.Arbusto (id_nome, Fruto, Altura) "
                            + "VALUES (?,?,?)")) {
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getFruto());
                stmt.setString(3, p.getAltura());
                

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            
        }
    }

    public void atualizar(Arvores p) {
        try {
            
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Planta SET "
                    + " Fruto = ?, Altura = ?"
                    + " WHERE id_nome = ? ");
            stmt.setString(1, p.getFruto());
            stmt.setString(2, p.getAltura());
            stmt.setInt(3, p.getId());

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
                        "DELETE botanica.Arvores  WHERE id_nome = ? ")) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    public static List<Arvores> getAll() throws ClassNotFoundException, SQLException {
        
        List<Arvores> lista = new ArrayList<Arvores>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, porte, estado, Fruto, Altura"
                        + " FROM botanica.Planta a inner join botanica.Arvores b on a.Id = b.id_nome ");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String porte = resultados.getString("porte");
                boolean estado = resultados.getBoolean("estado");
                String fruto = resultados.getString("Fruto");
                String altura = resultados.getString("Altura");

                Arvores p = new Arvores();
                p.setId(id);
                p.setNome(nome);
                p.setPorte(porte);
                p.setEstado(estado);
                p.setFruto(fruto);
                p.setAltura(altura);

                lista.add(p);

            }
        }
        return lista;
    }
}
