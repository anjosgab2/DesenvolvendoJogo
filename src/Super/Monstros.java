package Super;

public class Monstros {

    private String raca;
    private int vidaMaxima;
    private double dano;
    private double vida;

    public void Atacar(){

    }

    public Monstros(String raca, int vidaMaxima, double dano, double vida) {
        this.raca = raca;
        this.vidaMaxima = vidaMaxima;
        this.dano = dano;
        this.vida = vida;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public double getDano() {
        return dano;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Monstros{" +
                "raca='" + raca + '\'' +
                ", vidaMaxima=" + vidaMaxima +
                ", dano=" + dano +
                ", vida=" + vida +
                '}';
    }
}
