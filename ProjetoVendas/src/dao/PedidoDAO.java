package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PedidoDAO implements IDAOT<Pedido> {

    private static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("yyyy-MM-dd");

    public static final String _select =
        "select id, "
        + "data, "
        + "endereco_entrega, "
        + "observacao, "
        + "cliente_id "
        + "from pedido ";

    public static final String _insert =
        "insert into pedido "
        + "(data, endereco_entrega, observacao, cliente_id) "
        + "values "
        + "(?, ?, ?, ?)"
        + "returning id";

    public static final String _update =
        "update pedido "
        + "set data = ?, "
        + "endereco_entrega = ?, "
        + "observacao = ?, "
        + "cliente_id = ? "
        + "where id = ?";

    public static final String _delete =
        "delete from pedido "
        + "where id = ?";

    @Override
    public String salvar(Pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, formatarData(o.getData()));
            pst.setString(2, o.getEndereco_entrega());
            pst.setString(3, o.getObservacao());
            pst.setInt(4, o.getCliente_id());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            int idGerado = -1;
            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return idGerado.toString();

        } catch (Exception e) {
            System.out.println("Erro ao inserir PEDIDO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, formatarData(o.getData()));
            pst.setString(2, o.getEndereco_entrega());
            pst.setString(3, o.getObservacao());
            pst.setInt(4, o.getCliente_id());
            pst.setInt(5, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar PEDIDO: " + e);
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
            System.out.println("Erro ao excluir PEDIDO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        ArrayList<Pedido> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setId(rs.getInt("id"));
                pedido.setData(parseData(rs.getString("data")));
                pedido.setEndereco_entrega(rs.getString("endereco_entrega"));
                pedido.setObservacao(rs.getString("observacao"));
                pedido.setCliente_id(rs.getInt("cliente_id"));

                lista.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PEDIDOS: " + e);
        }

        return lista;
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio, String valor) {
        ArrayList<Pedido> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setId(rs.getInt("id"));
                pedido.setData(parseData(rs.getString("data")));
                pedido.setEndereco_entrega(rs.getString("endereco_entrega"));
                pedido.setObservacao(rs.getString("observacao"));
                pedido.setCliente_id(rs.getInt("cliente_id"));

                lista.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PEDIDOS: " + e);
        }

        return lista;
    }

    @Override
    public Pedido consultarId(int id) {
        Pedido pedido = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                pedido = new Pedido();

                pedido.setId(rs.getInt("id"));
                pedido.setData(parseData(rs.getString("data")));
                pedido.setEndereco_entrega(rs.getString("endereco_entrega"));
                pedido.setObservacao(rs.getString("observacao"));
                pedido.setCliente_id(rs.getInt("cliente_id"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PEDIDO: " + e);
        }

        return pedido;
    }

    private String formatarData(Date data) {
        if (data == null) {
            return null;
        }

        return FORMATO_DATA.format(data);
    }

    private Date parseData(String data) {
        try {
            if (data == null || data.trim().isEmpty()) {
                return null;
            }

            return FORMATO_DATA.parse(data);
        } catch (Exception e) {
            return null;
        }
    }
}