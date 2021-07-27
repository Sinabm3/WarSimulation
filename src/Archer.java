public class Archer extends Fighter {

    private int rangePower;

    public Archer(int health, int power,int rangePower) {
        this.health = health;
        this.power = power;
        this.rangePower = rangePower;
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

}
