/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import apoio.FileManager;
import entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author roveda
 */
public class ClienteDAO {

    private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados
    
    public void salvar(Cliente c) throws SQLException {
        String sql = ""
                + "INSERT INTO cliente (nome, cpf, telefone, endereco, datanasc, status) VALUES ("
                + "'" + c.getNome() + "',"
                + "'" + c.getCpf() + "',"
                + "'" + c.getTelefone() + "',"
                + "'" + c.getEndereco() + "', "
                 + "'" + c.getDatanasc() + "', "
                + "'" + c.getStatus() + "' "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
    
      public void editar(Cliente c) throws SQLException {
        String sql = ""
                + "UPDATE cliente SET "
                + "nome = '" + c.getNome() + "',"
                + "cpf = '" + c.getCpf() + "',"
                + "telefone = '" + c.getTelefone() + "',"
                + "endereco = '" + c.getEndereco() + "', "
                 + "datanasc = '" + c.getDatanasc() + "',"
                 + "status = '" + c.getStatus() + "' "
                + "WHERE idcliente = " + c.getIdcliente();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Cliente> recuperarTodos() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList();
        
        String sql = ""
                + "SELECT * FROM cliente";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cliente c = new Cliente();

            c.setIdcliente(resultadoQ.getInt("idcliente"));
            c.setNome(resultadoQ.getString("nome"));
            c.setCpf(resultadoQ.getString("cpf"));
            c.setTelefone(resultadoQ.getString("telefone"));
            c.setEndereco(resultadoQ.getString("endereco"));
            c.setDatanasc(resultadoQ.getString("datanasc"));
            c.setStatus(resultadoQ.getString("status"));
            clientes.add(c);
        }

        return clientes;
    }
    
     public Cliente recuperarUm(int id) throws SQLException {

        String sql = ""
                + "SELECT * FROM cliente WHERE idcliente = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Cliente c = new Cliente();

            c.setIdcliente(resultadoQ.getInt("idcliente"));
            c.setNome(resultadoQ.getString("nome"));
            c.setCpf(resultadoQ.getString("cpf"));
            c.setTelefone(resultadoQ.getString("telefone"));
            c.setEndereco(resultadoQ.getString("endereco"));
             c.setDatanasc(resultadoQ.getString("datanasc"));
              c.setStatus(resultadoQ.getString("status"));

            return c;
        }

        return null;
    }
     
 public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM cliente WHERE idcliente = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}

