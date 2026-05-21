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

    @Override
    public String salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = 
                    "insert into cliente values ("
                    + "default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getCpf() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "default)";
            
            st.executeUpdate(sql);
            return null;
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir Cidade: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) { 
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public String excluir(int id) { 
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(_select + "order by nome");
            
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
            System.out.println("Erro ao consultar CIDADES: " + e);
        }
        return lista;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio, String valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente c = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            
            if (rs.next()) {
                c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar CIDADE: " + e);
        }
        return c;
    }
}