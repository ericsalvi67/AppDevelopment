package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO implements IDAOT<Cliente> {
    
    public static final String _select = 
        "select id, "
        + "nome, "
        + "email, "
        + "cpf, "
        + "telefone "
        + "from cliente ";
    
    public static final String _insert = 
        "insert into cliente "
        + "(nome, email, telefone, cpf) "
        + "values "
        + "(?, ?, ?, ?)"
        + "returning id";

    public static final String _update =
        "update cliente "
        + "set nome = ?, "
        + "email = ?, "
        + "telefone = ?, "
        + "cpf = ? "
        + "where id = ?";
    
    public static final String _delete =
        "delete from cliente "
        + "where id = ?";

    @Override
    public String salvar(Cliente o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.getNome());
            pst.setString(2, o.getEmail());
            pst.setString(3, o.getTelefone());
            pst.setString(4, o.getCpf());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
            int idGerado = rs.getInt("id");
            }

            return idGerado;

        } catch (Exception e) {
            System.out.println("Erro ao inserir CLIENTE: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) { 
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.getNome());
            pst.setString(2, o.getEmail());
            pst.setString(3, o.getTelefone());
            pst.setString(4, o.getCpf());
            pst.setInt(5, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar CLIENTE: " + e);
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
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(_select + "order by nome");
            System.out.println("SQL executado!");
            
            while (rs.next()) {
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTES: " + e);
        }
        return lista;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio, String valor) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));

                clientes.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTES: " + e);
        }

        return clientes;
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente c = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");
            
            if (rs.next()) {
                c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar CLIENTE: " + e);
        }

        return c;
    }
}