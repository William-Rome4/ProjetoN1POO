package uam.n1;

public class Elemonstro extends Golpe{
    private String nomeElemonstro;
    private String elementoElemonstro;
    private double vida;
    private int forca;
    private int defesa;
    private int velocidade;


    public Elemonstro(String nomeGolpe1, String nomeGolpe2, int poder1, int poder2, String elementoGolpe, String nomeElemonstro, String elementoElemonstro, double vida, int forca, int defesa, int velocidade) {
    super(nomeGolpe1,nomeGolpe2,poder1,poder2,elementoGolpe);
        this.nomeElemonstro = nomeElemonstro;
        this.elementoElemonstro = elementoElemonstro;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }

    public String getNomeElemonstro() {
        return nomeElemonstro;
    }

    public String getElementoElemonstro() {
        return elementoElemonstro;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }
}