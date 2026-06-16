package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Item_pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemPedidoDAO implements IDAOT<Item_pedido> {

    public static final String _select = "select id, "
            + "produto_id, "
            + "pedido_id, "
            + "qtde, "
            + "valor_item "
            + "from item_pedido ";

    public static final String _insert = "insert into item_pedido "
            + "(produto_id, pedido_id, qtde, valor_item) "
            + "values "
            + "(?, ?, ?, ?);";

    public static final String _delete = "delete from item_pedido "
            + "where id = ?";

    @Override
    public String salvar(Item_pedido o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.produto_id);
            pst.setInt(2, o.pedido_id);
            pst.setDouble(2, o.qtde);
            pst.setFloat(2, o.valor_item);

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
      throw new UnsupportedOperationException("Not supported yet.");
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
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Item_pedido> consultar(String criterio, String valor) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item_pedido consultarId(int id) {
         throw new UnsupportedOperationException("Not supported yet.");
    }
}