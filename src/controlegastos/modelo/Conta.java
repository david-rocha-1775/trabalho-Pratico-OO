package controlegastos.modelo;

import controlegastos.excecoes.ControleGastosException;
import controlegastos.excecoes.SaldoInsuficienteException;
import controlegastos.repositorio.RepositorioTransacoes;
import java.math.BigDecimal;
import java.util.List;

public final class Conta {
    private final Titular titular;
    private final RepositorioTransacoes<Transacao> transacoes = new RepositorioTransacoes<>();
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(Titular titular) { this.titular = titular; }

    public void inserir(Transacao transacao) throws ControleGastosException {
        transacao.validar();
        BigDecimal novoSaldo = saldo.add(transacao.efeitoNoSaldo());
        verificarSaldo(novoSaldo);
        transacoes.adicionar(transacao);
        saldo = novoSaldo;
    }

    public void atualizar(long id, Transacao nova) throws ControleGastosException {
        nova.validar();
        Transacao antiga = localizar(id);
        BigDecimal novoSaldo = saldo.subtract(antiga.efeitoNoSaldo()).add(nova.efeitoNoSaldo());
        verificarSaldo(novoSaldo);
        transacoes.substituir(id, nova.comIdentificador(id));
        saldo = novoSaldo;
    }

    public void remover(long id) throws ControleGastosException {
        Transacao antiga = localizar(id);
        BigDecimal novoSaldo = saldo.subtract(antiga.efeitoNoSaldo());
        verificarSaldo(novoSaldo);
        transacoes.remover(id);
        saldo = novoSaldo;
    }

    private Transacao localizar(long id) throws ControleGastosException {
        return transacoes.buscar(id).orElseThrow(
                () -> new ControleGastosException("Transação não encontrada: " + id));
    }

    private void verificarSaldo(BigDecimal novoSaldo) throws SaldoInsuficienteException {
        if (novoSaldo.signum() < 0) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente. Disponível: " + saldo + "; operação resultaria em: " + novoSaldo);
        }
    }

    public Titular getTitular() { return titular; }
    public BigDecimal getSaldo() { return saldo; }
    public List<Transacao> listarTransacoes() { return transacoes.listar(); }
}
