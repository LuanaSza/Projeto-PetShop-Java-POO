import java.util.Scanner;
public class MultaExcessoVelocidade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Enunciado: Leia a velocidade de um carro. Se ultrapassar 80 km/h, exiba multa de R$ 5 por km
        acima do limite; caso contrário, informe que está dentro do limite. */
        System.out.println("Velocidade: ");
        double vel = sc.nextDouble();
        double multa;
        if(vel>80){
            multa = 5*(vel-80);
            System.out.printf("Multado! Valor da multa: %.2f", multa);
        }else{
            multa = 0;
            System.out.println("Sem multa");
        }

    }
}
