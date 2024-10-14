package ru.mirea.pkmn.PchelintsevNI;

import ru.mirea.pkmn.Card;

public class PkmnApplication {
    public static void main(String[] args) {
        CardImport imp = new CardImport();
        Card card = imp.importCards("C:\\Users\\fanno\\IdeaProjects\\Pkmn\\src\\main\\resources\\my_card.txt");

        CardExport exp = new CardExport();
        exp.exportCard(card);

        card = imp.importCardByte("C:\\Users\\fanno\\IdeaProjects\\Pkmn\\ChesnaughtV.crd");
        System.out.printf(card.toString());
    }
}