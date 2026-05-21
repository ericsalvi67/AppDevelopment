package entidade;

public class Item_pedido {
    private int id;
    private int produto_id;
    private int pedido_id;
    private double qtde;
    private float valor_item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public float getValor_item() {
        return valor_item;
    }

    public void setValor_item(float valor_item) {
        this.valor_item = valor_item;
    }
}
