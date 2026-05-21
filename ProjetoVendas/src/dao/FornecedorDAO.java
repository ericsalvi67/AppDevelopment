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
    
    @Override
    public String salvar(Fornecedor o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into fornecedor "
                    + "values "
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getCnpj() + "', "
                    + "default)";

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Fornecedor: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Fornecedor o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet retorno = st.executeQuery(_select + " order by nome");

            while (retorno.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("email"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));

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

            ResultSet retorno = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");

            while (retorno.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("email"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));

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

            ResultSet retorno = st.executeQuery(_select + " where id = " + id);

            while (retorno.next()) {
                fornecedor = new Fornecedor();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("email"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDOR: " + e);
        }

        return fornecedor;
    }
}