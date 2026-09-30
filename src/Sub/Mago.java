package Sub;

import Super.Monstros;
import Super.Personagem;

public class Mago extends Personagem {
    private int mana;
    private int manaMaxima;

    public Mago(String nome) {
        super(nome, "Mago", 100.0, 100, 18.0, 5);
        this.mana = 100;
        this.manaMaxima = 100;
    }

    // SOBRESCRIÇÃO (POLIMORFISMO): Ataque único do Mago contra um objeto da classe Monstros
    @Override
    public void atacar(Monstros alvo) {
        int custoMana = 15;

        if (this.mana >= custoMana) {
            this.mana -= custoMana;
            double danoMagico = getDano() + 18.0;

            IO.println(getNome() + " lançou uma Bola de Fogo no " + alvo.getNome() + "!");
            IO.println("Mana restante: " + this.mana + "/" + this.manaMaxima);

            // Aplica o dano no alvo
            alvo.receberDano(danoMagico);
        } else {
            double danoFisico = 3.0;
            IO.println(getNome() + " está sem mana e atacou fraco com o cajado!");
            alvo.receberDano(danoFisico);
        }
    }

    public int getMana() { return mana; }
    public int getManaMaxima() { return manaMaxima; }

    @Override
    public void Atacar(Monstros alvo) {

    }

    @Override
    public void receberDano() {

    }
}