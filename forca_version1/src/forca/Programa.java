package forca;

import java.util.Scanner;

/**
 *
 * @author raldney
 */
public class Programa {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Jogo forca = new Jogo();

        int countAux = 0;
        System.out.println(forca.toString());
        while (!forca.fimDeJogo()) {
            System.out.print("Letra(s): ");
            String palavra = ler.nextLine();
            char letras[] = palavra.toCharArray();
            for (countAux = 0; countAux < palavra.length(); countAux++) {
                forca.adivinha(letras[countAux]);
                
            }
            System.out.println(forca.toString());
        }

    }
}
