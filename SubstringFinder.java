
public class SubstringFinder {
//    Vakiomuuttujat
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
                    haeSanaa(merkkijono, osamj, rajoitus);
                } else if (rajoitus == 1) {
                    osamj = poistaYlimaarainen(osamj, rajoitus);
                    haeSanaa(merkkijono, osamj, rajoitus);
                } else if (rajoitus == -1) {
                    osamj = poistaYlimaarainen(osamj, rajoitus);
                    haeSanaaLopusta(merkkijono, osamj, rajoitus);
                }
            }

            jatkaMainLooppia = suoritetaankoOhjelmaUudelleen();
        }

        System.out.println("See you soon.");
    }


//    Tulostaa merkkijonon
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

    /*
            Määrittelee haluaako käyttäjä rajoitetun haun. Palauttaa int arvon käyttäjän valinnan mukaan
            0 = ei rajattu, 1 = haetaan alusta, -1= haetaan lopusta
    */
    public static int rajoitettuHaku(String osamj) {

        if (osamj.charAt(0) == '*') {
            return 1;
        } else if (osamj.charAt(osamj.length() - 1) == '*') {
            return -1;
        }

        return 0;
    }

    //    Hakee sanaa Stringin alusta päin
    public static void haeSanaa(String merkkijono, String osamj, int rajoitus) {
        boolean jatka = true;

        for (int i = 0; i < merkkijono.length(); i++) {

            if (jatka) {

                String merkkijonoOsamj = getOsaMerkkijonosta(merkkijono, i, osamj.length(), rajoitus);

                if (i + osamj.length() <= merkkijono.length() && jatka) {

                    if (merkkijonoOsamj.equals(osamj)) {
                        tulostaMerkkijono(merkkijono, osamj, i);

                        if (rajoitus == 1 || rajoitus == -1) {
                            jatka = false;
                        } else {
                            System.out.println("");
                        }


                    }

                }
            }
        }
    }

    //    Suorittaa rajatun haun Stringin lopusta päin
    public static void haeSanaaLopusta(String merkkijono, String osamj, int rajoitus) {
        boolean jatka = true;

        for (int i = merkkijono.length(); i > 0; i--) {

            String merkkijonoOsamj = getOsaMerkkijonosta(merkkijono, i, osamj.length(), rajoitus);
            if (i + osamj.length() <= merkkijono.length()) {

                if (merkkijonoOsamj.equals(osamj)) {
                    tulostaMerkkijono(merkkijono, osamj, i);
                }

            }
        }

    }

    //   Hakee merkkijonosta osan ja palauttaa sen vertailua varten
    public static String getOsaMerkkijonosta(String merkkijono, int indeksista, int pituus, int rajoitus) {
        String sana = "";
        if (rajoitus == 1 || rajoitus == 0) {
            if (indeksista + pituus <= merkkijono.length()) {
                for (int i = indeksista; i < indeksista + pituus; i++) {
                    sana += merkkijono.charAt(i);
                }
            }
            return sana;
        } else if (rajoitus == -1) {
            if (indeksista - pituus >= 0) {
                for (int i = indeksista - pituus; i < indeksista; i++) {

                    sana += merkkijono.charAt(i);
                }
            }
            return sana;
        }
        return merkkijono;
    }

    //    Poistaa tähden merkkijonosta ja palauttaa uuden Stringin
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

    //    Kysyy käyttäjältä haluaako käyttäjä jatkaa ja palauttaa totuusarvon
    public static boolean suoritetaankoOhjelmaUudelleen() {

        boolean jatka_valinta = true;

        while (jatka_valinta) {
            System.out.println("Continue y/n? ");
            char j = In.readString().charAt(0);

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
