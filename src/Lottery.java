import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

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

    public List<Ticket> getWinners() {
        List<Ticket> winners = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getNumbers().equals(winningNumbers)) {
                winners.add(ticket);
            }
        }
        return winners;
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
