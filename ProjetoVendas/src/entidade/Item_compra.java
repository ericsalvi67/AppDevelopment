package entidade;

public class Item_compra {
    public int id;
    public int compra_id;
    public int produto_id;
    public float qtde;
    public float valor;

    public Item_compra(int id, int compra_id, int produto_id, float qtde, float valor) {
        this.id = id;
        this.compra_id = compra_id;
        this.produto_id = produto_id;
        this.qtde = qtde;
        this.valor = valor;
    }
}
