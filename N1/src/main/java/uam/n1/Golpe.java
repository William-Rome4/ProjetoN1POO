
package uam.n1;

public abstract class Golpe {
    private String nomeGolpe1, nomeGolpe2;
    private int poder1, poder2;
    private String elementoGolpe;


    public Golpe(String nomeGolpe1, String nomeGolpe2, int poder1, int poder2, String elementoGolpe) {
        this.nomeGolpe1 = nomeGolpe1;
        this.nomeGolpe2 = nomeGolpe2;
        this.poder1 = poder1;
        this.poder2 = poder2;
        this.elementoGolpe = elementoGolpe;
    }
}
