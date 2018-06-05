/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.daoArbusto.obterConexao;
import static dao.daoArvores.obterConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jopo.Arvores;
import jopo.Flores;
import static jopo.Planta.obterConexao;

/**
 *
 * @author Matheus Maia
 */
public class daoFlores {
     
    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/botanica", "root", "");
        return conn;
    }
    
        
    public void salvar(Flores p) throws ClassNotFoundException, SQLException {
    
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO botanica.Flores (id_nome, cor) "
                            + "VALUES (?,?)")) {
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getCor());
                

                int status = stmt.executeUpdate();

                // Efetivar todas as operações no BD
                conn.commit();
            }

        } catch (SQLException e) {
            // Em caso de erro, volta para situação inicial

            throw e;
        }
    }

    
    public void atualizar(Flores p) {
         try {
            
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(" UPDATE Planta SET "
                    + " Cor = ?"
                    + " WHERE id_nome = ? ");
            stmt.setString(1, p.getCor());
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
                        "DELETE botanica.Flores WHERE id_nome = ? ")) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

//    public Object getById(int id) {
//        Flores flor = new Flores();
//
//        try (Connection conn = obterConexao();
//                PreparedStatement stmt = conn.prepareStatement(
//                        "select * FROM botanica.Flores WHERE id_carro = " + id);
//                ResultSet resultados = stmt.executeQuery()) {
//
//            while (resultados.next()) {
//
//                String cor = resultados.getString("cor");
//                
//                flor.setCor(cor);
//
//            }
//            conn.close();
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return Flores;
//    }

  public List<Flores> getAll() throws ClassNotFoundException, SQLException {
        
        List<Flores> lista = new ArrayList<Flores>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, porte, estado, cor"
                        + " FROM botanica.Planta a inner join botanica.Flores b on a.Id = b.id_nome ");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String porte = resultados.getString("porte");
                boolean estado = resultados.getBoolean("estado");
                String cor = resultados.getString("cor");

                Flores p = new Flores();
                p.setId(id);
                p.setNome(nome);
                p.setPorte(porte);
                p.setEstado(estado);
                p.setCor(cor);


                lista.add(p);

            }
        }
        return lista;
    }

}
