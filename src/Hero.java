public class Hero extends Fighter {

    public Hero(int health, int power, boolean firstTeam) {
        this.health = health;
        this.power = power;
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
        return false;
    }
}
