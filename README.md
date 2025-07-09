# 🧱 Padrão de Projeto: Builder

## 📌 Introdução: O que são os padrões de projetos

Padrões de projeto (design patterns) são soluções reutilizáveis para problemas recorrentes no desenvolvimento de software. Eles representam boas práticas adotadas por desenvolvedores experientes e ajudam a tornar o código mais compreensível, reutilizável e fácil de manter.

Esses padrões não são pedaços de código prontos para serem copiados e colados, mas sim estruturas e ideias que guiam a implementação de soluções. Existem diversas categorias, como **padrões criacionais**, **estruturais** e **comportamentais**.

O padrão **Builder** se encaixa na categoria dos padrões **criacionais**, pois lida com a criação de objetos.

-----

## 🏗️ Builder: O que é

O padrão **Builder** separa a **construção de um objeto complexo da sua representação final**. Ele permite que você construa objetos passo a passo, utilizando a mesma lógica de construção para criar diferentes tipos e representações do objeto.

É especialmente útil quando um objeto precisa de muitos parâmetros para ser instanciado, alguns obrigatórios e outros opcionais. O Builder torna o código mais legível e robusto, evitando construtores com uma longa lista de parâmetros (o anti-pattern conhecido como "telescoping constructor").

-----

## ✅ Vantagens

  * **Melhora a legibilidade:** A criação do objeto se torna mais clara, com chamadas de método autoexplicativas (ex: `.comNome("Produto")`, `.comPreco(100.0)`).
  * **Permite a criação de objetos imutáveis:** Após a construção, o objeto não pode ser alterado, o que aumenta a segurança em ambientes multithread.
  * **Encapsula a lógica de construção:** A complexidade da criação do objeto fica isolada na classe Builder, separada da lógica de negócio.
  * **Flexibilidade na construção:** Permite que a criação do objeto ocorra em múltiplos passos, com validações intermediárias.

-----

## ❌ Desvantagens

  * **Aumenta a verbosidade:** Requer a criação de uma classe Builder para cada objeto complexo, o que pode aumentar o número de classes no projeto.
  * **Pode ser excessivo para objetos simples:** Se o objeto tem poucos atributos, o custo de implementar o padrão pode não compensar.
  * Exige mais esforço inicial de implementação em comparação com uma instanciação direta.

-----

## 💡 Formas utilizadas no código

### 1\. 🧾 Construção de uma Nota Fiscal

Neste exemplo, usamos um Builder para construir um objeto `NotaFiscal`, que pode ter vários campos opcionais, como observações e impostos.

Classe `NotaFiscal`:

```java
public class NotaFiscal {
    private final String razaoSocial;
    private final String cnpj;
    private final double valorBruto;
    private final double impostos;
    private final String observacoes;

    // Construtor privado para forçar o uso do Builder
    private NotaFiscal(String razaoSocial, String cnpj, double valorBruto, double impostos, String observacoes) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.valorBruto = valorBruto;
        this.impostos = impostos;
        this.observacoes = observacoes;
    }

    // Getters...
}
```

Classe `NotaFiscalBuilder`:

```java
public class NotaFiscalBuilder {
    private String razaoSocial;
    private String cnpj;
    private double valorBruto;
    private double impostos;
    private String observacoes;

    public NotaFiscalBuilder comRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this; // Retorna a própria instância para encadear chamadas
    }

    public NotaFiscalBuilder comCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public NotaFiscalBuilder comValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
        return this;
    }

    public NotaFiscalBuilder comImpostos(double impostos) {
        this.impostos = impostos;
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    // O método build() constrói e retorna o objeto final
    public NotaFiscal construir() {
        return new NotaFiscal(razaoSocial, cnpj, valorBruto, impostos, observacoes);
    }
}
```

Uso:

```java
public class TesteBuilder {
    public static void main(String[] args) {
        NotaFiscal nf = new NotaFiscalBuilder()
                .comRazaoSocial("Empresa XYZ LTDA")
                .comCnpj("12.345.678/0001-99")
                .comValorBruto(1500.0)
                .comImpostos(150.0)
                .comObservacoes("Pagamento referente a serviços de manutenção.")
                .construir(); // O objeto é criado aqui!
    }
}
```

### 2\. 🧑 Construção de uma pessoa

```java
package com.ex1;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private String username;
    private String email;

    private Pessoa(String nome, String sobrenome, int idade, String username, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.username = username;
        this.email = email;
    }

    public static class PessoaBuilder{
        private String nome;
        private String sobrenome;
        private int idade;
        private String username;
        private String email;

        public PessoaBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome){
            this.sobrenome = sobrenome;
            return this;
        }
        public PessoaBuilder idade(int idade){
            this.idade = idade;
            return this;
        }

        public PessoaBuilder username(String username){
            this.username = username;
            return this;
        }

        public PessoaBuilder email(String email){
            this.email = email;
            return this;
        }

        public Pessoa build(){
            return new Pessoa(nome, sobrenome, idade, username, email);
        }
    }
}

```

### ❓. Curiosidade:

Dentro da própria JDK (Java Development Kit) podemos encontrar implementações do padrão Builder. A mais famosa é a classe `StringBuilder`.

```java
// O StringBuilder usa o padrão Builder para construir uma String
StringBuilder sb = new StringBuilder();

// Cada "append" é um passo da construção
sb.append("Olá, ");
sb.append("mundo!");
sb.append(" Este é um exemplo de Builder.");

// O método toString() finaliza a construção e retorna o objeto resultante
String resultado = sb.toString();

System.out.println(resultado); // "Olá, mundo! Este é um exemplo de Builder."
```

O `StringBuilder` permite construir uma string complexa passo a passo, de forma eficiente, sem criar múltiplos objetos `String` intermediários no processo.

-----

### 3\. ⚙️ Aplicação em objetos de configuração

O padrão é ideal para criar objetos de configuração (como uma conexão de banco de dados), onde vários parâmetros podem ser definidos (host, porta, usuário, senha, timeout, etc.), mas nem todos são sempre necessários.

-----

## 📢 Importante:

O padrão Builder **isola o processo de montagem de um objeto**, permitindo que ele seja construído de forma incremental e controlada.

Ele é ideal quando:

  * Um construtor teria **muitos parâmetros**, dificultando a leitura.
  * É preciso criar um **objeto imutável**.
  * Deseja-se **desacoplar a lógica de construção** da representação final do objeto.
  * O mesmo processo de construção precisa criar **diferentes representações** do objeto.

-----
