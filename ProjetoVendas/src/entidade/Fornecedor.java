package entidade;

public class Fornecedor {
    public int id;
    public String nome;
    public String email;
    public String telefone;
    public String cnpj;
    
    public Fornecedor(){}

    public Fornecedor(int id, String nome, String email, String telefone, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
}
