/**
 * Classe que representa o sistema de loteria.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();

    /**
     * Adiciona um bilhete à loteria.
     * @param ticket Bilhete a ser adicionado
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Sorteia os números vencedores.
     * @param count Quantidade de números a serem sorteados
     */
    public void drawWinningNumbers(int count) {
        Random random = new Random();
        winningNumbers.clear();
        while (winningNumbers.size() < count) {
            int number = random.nextInt(100) + 1;
            if (!winningNumbers.contains(number)) {
                winningNumbers.add(number);
            }
        }
    }

    /**
     * Conta quantos números de um bilhete coincidem com os números sorteados.
     * @param ticketNumbers Números do bilhete
     * @return Quantidade de números coincidentes
     */
    public int countMatches(List<Integer> ticketNumbers) {
        int matches = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    /**
     * Obtém os bilhetes vencedores.
     * @return Lista de bilhetes vencedores
     */
    public List<Ticket> getWinners() {
        List<Ticket> winners = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (countMatches(ticket.getNumbers()) > 0) {
                winners.add(ticket);
            }
        }
        return winners;
    }

    /**
     * Obtém todos os bilhetes comprados.
     * @return Lista de todos os bilhetes
     */
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    /**
     * Obtém os números vencedores sorteados.
     * @return Lista de números vencedores
     */
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
