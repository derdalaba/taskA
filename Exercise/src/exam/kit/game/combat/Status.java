package exam.kit.game.combat;

import exam.kit.game.BaseState;

/**
 * Represents the status of a monster in combat.
 * This holds the current levels for all stats and hp of the monster.
 * This also holds the current status condition of the monster.
 * The levels are normalized to be within the range of -5 to 5.
 * The levels are used to calculate the effective stats of the monster.
 * @author uepiy
 */

public class Status {
    private static final int MAX_LEVEL = 5;
    private static final int MIN_LEVEL = -5;
    private static final int ATK_DEF_SPD_FACTOR = 2;
    private static final int PRC_AGL_FACTOR = 3;
    private final BaseState baseState;
    private int hp;
    private int atkLevel = 0;
    private int defLevel = 0;
    private int spdLevel = 0;
    private int prcLevel = 0;
    private int aglLevel = 0;
    private StatusCondition statusCondition = StatusCondition.NORMAL;
    /**
     * Creates a new status with the given base state.
     * @param baseState the base state of the monster
     */
    public Status(BaseState baseState) {
        this.baseState = baseState;
        this.hp = baseState.maxHp();
    }
    private double statFactor(int level, int factor) {
        if (level > 0) {
            return (double) (factor * level) / factor;
        } else {
            return (double) factor / (factor * level);
        }
    }
    /**
     * Gets the current hp of the monster.
     * @return the current hp of the monster
     */
    public int getHp() {
        return hp;
    }
    /**
     * Gets the current attack value of the monster.
     * @return the current attack value of the monster
     */
    public double getAtk() {
        double factor = statFactor(atkLevel, ATK_DEF_SPD_FACTOR);
        if (statusCondition == StatusCondition.BURN) {
            return factor * 0.75;
        }
        return factor;
    }
    /**
     * Gets the current defence value of the monster.
     * @return the current defence value of the monster
     */
    public double getDef() {
        if (statusCondition == StatusCondition.WET) {
            return statFactor(defLevel, ATK_DEF_SPD_FACTOR) * 0.75;
        }
        return statFactor(defLevel, ATK_DEF_SPD_FACTOR);
    }
    /**
     * Gets the current speed value of the monster.
     * @return the current speed value of the monster
     */
    public double getSpd() {
        if (statusCondition == StatusCondition.QUICKSAND) {
            return statFactor(spdLevel, ATK_DEF_SPD_FACTOR) * 0.75;
        }
        return statFactor(spdLevel, ATK_DEF_SPD_FACTOR);
    }
    /**
     * Gets the current perception value of the monster.
     * @return the current perception value of the monster
     */
    public double getPrc() {
        return statFactor(prcLevel, PRC_AGL_FACTOR);
    }
    /**
     * Gets the current agility value of the monster.
     * @return the current agility value of the monster
     */
    public double getAgl() {
        return statFactor(aglLevel, PRC_AGL_FACTOR);
    }
    /**
     * Decreases the hp of the monster by the given amount.
     * @param damage the amount of damage to be dealt
     */
    public void decreaseHp(int damage) {
        this.hp = this.hp - damage;
    }
    private int normalizeLevel(int level) {
        if (level > 0) {
            return Math.min(level, MAX_LEVEL);
        } else {
            return Math.max(level, MIN_LEVEL);
        }
    }
    /**
     * Modifies the attack level of the monster by the given amount.
     * Can add or subtract one level.
     * @param levelChange the direction to change the attack level in
     */
    public void setAtkLevel(int levelChange) {
        this.atkLevel = this.atkLevel + levelChange;
        this.atkLevel = normalizeLevel(atkLevel);
    }
    /**
     * Modifies the defence level of the monster by the given amount.
     * Can add or subtract one level.
     * @param levelChange the direction to change the defence level in
     */
    public void setDefLevel(int levelChange) {
        this.defLevel = this.defLevel + levelChange;
        this.defLevel = normalizeLevel(defLevel);
    }
    /**
     * Modifies the speed level of the monster by the given amount.
     * Can add or subtract one level.
     * @param levelChange the direction to change the speed level in
     */
    public void setSpdLevel(int levelChange) {
        this.spdLevel = this.spdLevel + levelChange;
        this.spdLevel = normalizeLevel(spdLevel);
    }
}
