/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.DAO.ProdutoraDAO;
import entidades.Produtora;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author joao.fernandes2
 */
public class ControlaProdutora {
    
     private ProdutoraDAO pDAO = new ProdutoraDAO();

    public boolean salvar(Produtora p) {
        try {
            pDAO.salvar(p);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Produtora> recuperarTodos() {
        try {
            return pDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar produtora: " + ex.getMessage());
            return null;
        }
    }
      
    public boolean excluir(int id){
        try {
            pDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produtora: " + ex.getMessage());
            return false;
        }
    }
}

