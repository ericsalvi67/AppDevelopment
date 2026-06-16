package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Item_compra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemCompraDAO implements IDAOT<Item_compra> {

    public static final String _select = "select id, "
            + "compra_id, "
            + "produto_id, "
            + "qtde, "
            + "valor "
            + "from item_compra ";

    public static final String _insert = "insert into item_compra "
            + "(compra_id, produto_id, qtde, valor) "
            + "values "
            + "(?, ?, ?, ?);";

    public static final String _delete = "delete from item_compra "
            + "where id = ?";

    @Override
    public String salvar(Item_compra o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setInt(1, o.compra_id);
            pst.setInt(2, o.produto_id);
            pst.setDouble(2, o.qtde);
            pst.setFloat(2, o.valor);

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
    public ArrayList<Item_compra> consultarTodos() {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Item_compra> consultar(String criterio, String valor) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item_compra consultarId(int id) {
         throw new UnsupportedOperationException("Not supported yet.");
    }
}