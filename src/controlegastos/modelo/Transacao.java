package controlegastos.modelo;

import controlegastos.contratos.Exibivel;
import controlegastos.excecoes.ControleGastosException;
import controlegastos.servico.GeradorIdentificador;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transacao implements Exibivel {
    private final long id;
    private final String nome;
    private final String descricao;
    private final BigDecimal valor;
    private final LocalDate data;
    private final Categoria categoria;

    protected Transacao(String nome, String descricao, BigDecimal valor,
                        LocalDate data, Categoria categoria) {
        this(GeradorIdentificador.proximo(), nome, descricao, valor, data, categoria);
    }

    protected Transacao(long id, String nome, String descricao, BigDecimal valor,
                        LocalDate data, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    public abstract TipoCategoria getTipo();
    public abstract BigDecimal efeitoNoSaldo();
    protected abstract Transacao comId(long id);

    public final void validar() throws ControleGastosException {
        controlegastos.servico.ValidadorTransacao.validar(this);
    }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getData() { return data; }
    public Categoria getCategoria() { return categoria; }
    public Transacao comIdentificador(long novoId) { return comId(novoId); }

    @Override
    public String exibir() {
        return String.format("%d %s %s %s %s", id, getTipo(), nome,
                categoria == null ? "-" : categoria.getDescricao(), valor);
    }
}
