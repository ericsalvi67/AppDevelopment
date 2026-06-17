package entidade;

public class Compra {
    public int id;
    public String data;
    public int fornecedor_id;
    public String fornecedor_nome;

    public Compra(int id, String data, int fornecedor_id) {
        this.id = id;
        this.data = data;
        this.fornecedor_id = fornecedor_id;
    }

    public Compra(int id, String data, int fornecedor_id, String fornecedor_nome) {
        this.id = id;
        this.data = data;
        this.fornecedor_id = fornecedor_id;
        this.fornecedor_nome = fornecedor_nome;
    }
}
