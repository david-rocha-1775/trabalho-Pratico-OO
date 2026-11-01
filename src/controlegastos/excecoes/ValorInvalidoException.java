package controlegastos.excecoes;

public final class ValorInvalidoException extends ControleGastosException {
    private static final long serialVersionUID = 1L;

    public ValorInvalidoException(String mensagem) { super(mensagem); }
}
