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
            "select "
            + "ip.id, "
            + "ip.produto_id, "
            + "ip.pedido_id, "
            + "ip.qtde, "
            + "ip.valor_item, "
            + "p.descricao "
            + "from item_pedido ip "
            + "inner join produto p "
            + "on p.id = ip.produto_id "
            + "inner join pedido pe "
            + "on pe.id = ip.pedido_id ";

    public static final String _insert = "insert into item_pedido "
            + "(produto_id, pedido_id, qtde, valor_item) "
            + "values "
            + "(?, ?, ?, ?)"
            + "returning id";

    public static final String _update = "update item_pedido "
            + "set produto_id = ?, "
            + "pedido_id = ?, "
            + "qtde = ?, "
            + "valor_item = ? "
            + "where id = ?";

    public static final String _delete = "delete from item_pedido "
            + "where pedido_id = ?";

    @Override
    public String salvar(Item_pedido o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.produto_id);
            pst.setInt(2, o.pedido_id);
            pst.setDouble(3, o.qtde);
            pst.setFloat(4, o.valor_item);

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
    public String atualizar(Item_pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setInt(1, o.produto_id);
            pst.setInt(2, o.pedido_id);
            pst.setDouble(3, o.qtde);
            pst.setFloat(4, o.valor_item);
            pst.setInt(5, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

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
            System.out.println("Erro ao excluir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Item_pedido> consultarTodos() {
        ArrayList<Item_pedido> itens = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by ip.id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                itens.add(new Item_pedido(
                        rs.getInt("id"),
                        rs.getInt("produto_id"),
                        rs.getInt("pedido_id"),
                        rs.getDouble("qtde"),
                        rs.getFloat("valor_item")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDO: " + e);
        }

        return itens;
    }

    @Override
    public ArrayList<Item_pedido> consultar(String criterio, String valor) {
        ArrayList<Item_pedido> itens = new ArrayList<>();
        String sql = _select + " where ip." + criterio + " ilike '%" + valor + "%';";

        if ("ID".equalsIgnoreCase(criterio)) {
            sql = _select + " where ip." + criterio + " = " + valor + ";";
        }

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(sql);
            System.out.println("SQL executado!");

            while (rs.next()) {
                itens.add(new Item_pedido(
                        rs.getInt("id"),
                        rs.getInt("produto_id"),
                        rs.getInt("pedido_id"),
                        rs.getDouble("qtde"),
                        rs.getFloat("valor_item")
                    ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDO: " + e);
        }

        return itens;
    }

    @Override
    public Item_pedido consultarId(int id) {
        Item_pedido item = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where ip.id = " + id);
            System.out.println("SQL executado!");

            if (rs.next()) {
                item = new Item_pedido(
                        rs.getInt("id"),
                        rs.getInt("produto_id"),
                        rs.getInt("pedido_id"),
                        rs.getDouble("qtde"),
                        rs.getFloat("valor_item"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ITEM_PEDIDO: " + e);
        }

        return item;
    }
    
    public ArrayList<Item_pedido> consultarPorPedido(int pedidoId) {
        ArrayList<Item_pedido> itens =new ArrayList<>();

        try {

            Statement st =ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs =st.executeQuery(
                        _select
                        + " where ip.pedido_id = "
                        + pedidoId);

            while (rs.next()) {

                itens.add(
                        new Item_pedido(
                                rs.getInt("id"),
                                rs.getInt("produto_id"),
                                rs.getInt("pedido_id"),
                                rs.getDouble("qtde"),
                                rs.getFloat("valor_item"),
                                rs.getString("descricao")
                        ));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return itens;
    }
}