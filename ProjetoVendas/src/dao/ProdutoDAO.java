package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO implements IDAOT<Produto> {

    public static final String _select = "select id, "
            + "descricao, "
            + "valor_unitario, "
            + "qtde_estoque "
            + "from produto ";

    public static final String _insert = "insert into produto "
            + "(descricao, valor_unitario, qtde_estoque) "
            + "values "
            + "(?, ?, ?)"
            + "returning id";

    public static final String _update = "update produto "
            + "set descricao = ?, "
            + "valor_unitario = ?, "
            + "qtde_estoque = ? "
            + "where id = ?";

    public static final String _delete = "delete from produto "
            + "where id = ?";

    @Override
    public String salvar(Produto o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.descricao);
            pst.setFloat(2, o.valor_unitario);
            pst.setInt(3, o.qtde_estoque);

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);

        } catch (Exception e) {
            System.out.println("Erro ao inserir PRODUTO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produto o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.descricao);
            pst.setFloat(2, o.valor_unitario);
            pst.setInt(3, o.qtde_estoque);
            pst.setInt(4, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar PRODUTO: " + e);
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
            System.out.println("Erro ao excluir PRODUTO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by descricao");
            System.out.println("SQL executado!");

            while (rs.next()) {
                produtos.add(
                        new Produto(
                                rs.getInt("id"),
                                rs.getString("descricao"),
                                rs.getFloat("valor_unitario"),
                                rs.getInt("qtde_estoque")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTOS: " + e);
        }

        return produtos;
    }

    @Override
    public ArrayList<Produto> consultar(String criterio, String valor) {
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " ilike '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                produtos.add(
                        new Produto(
                                rs.getInt("id"),
                                rs.getString("descricao"),
                                rs.getFloat("valor_unitario"),
                                rs.getInt("qtde_estoque")));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTOS: " + e);
        }

        return produtos;
    }

    @Override
    public Produto consultarId(int id) {
        Produto produto = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getFloat("valor_unitario"),
                        rs.getInt("qtde_estoque"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTO: " + e);
        }

        return produto;
    }
}