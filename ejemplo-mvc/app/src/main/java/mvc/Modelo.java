package mvc;

import java.util.List;

public interface Modelo<T, K> {
    T buscar(K id);
    List<T> buscarTodos();    
}
