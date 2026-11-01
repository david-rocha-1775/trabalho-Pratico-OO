package controlegastos.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Despesa extends Transacao {
    public Despesa(String nome, String descricao, BigDecimal valor,
                   LocalDate data, Categoria categoria) {
        super(nome, descricao, valor, data, categoria);
    }

    private Despesa(long id, String nome, String descricao, BigDecimal valor,
                    LocalDate data, Categoria categoria) {
        super(id, nome, descricao, valor, data, categoria);
    }

    @Override
    public TipoCategoria getTipo() { return TipoCategoria.DESPESA; }

    @Override
    public BigDecimal efeitoNoSaldo() { return getValor().negate(); }

    @Override
    protected Transacao comId(long id) {
        return new Despesa(id, getNome(), getDescricao(), getValor(), getData(), getCategoria());
    }
}
