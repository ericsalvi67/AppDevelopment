package entidade;

import java.util.Date;

public class Pedido {
    private int id;
    private Date data;
    private String endereco_entrega;
    private String observacao;
    private int cliente_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco_entrega() {
        return endereco_entrega;
    }

    public void setEndereco_entrega(String endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
}

