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

    public static final String _select = "select id, "
            + "data, "
            + "endereco_entrega, "
            + "observacao, "
            + "cliente_id "
            + "from pedido ";

    public static final String _insert = "insert into pedido "
            + "(data, endereco_entrega, observacao, cliente_id) "
            + "values "
            + "(?, ?, ?, ?)"
            + "returning id";

    public static final String _update = "update pedido "
            + "set data = ?, "
            + "endereco_entrega = ?, "
            + "observacao = ?, "
            + "cliente_id = ? "
            + "where id = ?";

    public static final String _delete = "delete from pedido "
            + "where id = ?";

    @Override
    public String salvar(Pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, formatarData(o.data));
            pst.setString(2, o.endereco_entrega);
            pst.setString(3, o.observacao);
            pst.setInt(4, o.cliente_id);

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            int idGerado = -1;
            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);

        } catch (Exception e) {
            System.out.println("Erro ao inserir PEDIDO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Pedido o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, formatarData(o.data));
            pst.setString(2, o.endereco_entrega);
            pst.setString(3, o.observacao);
            pst.setInt(4, o.cliente_id);
            pst.setInt(5, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

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
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by id");
            System.out.println("SQL executado!");

            while (rs.next()) {
                pedidos.add(new Pedido(rs.getInt("id"),
                        parseData(rs.getString("data")),
                        rs.getString("endereco_entrega"),
                        rs.getString("observacao"),
                        rs.getInt("cliente_id")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PEDIDOS: " + e);
        }

        return pedidos;
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio, String valor) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = _select + " where " + criterio + " ilike '%" + valor + "%';";
        
        if(criterio == "ID"){
            sql = _select + " where " + criterio + " = " + valor + ";";
        }
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(sql);
            System.out.println("SQL executado!");

            while (rs.next()) {
                pedidos.add(new Pedido(rs.getInt("id"),
                        parseData(rs.getString("data")),
                        rs.getString("endereco_entrega"),
                        rs.getString("observacao"),
                        rs.getInt("cliente_id")));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PEDIDOS: " + e);
        }

        return pedidos;
    }

    @Override
    public Pedido consultarId(int id) {
        Pedido pedido = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                pedido = new Pedido(rs.getInt("id"),
                        parseData(rs.getString("data")),
                        rs.getString("endereco_entrega"),
                        rs.getString("observacao"),
                        rs.getInt("cliente_id"));
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