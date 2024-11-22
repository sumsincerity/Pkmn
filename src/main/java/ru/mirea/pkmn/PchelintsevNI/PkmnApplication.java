package ru.mirea.pkmn.PchelintsevNI;


import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.AttackSkill;
import com.fasterxml.jackson.databind.JsonNode;
import ru.mirea.pkmn.PchelintsevNI.web.http.PkmnHttpClient;
import ru.mirea.pkmn.PchelintsevNI.web.jdbc.DatabaseService;
import ru.mirea.pkmn.PchelintsevNI.web.jdbc.DatabaseServiceImpl;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PkmnApplication {
    public static void main(String[] args) throws IOException, SQLException {

        Card card = new Card();
        Scanner scanner = new Scanner(System.in);
        DatabaseServiceImpl db = new DatabaseServiceImpl();
        boolean flag = true;

        System.out.println(db.getCardFromDatabase("Chesnaught V"));
        System.out.println(db.getStudentIdFromDatabase("Pchelintsev Nikita Igorevich"));

        System.out.println("0 - Выход");
        System.out.println("1 - парсинг ноут умений");
        System.out.println("2 - сохранение карточки в бд");
        System.out.println("3 - есть ли карта в бд)");


        while (flag) {
            int input = scanner.nextInt();

            if (input == 0) {
                flag = false;
            } else if (input == 1) {
                card = CardImport.importCard("src/main/resources/my_card.txt");
                System.out.println(card);
                updateSkills(card);
                System.out.println(card);
            } else if (input == 2) {
                card = CardImport.importCard("src/main/resources/my_card.txt");
                updateSkills(card, false);
                db.saveCardToDatabase(card);
                System.out.println(db.getCardFromDatabase(card.getName()));
            } else if (input == 3) {
                card = CardImport.importCard("src/main/resources/my_card.txt");
                System.out.println(db.getCardFromDatabase(card.getName()));
            }
        }

    }
    public static void updateSkills(Card card) throws IOException {
        updateSkills(card, true);
    }

    public static void updateSkills(Card card, boolean flag) throws IOException {
        if(card.getEvolvesFrom() != null)
            updateSkills(card.getEvolvesFrom(), flag);
        PkmnHttpClient pkmnHttpClient = new PkmnHttpClient();
        JsonNode card_jn = pkmnHttpClient.getPokemonCard(card.getName(), card.getNumber());
        if (flag)
            System.out.println(card_jn.toPrettyString());


        Stream<JsonNode> stream = card_jn.findValues("attacks").stream();
        JsonNode attacks = stream.toList().getFirst();

        for(JsonNode attack : attacks) {
            for(AttackSkill skill : card.getSkills()) {
                if(skill.getName().equals(attack.findValue("name").asText())) {
                    skill.setDescription(attack.findValue("text").asText());
                }
            }
        }
        stream.close();
    }
}