package entidade;

public class Cliente_endereco {
    public int id;
    public int cliente_id;
    public int endereco_id;
    
    public Cliente_endereco (int id, int cliente_id, int endereco_id)
    {
        this.id = id;
        this.cliente_id = cliente_id;
        this.endereco_id = endereco_id;
    }
}


