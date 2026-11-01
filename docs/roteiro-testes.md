# Roteiro de testes

| Caso | Operação | Resultado esperado |
|---|---|---|
| V1 | Inserir receita válida | Receita registrada e saldo atualizado |
| V2 | Inserir despesa válida | Despesa registrada e saldo atualizado |
| E1 | Despesa maior que o saldo | `SaldoInsuficienteException`, sem alteração |
| E2 | Valor zero ou negativo | `ValorInvalidoException`, sem alteração |
| E3 | Nome ou descrição vazios | `NomeInvalidoOuNuloException`, sem alteração |
| E4 | Categoria ausente | `CategoriaNaoDefinidaException`, sem alteração |
| E5 | Categoria incompatível | `CategoriaNaoDefinidaException`, sem alteração |
| E6 | Remoção que negativaria o saldo | `SaldoInsuficienteException`, sem alteração |
| E7 | Atualização que negativaria o saldo | `SaldoInsuficienteException`, sem alteração |
