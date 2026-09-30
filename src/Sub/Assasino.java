package Sub;

import Super.Monstros;
import Super.Personagem;

public class Assasino extends Personagem {

    private int stamina;
    private int staminaMaxima;
    private double chanceCritico;


    public Assasino(String nome) {
        super(nome, "Assasino", 120, 120, 20, 10);
        this.stamina = 100;
        this.staminaMaxima = 100;
        this.chanceCritico = 0.30;
    }

    @Override
    public void receberDano() {

    }

    public void atacar(Monstros alvo) {
        int custoStamina = 15;

        if (this.stamina >= custoStamina) {
            this.stamina -= custoStamina;
            double danoCalculado = getDano();

            // Lógica de Acerto Crítico (30% de hipótese de dar o dobro do dano)
            if (Math.random() < this.chanceCritico) {
                danoCalculado *= 2.0;
                IO.println("GOLPE CRÍTICO! " + getNome() + " atacou com as adagas nas sombras!");
            } else {
                IO.println(getNome() + " atacou rapidamente com as adagas!");
            }

            IO.println("Stamina restante: " + this.stamina + "/" + this.staminaMaxima);
            alvo.receberDano(danoCalculado);

        } else {
            // Ataque básico quando está sem stamina
            double danoFraco = 5.0;
            IO.println(getNome() + " está cansado e fez um ataque fraco com a adaga!");
            alvo.receberDano(danoFraco);
        }
    }

    @Override
    public void Atacar(Monstros alvo) {

    }

    //Método para recuperar stamina (pode ser usado ao passar de turno ou usar item)
    public void recuperarStamina(int quantidade) {
        this.stamina += quantidade;
        if (this.stamina > this.staminaMaxima) {
            this.stamina = this.staminaMaxima;
        }
        IO.println(getNome() + " recuperou " + quantidade + " de stamina!");
    }

    // Getters e Setters dos atributos exclusivos
    public int getStamina() { return stamina; }
    public int getStaminaMaxima() { return staminaMaxima; }
    public double getChanceCritico() { return chanceCritico; }

}
