package entidade;

public class Usuario {

    public int id;
    public String email;
    public String senha;
    public char situacao;
    
    public Usuario(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String email, String senha, char situacao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.situacao = situacao;
    }
}
