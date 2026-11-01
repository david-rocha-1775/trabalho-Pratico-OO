package controlegastos.servico;

public final class GeradorIdentificador {
    private static long proximoId = 1;

    private GeradorIdentificador() {}

    public static synchronized long proximo() { return proximoId++; }
}
