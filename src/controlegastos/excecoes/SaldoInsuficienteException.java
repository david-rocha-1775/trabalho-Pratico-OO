package controlegastos.excecoes;

public final class SaldoInsuficienteException extends ControleGastosException {
    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(String mensagem) { super(mensagem); }
}
