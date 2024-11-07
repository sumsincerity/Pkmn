package ru.mirea.pkmn.PchelintsevNI.web.jdbc;

import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.Student;
import java.sql.SQLException;
import java.util.UUID;

public interface DatabaseService {
    Card getCardFromDatabase(String cardName) throws SQLException;

    Student getStudentFromDatabaseById(UUID uuid) throws SQLException;

    Student getStudentFromDatabase(String studentName) throws SQLException;

    void saveCardToDatabase(Card card) throws SQLException;

    void createPokemonOwner(Student owner) throws SQLException;
}