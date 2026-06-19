/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;
import apoio.ConexaoBD;
import apoio.FileManager;
import entidades.Produtora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author joao.fernandes2
 */
public class ProdutoraDAO {
    
     private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados
    
    public void salvar(Produtora p) throws SQLException {
        String sql = ""
                + "INSERT INTO produtora (razaosocial, nomefantasia, cnpj, telefone, email) VALUES ("
                + "'" + p.getRazaosocial() + "',"
                + "'" + p.getNomefantasia() + "',"
                + "'" + p.getTelefone() + "',"
                + "'" + p.getCnpj() + "', "
                 + "'" + p.getEmail() + "' "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
    
     public void editar(Produtora p) throws SQLException {
        String sql = ""
                + "UPDATE produtora SET "
                + "razaosocial = '" + p.getRazaosocial() + "',"
                + "nomefantasia = '" + p.getNomefantasia() + "',"
                + "cnpj = '" + p.getCnpj() + "',"
                + "telefone = '" + p.getTelefone() + "', "
                 + "email = '" + p.getEmail() + "'"
                 
                + "WHERE idcliente = " + p.getIdprod();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Produtora> recuperarTodos() throws SQLException {
        ArrayList<Produtora> produtoras = new ArrayList();
        
        String sql = ""
                + "SELECT * FROM produtora";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Produtora p = new Produtora();

            p.setIdprod(resultadoQ.getInt("idprod"));
            p.setRazaosocial(resultadoQ.getString("razaosocial"));
            p.setNomefantasia(resultadoQ.getString("nomefantasia"));
            p.setTelefone(resultadoQ.getString("telefone"));
            p.setCnpj(resultadoQ.getString("cnpj"));
            p.setEmail(resultadoQ.getString("email"));
            
            produtoras.add(p);
        }
         return produtoras;
    }
  
   public Produtora recuperarUm(int id) throws SQLException {

        String sql = ""
                + "SELECT * FROM produtora WHERE idprod = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Produtora p = new Produtora();

            p.setIdprod(resultadoQ.getInt("idprod"));
            p.setRazaosocial(resultadoQ.getString("razaosocial"));
            p.setNomefantasia(resultadoQ.getString("nomefantasia"));
            p.setCnpj(resultadoQ.getString("cnpj"));
            p.setTelefone(resultadoQ.getString("telefone"));
             p.setEmail(resultadoQ.getString("email"));
             

            return p;
        }

        return null;
    }

       
 public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM produtora WHERE idprod = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}



