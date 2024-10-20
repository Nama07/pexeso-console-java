import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner souradnice = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> inv = new ArrayList<>();

        
        inv.add("o");
        inv.add("o");
        inv.add("x");
        inv.add("x");
        inv.add("a");
        inv.add("a");   //semka jsem chtel pridat treba nejaky smajliky ale za prvy nevim jestli to vubec jde (jestli je to na to typ) protoze jsem to zkousel a dalo my to takovy to ze to nevi co to je takze jsem sem dal x o a pak proste pismena
        inv.add("b");
        inv.add("b");
        inv.add("c");
        inv.add("c");
        inv.add("d");
        inv.add("d");
        inv.add("e");
        inv.add("e");
        inv.add("f");
        inv.add("f");

        boolean playAgain;

        do {
            String[][] matrix = new String[4][4];
            ArrayList<String> tempInv = new ArrayList<>(inv); 

            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    int randomIndex = random.nextInt(tempInv.size());
                    String randomItem = tempInv.remove(randomIndex);
                    matrix[x][y] = randomItem;
                }
            }

            String[][] matrix2 = new String[4][4];
            for (int x = 0; x < matrix2.length; x++) {
                for (int y = 0; y < matrix2[x].length; y++) {
                    matrix2[x][y] = "[]";
                }
            }

            while (!dohrano(matrix2)) {
                for (int x = 0; x < matrix2.length; x++) {
                    for (int y = 0; y < matrix2[x].length; y++) {
                        System.out.print(" " + matrix2[x][y] + " ");
                    }
                    System.out.println();
                }

                System.out.println("Zadejte první souradnici x (0, 1, 2 nebo 3):");
                int x1 = souradnice.nextInt();
                System.out.println("Zadejte první souřadnici y (0, 1, 2 nebo 3):"); //semka jsem chtel pridat treba nejaky smajliky ale za prvy nevim jestli to vubec jde (jestli je to na to typ) protoze jsem to zkousel a dalo my to takovy to ze to nevi co to je takze jsem sem dal x o a pak proste pismena
                int y1 = souradnice.nextInt();
                System.out.println("Zadejte druhou souradnici x (0, 1, 2 nebo 3):");
                int x2 = souradnice.nextInt();
                System.out.println("Zadejte druhou souradnici y (0, 1, 2 nebo 3):");
                int y2 = souradnice.nextInt();

                matrix2[x1][y1] = matrix[x1][y1];
                matrix2[x2][y2] = matrix[x2][y2];

                if (matrix2[x1][y1].equals(matrix2[x2][y2])) {
                    System.out.println("Shoda! Obě karty jsou stejné.");
                } else {
                    System.out.println("Neshoda! Obě karty nejsou stejné.");
                    System.out.println("Bylo skryto: " + matrix[x1][y1] + " a " + matrix[x2][y2]); ////tady bych jeste chtel podotknout ze tohle byla asi tak posledni vec co jsem v tom projektu delal a kvuli tomu ze mi dochazel cas tak jsem to udelal timhle zpusobem, az budu priste delat neco podobneho tak to udelam ve stylu ze az to pritne tak to v tom matrixu ukaze na to 1 kolo i to co uzivatel uhadnul ( ano vim ze by to bylo rychly to tak udelat ale tohle proste znam lip :D) 
                    matrix2[x1][y1] = "[]";
                    matrix2[x2][y2] = "[]";
                }
            }

            System.out.println("Gratuluji! Všechny karty byly nalezeny.");
            for (int x = 0; x < matrix2.length; x++) {
                for (int y = 0; y < matrix2[x].length; y++) {
                    System.out.print(" " + matrix2[x][y] + " ");
                }
                System.out.println();
            }

            System.out.print("Chcete hrát znovu? (ano/ne): ");
            String answer = souradnice.next();
            playAgain = answer.equalsIgnoreCase("ano");

        } while (playAgain);

        souradnice.close();
    }

    public static boolean dohrano(String[][] matrix2) {
        for (int x = 0; x < matrix2.length; x++) {
            for (int y = 0; y < matrix2[x].length; y++) {
                if (matrix2[x][y].equals("[]")) {
                    return false;
                }
            }
        }
        return true;
    }
}
