package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Fornecedor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FornecedorDAO implements IDAOT<Fornecedor> {
    
    public static final String _select = 
        "select id, "
        + "nome, "
        + "email, "
        + "telefone, "
        + "cnpj "
        + "from fornecedor ";
    
    public static final String _insert = 
        "insert into fornecedor "
        + "(nome, email, telefone, cnpj) "
        + "values "
        + "(?, ?, ?, ?)"
        + "returning id";

    public static final String _update =
        "update fornecedor "
        + "set nome = ?, "
        + "email = ?, "
        + "telefone = ?, "
        + "cnpj = ? "
        + "where id = ?";
    
    public static final String _delete =
        "delete from fornecedor "
        + "where id = ?";
    
    @Override
    public String salvar(Fornecedor o) {
        try {

            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.getNome());
            pst.setString(2, o.getEmail());
            pst.setString(3, o.getTelefone());
            pst.setString(4, o.getCnpj());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
            int idGerado = rs.getInt("id");
            }

            return idGerado;

        } catch (Exception e) {
            System.out.println("Erro ao inserir FORNECEDOR: " + e);
            return -1;
        }
    }

    @Override
    public String atualizar(Fornecedor o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.getNome());
            pst.setString(2, o.getEmail());
            pst.setString(3, o.getTelefone());
            pst.setString(4, o.getCnpj());
            pst.setInt(5, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar FORNECEDOR: " + e);
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
            System.out.println("Erro ao excluir FORNECEDOR: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by nome");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCnpj(rs.getString("cnpj"));

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDORES: " + e);
        }

        return fornecedores;
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio, String valor) {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCnpj(rs.getString("cnpj"));

                fornecedores.add(fornecedor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDORES: " + e);
        }

        return fornecedores;
    }

    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor fornecedor = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCnpj(rs.getString("cnpj"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDOR: " + e);
        }

        return fornecedor;
    }
}