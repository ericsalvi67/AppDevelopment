package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CompraDAO implements IDAOT<Compra> {

    public static final String _select =
        "select id, "
        + "data, "
        + "fornecedor_id "
        + "from compra ";

    public static final String _insert =
        "insert into compra "
        + "(data, fornecedor_id) "
        + "values "
        + "(?, ?)"
        + "returning id";

    public static final String _update =
        "update compra "
        + "set data = ?, "
        + "fornecedor_id = ? "
        + "where id = ?";

    public static final String _delete =
        "delete from compra "
        + "where id = ?";

    @Override
    public String salvar(Compra o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.getData());
            pst.setInt(2, o.getFornecedor_id());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return idGerado.toString();

        } catch (Exception e) {
            System.out.println("Erro ao inserir COMPRA: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Compra o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.getData());
            pst.setInt(2, o.getFornecedor_id());
            pst.setInt(3, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

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
        ArrayList<Compra> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Compra compra = new Compra();

                compra.setId(rs.getInt("id"));
                compra.setData(rs.getString("data"));
                compra.setFornecedor_id(rs.getInt("fornecedor_id"));

                lista.add(compra);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRAS: " + e);
        }

        return lista;
    }

    @Override
    public ArrayList<Compra> consultar(String criterio, String valor) {
        ArrayList<Compra> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Compra compra = new Compra();

                compra.setId(rs.getInt("id"));
                compra.setData(rs.getString("data"));
                compra.setFornecedor_id(rs.getInt("fornecedor_id"));

                lista.add(compra);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRAS: " + e);
        }

        return lista;
    }

    @Override
    public Compra consultarId(int id) {
        Compra compra = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                compra = new Compra();

                compra.setId(rs.getInt("id"));
                compra.setData(rs.getString("data"));
                compra.setFornecedor_id(rs.getInt("fornecedor_id"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar COMPRA: " + e);
        }

        return compra;
    }
}