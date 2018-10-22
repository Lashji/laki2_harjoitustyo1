
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello! I find substrings.\n");
        boolean jatka = true;

        while (jatka) {
            System.out.println("Please, enter a string: ");

            String merkkijono = In.readString();

            System.out.println("Please enter a substring: ");
            String osamj = In.readString();

            if (merkkijono.length() >= osamj.length()) {

                for (int i = 0; i < merkkijono.length(); i++) {

                    if (merkkijono.charAt(i) == osamj.charAt(0)) {
                        if (tarkistaMerkkijono(merkkijono, osamj, i)) {
                            tulostaMerkkijono(merkkijono, osamj, i);
                            break;
                        }
                    }
                }

            }

            System.out.println("Continue y/n? ");
            char j = In.readString().charAt(0);

            while (true) {

                if (j != 'n' && j != 'y') {
                    System.out.println("Error!");
                } else if (j == 'n') {
                    jatka = false;
                    break;
                } else {
                    break;
                }

            }
        }

        System.out.println("See you soon.");
    }

    static boolean tarkistaMerkkijono(String mj, String osa, int start) {

        for (int i = start; i < osa.length(); i++) {
            if (mj.charAt(i) != osa.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    static void tulostaMerkkijono(String mj, String osamj, int loytynyt_indeksi) {

        for (int i = 0; i <= mj.length(); i++) {

            if (i < loytynyt_indeksi) {

                System.out.print('-');
            } else if (i == loytynyt_indeksi) {

                System.out.print(osamj);

                i += osamj.length();
            } else {
                System.out.print("-");
            }

        }
        System.out.println("");

    }

}
