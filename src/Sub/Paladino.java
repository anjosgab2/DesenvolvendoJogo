package Sub;

import Super.Monstros;
import Super.Personagem;

public class Paladino extends Personagem {
    private int fe;
    private int feMaxima;
    private double bloqueio;

    public Paladino(String nome) {
        // Parametros para o super: (nome, vida, vidaMaxima, dano, pontosDefesa)
        // O Paladino nasce com mais VIDA e mais DEFESA que as outras classes
        super(nome, "Paladino", 150, 150, 22.5, 15);
        this.fe = 100;
        this.feMaxima = 100;
        this.bloqueio = 5.0; // Bônus fixo de defesa ao bloquear
    }

    // SOBRESCRIÇÃO (POLIMORFISMO): Ataque com Golpe Sagrado usando Fé
    @Override
    public void atacar(Monstros alvo) {
        int custoFe = 10;

        if (this.fe >= custoFe) {
            this.fe -= custoFe;
            double danoSagrado = getDano() + 8.0; // Dano físico + bônus de luz

            IO.println(getNome() + " usou Golpe Sagrado no " + alvo.getNome() + "!");
            IO.println("Fé restante: " + this.fe + "/" + this.feMaxima);

            alvo.receberDano(danoSagrado);
        } else {
            // Ataque básico com a espada quando está sem fé
            IO.println(getNome() + " atacou com sua espada!");
            alvo.receberDano(getDano());
        }
    }


    // Habilidade exclusiva do Paladino: Curar a si mesmo usando Fé
    public void curar() {
        int custoFe = 15;
        if (this.fe >= custoFe) {
            this.fe -= custoFe;
            double quantidadeCura = 20.0;

            // Incrementa a vida respeitando a vida máxima
            setVida(getVida() + quantidadeCura);
            if (getVida() > getVidaMaxima()) {
                setVida(getVidaMaxima());
            }

            IO.println(getNome() + " usou Luz Divina e recuperou " + quantidadeCura + " de vida!");
            IO.println("Vida atual: " + getVida() + "/" + getVidaMaxima());
        } else {
            IO.println(getNome() + " não tem Fé suficiente para se curar!");
        }
    }

    // Getters dos atributos exclusivos
    public int getFe() { return fe; }
    public int getFeMaxima() { return feMaxima; }
    public double getBloqueio() { return bloqueio; }

    @Override
    public void Atacar(Monstros alvo) {

    }

    @Override
    public void receberDano() {

    }

}
