package controlegastos.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Receita extends Transacao {
    public Receita(String nome, String descricao, BigDecimal valor,
                   LocalDate data, Categoria categoria) {
        super(nome, descricao, valor, data, categoria);
    }

    private Receita(long id, String nome, String descricao, BigDecimal valor,
                    LocalDate data, Categoria categoria) {
        super(id, nome, descricao, valor, data, categoria);
    }

    @Override
    public TipoCategoria getTipo() { return TipoCategoria.RECEITA; }

    @Override
    public BigDecimal efeitoNoSaldo() { return getValor(); }

    @Override
    protected Transacao comId(long id) {
        return new Receita(id, getNome(), getDescricao(), getValor(), getData(), getCategoria());
    }
}
