package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO implements IDAOT<Endereco> {

    public static final String _select =
        "select id, "
        + "descricao, "
        + "cep "
        + "from endereco ";

    public static final String _insert =
        "insert into endereco "
        + "(descricao, cep) "
        + "values "
        + "(?, ?)"
        + "returning id";

    public static final String _update =
        "update endereco "
        + "set descricao = ?, "
        + "cep = ? "
        + "where id = ?";

    public static final String _delete =
        "delete from endereco "
        + "where id = ?";

    @Override
    public String salvar(Endereco o) {
        int idGerado = -1;

        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_insert);

            pst.setString(1, o.getDescricao());
            pst.setString(2, o.getCep());

            ResultSet rs = pst.executeQuery();
            System.out.println("SQL executado!");

            if (rs.next()) {
                idGerado = rs.getInt("id");
            }

            return String.valueOf(idGerado);   

        } catch (Exception e) {
            System.out.println("Erro ao inserir ENDERECO: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Endereco o) {
        try {
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement(_update);

            pst.setString(1, o.getDescricao());
            pst.setString(2, o.getCep());
            pst.setInt(3, o.getId());

            pst.executeUpdate();
            System.out.println("SQL executado!");

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar ENDERECO: " + e);
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
            System.out.println("Erro ao excluir ENDERECO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Endereco> consultarTodos() {
        ArrayList<Endereco> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " order by descricao");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id"));
                endereco.setDescricao(rs.getString("descricao"));
                endereco.setCep(rs.getString("cep"));

                lista.add(endereco);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ENDERECOS: " + e);
        }

        return lista;
    }

    @Override
    public ArrayList<Endereco> consultar(String criterio, String valor) {
        ArrayList<Endereco> lista = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where " + criterio + " like '%" + valor + "%';");
            System.out.println("SQL executado!");

            while (rs.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id"));
                endereco.setDescricao(rs.getString("descricao"));
                endereco.setCep(rs.getString("cep"));

                lista.add(endereco);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ENDERECOS: " + e);
        }

        return lista;
    }

    @Override
    public Endereco consultarId(int id) {
        Endereco endereco = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(_select + " where id = " + id);
            System.out.println("SQL executado!");

            while (rs.next()) {
                endereco = new Endereco();

                endereco.setId(rs.getInt("id"));
                endereco.setDescricao(rs.getString("descricao"));
                endereco.setCep(rs.getString("cep"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ENDERECO: " + e);
        }

        return endereco;
    }
}