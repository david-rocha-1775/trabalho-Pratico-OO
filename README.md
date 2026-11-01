# Trabalho Prático de Orientação a Objetos

Aplicação de console para controle financeiro, conforme o [enunciado](enunciado.md).

## Compilação e execução

No Windows, a partir da raiz do projeto:

```powershell
New-Item -ItemType Directory -Force out
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
java -cp out controlegastos.app.Main
```

O projeto usa somente a biblioteca padrão do Java 17 ou superior.

## Estrutura

- `src/controlegastos/modelo`: entidades e regras do domínio.
- `src/controlegastos/excecoes`: hierarquia de exceções da aplicação.
- `src/controlegastos/contratos`: interfaces.
- `src/controlegastos/repositorio`: armazenamento genérico das transações.
- `src/controlegastos/servico`: validação e utilitários.
- `src/controlegastos/app`: pontos de entrada da aplicação.
- `docs`: documentação e roteiro inicial de testes.

O diagrama completo está em [`docs/diagrama-classes.md`](docs/diagrama-classes.md).
