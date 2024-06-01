import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String vvod = scanner.nextLine();
        vvod = vvod.replace("\"", "");
        String[] chast;

        char virajeniye;

        if (vvod.contains(" + ")) {
            chast = vvod.split(" \\+ ");
            virajeniye = '+';

        } else if (vvod.contains(" - ")) {
            chast = vvod.split(" - ");
            virajeniye = '-';
        } else if (vvod.contains(" / ")) {
            chast = vvod.split(" / ");
            virajeniye = '/';
        } else if (vvod.contains(" * ")) {
            chast = vvod.split(" \\* ");
            virajeniye = '*';
        } else {
            throw new IllegalArgumentException("Неверный знак");
        }


        if (virajeniye == '+') {
            System.out.println("\"" + chast[0] + chast[1] + "\"");


        } else if (virajeniye == '-') {
            System.out.println("\"" + chast[0].replace(chast[1], "") + "\"");


        } else if (virajeniye == '*') {
            int razi = Integer.parseInt(chast[1]);
            if (razi < 0 || razi > 10) {
                throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10 включительно");
            }
            StringBuilder umnojeniye = new StringBuilder();
            for (int i = 0; i < razi; i++) {
                umnojeniye.append(chast[0]);
            }
            if(umnojeniye.length() > 40){
                System.out.println("\"" + umnojeniye.substring(0,40) + "..." + "\"");
            } else {System.out.println("\"" + umnojeniye + "\"");}

        } else if (virajeniye == '/') {
            int razi1 = Integer.parseInt(chast[1]);
            if (razi1 <= 0 || razi1 > 10) {
                throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10 включительно");
            }
            if (razi1 != 0 & razi1 > 0 && razi1 <= 10) {
                String deleniye = chast[0].substring(0, chast[0].length() / razi1);
                System.out.println("\"" + deleniye + "\"");

            }

        }

    }

}