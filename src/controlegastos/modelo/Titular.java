package controlegastos.modelo;

public final class Titular {
    private final String nome;

    public Titular(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do titular é obrigatório.");
        }
        this.nome = nome.trim();
    }

    public String getNome() { return nome; }
}
