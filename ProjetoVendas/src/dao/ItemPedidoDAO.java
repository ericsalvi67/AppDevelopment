package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Item_pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemPedidoDAO implements IDAOT<Item_pedido> {

    public static final String _select =
        "select id, "
        + "produto_id, "
        + "pedido_id, "
        + "qtde, "
        + "valor_item "
        + "from item_pedido ";

    public static final String _insert =
        "insert into item_pedido "
        + "(produto_id, pedido_id, qtde, valor_item) "
        + "values "
        + "(?, ?, ?, ?)"
        + "returning id";

    public static final String _update =
        "update item_pedido "
        + "set produto_id = ?, "
        + "pedido_id = ?, "
        + "qtde = ?, "
        + "valor_item = ? "
        + "where id = ?";

    public static final String _delete =
        "delete from item_pedido "
        + "where id = ?";

    @Override
    public String salvar(Item_pedido o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.getProduto_id());
            pst.setInt(2, o.getPedido_id());
            pst.setDouble(3, o.getQtde());
            pst.setFloat(4, o.getValor_item());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return idGerado.toString();

        } catch (Exception e) {
            System.out.println("Erro ao inserir ITEM_PEDIDO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Item_pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setInt(1, o.getProduto_id());
            pst.setInt(2, o.getPedido_id());
            pst.setDouble(3, o.getQtde());
            pst.setFloat(4, o.getValor_item());
            pst.setInt(5, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar ITEM_PEDIDO: " + e);
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
            System.out.println("Erro ao excluir ITEM_PEDIDO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Item_pedido> consultarTodos() {
        ArrayList<Item_pedido> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Item_pedido item = new Item_pedido();

                item.setId(rs.getInt("id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setPedido_id(rs.getInt("pedido_id"));
                item.setQtde(rs.getDouble("qtde"));
                item.setValor_item(rs.getFloat("valor_item"));

                lista.add(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDOS: " + e);
        }

        return lista;
    }

    @Override
    public ArrayList<Item_pedido> consultar(String criterio, String valor) {
        ArrayList<Item_pedido> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Item_pedido item = new Item_pedido();

                item.setId(rs.getInt("id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setPedido_id(rs.getInt("pedido_id"));
                item.setQtde(rs.getDouble("qtde"));
                item.setValor_item(rs.getFloat("valor_item"));

                lista.add(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDOS: " + e);
        }

        return lista;
    }

    @Override
    public Item_pedido consultarId(int id) {
        Item_pedido item = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                item = new Item_pedido();

                item.setId(rs.getInt("id"));
                item.setProduto_id(rs.getInt("produto_id"));
                item.setPedido_id(rs.getInt("pedido_id"));
                item.setQtde(rs.getDouble("qtde"));
                item.setValor_item(rs.getFloat("valor_item"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDO: " + e);
        }

        return item;
    }
}