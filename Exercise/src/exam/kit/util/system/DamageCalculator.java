package exam.kit.util.system;


import exam.kit.game.Element;
import exam.kit.game.NumberGenerator;
import exam.kit.game.action.effect.DamageEffect;
import exam.kit.game.action.effect.StrengthType;
import exam.kit.game.combat.Monster;

/**
 * Represents a calculator that calculates damage.
 * This is used in combat.
 * @author uepiy
 */

public final class DamageCalculator {
    private static final double LESS_EFFECTIVE = 0.75;
    private DamageCalculator() {
    }
    private static int calculateBaseDamage(NumberGenerator generator,
                                           Monster attacker, Monster defender, DamageEffect effect, Element element) {
        double elementMult = getElementMultiplier(defender, element);
        printEffectiveness(elementMult);
        double statusMult = getStatusMultiplier(attacker, defender);
        double criticalMult = getCriticalMultiplier(generator, attacker, defender);
        double sameTypeMult = getSameTypeMultiplier(attacker, element);
        double randomMult = generator.getDamageFactor("random damage factor");
        return (int) Math.ceil(effect.getStrength() * elementMult * statusMult * criticalMult * sameTypeMult * randomMult);
    }
    private static double getSameTypeMultiplier(Monster attacker, Element element) {
        if (attacker.getMonsterTemplate().type().equals(element)) {
            return 1.5;
        }
        return 1.0;
    }
    private static double getCriticalMultiplier(NumberGenerator generator, Monster attacker, Monster defender) {
        double limit = Math.pow(10, (-defender.getStatus().getSpd()) / attacker.getStatus().getSpd()) * 100;
        if (generator.getHitCritStatCond(limit, "critical hit")) {
            System.out.println("Critical hit!");
            return 2;
        }
        return 1;
    }
    private static void printEffectiveness(double elementMult) {
        if (elementMult == 2.0) {
            System.out.println("It is very effective!");
        } else if (elementMult == 0.5) {
            System.out.println("It is not very effective...");
        }
    }

    private static double getElementMultiplier(Monster defender, Element element) {
        return switch (element.getEffectiveness(defender.getMonsterTemplate().type())) {
            case WEAK -> 0.5;
            case NORMAL -> 1.0;
            case STRONG -> 2.0;
        };
    }
    private static double getStatusMultiplier(Monster attacker, Monster defender) {
        return attacker.getStatus().getAtk() / defender.getStatus().getDef();
    }
    /**
     * Returns the damage the action will deal.
     * @param generator random number generator used for critical hit.
     * @param attacker the monster that is attacking
     * @param defender the monster that is defending/being attacked
     * @param effect the damage effect
     * @param element the element of the damage effect
     * @return the damage the action will deal
     */
    public static int calculateDamage(NumberGenerator generator, Monster attacker, Monster defender, DamageEffect effect, Element element) {
        if (effect.getStrengthType() == StrengthType.BASE) { // calculates the base damage with modifiers
            return calculateBaseDamage(generator, attacker, defender, effect, element);
        } else if (effect.getStrengthType() == StrengthType.RELATIVE) { // calculates the relative damage
            return (int) Math.ceil(effect.getStrength() * LESS_EFFECTIVE);
        }
        return effect.getStrength(); // gets the absolut damage
    }
}
