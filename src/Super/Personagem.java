package Super;

public abstract class Personagem {

    private String nome;
    private double vida;
    private int vidaMaxima;
    private double dano;
    private double pontosDefesa;
    private double danoRecebido;

    public abstract void Atacar(Monstros alvo);

    public void receberDano(double danoRecebido) {
        double danoFinal = danoRecebido - this.pontosDefesa;

        if (danoFinal < 1) {
            danoFinal = 1;
        }

        this.vida -= danoFinal;

        if (this.vida < 0) {
            this.vida = 0;
        }

        System.out.println(this.nome + " recebeu " + danoFinal + " de dano! Vida restante: " + this.vida);
    }

    public void usarPocao() {

    }


    public Personagem(String nome, double vida, int vidaMaxima, double dano, double pontosDefesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.dano = dano;
        this.pontosDefesa = pontosDefesa;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
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

    public double getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosDefesa(double pontosDefesa) {
        this.pontosDefesa = pontosDefesa;
    }


    @Override
    public String toString() {
        return "Super.Personagem{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", vidaMaxima=" + vidaMaxima +
                ", dano=" + dano +
                ", pontosDefesa=" + pontosDefesa +
                '}';
    }

    public abstract void receberDano();
}
