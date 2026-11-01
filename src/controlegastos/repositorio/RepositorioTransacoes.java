package controlegastos.repositorio;

import controlegastos.modelo.Transacao;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public final class RepositorioTransacoes<T extends Transacao> implements Repositorio<T> {
    private final LinkedHashMap<Long, T> itens = new LinkedHashMap<>();

    @Override
    public void adicionar(T item) { itens.put(item.getId(), item); }

    @Override
    public Optional<T> buscar(long id) { return Optional.ofNullable(itens.get(id)); }

    @Override
    public void substituir(long id, T item) {
        if (!itens.containsKey(id)) {
            throw new IllegalArgumentException("Transação não encontrada: " + id);
        }
        itens.put(id, item);
    }

    @Override
    public void remover(long id) { itens.remove(id); }

    @Override
    public List<T> listar() { return new ArrayList<>(itens.values()); }
}
