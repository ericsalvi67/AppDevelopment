package entidade;

public class Produto {
    private int id;
    private String descricao;
    private float valor_unitario;
    private String qtde_estoque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(String qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }
}
