import java.util.Scanner;
public class PreçoPassagem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("report the travel distance: ");
        double km = sc.nextDouble();
        double precoPassagem;
        if(km<=200){
            precoPassagem = 0.50 * km;
        }else{
            precoPassagem = 0.45 * km;
        }

        System.out.printf("Ticket price: %.2f",precoPassagem);
    }
}
