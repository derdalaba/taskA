package model.data.monster;

public class CombatMonster implements Comparable<CombatMonster> {
    private final Monster monster;
    private final int id;

    public CombatMonster(Monster monster, int id) {
        this.monster = new Monster(monster);
        this.id = id;
    }

    public Monster getMonster() {
        return monster;
    }
    public int getId() {
        return id;
    }
    /**
     * Check if the monsters are the same.
     * source: https://www.baeldung.com/java-equals-hashcode-contracts
     * @param other the other object to compare
     * @return true if the monsters are the same, false otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CombatMonster combatMonster = (CombatMonster) other;
        return this.monster.getName().equals(combatMonster.monster.getName());
    }
    @Override
    public int hashCode() {
        return this.monster.getName().hashCode();
    }
    @Override
    public int compareTo(CombatMonster other) {
        return Integer.compare(this.id, other.id);
    }
}
