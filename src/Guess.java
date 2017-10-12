import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) throws Exception {

        int random = (int) (Math.random() * 45);
        File file = new File("panstwaeuropy.txt");
        Scanner scanner = new Scanner(file, "UTF-8");
        StringBuilder sb = new StringBuilder("");

        ArrayList<String> countries = new ArrayList<String>();


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            countries.add(line);
        }

        String randomCountry = countries.get(random).toLowerCase();

        System.out.println("Poniżej widzisz ukrytą nazwę europejskiego państwa.\n" +
                "Możesz za jednym razem zgadnąć tylko jedną literę, TYLKO MAŁE LITERY.\nMasz 10 prób, powodzenia!");

        String unknown = "_";
        for (int i = 1; i < randomCountry.length(); i++) {
            unknown += "_";
        }
        sb.append(unknown);

        System.out.println(unknown);




        Scanner scannerinput = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            char guess = scannerinput.next().charAt(0);
            int x = randomCountry.indexOf(guess);

            if (x == -1) {
                System.out.println("Nie ma takiej litery w nazwie tego państwa");
            } else {
                while (x > -1) {
                    sb.setCharAt(x, guess);
                    x = randomCountry.indexOf(guess, x + 1);

                }
                System.out.println("Jest litera!  " + sb);

            }

            System.out.println("Zostało " + (i - 1) + " prób");
            if (sb.indexOf("_") == -1) {
                System.out.println("ZWYCIĘSTWO");
            }

        }
        if (sb.indexOf("_") >= 0) {
            System.out.println("Przegrana. To : " + randomCountry);
        }

    }
}
