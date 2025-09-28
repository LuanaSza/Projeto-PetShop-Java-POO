import java.util.Scanner;
public class LitrosAbastecer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Preço do litro do combustível: ");
        double precoComb = sc.nextDouble();
        System.out.println("informe o valor em dinheiro para abastecer: ");
        double valorAbast = sc.nextDouble();
        double litros;
        litros = valorAbast/precoComb;
        System.out.printf("Litros: %.2f", litros);
    }
}
