import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String vvod = scanner.nextLine();
        vvod = vvod.replace("\"", "");
        char virajeniye = getVirajeniye(vvod);
        reseniye(vvod,virajeniye);
    }

    private static char getVirajeniye(String vvod) {
        if (vvod.contains(" + ")) {
            return '+';
        } else if (vvod.contains(" - ")) {
            return '-';
        } else if (vvod.contains(" / ")) {
            return '/';
        } else if (vvod.contains(" * ")) {
            return  '*';
        } else {
            throw new IllegalArgumentException("Неверный знак");
        }
    }

    private static void reseniye (String vvod,char virajeniye){
        String [] chast = vvod.split(" " + Pattern.quote(String.valueOf(virajeniye)) + " ");
        ogranTexta(chast);
        switch (virajeniye){
            case '+':
                slojeniye(chast);
                break;
            case '-':
                minus(chast);
                break;
            case '*':
                umnojeniye(chast);
                break;
            case '/':
                deleniye(chast);
                break;
        }
    }


//      +++++++++++++++++++
    private static void slojeniye (String [] chast){
        System.out.println("\"" + chast[0] + chast[1] + "\"");

    }

//      -------------------
    private static void minus (String[] chast){
        System.out.println("\"" + chast[0].replace(chast[1],"") + "\"");
    }

//      *******************
    private static void umnojeniye(String[]chast){
    int mnojitel = Integer.parseInt(chast[1]);
        ogranChisel(mnojitel);
        StringBuilder resultat = new StringBuilder();
        resultat.append(String.valueOf(chast[0]).repeat(Math.max(0,mnojitel)));
       vivodi(resultat.toString());
    }

//      ////////////////////
    private static void deleniye(String[]chast){
        int delitel = Integer.parseInt(chast[1]);
        ogranChisel(delitel);
        if (delitel != 0){
            String resultat = chast[0].substring(0,chast[0].length()/delitel);
            System.out.println("\"" + resultat + "\"");
        }
    }



    private static void ogranChisel (int chislo){
        if (chislo < 1 || chislo > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10 включительно");
        }
    }
    private static void ogranTexta (String [] slova){
            for (String s : slova) {
                if (s.length() > 10) {
                    throw new IllegalArgumentException("Введенный текст не превышает 10 символов");
                }
            }

    }

    private static void vivodi (String resultat) {
        if (resultat.length() > 40) {
            System.out.println("\"" + resultat.substring(0, 40) + "..." + "\"");
        }else {
            System.out.println("\"" + resultat + "\"");
        }
    }

}