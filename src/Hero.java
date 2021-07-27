public class Hero extends Fighter {

    public Hero(int health, int power) {
        this.health = health;
        this.power = power;
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
        return false;
    }
}
