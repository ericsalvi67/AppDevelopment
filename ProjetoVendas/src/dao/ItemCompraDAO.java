package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Item_compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemCompraDAO implements IDAOT<Item_compra> {

    public static final String _select = "select ic.id, "
            + "ic.compra_id, "
            + "ic.produto_id, "
            + "ic.qtde, "
            + "ic.valor, "
            + "p.descricao produto_descricao, "
            + "c.data compra_data "
            + "from item_compra ic "
            + "inner join produto p on p.id = ic.produto_id "
            + "inner join compra c on c.id = ic.compra_id ";

    public static final String _insert = "insert into item_compra "
            + "(compra_id, produto_id, qtde, valor) "
            + "values "
            + "(?, ?, ?, ?)"
            + "returning id";

    public static final String _update = "update item_compra "
            + "set compra_id = ?, "
            + "produto_id = ?, "
            + "qtde = ?, "
            + "valor = ? "
            + "where id = ?";

    public static final String _delete = "delete from item_compra "
            + "where id = ?";

    @Override
    public String salvar(Item_compra o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.compra_id);
            pst.setInt(2, o.produto_id);
            pst.setDouble(3, o.qtde);
            pst.setFloat(4, o.valor);

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);

        } catch (Exception e) {
            System.out.println("Erro ao inserir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Item_compra o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setInt(1, o.compra_id);
            pst.setInt(2, o.produto_id);
            pst.setDouble(3, o.qtde);
            pst.setFloat(4, o.valor);
            pst.setInt(5, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar ITEM_COMPRA: " + e);
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
            System.out.println("Erro ao excluir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Item_compra> consultarTodos() {
        ArrayList<Item_compra> itens = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by ic.id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                itens.add(new Item_compra(
                        rs.getInt("id"),
                        rs.getInt("compra_id"),
                        rs.getInt("produto_id"),
                        rs.getFloat("qtde"),
                        rs.getFloat("valor")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRA: " + e);
        }

        return itens;
    }

    @Override
    public ArrayList<Item_compra> consultar(String criterio, String valor) {
        ArrayList<Item_compra> itens = new ArrayList<>();
        String sql = _select + " where ic." + criterio + " ilike '%" + valor + "%';";

        if ("ID".equalsIgnoreCase(criterio)) {
            sql = _select + " where ic." + criterio + " = " + valor + ";";
        }

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(sql);
            System.out.println("SQL executado!");

            while (rs.next()) {
                itens.add(new Item_compra(
                        rs.getInt("id"),
                        rs.getInt("compra_id"),
                        rs.getInt("produto_id"),
                        rs.getFloat("qtde"),
                        rs.getFloat("valor")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRA: " + e);
        }

        return itens;
    }

    @Override
    public Item_compra consultarId(int id) {
        Item_compra item = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where ic.id = " + id);
            System.out.println("SQL executado!");

            if (rs.next()) {
                item = new Item_compra(
                        rs.getInt("id"),
                        rs.getInt("compra_id"),
                        rs.getInt("produto_id"),
                        rs.getFloat("qtde"),
                        rs.getFloat("valor"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRA: " + e);
        }

        return item;
    }
}