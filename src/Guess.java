import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) throws Exception {



        File file = new File("input/panstwaeuropy.txt");

        Scanner scanner = new Scanner(file);

        StringBuilder sb = new StringBuilder("");

        ArrayList<String> countries = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            countries.add(line);
        }
        int random = (int) (Math.random() * 45);
        System.out.println(countries.get(random)); //TEST

        String randomCountry = countries.get(random).toLowerCase();

        String letters[] = randomCountry.split("");
        String unknown = "_";
        for (int i = 1; i < letters.length; i++) {
            unknown += "_";
        }
        sb.append(unknown);

        System.out.print(unknown);

        Scanner scannerinput = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            char guess = scannerinput.next().charAt(0);
            System.out.println(guess);
            int x = randomCountry.indexOf(guess);
            // for (int q = 0; q < letters.length; q++){ }
            if (x == -1) {
                System.out.println("Nie ma takiej litery w nazwie tego państwa");
            } else {
                 while (x > -1) {
                 sb.setCharAt(x, guess);
                    x = randomCountry.indexOf(guess, x+1);


                }
                System.out.println("Jest litera!  " + sb);

            }

            System.out.println("Zostało " + (i - 1) + " prób");
            if (sb.indexOf("_")== -1){
                System.out.println("ZWYCIĘSTWO");
            }
        }

    }

}
