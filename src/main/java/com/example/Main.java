package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main 
{
    public static void main( String[] args ) throws InterruptedException {

        String s = "";
        String c = "";
        String numero = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nBenvenuto nel programma per codificare o decodificare una parola con il Cifrario di Giulio Cesare.");
        Thread.sleep(1700);

        do{

            Thread.sleep(2500);
            System.out.println("\nSeleziona una delle azioni da compiere: ");
            System.out.println("    - Seleziona 1 per spengere il programma");
            System.out.println("    - Seleziona 2 per codificare una parola");
            System.out.println("    - Seleziona 3 per decodificare una parola");
            System.out.print("\nInserire il numero: ");

            try {
                numero = br.readLine();
            }catch(Exception e) {
                e.printStackTrace();
            }

            if(numero.equals("0")){
                System.out.println("\n:( IL PROGRAMMA SI SPENGERÀ TRA 5 SECONDI. ALLA PROSSIMA, CIAO.\n");
                Thread.sleep(5000);
                break;

            }else if (numero.equals("1")){
                System.out.print("\nInserire la parola che si desidera codificare: ");

                try {
                    s = br.readLine();
                }catch(Exception e) {
                    e.printStackTrace();
                }

                System.out.print("Inserire la chiave che si vuole usare per codificare (per inserire una chiave composta da più numeri fare come nell'esempio a fianco. es: 3, 17, 8, 11): ");

                try {
                    c = br.readLine();
                }catch(Exception e) {
                    e.printStackTrace();
                }

                Criptare crip = new Criptare(s, c);
                System.out.println("\nLa parola " + s + " viene codificata in " + crip.codifica());

            }else if (numero.equals("2")){

                System.out.print("\nInserire la parola che si desidera decodificare: ");

                try {
                    s = br.readLine();
                }catch(Exception e) {
                    e.printStackTrace();
                }

                System.out.print("Inserire la chiave che si vuole usare per decodificare (per inserire una chiave composta da più numeri fare come nell'esempio a fianco. es: 3, 17, 8, 11): ");

                try {
                    c = br.readLine();
                }catch(Exception e) {
                    e.printStackTrace();
                }

                Decriptare crip = new Decriptare(s, c);
                System.out.println("\nLa parola " + s + " viene decodificata in " + crip.decodifica());

            }else{
                System.out.print("\nIl comando inserito non è corretto, per favore reinseriscilo.\n");
            }
            
        }while(true);
    }
}
