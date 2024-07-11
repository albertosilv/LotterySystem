import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lottery lottery = new Lottery();


        System.out.println("Bem-vindo ao Sistema de Loteria!");

        while (true) {
            System.out.println("Digite 1 para comprar um bilhete, 2 para sortear números, 3 para ver vencedores, 4 para sair:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();

                List<Integer> numbers = new ArrayList<>();
                System.out.println("Digite 5 números entre 1 e 100:");
                for (int i = 0; i < 5; i++) {
                    numbers.add(scanner.nextInt());
                }
                scanner.nextLine(); // Consume newline

                Ticket ticket = new Ticket(name, numbers);
                lottery.addTicket(ticket);
                System.out.println("Bilhete comprado com sucesso!");
            } else if (choice == 2) {
                System.out.println("Digite a quantidade de números vencedores a serem sorteados:");
                int count = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                lottery.drawWinningNumbers(count);
                System.out.println("Números sorteados: "  + lottery.getWinningNumbers());
            } else if (choice == 3) {
                List<Ticket> winners = lottery.getWinners();
                if (winners.isEmpty()) {
                    System.out.println("Nenhum vencedor desta vez.");
                } else {
                    System.out.println("Parabéns aos vencedores:");
                    for (Ticket winner : winners) {

                        System.out.println(winner.getOwnerName() +  " com os números "  + winner.getNumbers());
                    }
                }
            } else if (choice == 4) {
                System.out.println("Saindo do sistema. Até logo!");
                break;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}