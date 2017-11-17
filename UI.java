
import java.util.*;
import java.math.*;

public class UI {

    private List<Jumper> jumpers;
    private Scanner reader;
    private int rounds;

    public UI() {
        this.jumpers = new ArrayList<Jumper>();
        this.reader = new Scanner(System.in);
        this.rounds = 1;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");

        String jumperName = "";

        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while (true) {
            System.out.print("  Participant name: ");
            jumperName = this.reader.nextLine();

            if (jumperName.isEmpty()) {
                break;
            } else {
                this.jumpers.add(new Jumper(jumperName));
            }
        }

        System.out.println("\nThe tournament begins!\n");
        String command = "jump";
        
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = reader.nextLine();
            
            if(!command.equals("jump")) {
                break;
            }
            System.out.println("\nRound " + this.rounds);
            System.out.println("");
            
            setJumperPoints();
            Collections.sort(jumpers);
            System.out.println("Jumping order:");
            for(int i = 0; i < this.jumpers.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + this.jumpers.get(i));
            }
            
            System.out.println("Results of round " + this.rounds);
            addJumpsToAllJumpers();
            setJumperPoints();
            Collections.sort(jumpers);
            printResults();
            this.rounds++;
        }
        printTournamentResults();

    }
    
    public void addJumpsToAllJumpers() {
        for(int i = 0; i < this.jumpers.size(); i++) {
            this.jumpers.get(i).addJump(new Jump());
        }
    }
    
    public void printResults() {
       
        for(int i = 0; i < this.jumpers.size(); i++) {
            int[] judgeVotes = this.jumpers.get(i).getFiveScores(rounds - 1);
            System.out.println("  " + this.jumpers.get(i).getName());
            System.out.println("    length: " + this.jumpers.get(i).getJumpDistance(rounds - 1));
            System.out.print("    judge votes: [");
            for(int j = 0; j < 5; j++) {
                System.out.print(judgeVotes[j]);
                if(j != 4) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }
    }
    
    public void setJumperPoints() {
        for(int i = 0; i < this.jumpers.size(); i++) {
            this.jumpers.get(i).setTotalPoints();
        }
    }
    
    public void printTournamentResults() {
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int j = 1;
        for(int i = this.jumpers.size() - 1; i >= 0; i--) {
            System.out.println(j + "           " + this.jumpers.get(i));
            System.out.print("             jump lengths: ");
            for(int k = 0; k < this.rounds - 1; k++) {
                System.out.print(this.jumpers.get(i).getJumpDistance(k) + " m");
                if(k != this.rounds - 2) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
            j++;
        }
    }
}
