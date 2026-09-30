package Sub;

import Super.Monstros;
import Super.Personagem;

public class Boss extends Monstros {

    private double multiplicadorFuria;
    private boolean emFuria;

    public Boss() {
        // Parametros para o super: (raca, vidaMaxima, dano, vida)
        super("Monarca: o Rei das Sombras", 250, 30.0, 250.0);
        this.multiplicadorFuria = 1.5;
        this.emFuria = false; // está em "false" para ele não começar em fúria
    }

    //construtor para mini boss na fase 5
    public Boss(String raca, int vidaMaxima, double dano, double vida, double multiplicadorFuria) {
        super(raca, vidaMaxima, dano, vida);
        this.multiplicadorFuria = multiplicadorFuria;
        this.emFuria = false;
    }

    // mecânica de furia
    @Override
    public void atacar(Personagem alvo) {
        // Se a vida cair para menos de 40% e ele ainda não entrou em fúria, ativa a fase 2
        if (getVida() <= (getVidaMaxima() * 0.4) && !this.emFuria) {
            this.emFuria = true;
            IO.println("\n⚠️ " + getRaca() + " FICOU ENFURECIDO! PREPARE-SE PARA VERDADEIRA BATALHA!\n");
        }

        double danoCalculado = getDano();

        if (this.emFuria) {
            // Ataque quando estiver em furia
            danoCalculado *= this.multiplicadorFuria;
            IO.println("O" + getRaca() + " realizou um GOLPE DEVASTADOR DE FÚRIA em " + alvo.getNome() + "!");
        } else {
            // Ataque normal do boss
            IO.println("O " + getRaca() + " atacou " + alvo.getNome() + " com seu machado colossal!");
        }

        // Dano no jogador
        alvo.receberDano(danoCalculado);
    }

    public double getMultiplicadorFuria() {
        return multiplicadorFuria;
    }

    public boolean isEmFuria() {
        return emFuria;
    }
}