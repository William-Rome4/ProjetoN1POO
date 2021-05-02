package uam.n1;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        
        int escolha = 0, i = 0;
        Elemonstro[] jogador1 = new Elemonstro[3];
        Elemonstro[] jogador2 = new Elemonstro[3];
        for(int j=0 ; j<6; j++){
            System.out.println("Jogador "+ (i+1) + "! Escolha 3 Elemonstros!");
            System.out.println("---------------------------------");
            System.out.println("| 1 - Draterra\n| 2 - Ventáguia\n| 3 - Zillétrico\n| 4 - Águarto\n|"
                    + " 5 - Sementauro\n| 6 - Lobrasa\n|__________________________________");
            Scanner entrada = new Scanner(System.in);
            escolha = Integer.parseInt(entrada.nextLine());
            if(i == 0)
                elemonstro(jogador1,escolha,i,j);
            else
                elemonstro(jogador2,escolha,i,j);
            if(j==2)
                i++;
        }
        if((jogador1[0].getNomeElemonstro().equals(jogador1[1].getNomeElemonstro()))||
                (jogador1[0].getNomeElemonstro().equals(jogador1[2].getNomeElemonstro()))||
                (jogador1[1].getNomeElemonstro().equals(jogador1[2].getNomeElemonstro()))){
            System.out.println("O Jogador não pode escolher dois monstros iguais!");
            System.exit(0);
        }else if((jogador2[0].getNomeElemonstro().equals(jogador2[1].getNomeElemonstro()))||
                (jogador2[0].getNomeElemonstro().equals(jogador2[2].getNomeElemonstro()))||
                (jogador2[1].getNomeElemonstro().equals(jogador2[2].getNomeElemonstro()))){
            System.out.println("O Jogador não pode escolher dois monstros iguais!");
            System.exit(0);
        }
    }
    
    public static void elemonstro(Elemonstro[] jogador, int escolha, int i, int j){
        if(i == 0){
            Elemonstro draterra1 = new Elemonstro("Terremoto","Garras Granito",70,55,"Terra","Draterra","Terra",140,150,160,80);
            Elemonstro ventaguia1 = new Elemonstro("Vendaval","Bico Mortal",40,60,"Vento","Ventaguia","Vento",200,170,80,110);
            Elemonstro zilletrico1 = new Elemonstro("Relâmpago do Olimpo","Sobregarga",100,65,"Elétrico","Zilletrico","Elétrico",160,180,75,100);
            Elemonstro aguarto1 = new Elemonstro("Caud’água","Tsunami",80,90,"Água","Águarto","Água",180,120,100,95);
            Elemonstro sementauro1 = new Elemonstro("Folha Cortante","Semente Explosiva",55,80,"Grama","Sementauro","Grama",175,140,120,120);
            Elemonstro lobrasa1  = new Elemonstro("Mordida Flamejante","Cuspir Fogo",65,90,"Fogo","Lobrasa","Fogo",185,160,145,105);
            switch(escolha){
                case 1 -> jogador[j] = draterra1;
                case 2 -> jogador[j] = ventaguia1;
                case 3 -> jogador[j] = zilletrico1;
                case 4 -> jogador[j] = aguarto1;
                case 5 -> jogador[j] = sementauro1;
                case 6 -> jogador[j] = lobrasa1;
            }
        }else{
            Elemonstro draterra2 = new Elemonstro("Terremoto","Garras Granito",70,55,"Terra","Draterra","Terra",140,150,160,80);
            Elemonstro ventaguia2 = new Elemonstro("Vendaval","Bico Mortal",40,60,"Vento","Ventaguia","Vento",200,170,80,110);
            Elemonstro zilletrico2 = new Elemonstro("Relâmpago do Olimpo","Sobregarga",100,65,"Elétrico","Zilletrico","Elétrico",160,180,75,100);
            Elemonstro aguarto2 = new Elemonstro("Caud’água","Tsunami",80,90,"Água","Águarto","Água",180,120,100,95);
            Elemonstro sementauro2 = new Elemonstro("Folha Cortante","Semente Explosiva",55,80,"Grama","Sementauro","Grama",175,140,120,120);
            Elemonstro lobrasa2  = new Elemonstro("Mordida Flamejante","Cuspir Fogo",65,90,"Fogo","Lobrasa","Fogo",185,160,145,105);
            switch(escolha){
                case 1 -> jogador[j-3] = draterra2;
                case 2 -> jogador[j-3] = ventaguia2;
                case 3 -> jogador[j-3] = zilletrico2;
                case 4 -> jogador[j-3] = aguarto2;
                case 5 -> jogador[j-3] = sementauro2;
                case 6 -> jogador[j-3] = lobrasa2;
            }
        }
    }
    
}