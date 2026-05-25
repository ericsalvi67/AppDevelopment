package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FornecedorDAO implements IDAOT<Fornecedor> {

    public static final String _select = "select id, "
            + "nome, "
            + "email, "
            + "telefone, "
            + "cnpj "
            + "from fornecedor ";

    public static final String _insert = "insert into fornecedor "
            + "(nome, email, telefone, cnpj) "
            + "values "
            + "(?, ?, ?, ?)"
            + "returning id";

    public static final String _update = "update fornecedor "
            + "set nome = ?, "
            + "email = ?, "
            + "telefone = ?, "
            + "cnpj = ? "
            + "where id = ?";

    public static final String _delete = "delete from fornecedor "
            + "where id = ?";

    @Override
    public String salvar(Fornecedor o) {
        int idGerado = -1;

        try {

            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.nome);
            pst.setString(2, o.email);
            pst.setString(3, o.telefone);
            pst.setString(4, o.cnpj);

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);

        } catch (Exception e) {
            System.out.println("Erro ao inserir FORNECEDOR: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Fornecedor o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.nome);
            pst.setString(2, o.email);
            pst.setString(3, o.telefone);
            pst.setString(4, o.cnpj);
            pst.setInt(5, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar FORNECEDOR: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_delete);

            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir FORNECEDOR: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by nome");
            System.out.println("SQL executado!");

            while (rs.next()) {
                fornecedores.add(
                        new Fornecedor(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("email"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDORES: " + e);
        }

        return fornecedores;
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio, String valor) {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " ilike '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                fornecedores.add(
                        new Fornecedor(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("email"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDORES: " + e);
        }

        return fornecedores;
    }

    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor fornecedor = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("cnpj"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDOR: " + e);
        }

        return fornecedor;
    }
}