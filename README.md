As expressões lambda em Java são uma forma concisa de expressar funções anônimas. Elas são úteis quando você precisa passar uma função como argumento para outro método
, como em programação funcional, metodos a serem implementados de interfaces funcionais ,ou quando deseja expressar uma função simples de forma mais compacta.

Todavia, quanto à recomendação de uso de lambdas em comparação com métodos normais, não há uma resposta definitiva. O uso de lambdas depende do contexto e das preferências da pessoa desenvolvedora. Mas, devemos considerar os seguintes pontos:

Clareza e legibilidade do código: Em alguns casos, o uso de lambdas pode tornar o código mais conciso e legível, especialmente quando se trata de funções simples. No entanto, em casos mais complexos, um método nomeado tradicional pode ser mais claro e facilitar a compreensão do código.

Reutilização do código: Se você precisar reutilizar a mesma lógica em vários lugares do seu código, pode ser mais adequado criar um método nomeado em vez de usar uma expressão lambda. Dessa forma, você evita a duplicação de código e promove a modularidade.

Compatibilidade com APIs existentes: Nem todas as APIs do Java suportam o uso de lambdas. Algumas APIs mais antigas podem exigir interfaces funcionais específicas ou implementações de interfaces existentes, o que pode limitar o uso de lambdas nessas situações.

No geral, a escolha entre o uso de lambdas ou métodos normais depende da situação específica e das preferências de cada pessoa.

uma interface funcional é uma interface que contém apenas um método abstrato e pode ter métodos default e estáticos
uma interface funcional pode ser implementada por uma expressão lambda
  uma expressão lambda é composta por parâmetros, seta e corpo
  (parâmetros) -> corpo
  (a, b) -> a + b
  (n) -> n % 2 == 0
  () -> System.out.println("Olá")
  (a, b) -> { return a + b; }
  (n) -> {
   if (n % 2 == 0) return true;
      return false;

  }
uma expressão lambda pode ser usada em variáveis, parâmetros e retornos de métodos
uma expressão lambda pode ser usada em interfaces funcionais
uma interface funcional pode ter apenas um método abstrato, mas pode ter vários métodos default
uma interface funcional pode ter métodos estáticos
uma interface funcional pode ser anotada com @FunctionalInterface
uma interface funcional pode ser implementada por uma expressão lambda
uma interface funcional pode ser implementada por uma referência de método
uma referência de método é uma forma de referenciar um método existente
uma referência de método é composta por uma classe, um operador (::) e um método
String::toUpperCase
System.out::println
Math::sqrt
em java temos várias interfaces funcionais, como Function, Predicate, Consumer, Supplier, BiFunction, BiPredicate, BiConsumer
uma interface funcional pode ser usada em streams
uma stream é uma sequência de elementos que suporta operações sequenciais e paralelas
uma stream pode ser criada a partir de uma coleção, um array, um arquivo, um iterador, um gerador, um supplier
uma stream pode ser operada por operações intermediárias e operações terminais
operações intermediárias são operações que retornam uma stream
Function é uma interface funcional que recebe um parâmetro e retorna um resultado
Predicate é uma interface funcional que recebe um parâmetro e retorna um boolean
Consumer é uma interface funcional que recebe um parâmetro e não retorna nada
Supplier é uma interface funcional que não recebe parâmetros e retorna um resultado
BiFunction é uma interface funcional que recebe dois parâmetros e retorna um resultado
BiPredicate é uma interface funcional que recebe dois parâmetros e retorna um boolean
BiConsumer é uma interface funcional que recebe dois parâmetros e não retorna nada
