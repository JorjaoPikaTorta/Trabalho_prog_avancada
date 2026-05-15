/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplotelas;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import telas.TelaPrincipal;

/**
 *
 * @author roveda
 */
public class ExemploTelas {

    public static void main(String[] args) {        
        try {
            ConexaoBD.getInstance().getConnection();
            TelaPrincipal tp = new TelaPrincipal();
            tp.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!\nPor favor entre em contato com o suporte.");
        } finally {
            ConexaoBD.getInstance().shutdown();
        }
    }
}
