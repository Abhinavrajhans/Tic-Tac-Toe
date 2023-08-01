import java.util.HashMap;
import java.util.Scanner;

public class Player {
    HashMap<String, Player> mp = new HashMap<>();
    String name;
    int noOfMatchesWon;
    int noOfMatchesLost;
    int rank;
    int id;
    private int count;

    Player() {

    }

    public Player(String name, int noOfMatchesWon, int noOfMatchesLost, int rank, int id) {
        count++;
        this.name = name;
        this.noOfMatchesWon = noOfMatchesWon;
        this.noOfMatchesLost = noOfMatchesLost;
        this.rank = rank;
        this.id = id;

    }

    public int getId(String name) {
        return mp.get(name).getCount();
    }

    public void setCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public void create() {
        try (Scanner sc = new Scanner(System.in)) {
            Player p = new Player();
            System.out.println("Enter your name");
            String name = sc.next();
            p.setCount();
            int countPlayer = p.getCount();
            System.out.println(countPlayer);
            mp.put(name, new Player(name, 0, 0, 0, countPlayer));

            System.out.println(getId("nihar"));

        } catch (Throwable e) {
            System.out.println("Error :" + e);
        }
    }
}

