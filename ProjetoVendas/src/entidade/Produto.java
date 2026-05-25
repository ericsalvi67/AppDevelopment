package entidade;

public class Produto {
    public int id;
    public String descricao;
    public float valor_unitario;
    public int qtde_estoque;

    public Produto(int id, String descricao, float valor_unitario, int qtde_estoque) {
        this.id = id;
        this.descricao = descricao;
        this.valor_unitario = valor_unitario;
        this.qtde_estoque = qtde_estoque;
    }
}
