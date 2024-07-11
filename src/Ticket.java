import java.util.List;

public class Ticket {
    private String ownerName;
    private List<Integer> numbers;

    public Ticket(String ownerName, List<Integer> numbers) {
        this.ownerName = ownerName;
        this.numbers = numbers;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
