package entidade;

public class Item_pedido {
    public int id;
    public int produto_id;
    public int pedido_id;
    public double qtde;
    public float valor_item;

    public Item_pedido(int id, int produto_id, int pedido_id, double qtde, float valor_item) {
        this.id = id;
        this.produto_id = produto_id;
        this.pedido_id = pedido_id;
        this.qtde = qtde;
        this.valor_item = valor_item;
    }
    
    public Item_pedido(int produto_id, int pedido_id, double qtde, float valor_item) {

        this.produto_id = produto_id;
        this.pedido_id = pedido_id;
        this.qtde = qtde;
        this.valor_item = valor_item;
    }
}
