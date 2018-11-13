
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
            int rajoitus = rajoitettuHaku(osamj);

            if (merkkijono.length() >= osamj.length()) {

                if (rajoitus == 0) {
                    haeSanaa(merkkijono, osamj);
                } else if (rajoitus == 1) {
                    osamj = poistaYlimaarainen(osamj, rajoitus);
                    haeSanaaAlusta(merkkijono, osamj);
                } else if (rajoitus == -1) {
                    osamj = poistaYlimaarainen(osamj, rajoitus);
                    haeSanaaLopusta(merkkijono, osamj, rajoitus);
                }
            }

            jatkaMainLooppia = suoritetaankoOhjelmaUudelleen();
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

    public static int rajoitettuHaku(String osamj) {

        if (osamj.charAt(0) == '*') {
            return 1;
        } else if (osamj.charAt(osamj.length() - 1) == '*') {
            return -1;
        }

        return 0;
    }

    public static void haeSanaa(String merkkijono, String osamj) {
        for (int i = 0; i < merkkijono.length(); i++) {

            if (merkkijono.charAt(i) == osamj.charAt(0)) {

                if (tarkistaMerkkijono(merkkijono, osamj, i)) {

                    if (i + osamj.length() < merkkijono.length()) {

                        tulostaMerkkijono(merkkijono, osamj, i);
                        System.out.println("");

                    }

                }
            }
        }
    }

    public static void haeSanaaAlusta(String merkkijono, String osamj) {
        boolean jatka = true;

        for (int i = 0; i < merkkijono.length(); i++) {

            if (merkkijono.charAt(i) == osamj.charAt(0) && jatka) {

                if (tarkistaMerkkijono(merkkijono, osamj, i)) {

                    if (i + osamj.length() < merkkijono.length()) {

                        tulostaMerkkijono(merkkijono, osamj, i);
                        jatka = false;
                    }

                }
            }
        }
    }

    public static void haeSanaaLopusta(String merkkijono, String osamj, int rajoitus) {
        boolean jatka = true;

        for (int i = merkkijono.length(); i > 0; i--) {

            String merkkijonoOsamj = getOsaMerkkijonosta(merkkijono, i, osamj.length(), rajoitus);

            System.out.println(merkkijonoOsamj);

        }

    }

    public static String getOsaMerkkijonosta(String merkkijono, int indeksista, int pituus, int rajoitus) {
        String sana = "";
        if (rajoitus == 1) {
            for (int i = indeksista; i < indeksista + pituus; i++) {
                sana += merkkijono.charAt(i);
            }
            return sana;
        } else if (rajoitus == -1) {
            for (int i = indeksista; i > indeksista + pituus; i--) {
                sana += merkkijono.charAt(i);
            }
            return sana;
        }
        return merkkijono;
    }

    public static String poistaYlimaarainen(String osamj, int rajoitus) {
        String sana = "";
        if (rajoitus == 1) {
            for (int i = 1; i < osamj.length(); i++) {
                sana += osamj.charAt(i);
            }
        } else if (rajoitus == -1) {
            for (int i = 0; i < osamj.length() - 1; i++) {
                sana += osamj.charAt(i);
            }
        }
        return sana;
    }

    public static boolean suoritetaankoOhjelmaUudelleen() {

        System.out.println("Continue y/n? ");
        char j = In.readString().charAt(0);
        boolean jatka_valinta = true;

        while (jatka_valinta) {
            if (j != JATKA_VALINTA_KYLLA && j != JATKA_VALINTA_EI) {
                System.out.println(ERROR_MESSAGE);
            } else if (j == JATKA_VALINTA_EI) {
                return false;
            } else {
                jatka_valinta = false;
            }
        }

        return true;
    }
}
