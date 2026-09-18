package Sub;

import Super.Monstros;

public class Mago extends Personagem {
    private int mana;
    private int manaMaxima;

    public Mago(String nome) {
        // Chamada do construtor pai: (nome, vida, vidaMaxima, dano, pontosDefesa)
        super(nome, 80.0, 80, 18.0, 5.0);
        this.mana = 50;
        this.manaMaxima = 50;
    }

    // SOBRESCRIÇÃO (POLIMORFISMO): Ataque único do Mago contra um objeto da classe Monstros
    @Override
    public void atacar(Monstros alvo) {
        int custoMana = 10;

        if (this.mana >= custoMana) {
            this.mana -= custoMana;
            double danoMagico = getDano() + 10.0;

            System.out.println(getNome() + " lançou uma Bola de Fogo no " + alvo.getNome() + "!");
            System.out.println("Mana restante: " + this.mana + "/" + this.manaMaxima);

            // Aplica o dano no alvo
            alvo.receberDano(danoMagico);
        } else {
            double danoFisico = 3.0;
            System.out.println(getNome() + " está sem mana e atacou fraco com o cajado!");
            alvo.receberDano(danoFisico);
        }
    }

    public int getMana() { return mana; }
    public int getManaMaxima() { return manaMaxima; }
}