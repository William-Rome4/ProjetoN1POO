package uam.n1;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        
        int escolha = 0, i = 0;
        Elemonstro[] jogador1 = new Elemonstro[3];
        Elemonstro[] jogador2 = new Elemonstro[3];
        Scanner entrada = new Scanner(System.in);
        for(int j=0 ; j<6; j++){
            System.out.println("Jogador "+ (i+1) + "! Escolha 3 Elemonstros!");
            System.out.println("---------------------------------");
            System.out.println("| 1 - Draterra\n| 2 - Ventáguia\n| 3 - Zillétrico\n| 4 - Águarto\n|"
                    + " 5 - Sementauro\n| 6 - Lobrasa\n|__________________________________");
            escolha = Integer.parseInt(entrada.nextLine());
            if(i == 0)
                selecao(jogador1,escolha,i,j);
            else
                selecao(jogador2,escolha,i,j);
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
        int nocaute1=0, nocaute2=0;
        int[] escolhaAtaque;
        int elemonstroAtual1=0, elemonstroAtual2=0;
        int escolherAcao = 0; int[] troca = new int[2];
        escolhaAtaque = new int [2];
        escolhaAtaque[0]=0;
        escolhaAtaque[1]=0;
        while(nocaute1<3 && nocaute2<3){
            for(i=0;i<2;i++) {
                if(i==1 && troca[0]==1){
                    escolherAcao = 2;
                }else if(jogador1[elemonstroAtual1].getVida() > 0
                        && jogador2[elemonstroAtual2].getVida() > 0){
                    System.out.println("---------------------");
                    System.out.println("Jogador "+(i+1)+" escolha sua ação: ");
                    System.out.println("\t1 -> Atacar\n\t2 -> Trocar");
                    escolherAcao = entrada.nextInt();
                }else if(i==0 && jogador1[elemonstroAtual1].getVida()<=0){
                    escolherAcao = 2;
                }
                switch(escolherAcao){
                    case 1: do {
                                System.out.println("---------------------");
                                if(i==0) {
                                    System.out.println("Jogador "+ (i+1));
                                    System.out.println("Você está com o "+jogador1[elemonstroAtual1].getNomeElemonstro());
                                    System.out.println("Vida atual "+jogador1[elemonstroAtual1].getVida());
                                    System.out.println("Ataque 1 : "+jogador1[elemonstroAtual1].getNomeGolpe1());
                                    System.out.println("Ataque 2 : "+jogador1[elemonstroAtual1].getNomeGolpe2());
                                    System.out.println("Escolha o ataque (1 ou 2)");
                                    escolhaAtaque[0] = entrada.nextInt();
                                    troca[0] = 0;
                                }else {
                                    System.out.println("Jogador "+ (i+1));
                                    System.out.println("Você está com o "+jogador2[elemonstroAtual2].getNomeElemonstro());
                                    System.out.println("Vida atual "+jogador2[elemonstroAtual2].getVida());
                                    System.out.println("Ataque 1 : "+jogador2[elemonstroAtual2].getNomeGolpe1());
                                    System.out.println("Ataque 2 : "+jogador2[elemonstroAtual2].getNomeGolpe2());
                                    System.out.println("Escolha o ataque (1 ou 2)");
                                    escolhaAtaque[1] = entrada.nextInt();
                                    troca[1] = 0;
                                }
                            }while((escolhaAtaque[0] < 1 || escolhaAtaque[0] >2) && (escolhaAtaque[1] < 1 || escolhaAtaque[1] >2));
                            break;
                    case 2: System.out.println("Para qual Elemonstro deseja trocar?");
                            if(i==0){
                                do{
                                    System.out.println("1 -> "+jogador1[0].getNomeElemonstro()+
                                            "\n2 -> "+jogador1[1].getNomeElemonstro()+
                                            "\n3 -> "+jogador1[2].getNomeElemonstro());
                                    elemonstroAtual1 = (entrada.nextInt()-1);
                                    if(jogador1[elemonstroAtual1].getVida()<=0){
                                        System.out.println("Esse elemonstro está nocauteado!");
                                        elemonstroAtual1 = 5;
                                    }
                                    troca[0] = 1;
                                }while(elemonstroAtual1==5);
                            }else{
                                do{
                                    System.out.println("1 -> "+jogador2[0].getNomeElemonstro()+
                                            "\n2 -> "+jogador2[1].getNomeElemonstro()+
                                            "\n3 -> "+jogador2[2].getNomeElemonstro());
                                    elemonstroAtual2 = (entrada.nextInt()-1);
                                    if(jogador2[elemonstroAtual2].getVida()<=0){
                                        System.out.println("Esse elemonstro está nocauteado!");
                                        elemonstroAtual2 = 5;
                                    }
                                    troca[1] = 1;
                                }while(elemonstroAtual2==5);
                            }
                            break;
                }
            }
            if(troca[0]==0 && troca[1]==0){
                if(jogador1[elemonstroAtual1].getVelocidade() > jogador2[elemonstroAtual2].getVelocidade()){
                    if(escolhaAtaque[0]==1){
                        jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                                - ((((22 * jogador1[elemonstroAtual1].getPoder1()
                                * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                                /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                    }else if(escolhaAtaque[0]==2){
                        jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                                - ((((22 * jogador1[elemonstroAtual1].getPoder2()
                                * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                                /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                    }
                    if(jogador2[elemonstroAtual2].getVida() > 0){
                        if(escolhaAtaque[1]==1){
                            jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                                ((((22 * jogador2[elemonstroAtual2].getPoder1()
                                * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                                /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                        }else if(escolhaAtaque[1]==2){
                            jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                                ((((22 * jogador2[elemonstroAtual2].getPoder2()
                                * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                                /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                        }
                    }
                }else if(jogador1[elemonstroAtual1].getVelocidade() < jogador2[elemonstroAtual2].getVelocidade()){
                    if(escolhaAtaque[1]==1){
                        jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                                ((((22 * jogador2[elemonstroAtual2].getPoder1()
                                * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                                /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                    }else if(escolhaAtaque[1]==2){
                        jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                                ((((22 * jogador2[elemonstroAtual2].getPoder2()
                                * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                                /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                    }
                    if(jogador1[elemonstroAtual1].getVida() > 0){
                        if(escolhaAtaque[0]==1){
                            jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                                - ((((22 * jogador1[elemonstroAtual1].getPoder1()
                                * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                                /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                        }else if(escolhaAtaque[0]==2){
                            jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                                - ((((22 * jogador1[elemonstroAtual1].getPoder2()
                                * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                                /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                        }
                    }
                }
            }else if(troca[0]==1 && troca[1]==0){
                if(escolhaAtaque[1]==1){
                    jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                    ((((22 * jogador2[elemonstroAtual2].getPoder1()
                    * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                    /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                }else if(escolhaAtaque[1]==2){
                    jogador1[elemonstroAtual1].setVida(jogador1[elemonstroAtual1].getVida() - 
                    ((((22 * jogador2[elemonstroAtual2].getPoder2()
                    * jogador2[elemonstroAtual2].getForca() / jogador1[elemonstroAtual1].getDefesa())
                    /50)+2)*reacaoElemental(jogador2[elemonstroAtual2],jogador1[elemonstroAtual1])));
                }
            }else if(troca[0]==0 && troca[1]==1){
                if(escolhaAtaque[0]==1){
                    jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                    - ((((22 * jogador1[elemonstroAtual1].getPoder1()
                    * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                    /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                }else if(escolhaAtaque[0]==2){
                    jogador2[elemonstroAtual2].setVida(jogador2[elemonstroAtual2].getVida() 
                    - ((((22 * jogador1[elemonstroAtual1].getPoder2()
                    * jogador1[elemonstroAtual1].getForca() / jogador2[elemonstroAtual2].getDefesa())
                    /50)+2)*reacaoElemental(jogador1[elemonstroAtual1],jogador2[elemonstroAtual2])));
                }
            }
            if(jogador1[elemonstroAtual1].getVida() <= 0){
                System.out.println("\n---------------------");
                System.out.println(jogador1[elemonstroAtual1].getNomeElemonstro()+" foi nocauteado!");
                System.out.println("---------------------");
                nocaute1++;
            }
            if(jogador2[elemonstroAtual2].getVida() <= 0){
                System.out.println("\n---------------------");
                System.out.println(jogador2[elemonstroAtual2].getNomeElemonstro()+" foi nocauteado!");
                System.out.println("---------------------");
                nocaute2++;
            }
        }
        System.out.println("---------------------------------------");
        if(nocaute1 == 3){
            System.out.println("Parabéns! O Jogador 1 ganhou a batalha!!");
        }else if(nocaute2 == 3){
            System.out.println("Parabéns! O Jogador 2 ganhou a batalha!!");
        }
    }
    
    public static void selecao(Elemonstro[] jogador, int escolha, int i, int j){
        if(i == 0){
            Elemonstro draterra1 = new Elemonstro("Terremoto","Garras Granito",70,55,"Terra","Draterra","Terra",140,150,160,80);
            Elemonstro ventaguia1 = new Elemonstro("Vendaval","Bico Mortal",40,60,"Vento","Ventaguia","Vento",200,170,80,110);
            Elemonstro zilletrico1 = new Elemonstro("Relâmpago do Olimpo","Sobregarga",100,65,"Elétrico","Zilletrico","Elétrico",160,180,75,100);
            Elemonstro aguarto1 = new Elemonstro("Caud’água","Tsunami",80,90,"Água","Águarto","Água",180,120,100,95);
            Elemonstro sementauro1 = new Elemonstro("Folha Cortante","Semente Explosiva",55,80,"Grama","Sementauro","Grama",175,140,120,120);
            Elemonstro lobrasa1  = new Elemonstro("Mordida Flamejante","Cuspir Fogo",65,90,"Fogo","Lobrasa","Fogo",185,160,145,105);
            switch(escolha){
                case 1 : jogador[j] = draterra1; break;
                case 2 : jogador[j] = ventaguia1; break;
                case 3 : jogador[j] = zilletrico1; break;
                case 4 : jogador[j] = aguarto1; break;
                case 5 : jogador[j] = sementauro1; break;
                case 6 : jogador[j] = lobrasa1; break;
            }
        }else{
            Elemonstro draterra2 = new Elemonstro("Terremoto","Garras Granito",70,55,"Terra","Draterra","Terra",140,150,160,80);
            Elemonstro ventaguia2 = new Elemonstro("Vendaval","Bico Mortal",40,60,"Vento","Ventaguia","Vento",200,170,80,110);
            Elemonstro zilletrico2 = new Elemonstro("Relâmpago do Olimpo","Sobregarga",100,65,"Elétrico","Zilletrico","Elétrico",160,180,75,100);
            Elemonstro aguarto2 = new Elemonstro("Caud’água","Tsunami",80,90,"Água","Águarto","Água",180,120,100,95);
            Elemonstro sementauro2 = new Elemonstro("Folha Cortante","Semente Explosiva",55,80,"Grama","Sementauro","Grama",175,140,120,120);
            Elemonstro lobrasa2  = new Elemonstro("Mordida Flamejante","Cuspir Fogo",65,90,"Fogo","Lobrasa","Fogo",185,160,145,105);
            switch(escolha){
                case 1 : jogador[j-3] = draterra2; break;
                case 2 : jogador[j-3] = ventaguia2; break;
                case 3 : jogador[j-3] = zilletrico2; break;
                case 4 : jogador[j-3] = aguarto2; break;
                case 5 : jogador[j-3] = sementauro2; break;
                case 6 : jogador[j-3] = lobrasa2; break;
            }
        }
        
    }
    
    public static double reacaoElemental(Elemonstro atacante, Elemonstro defensor){
        int i, j = 0; double modificador = 1;
        String[] elementos = new String[6];
        elementos[0] = "Fogo"; elementos[1] = "Grama"; 
        elementos[2] = "Vento";elementos[3] = "Terra"; 
        elementos[4] = "Elétrico"; elementos[5] = "Água";
        for(i=0;i<6;i++){
            if(atacante.getElementoGolpe().equals(elementos[i])){
                break;
            }
        }
        if(i-1 == -1){
            j = 6;
        }
        System.out.println("-----------------------");
        if(elementos[(i-1)+j].equals(defensor.getElementoElemonstro())){
            modificador = 0.5;
            System.out.println("O ataque de "+atacante.getNomeElemonstro()+" não pareceu surtir muito efeito.");
        }
        j = 0;
        if(i+1 == 6){
            j = 6;
        }
        if(elementos[(i+1)-j].equals(defensor.getElementoElemonstro())){
            modificador = 2;
            System.out.println("O ataque de "+atacante.getNomeElemonstro()+" foi superefetivo!");
        }
        return modificador;
    }
}