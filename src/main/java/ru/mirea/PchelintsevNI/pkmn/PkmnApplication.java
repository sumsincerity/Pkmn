package ru.mirea.PchelintsevNI.pkmn;

public class PkmnApplication {
    public static void main(String[] args) {
        CardImport imp = new CardImport();
        System.out.printf(imp.importCards("C:\\Users\\fanno\\IdeaProjects\\Pkmn\\src\\main\\resources\\my_card.txt").toString());
    }
}