package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CompraDAO implements IDAOT<Compra> {

    public static final String _select = "select co.id, "
            + "co.data, "
            + "co.fornecedor_id, "
            + "f.nome fornecedor_nome "
            + "from compra co "
            + "inner join fornecedor f on f.id = co.fornecedor_id ";

    public static final String _insert = "insert into compra "
            + "(data, fornecedor_id) "
            + "values "
            + "(?, ?)"
            + "returning id";

    public static final String _update = "update compra "
            + "set data = ?, "
            + "fornecedor_id = ? "
            + "where id = ?";

    public static final String _delete = "delete from compra "
            + "where id = ?";

    @Override
    public String salvar(Compra o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.data);
            pst.setInt(2, o.fornecedor_id);

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);

        } catch (Exception e) {
            System.out.println("Erro ao inserir COMPRA: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Compra o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.data);
            pst.setInt(2, o.fornecedor_id);
            pst.setInt(3, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar COMPRA: " + e);
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
            System.out.println("Erro ao excluir COMPRA: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Compra> consultarTodos() {
        ArrayList<Compra> compras = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by co.id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getInt("fornecedor_id"),
                        rs.getString("fornecedor_nome")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRAS: " + e);
        }

        return compras;
    }

    @Override
    public ArrayList<Compra> consultar(String criterio, String valor) {
        ArrayList<Compra> compras = new ArrayList<>();
        String sql = _select + " where co." + criterio + " ilike '%" + valor + "%';";

        if ("ID".equalsIgnoreCase(criterio)) {
            sql = _select + " where co." + criterio + " = " + valor + ";";
        }

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(sql);
            System.out.println("SQL executado!");

            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getInt("fornecedor_id"),
                        rs.getString("fornecedor_nome")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRA: " + e);
        }

        return compras;
    }

    @Override
    public Compra consultarId(int id) {
        Compra compra = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where co.id = " + id);
            System.out.println("SQL executado!");

            if (rs.next()) {
                compra = new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getInt("fornecedor_id"),
                        rs.getString("fornecedor_nome"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRA: " + e);
        }

        return compra;
    }
}