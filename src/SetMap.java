import java.util.HashMap;

public class SetMap {
    public static Fighter[][] world = new Fighter[9][9];

    public static void main(String[] args) {
        drawWorld();
        HashMap<Integer,Fighter> teamOne = new HashMap<Integer, Fighter>();


        teamOne.put(0,new Archer(0,0,10));
        teamOne.put(1,new Archer(0,0,10));
        teamOne.put(2,new Archer(0,0,10));
        teamOne.put(3,new Archer(0,0,10));
        teamOne.put(5,new Hero(10,10));
        teamOne.put(6,new Hero(10,10));
        teamOne.put(7,new Hero(10,10));
        teamOne.put(8,new Hero(10,10));

        System.out.println(teamOne);

        HashMap<Integer,Fighter> teamTwo = new HashMap<Integer, Fighter>();
        teamTwo.put(0,new Archer(0,0,20));
        teamTwo.put(1,new Archer(0,0,20));
        teamTwo.put(2,new Archer(0,0,20));
        teamTwo.put(3,new Archer(0,0,20));
        teamTwo.put(5,new Hero(5,10));
        teamTwo.put(6,new Hero(5,10));
        teamOne.put(7,new Hero(5,10));
        teamOne.put(8,new Hero(5,10));

        System.out.println(teamTwo);


    }
    private static void readyTeams(HashMap<Integer, Fighter> team1, HashMap<Integer, Fighter> team2){
        for (int i = 0; i < team1.size(); i++) {
            if(team1.get(i).isArcher()){
                world[0][i] = team1.get(i);
            } else {
                world[1][i] = team1.get(i);
            }
        }
        for (int i = 0; i < team2.size(); i++) {
            if(team2.get(i).isArcher()){
                world[0][i] = team2.get(i);
            } else {
                world[1][i] = team2.get(i);
            }
        }
    }
    public static void drawWorld(){
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
    }
}
