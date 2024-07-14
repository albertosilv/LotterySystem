import java.util.*;

/**
 * Classe principal do sistema de loteria.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lottery lottery = new Lottery();

        // Mensagem de boas-vindas
        System.out.println("Bem-vindo ao Sistema de Loteria!");

        // Loop principal do menu
        while (true) {
            System.out.println("Digite 1 para comprar um bilhete, 2 para sortear números, 3 para ver vencedores, 4 para ver todos os bilhetes, 5 para ajuda, 6 para sair:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Comprar um bilhete
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();

                List<Integer> numbers = new ArrayList<>();
                System.out.println("Digite 5 números entre 1 e 100:");
                for (int i = 0; i < 5; i++) {
                    int number = scanner.nextInt();
                    number = validateNumber(scanner, number);
                    numbers.add(number);
                }
                scanner.nextLine(); // Consume newline

                Ticket ticket = new Ticket(name, numbers);
                lottery.addTicket(ticket);
                System.out.println("Bilhete comprado com sucesso!");

            } else if (choice == 2) {
                // Sortear números
                System.out.println("Digite a quantidade de números vencedores a serem sorteados:");
                int count = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                lottery.drawWinningNumbers(count);
                System.out.println("Números sorteados: " + lottery.getWinningNumbers());

            } else if (choice == 3) {
                // Ver vencedores
                List<Ticket> winners = lottery.getWinners();
                if (winners.isEmpty()) {
                    System.out.println("Nenhum vencedor desta vez.");
                } else {
                    System.out.println("Parabéns aos vencedores:");
                    for (Ticket winner : winners) {
                        System.out.println(winner.getOwnerName() + " com os números " + winner.getNumbers() +
                                " (coincidências: " + lottery.countMatches(winner.getNumbers()) + ")");
                    }
                }

            } else if (choice == 4) {
                // Ver todos os bilhetes
                List<Ticket> allTickets = lottery.getAllTickets();
                if (allTickets.isEmpty()) {
                    System.out.println("Nenhum bilhete comprado.");
                } else {
                    System.out.println("Todos os bilhetes comprados:");
                    for (Ticket ticket : allTickets) {
                        System.out.println(ticket.getOwnerName() + " com os números " + ticket.getNumbers());
                    }
                }

            } else if (choice == 5) {
                // Exibir ajuda
                displayHelp();

            } else if (choice == 6) {
                // Sair do sistema
                System.out.println("Saindo do sistema. Até logo!");
                break;

            } else {
                // Opção inválida
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    /**
     * Valida a entrada de um número.
     * @param scanner Scanner para ler a entrada do usuário
     * @param number Número a ser validado
     * @return Número validado
     */
    private static int validateNumber(Scanner scanner, int number) {
        while (number < 1 || number > 100) {
            System.out.println("Número inválido. Digite um número entre 1 e 100:");
            number = scanner.nextInt();
        }
        return number;
    }

    /**
     * Exibe informações de ajuda sobre o sistema.
     */
    private static void displayHelp() {
        System.out.println("Sistema de Loteria - Ajuda:");
        System.out.println("1 - Comprar um bilhete: Você pode comprar um bilhete escolhendo 5 números entre 1 e 100.");
        System.out.println("2 - Sortear números: Sorteia uma quantidade específica de números vencedores.");
        System.out.println("3 - Ver vencedores: Exibe todos os bilhetes que possuem pelo menos um número coincidente com os números sorteados.");
        System.out.println("4 - Ver todos os bilhetes: Exibe todos os bilhetes comprados.");
        System.out.println("5 - Ajuda: Exibe esta mensagem de ajuda.");
        System.out.println("6 - Sair: Sai do sistema.");
    }
}