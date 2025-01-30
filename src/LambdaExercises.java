import java.util.Arrays;
import java.util.List;

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

        // Stream pode usar lambda, recursos de programação funcional
        List<String> nomesT = Arrays.asList("Lucas", "Maria", "João", "Ana");
        nomesT.stream()
                .sorted()
                .limit(3)
                .filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }




}