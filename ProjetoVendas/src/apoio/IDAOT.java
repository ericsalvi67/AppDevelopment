package apoio;

import java.util.ArrayList;

// Utiliza Generics como tipo de dado

public interface IDAOT<T> {
    public static final String _select;
        
    public static final String _insert;

    public static final String _update;
    
    public static final String _delete;

    public String salvar(T entity);

    public String atualizar(T entity);

    public String excluir(int id);

    public ArrayList<T> consultarTodos();

    public ArrayList<T> consultar(String criterio, String valor);

    public T consultarId(int id);
}
