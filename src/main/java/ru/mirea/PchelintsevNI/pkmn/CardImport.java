package ru.mirea.PchelintsevNI.pkmn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardImport {

    // Метод для импорта карт из текстового файла
    public Card importCards(String filePath) {
        Card card = new Card();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            card.setPokemonStage(PokemonStage.valueOf(br.readLine().split("\\. ")[1]));
            card.setName(br.readLine().split("\\. ")[1]);
            card.setHp(Integer.parseInt(br.readLine().split("\\. ")[1]));
            card.setPokemonType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
            String line5 = br.readLine().split("\\. ")[1];
            switch (line5) {
                case ("-"):
                    break;
                default:
                    card.setEvolvesFrom(new Card(line5));
                    break;
            }
            String[] line6 = br.readLine().split("\\. ")[1].split(", ");
            List<AttackSkill> skills = new ArrayList<>();
            for (String i : line6){
                String[] arr = i.split(" / ");
                AttackSkill attackSkill = new AttackSkill(arr[1], "", arr[0], Integer.parseInt(arr[2]));
                skills.add(attackSkill);
            }
            card.setSkills(skills);
            card.setWeaknessType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
            String line8 = br.readLine().split("\\. ")[1];
            switch (line8) {
                case ("-"):
                    break;
                default:
                    card.setResistanceType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
                    break;
            }
            String line9 = br.readLine().split("\\. ")[1];
            card.setRetreatCost(line9);
            String line10 = br.readLine().split("\\. ")[1];
            card.setGameSet(line10);
            card.setRegulationMark(br.readLine().split("\\. ")[1].charAt(0));
            String line12 = br.readLine().split("\\. ")[1];

            String[] nameStudent = line12.split(" / ");
            card.setPokemonOwner(new Student(nameStudent[0],
                    nameStudent[1], nameStudent[2], nameStudent[3]));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата числа: " + e.getMessage());
        }

        return card;
    }
}