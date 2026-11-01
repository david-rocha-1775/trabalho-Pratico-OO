package controlegastos.servico;

import controlegastos.excecoes.CategoriaNaoDefinidaException;
import controlegastos.excecoes.ControleGastosException;
import controlegastos.excecoes.NomeInvalidoOuNuloException;
import controlegastos.excecoes.ValorInvalidoException;
import controlegastos.modelo.Transacao;

public final class ValidadorTransacao {
    private ValidadorTransacao() {}

    public static void validar(Transacao transacao) throws ControleGastosException {
        if (transacao.getNome() == null || transacao.getNome().isBlank()
                || transacao.getDescricao() == null || transacao.getDescricao().isBlank()) {
            throw new NomeInvalidoOuNuloException("Nome e descrição devem ser preenchidos.");
        }
        if (transacao.getCategoria() == null
                || transacao.getCategoria().getTipo() != transacao.getTipo()) {
            throw new CategoriaNaoDefinidaException("A categoria não existe ou é incompatível com a transação.");
        }
        if (transacao.getValor() == null || transacao.getValor().signum() <= 0) {
            throw new ValorInvalidoException("O valor deve ser positivo.");
        }
    }
}
