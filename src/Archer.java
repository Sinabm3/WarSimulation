public class Archer extends Fighter {

    private int rangePower;

    public Archer(int health, int power,int rangePower, Boolean firstTeam) {
        this.health = health;
        this.power = power;
        this.rangePower = rangePower;
        this.firstTeam = firstTeam;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public boolean isArcher() {
        return true;
    }

    public int getRangePower() {
        return rangePower;
    }
}
