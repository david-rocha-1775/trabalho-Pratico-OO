package controlegastos.excecoes;

public final class NomeInvalidoOuNuloException extends ControleGastosException {
    private static final long serialVersionUID = 1L;

    public NomeInvalidoOuNuloException(String mensagem) { super(mensagem); }
}
