import java.util.Scanner;
public class CelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Temperatura de Celsius: ");
        double c = sc.nextDouble();
        double f;
        f = (9*c+160)/5;
        System.out.printf("Temperatura em ºF: %.2f", f );
    }

}
