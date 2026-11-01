package controlegastos.excecoes;

public final class CategoriaNaoDefinidaException extends ControleGastosException {
    private static final long serialVersionUID = 1L;

    public CategoriaNaoDefinidaException(String mensagem) { super(mensagem); }
}
