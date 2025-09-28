import java.util.Scanner;
public class ReajusteSalarial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu salário: ");
        double wage = sc.nextDouble();
        double newWage;
        if(wage>1250){
            newWage = wage + (wage*0.10);
        } else{
            newWage = wage + (wage*0.15);
        }
        System.out.printf("Novo salário: %.2f",newWage);
    }
}
