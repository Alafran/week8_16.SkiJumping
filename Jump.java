import java.util.*;

public class Jump {
    //the class is designed this way so there is only one call to the jump
    //when the new jump object is created it calls the random methods once
    //as to not get new numbers everytime
    private Random randomNum;
    private int jumpDistance;
    private int[] judgeScores;
    private int totalScore;
    private int[] fiveJudgeScores;
    
    public Jump() {
        this.randomNum = new Random();
        this.jumpDistance = jumpDistance();
        this.judgeScores = judgeScores();
        this.totalScore = totalScore();
    }
    
    //returns a random number 60 - 120
    public int jumpDistance() {
        return this.randomNum.nextInt(61) + 60;
    }
    
    public int[] judgeScores() {
        //makes an array with 5 random scores 10-20
        int[] fiveScores = new int[5];
        for(int i = 0; i < 5; i++) {
            fiveScores[i] = this.randomNum.nextInt(11) + 10;
        }
        this.fiveJudgeScores = fiveScores;
        
        //sorts
        Arrays.sort(fiveScores);
        
        //makes a new array with the first and last scores dropped
        int[] threeScores = new int[3];
        for(int i = 0; i < 3; i++) {
            threeScores[i] = fiveScores[i+1];
        }
        
        return threeScores;
    }
    
    public int totalScore() {
        return this.judgeScores[0] + this.judgeScores[1] + this.judgeScores[2] + this.jumpDistance;
    }
    
    public int[] getFiveScores() {
        return this.fiveJudgeScores;
    }
    
    public int getJumpLength() {
        return this.jumpDistance;
    }
    
}
