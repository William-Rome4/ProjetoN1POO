package uam.n1;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        
        int escolha = 0;
        Elemonstro[] jogador1 = new Elemonstro[3];
        Elemonstro[] jogador2 = new Elemonstro[3];
        System.out.println("Jogador 1! Escolha 3 Elemonstros!");
        System.out.println("---------------------------------");
        System.out.println("| 1 - Draterra\n| 2 - Ventáguia\n| 3 - Zillétrico\n| 4 - Águarto\n|"
                + " 5 - Sementauro\n| 6 - Lobrasa\n|__________________________________");
        Scanner entrada = new Scanner(System.in);
        escolha = Integer.parseInt(entrada.nextLine());
        pokemon(jogador1,escolha);
        pokemon(jogador2,escolha);
    }
    
    public static void pokemon(Elemonstro[] jogador, int escolha){
        Elemonstro draterra = new Elemonstro("Terremoto","Garras Granito",70,55,"Terra","Draterra","Terra",140,150,160,80);
        Elemonstro ventaguia = new Elemonstro("Vendaval","Bico Mortal",40,60,"Vento","Ventaguia","Vento",200,170,80,110);
        Elemonstro zilletrico = new Elemonstro("Relâmpago do Olimpo","Sobregarga",100,65,"Elétrico","Zilletrico","Elétrico",160,180,75,100);
        Elemonstro aguarto = new Elemonstro("Caud’água","Tsunami",80,90,"Água","Águarto","Água",180,120,100,95);
        Elemonstro sementauro = new Elemonstro("Folha Cortante","Semente Explosiva",55,80,"Grama","Sementauro","Grama",175,140,120,120);
        Elemonstro lobrasa  = new Elemonstro("Mordida Flamejante","Cuspir Fogo",65,90,"Fogo","Lobrasa","Fogo",185,160,145,105);
        switch(escolha){
            case 1 -> jogador[0] = draterra;
            case 2 -> jogador[0] = ventaguia;
            case 3 -> jogador[0] = zilletrico;
            case 4 -> jogador[0] = aguarto;
            case 5 -> jogador[0] = sementauro;
            case 6 -> jogador[0] = lobrasa;
        }
    }
    
}
