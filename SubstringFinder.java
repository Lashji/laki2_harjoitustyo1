
public class SubstringFinder {

    public static final char JATKA_VALINTA_KYLLA = 'y';
    public static final char JATKA_VALINTA_EI = 'n';
    public static final String ERROR_MESSAGE = "Error!";

    public static void main(String[] args) {

        System.out.println("Hello! I find substrings.\n");
        boolean jatkaMainLooppia = true;

        while (jatkaMainLooppia) {
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
            boolean jatka_valinta = true;
            while (jatka_valinta) {

                if (j != JATKA_VALINTA_KYLLA && j != JATKA_VALINTA_EI) {
                    System.out.println(ERROR_MESSAGE);
                } else if (j == JATKA_VALINTA_EI) {

                    jatkaMainLooppia = false;
                    jatka_valinta = false;
                } else {

                    jatka_valinta = false;
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
