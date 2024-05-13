import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String vvod = scanner.nextLine();

        String [] chasti = vvod.split(" ");
        String pervi = chasti[0];
        String vitajeniye = chasti[1];
        String vtoroi = chasti [2];


        switch (vitajeniye) {
            case "+":
                System.out.println(pervi+vtoroi);
                break;

            case "-":
                System.out.println(pervi.replace(vtoroi,""));
                break;


            case "*":
                int razi = Integer.parseInt(vtoroi);
                StringBuilder umnojeniye = new StringBuilder();
                for (int i = 0; i < razi; i++) {
                    umnojeniye.append(pervi);
                }
                System.out.println(umnojeniye);
                    break;

            case "/":
                int razi1 = Integer.parseInt(vtoroi);
                if (razi1 != 0){
                    String deleniye = pervi.substring(0,pervi.length() / razi1);
                    System.out.println(deleniye);
                    break;
                }if(razi1 == 1){
                System.out.println(pervi);
                } else {
                    throw new IllegalArgumentException("На ноль не делим");
                }
                break;

            default:
                System.out.println("Неизвестная олперация");
                break;


        }


    }


}