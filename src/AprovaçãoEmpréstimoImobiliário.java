import java.util.Scanner;
public class AprovaçãoEmpréstimoImobiliário {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("report the value of the house: ");
        double houseValue = sc.nextDouble();
        System.out.println("What is your salary?");
        double wage = sc.nextDouble();
        System.out.println("How many years to pay: ");
        int years = sc.nextInt();
        double installment = houseValue/(years*12);
        if(installment<=wage*0.30){
            System.out.printf("approved. installment: %.2f",installment);
        }else{
            System.out.println("denied!");
        }


    }
}
