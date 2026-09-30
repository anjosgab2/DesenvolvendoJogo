package Super;

public abstract class Monstros {

    private String raca;
    private int vidaMaxima;
    private double dano;
    private double vida;

    public Monstros(String raca, int vidaMaxima, double dano, double vida) {
        this.raca = raca;
        this.vidaMaxima = vidaMaxima;
        this.dano = dano;
        this.vida = vida;
    }

    // Método abstrato: obriga MonstroComum e Boss a criarem seu próprio ataque
    // Recebe obrigatoriamente um Personagem como alvo
    public abstract void atacar(Personagem alvo);

    // Lógica para aplicar dano e atualizar a vida do monstro
    public void receberDano(double danoRecebido) {
        this.vida -= danoRecebido;

        if (this.vida < 0) {
            this.vida = 0;
        }

        IO.println(this.raca + " recebeu " + danoRecebido + " de dano! Vida restante: " + this.vida + "/" + this.vidaMaxima);
    }

    // Adaptação para o método getNome funcionar usando a raça
    public String getNome() {
        return this.raca;
    }

    // Getters e Setters
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