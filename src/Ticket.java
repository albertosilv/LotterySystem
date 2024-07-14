

/**
 * Classe que representa um bilhete de loteria.
 */
import java.util.List;

public class Ticket {
    private String ownerName;
    private List<Integer> numbers;

    /**
     * Construtor da classe Ticket.
     * @param ownerName Nome do dono do bilhete
     * @param numbers Números escolhidos no bilhete
     */
    public Ticket(String ownerName, List<Integer> numbers) {
        this.ownerName = ownerName;
        this.numbers = numbers;
    }

    /**
     * Obtém o nome do dono do bilhete.
     * @return Nome do dono do bilhete
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Obtém os números do bilhete.
     * @return Lista de números do bilhete
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}

/**
 * Classe que representa o sistema de loteria.
 */