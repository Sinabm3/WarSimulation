public abstract class Fighter {
    protected int health;
    protected int power;
    protected boolean firstTeam;


    public abstract int getHealth();

    public abstract int getPower();

    public abstract boolean isArcher();

    public void damage(int i){
        this.health -= i;
    }

    public boolean isDead(){
        return this.health < 0;
    }
}


