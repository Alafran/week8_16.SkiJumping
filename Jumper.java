import java.util.*;

public class Jumper implements Comparable<Jumper>{
    
    private String name;
    private List<Jump> jumps;
    private int totalPoints;
    
    public Jumper(String name) {
        this.name = name;
        this.jumps = new ArrayList<Jump>();
        this.totalPoints = 0;
    }
    
    public void addJump(Jump jump) {
        this.jumps.add(jump);
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    
    public void setTotalPoints() {
        int points = 0;
        for(int i = 0; i < this.jumps.size(); i++) {
            points += this.jumps.get(i).totalScore();
        }
        this.totalPoints = points;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getJumpDistance(int jumpNumber) {
        return this.jumps.get(jumpNumber).getJumpLength();
    }
    
    public int[] getFiveScores(int jumpNumber) {
        return this.jumps.get(jumpNumber).getFiveScores();
    } 

    @Override
    public String toString() {
        return name + " (" + this.totalPoints + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        if(this.totalPoints == jumper.totalPoints) {
            return 0;
        }
        else if(this.totalPoints > jumper.totalPoints) {
            return 1;
        }
        else {
            return -1;
        }
    }
      
}
