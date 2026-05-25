package entidade;

import java.util.Date;

public class Pedido {
    public int id;
    public Date data;
    public String endereco_entrega;
    public String observacao;
    public int cliente_id;

    public Pedido(int id, Date data, String endereco_entrega, String observacao, int cliente_id) {
        this.id = id;
        this.data = data;
        this.endereco_entrega = endereco_entrega;
        this.observacao = observacao;
        this.cliente_id = cliente_id;
    }
}
