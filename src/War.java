import com.sun.jdi.event.MonitorWaitedEvent;

import java.util.concurrent.TimeUnit;

public class War {
    private static boolean win = false;
    private static Fighter[][] world = SetMap.world;

    public static void war()  {
        while (!win){

            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    if(world[i][j] != null) {// something is there
                        if(world[i][j].isDead()){
                            world[i][j] = null;
                        } else {
                       move(i,j);
                        }
                    }
                }
            }
            win = checkWin();
            SetMap.drawWorld();
            //wait
        }
    }
    public static void move(int i, int j){

        if (world[i][j].firstTeam) {                // is first team
            if (world[i][j].isArcher()){              //is archer
                for (int k = i; k < world[0].length; k++) {
                    if(world[i][k] != null){   // exists
                        if( world[i][k]instanceof Hero && !world[i][k].firstTeam){
                            world[i][k].damage(((Archer)world[i][j]).getRangePower());
                        }
                    }
                }
            }
        }
    }
    private static boolean checkWin(){
        for (int i = 0; i < world.length; i++) {
            if(world[0][i] != null){
                if(!world[0][i].firstTeam){
                    return true;
                }
            }
        }
        for (int i = 0; i < world.length; i++) {
            if(world[8][i] != null){
                if(world[8][i].firstTeam){
                    return true;
                }
            }
        }
        return false;
    }
}
