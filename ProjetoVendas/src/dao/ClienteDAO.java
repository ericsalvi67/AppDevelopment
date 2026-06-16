package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO implements IDAOT<Cliente> {

    public static final String _select = "select c.id, "
            + "c.nome, "
            + "c.email, "
            + "c.cpf, "
            + "c.telefone, "
            + "e.descricao "
            + "from cliente c "
            + "left join cliente_endereco ce "
            + "on ce.cliente_id = c.id "
            + "left join endereco e "
            + "on e.id = ce.endereco_id ";

    public static final String _insert = "insert into cliente "
            + "(nome, email, telefone, cpf) "
            + "values "
            + "(?, ?, ?, ?)"
            + "returning id";

    public static final String _update = "update cliente "
            + "set nome = ?, "
            + "email = ?, "
            + "telefone = ?, "
            + "cpf = ? "
            + "where id = ?";

    public static final String _delete = "delete from cliente "
            + "where id = ?";

    @Override
    public String salvar(Cliente o) {
        try (PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert)) {

            pst.setString(1, o.nome);
            pst.setString(2, o.email);
            pst.setString(3, o.telefone);
            pst.setString(4, o.cpf);

            try (ResultSet rs = pst.executeQuery()) {
                System.out.println("SQL executado!");

                if (rs.next()) {
                    return String.valueOf(rs.getInt("id"));
                }
            }

            return "-1";

        } catch (Exception e) {
            System.out.println("Erro ao inserir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        try (PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update)) {

            pst.setString(1, o.nome);
            pst.setString(2, o.email);
            pst.setString(3, o.telefone);
            pst.setString(4, o.cpf);
            pst.setInt(5, o.id);

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return "0";

        } catch (Exception e) {
            System.out.println("Erro ao atualizar CLIENTE: " + e);
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
            System.out.println("Erro ao excluir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(_select + " order by nome")) {

            System.out.println("SQL executado!");

            while (rs.next()) {
                clientes.add(mapCliente(rs));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTES: " + e);
        }
        return clientes;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio, String valor) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String criterioLimpo = criterio == null ? "" : criterio.trim();
        String valorLimpo = valor == null ? "" : valor.trim();
        String sql = _select + " where " + criterioLimpo + " ilike '%" + valorLimpo + "%';";

        if ("ID".equalsIgnoreCase(criterioLimpo)) {
            sql = _select + " where " + criterioLimpo + " = " + valorLimpo + ";";
        }

        try (Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            System.out.println("SQL executado!");

            while (rs.next()) {
                clientes.add(mapCliente(rs));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTES: " + e);
        }

        return clientes;
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente cliente = null;
        try (Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(_select + " where c.id = " + id)) {
            System.out.println("SQL executado!");

            if (rs.next()) {
                cliente = mapCliente(rs);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTE: " + e);
        }

        return cliente;
    }

    private Cliente mapCliente(ResultSet rs) throws Exception {
        return new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("cpf"),
                rs.getString("descricao"));
    }
}