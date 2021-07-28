import com.sun.jdi.event.MonitorWaitedEvent;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class War {
    private static boolean win = false;
    private static Fighter[][] world = SetMap.world;

    public static void war() throws InterruptedException {
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
            sleep(2000);
        }
    }
    public static void move(int i, int j){

        if (world[i][j].firstTeam) {                // is first team
            if (world[i][j].isArcher()){              //is archer
                for (int k = i+1; k < world.length-i-1; k++) {
                    if(world[k][j] != null){   // exists
                        if( world[k][j]instanceof Hero && !world[k][j].firstTeam){
                            world[k][j].damage(((Archer)world[i][j]).getRangePower());
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
                    System.out.println("team two won!");
                    return true;
                }
            }
        }
        for (int i = 0; i < world.length; i++) {
            if(world[8][i] != null){
                if(world[8][i].firstTeam){
                    System.out.println("team one won!");
                    return true;
                }
            }
        }
        return false;
    }
}
