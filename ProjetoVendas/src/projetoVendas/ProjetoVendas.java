package projetoVendas;

import apoio.ConexaoBD;
import apoio.TablesInsertionDB;
import java.sql.*;
import javax.swing.JOptionPane;
import tela.FrmPrincipal;

/**
 *
 * @author Erics.
 */
public class ProjetoVendas {

    static Connection conexao = null;
    
    public static void main(String[] args) {
        
        var create = new TablesInsertionDB();
        
        try{
            // com classe ConexaoBD.java
            if (ConexaoBD.getInstance().getConnection() != null) {
                new FrmPrincipal().setVisible(true);
                create.CreateTables();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
            }
        }
        catch(Exception e){
            System.err.println(e);
        }       
    }
}
