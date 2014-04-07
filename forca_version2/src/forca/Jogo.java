package forca;

/**
 *
 * @author raldney
 * @version 1.0
 */
public final class Jogo {

    int i = 0, acertosAux = 0, usadasAux = 0;
    String palavraSecreta;
    char palavraErrada[] = {' ', ' ', ' ', ' ', ' ', ' '};
    char[ ]palavraUsada;
    

    public void setPalavra(String palavra) {
        this.palavraSecreta = palavra;
    }
    public void setPalavraUsada(){
    this.palavraUsada = new char[palavraSecreta.length() + palavraErrada.length + 1];
    }

    

    public Jogo(String palavra) {
      setPalavra(palavra);
      setPalavraUsada();
     
    }
    

    int letrasTotal() {
        int contAux = 0;
        do {
            contAux++;
        } while (contAux < palavraSecreta.length());
        return contAux;
    }

    int letrasErradas() {
        int contAux = 0;
        i = 0;
        while (i < palavraUsada.length) {
            if (contAux > 5) {
                break;
            }
            if (palavraErrada[contAux] == palavraUsada[i]) {
                contAux++;
            } else {
                i++;
            }

        }
        return contAux;

    }

    int letrasCertas() {
        int countAux = 0;
        while (palavraUsada[countAux] != '|' && palavraUsada[countAux] == palavraSecreta.charAt(countAux)) {
            countAux++;
        }
        return countAux;
    }

    int adivinha(char letra) {


        if (letraUsada(letra)) {
            return -1;
        } else if (letraCerta(letra)) {
            return letrasCertas();
        } else if (letraErrada(letra)) {
            return 0;
        } else if (fimDeJogo()) {
            return -2;
        }
        return 0;

    }

    boolean fimDeJogo() {

        if (jogadorGanhou()) {
            System.out.println("Fim de jogo! Você Ganhou! :-)");
            return true;
        } else if (jogadorPerdeu()) {

            return true;
        } else {
            return false;
        }

    }

    boolean jogadorGanhou() {

        if (letrasCertas() == letrasTotal()) {
            return true;
        } else {
            return false;
        }

    }

    boolean jogadorPerdeu() {
        if (letrasErradas() == 6) {
            System.out.println("Fim de jogo! Você Perdeu! :-(");
            return true;
        }
        return false;
    }

    boolean letraUsada(char letra) {
        palavraUsada[palavraSecreta.length()] = '|';
        for (i = 0; i < palavraUsada.length; i++) {
            if (palavraUsada[i] == letra) {
                System.out.println("A letra " + letra + " já foi usada...");
                return true;

            }
        }
        return false;
    }

    boolean letraCerta(char letra) {
        acertosAux = 0;

        for (i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                acertosAux++;
                palavraUsada[i] = letra;
                usadasAux++;


            }

        }


        if (acertosAux > 0) {
            System.out.println(acertosAux + " Acertos com a letra " + letra);
            System.out.println(toString());
            return true;
        } else {
            return false;
        }

    }

    boolean letraErrada(char letra) {
        if (letrasErradas() <= 5) {
            System.out.println("A letra: " + letra + " não esta na palavra");
            palavraErrada[letrasErradas()] = letra;
            palavraUsada[letrasErradas() + (palavraSecreta.length() + 1)] = letra;

            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        palavraUsada[palavraSecreta.length()] = '|';
        String usadas = new String(palavraUsada);
        String erros = new String(palavraErrada);
        String acertos = usadas.replaceAll(erros, "");
        return usadas;
    }
}
