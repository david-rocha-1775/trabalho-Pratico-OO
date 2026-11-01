package controlegastos.modelo;

public enum Categoria {
    SALARIOS("Salários", TipoCategoria.RECEITA),
    HONORARIOS("Honorários", TipoCategoria.RECEITA),
    RENDIMENTOS("Rendimentos", TipoCategoria.RECEITA),
    OUTRAS_RECEITAS("Outras receitas", TipoCategoria.RECEITA),
    MORADIA("Moradia", TipoCategoria.DESPESA),
    LUZ("Luz", TipoCategoria.DESPESA),
    AGUA("Água", TipoCategoria.DESPESA),
    COMUNICACOES("Comunicações", TipoCategoria.DESPESA),
    ALIMENTACAO("Alimentação", TipoCategoria.DESPESA),
    TRANSPORTE("Transporte", TipoCategoria.DESPESA),
    SAUDE("Saúde", TipoCategoria.DESPESA),
    EDUCACAO("Educação", TipoCategoria.DESPESA),
    LAZER("Lazer", TipoCategoria.DESPESA),
    OUTRAS_DESPESAS("Outras despesas", TipoCategoria.DESPESA);

    private final String descricao;
    private final TipoCategoria tipo;

    Categoria(String descricao, TipoCategoria tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getDescricao() { return descricao; }
    public TipoCategoria getTipo() { return tipo; }
}
