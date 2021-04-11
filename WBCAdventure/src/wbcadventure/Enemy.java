package wbcadventure;

public abstract class Enemy extends Character {
    private int randHP;
    private int randPower;
    public Enemy(WBC wbc){
        randHP=randomHP(wbc);
        randPower=randomPower(wbc);
        this.getHPcontrol().increaseMaxHP(randHP);
        this.plusPowerDefault(randPower);
    }
    public abstract int randomHP(WBC wbc);
    public abstract int randomPower(WBC wbc);
}
