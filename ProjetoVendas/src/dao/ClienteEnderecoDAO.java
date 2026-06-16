package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente_endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteEnderecoDAO implements IDAOT<Cliente_endereco> {

    public static final String _select = "select ce.id, "
            + "ce.cliente_id, "
            + "ce.endereco_id "
            + "from cliente_endereco ce "
            + "inner join cliente c "
            + "on c.id = ce.cliente_id "
            + "inner join endereco e "
            + "on e.id = ce.endereco_id ";

    public static final String _insert = "insert into cliente_endereco "
            + "(cliente_id, endereco_id) "
            + "values "
            + "(?, ?);";

    public static final String _update = "update cliente_endereco "
            + "set cliente_id = ?, "
            + "endereco_id = ? "
            + "where id = ?";

    public static final String _delete = "delete from cliente_endereco "
            + "where id = ?";

    @Override
    public String salvar(Cliente_endereco o) {
        try (PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert)) {

            pst.setInt(1, o.cliente_id);
            pst.setInt(2, o.endereco_id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao inserir CLIENTE_ENDERECO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente_endereco o) {
        try (PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update)) {

            pst.setInt(1, o.cliente_id);
            pst.setInt(2, o.endereco_id);
            pst.setInt(3, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar CLIENTE_ENDERECO: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try (PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_delete)) {

            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir CLIENTE_ENDERECO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Cliente_endereco> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Cliente_endereco> consultar(String criterio, String valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente_endereco consultarId(int id) {
        Cliente_endereco ce = null;

        try (Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(_select + " where ce.cliente_id = " + id)) {
            System.out.println("SQL executado!");

            if (rs.next()) {
                ce = mapClienteEndereco(rs);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTE_ENDERECO: " + e);
        }

        return ce;
    }

    private Cliente_endereco mapClienteEndereco(ResultSet rs) throws Exception {
        return new Cliente_endereco(
                rs.getInt("id"),
                rs.getInt("cliente_id"),
                rs.getInt("endereco_id"));
    }
}