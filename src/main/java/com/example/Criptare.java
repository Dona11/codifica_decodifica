package com.example;

public class Criptare {

    String stringaDaCodificare;
    String chiave;
    char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Criptare(String stringaDaCodificare, String chiave){

        this.chiave = chiave;
        this.stringaDaCodificare = stringaDaCodificare;
    }

    private int trovaPosizione(char letteraCercare){
        for(int i = 0; i < alfabeto.length; i++){
            if(letteraCercare == alfabeto[i]){
                return i;
            }
        }
        return -1;
    }

    private int[] chiaveSplittata(){

        String [] chiaveSplittata = chiave.split(", ");
        int[] chiaveInteri = new int [chiaveSplittata.length];

        for (int i = 0; i < chiaveSplittata.length; i++){
            chiaveInteri[i] = Integer.parseInt(chiaveSplittata[i]);
        }

        return chiaveInteri;
    }

    public String codifica(){
        String s = "";
        int indice;
        char[] arrayS = stringaDaCodificare.toCharArray();
        int[] arrayC = chiaveSplittata();
        int giro = 0;
        for (int i = 0; i < arrayS.length; i++){
            int posizione = trovaPosizione(arrayS[i]);
            indice = (posizione + arrayC[giro]) % 26;
            s += alfabeto[indice];
            giro++;

            if(giro == arrayC.length){
                giro = 0;
            }
        }
        return s;
    }
}
