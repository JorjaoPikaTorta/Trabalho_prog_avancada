/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import apoio.FileManager;
import entidades.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joao.fernandes2
 */
public class FuncionarioDAO {
     private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados
    
    public void salvar(Funcionario f) throws SQLException {
        String sql = ""
                + "INSERT INTO funcionario (nomefunc, cpf, datanasc, cargo, salario , status) VALUES ("
                + "'" + f.getNomefunc() + "',"
                + "'" + f.getCpf() + "',"
                 + "'" + f.getDatanasc() + "', "
                + "'" + f.getCargo() + "', "
                + "" + f.getSalario() + ", "
                  + "'" + f.getStatus() + "' "
                + ")";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Funcionario> recuperarTodos() throws SQLException {
        ArrayList<Funcionario> funcionario = new ArrayList();
        
        String sql = ""
                + "SELECT * FROM funcionario";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Funcionario f = new Funcionario();

            f.setIdfunc(resultadoQ.getInt("idfunc"));
            f.setNomefunc(resultadoQ.getString("nomefunc"));
            f.setCpf(resultadoQ.getString("cpf"));
            f.setDatanasc(resultadoQ.getString("datanasc"));
            f.setCargo(resultadoQ.getString("cargo"));
            f.setSalario(resultadoQ.getString("salario"));
            f.setStatus(resultadoQ.getString("status"));
            funcionario.add(f);
        }

        return funcionario;
    }
 public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM funcionario WHERE idfunc = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}

