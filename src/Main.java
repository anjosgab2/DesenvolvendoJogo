import Sub.*;
import Super.Personagem;
import Super.Monstros;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IO.println("=== BEM-VINDO AO RPG DE TEXTO ===");

        IO.println("Escolha a sua classe de herói:");
        IO.println("1 - Mago");
        IO.println("2 - Assassino");
        IO.println("3 - Paladino");
        IO.print("Opção: ");

        int escolhaClasse = scanner.nextInt();
        scanner.nextLine(); // Limpa a quebra de linha

        IO.print("Digite o nome do seu herói: ");
        String nomeHeroi = scanner.nextLine();

        // Instancia a subclasse escolhida passando o nome digitado
        Personagem jogador;
        if (escolhaClasse == 1) {
            jogador = new Mago(nomeHeroi);
        } else if (escolhaClasse == 2) {
            jogador = new Assasino(nomeHeroi);
        } else {
            jogador = new Paladino(nomeHeroi);
        }

        IO.println("\n🔥 A tua jornada pela Masmorra começou!\n");

        // LOOP DOS ANDARES: Executa sequencialmente do Andar 1 ao Andar 10
        for (int andar = 1; andar <= 10; andar++) {

            IO.println("\n========================================");
            IO.println("           ANDAR " + andar + "/10           ");
            IO.println("========================================");

            // 1. seleção de inimigos por andar
            Monstros inimigo;

            if (andar == 5) {
                // Mini Boss no meio da masmorra
                inimigo = new Boss("Gorgoroth: O Guardião", 180, 20.0, 180.0, 1.4);
                IO.println("⚠️ ATENÇÃO: Um Guardião bloqueia a tua passagem!");
            } else if (andar == 10) {
                // Boss Final do jogo
                inimigo = new Boss(); // Usa o construtor padrão (Monarca: O Rei das Sombras, 250 de vida)
                IO.println("🔥 CHEGASTE AO CONFRONTO FINAL! O Rei das Sombras te aguarda!");
            } else {
                // Nos andares normais sorteia entre Goblin e Esqueleto
                if (Math.random() < 0.5) {
                    inimigo = new Goblin();
                } else {
                    inimigo = new Esqueleto();
                }
                IO.println("Um " + inimigo.getRaca() + " apareceu no teu caminho!");
            }

            // 2. loop de combate do andar que eu estou
            while (jogador.getVida() > 0 && inimigo.getVida() > 0) {
                IO.println("\n----------------------------------------");
                IO.println("Sua Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
                IO.println("Vida do Inimigo: " + inimigo.getVida() + "/" + inimigo.getVidaMaxima());
                IO.println("----------------------------------------");
                IO.println("Escolha sua ação:");
                IO.println("1 - Atacar");
                IO.println("2 - Passar Turno");
                IO.print("Opção: ");

                int opcaoAcao = scanner.nextInt();
                IO.println("");

                // turno do jogador
                if (opcaoAcao == 1) {
                    jogador.atacar(inimigo);
                } else if (opcaoAcao == 2) {
                    IO.println(jogador.getNome() + " aguardou o movimento do inimigo.");
                } else {
                    IO.println("Opção inválida! Perdeu a vez.");
                }

                // Verifica se o monstro foi derrotado no andar
                if (inimigo.getVida() <= 0) {
                    IO.println("\n Derrotou o " + inimigo.getRaca() + "!");
                    IO.println("Avançando para o próximo andar...");
                    break; // Sai do loop do combate (while) e continua o loop do andar (for)
                }

                // turno do monstro
                IO.println("\n--- TURNO DOS MONSTROS ---");
                inimigo.atacar(jogador);

                // se deu game over
                if (jogador.getVida() <= 0) {
                    IO.println("\n FIM DE JOGO! Perdeu Seu progresso no Andar " + andar + "...");
                    break; // Sai do loop de combate
                }
            }

            // Se o jogador morreu no combate encerra o loop dos andares (for)
            if (jogador.getVida() <= 0) {
                break;
            }
        }

        // 3. Se o jogador ganhar:
        if (jogador.getVida() > 0) {
            IO.println("\n PARABÉNS! Superou os 10 andares e completaste a Masmorra!");
        }

        scanner.close();
    }
}