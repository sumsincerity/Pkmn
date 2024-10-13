package ru.mirea.PchelintsevNI.pkmn;

public class AttackSkill {
    private String name;
    private String description;
    private String cost;
    private int damage;

    @Override
    public String toString() {
        return "AttackSkill{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost='" + cost + '\'' +
                ", damage=" + damage +
                '}';
    }

    public AttackSkill(String name, String description, String cost, int damage) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.damage = damage;
    }
}

