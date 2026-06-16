package entidade;

public class Cliente {
    public int id;
    public String nome;
    public String email;
    public String cpf;
    public String telefone;
    public String endereco;

    public Cliente(int id, String nome, String email, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public Cliente(int id, String nome, String email, String cpf, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
