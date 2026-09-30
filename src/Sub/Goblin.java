package Sub;

import Super.Monstros;
import Super.Personagem;

public class Goblin extends Monstros {
    private double chanceVeneno;
    private double danoVeneno;

    public Goblin() {
        super("Goblin", 100, 12.0, 100.0);
        this.chanceVeneno = 0.25;
        this.danoVeneno = 4.0;
    }

    public Goblin(String raca, int vidaMaxima, double dano, double vida, double chanceVeneno) {
        super("Goblin", 100,12, 100.0);
        this.chanceVeneno = chanceVeneno;
        this.danoVeneno = 4.0;
    }

    @Override
    public void atacar(Personagem alvo) {
        IO.println("O " + getRaca() + " avançou rapidamente e atacou " + alvo.getNome() + " com suas adagas!");
        alvo.receberDano(getDano());

        if (Math.random() < this.chanceVeneno) {
            IO.println("As adagas do Goblin estavam envenenadas! " + alvo.getNome() + " sofreu " + this.danoVeneno + " de dano extra por veneno.");
            alvo.receberDano(this.danoVeneno);
        }
    }

    public double getChanceVeneno() { return chanceVeneno; }
    public double getDanoVeneno() { return danoVeneno; }
}