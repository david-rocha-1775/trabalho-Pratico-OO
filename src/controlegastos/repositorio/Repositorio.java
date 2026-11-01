package controlegastos.repositorio;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {
    void adicionar(T item);
    Optional<T> buscar(long id);
    void substituir(long id, T item);
    void remover(long id);
    List<T> listar();
}
