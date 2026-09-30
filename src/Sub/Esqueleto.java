package Sub;

import Super.Monstros;
import Super.Personagem;

public class Esqueleto extends Monstros {
    private int quantidadeFlechas;
    private double chanceTiroPreciso;

//    Sobrecarga de construtores
    public Esqueleto() {
        super("Esqueleto Arqueiro", 100, 12.0, 100.0);
        this.quantidadeFlechas = 10;
        this.chanceTiroPreciso = 0.30;
    }

    public Esqueleto(String raca, int vidaMaxima, double dano, double vida, int quantidadeFlechas) {
        super(raca, vidaMaxima, dano, vida);
        this.quantidadeFlechas = quantidadeFlechas;
        this.chanceTiroPreciso = 0.30;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (this.quantidadeFlechas > 0) {
            this.quantidadeFlechas--;
            double danoFinal = getDano();

            // Aqui mostra como funciona o tiro preciso
            if (Math.random() < this.chanceTiroPreciso) {
                danoFinal += 8.0;
                IO.println("TIRO PERFEITO! O " + getRaca() + " acertou uma flechada num ponto vital de " + alvo.getNome() + "!");
            } else {
                IO.println("O " + getRaca() + " disparou uma flecha em " + alvo.getNome() + "!");
            }

            IO.println("Flechas restantes do Esqueleto: " + this.quantidadeFlechas);
            alvo.receberDano(danoFinal);
        } else {
            // Ataque básico de corpo a corpo caso acabem as flechas
            IO.println("O " + getRaca() + " ficou sem flechas e atacou " + alvo.getNome() + " usando seus ossos!");
            alvo.receberDano(3.0);
        }
    }

    public int getQuantidadeFlechas() { return quantidadeFlechas; }
    public double getChanceTiroPreciso() { return chanceTiroPreciso; }
}