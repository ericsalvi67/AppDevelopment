package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import apoio.MD5;
import entidade.Usuario;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UsuarioDAO implements IDAOT<Usuario> {

    public static final String _select = "select email, senha "
            + "from usuario "
            + "where email = ? "
            + "and senha = ? "
            + "and situacao = 'A'";

    @Override
    public String salvar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public String atualizar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultar(String criterio, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Usuario consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    public boolean autenticar(Usuario u) {

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_select);

            pst.setString(1, u.email);
            pst.setString(2, MD5.getMd5(u.senha));

            ResultSet result = pst.executeQuery();
            System.out.println("SQL executado!");

            if (result.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro ao autenticar usuário: " + e);
            return false;
        }
    }

}
