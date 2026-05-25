package entidade;

public class Endereco {
    public int id;
    public String descricao;
    public String cep;

    public Endereco(int id, String descricao, String cep) {
        this.id = id;
        this.descricao = descricao;
        this.cep = cep;
    }
}
