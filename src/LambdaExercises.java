import java.util.*;

//  iremos ver lambdas em java nas implementações de interfaces funcionais
//  uma interface funcional é uma interface que contém apenas um método abstrato
//  e pode ter métodos default e estáticos
//  uma interface funcional pode ser implementada por uma expressão lambda
//  uma expressão lambda é uma função anônima que pode ser usada para criar instâncias de interfaces funcionais
//  uma expressão lambda é composta por parâmetros, seta e corpo
//  (parâmetros) -> corpo
//  (a, b) -> a + b
//  (n) -> n % 2 == 0
//  () -> System.out.println("Olá")
//  (a, b) -> { return a + b; }
//  (n) -> {
//      if (n % 2 == 0) return true;
//      return false;
//
//  }
//  uma expressão lambda pode ser usada em variáveis, parâmetros e retornos de métodos
//  uma expressão lambda pode ser usada em interfaces funcionais
//  uma interface funcional pode ter apenas um método abstrato, mas pode ter vários métodos default
//  uma interface funcional pode ter métodos estáticos
//  uma interface funcional pode ser anotada com @FunctionalInterface
//  uma interface funcional pode ser implementada por uma expressão lambda
//  uma interface funcional pode ser implementada por uma referência de método
//  uma referência de método é uma forma de referenciar um método existente
//  uma referência de método é composta por uma classe, um operador (::) e um método
//  String::toUpperCase
//  System.out::println
//  Math::sqrt
//  em java temos várias interfaces funcionais, como Function, Predicate, Consumer, Supplier, BiFunction, BiPredicate, BiConsumer
//  uma interface funcional pode ser usada em streams
//  uma stream é uma sequência de elementos que suporta operações sequenciais e paralelas
//  uma stream pode ser criada a partir de uma coleção, um array, um arquivo, um iterador, um gerador, um supplier
//  uma stream pode ser operada por operações intermediárias e operações terminais
//  operações intermediárias são operações que retornam uma stream
// Function é uma interface funcional que recebe um parâmetro e retorna um resultado
// Predicate é uma interface funcional que recebe um parâmetro e retorna um boolean
// Consumer é uma interface funcional que recebe um parâmetro e não retorna nada
// Supplier é uma interface funcional que não recebe parâmetros e retorna um resultado
// BiFunction é uma interface funcional que recebe dois parâmetros e retorna um resultado
// BiPredicate é uma interface funcional que recebe dois parâmetros e retorna um boolean
// BiConsumer é uma interface funcional que recebe dois parâmetros e não retorna nada


class ComparadorPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s2.length() < s1.length())
            return 1;
        return 0;
    }
}

class ComparadorPorTamanhoSimples implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}


@FunctionalInterface
interface Soma {
    int soma(int a, int b);
}

@FunctionalInterface
interface Primo {
    boolean verificarPrimo(int n);
}

interface Transformador {
    String transformar(String s);
}

@FunctionalInterface
interface Palindromo {
    boolean verificarPalindromo(String str);
}

interface Divisor {
    int dividir(int a, int b) throws ArithmeticException;
}

public class LambdaExercises {
    public static void main(String[] args) {

        // 1 exemplo
        Soma soma = (a, b) -> a + b;
        System.out.println(soma.soma(5, 3));  // Resultado: 8

        // 2 exemplo
        Primo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(primo.verificarPrimo(11));  // Resultado: true
        System.out.println(primo.verificarPrimo(12));  // Resultado: false

        // 3 exemplo
        Transformador transformador = s -> s.toUpperCase();
        System.out.println(transformador.transformar("arlei"));  // Resultado: ARLEI

        // 4 exemplo

        Palindromo palindromo = str -> str.equals(new StringBuilder(str).reverse().toString());
        System.out.println(palindromo.verificarPalindromo("radar"));  // Resultado: true
        System.out.println(palindromo.verificarPalindromo("java"));   // Resultado: false

        // 5 exemplo

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        numeros.replaceAll(n -> n * 3);
        System.out.println(numeros);  // Resultado: [3, 6, 9, 12, 15]

        // 6 exemplo

        List<String> nomes = Arrays.asList("Lucas", "Maria", "João", "Ana");
        nomes.sort((a, b) -> a.compareTo(b));
        System.out.println(nomes);  // Resultado: [Ana, João, Lucas, Maria]

        // 7 exemplo

        Divisor divisor = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por zero");
            return a / b;
        };

        try {
            System.out.println(divisor.dividir(10, 2)); // Esperado: 5
            System.out.println(divisor.dividir(10, 0)); // Esperado: Exceção
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // 8 exemplo Stream pode usar lambda, recursos de programação funcional
        List<String> nomesT = Arrays.asList("Lucas", "Maria", "João", "Ana");
        nomesT.stream()
                .sorted()
                .limit(3)
                .filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //9 exemplo
        // aqui em um padrão mais antigo
        List<String> lista = new ArrayList<>();
        lista.add("Sérgio");
        lista.add("Paulo");
        lista.add("Guilherme");

        lista.sort(new ComparadorPorTamanho());

        System.out.println(lista);

        // aqui com classe anonima
        Collections.sort(lista, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(lista);


        // aqui com lambda
        Collections.sort(lista, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

    }




}