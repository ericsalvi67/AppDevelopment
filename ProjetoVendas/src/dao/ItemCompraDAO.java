package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Item_compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemCompraDAO implements IDAOT<Item_compra> {

    public static final String _select =
        "select id, "
        + "compra_id, "
        + "produto_id, "
        + "qtde, "
        + "valor "
        + "from item_compra ";

    public static final String _insert =
        "insert into item_compra "
        + "(compra_id, produto_id, qtde, valor) "
        + "values "
        + "(?, ?, ?, ?)"
        + "returning id";

    public static final String _update =
        "update item_compra "
        + "set compra_id = ?, "
        + "produto_id = ?, "
        + "qtde = ?, "
        + "valor = ? "
        + "where id = ?";

    public static final String _delete =
        "delete from item_compra "
        + "where id = ?";

    @Override
    public String salvar(Item_compra o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.getCompra_id());
            pst.setInt(2, o.getProduto_id());
            pst.setFloat(3, o.getQtde());
            pst.setFloat(4, o.getValor());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return idGerado.toString();

        } catch (Exception e) {
            System.out.println("Erro ao inserir ITEM_COMPRA: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Item_compra o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setInt(1, o.getCompra_id());
            pst.setInt(2, o.getProduto_id());
            pst.setFloat(3, o.getQtde());
            pst.setFloat(4, o.getValor());
            pst.setInt(5, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

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
            System.out.println("Erro ao excluir ITEM_COMPRA: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Item_compra> consultarTodos() {
        ArrayList<Item_compra> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Item_compra item = new Item_compra();

                item.setId(rs.getInt("id"));
                item.setCompra_id(rs.getInt("compra_id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setQtde(rs.getFloat("qtde"));
                item.setValor(rs.getFloat("valor"));

                lista.add(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRAS: " + e);
        }

        return lista;
    }

    @Override
    public ArrayList<Item_compra> consultar(String criterio, String valor) {
        ArrayList<Item_compra> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Item_compra item = new Item_compra();

                item.setId(rs.getInt("id"));
                item.setCompra_id(rs.getInt("compra_id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setQtde(rs.getFloat("qtde"));
                item.setValor(rs.getFloat("valor"));

                lista.add(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRAS: " + e);
        }

        return lista;
    }

    @Override
    public Item_compra consultarId(int id) {
        Item_compra item = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                item = new Item_compra();

                item.setId(rs.getInt("id"));
                item.setCompra_id(rs.getInt("compra_id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setQtde(rs.getFloat("qtde"));
                item.setValor(rs.getFloat("valor"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_COMPRA: " + e);
        }

        return item;
    }
}