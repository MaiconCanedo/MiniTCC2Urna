package br.gov.tse.urna.util;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class CriarSenha {

    Random Numero = new Random();

    private int Numero() {
        return Numero.nextInt(10);
    }

    private char Letra() {
        //Retorna um caractere
        return (char) (65 + Numero.nextInt(25));
    }
    
    public String geraSenhas(int qtdDigitos){

        // qtdDigito = tamanha da senha
        int x = 0;
        String Senha = "";

        while (x < qtdDigitos) {
            if (x % 2 == 0) {
                Senha += Letra();
            } else {
                Senha += Numero();
            }
            x++;
        }

        return Senha;
    }
    public String geraNumeros(int qtdDigitos){

        // qtdDigito = tamanho da senha
        int x = 0;
        String Senha = "";

        while (x < qtdDigitos) {
                Senha += Numero();
            x++;
        }

        return Senha;
    }
}