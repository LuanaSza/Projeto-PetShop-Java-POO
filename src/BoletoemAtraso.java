import java.util.Scanner;
public class BoletoemAtraso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Valor do boleto: ");
        double valorBoleto = sc.nextDouble();
        System.out.println("Juros: ");
        double juros = sc.nextDouble();
        System.out.println("Dias: ");
        double dias = sc.nextDouble();
        double prestacao = valorBoleto+(valorBoleto*(juros/100)) * dias;
        System.out.printf("Valor atualizado: %.2f",prestacao);
    }
}