import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SetMap {
    public static Fighter[][] world = new Fighter[9][9];
    private static int turn = 0;
    public static void main(String[] args) throws InterruptedException {
        drawWorld();

        //team one
        HashMap<Integer,Fighter> teamOne = new HashMap<Integer, Fighter>();


        teamOne.put(0,new Archer(0,0,10,true));
        teamOne.put(1,new Archer(0,0,10,true));
        teamOne.put(2,new Archer(0,0,10,true));
        teamOne.put(3,new Archer(0,0,10,true));
        teamOne.put(4,new Hero(100,10,true));
        teamOne.put(5,new Hero(100,10,true));
        teamOne.put(6,new Hero(100,10,true));
        teamOne.put(7,new Hero(100,10,true));

        System.out.println(teamOne);

        //team 2
        HashMap<Integer,Fighter> teamTwo = new HashMap<Integer, Fighter>();
        teamTwo.put(0,new Hero(50,10,false));
        teamTwo.put(1,new Hero(50,10,false));
        teamTwo.put(2,new Hero(50,10,false));
        teamTwo.put(3,new Hero(50,10,false));
        teamTwo.put(4,new Archer(0,0,20,false));
        teamTwo.put(5,new Archer(0,0,20,false));
        teamTwo.put(6,new Archer(0,0,20,false));
        teamTwo.put(7,new Archer(0,0,20,false));

        System.out.println(teamTwo);

        readyTeams(teamOne,teamTwo);
    }
    private static void readyTeams(HashMap<Integer, Fighter> team1, HashMap<Integer, Fighter> team2) throws InterruptedException {
        int count = 0;
        for (int i = 0; i < team1.size(); i++) {

            if(team1.get(i).isArcher()){
                count++;
                world[0][i] = team1.get(i);
            } else {
                world[1][i-count] = team1.get(i);
            }
        }

        count = 0;
        for (int i = 0; i < team2.size(); i++) {
            if(!team2.get(i).isArcher()){
                count++;
                world[7][i] = team2.get(i);
            } else {
                world[8][i-count] = team2.get(i);
            }
        }
        drawWorld();
        War.war();
    }
    public static void drawWorld(){
        System.out.println("turn:"+turn+"  ---------------------------");
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                if(world[i][j] == null){
                    System.out.print("   |");
                } else if(world[i][j].isArcher()){
                    System.out.print(" A |");
                } else {
                    System.out.print(" H |");
                }
            }
            System.out.println();
        }
        turn++;
    }
}
