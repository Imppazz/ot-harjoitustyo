package vesiputous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vesiputous.domain.Card;
import vesiputous.domain.Rule;

public class RuleDao implements Dao<Rule, String> {

    private Database database;

    public RuleDao(Database db) {
        this.database = db;
    }

    @Override
    public Rule findOne(String key) throws SQLException {
        String[] split = key.split(" ");
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Rule WHERE card = '" + split[0] + "' AND ruleset = '" + split[1] + "'");

        ResultSet rs = stmt.executeQuery();

        String card = rs.getString("card");
        String rule = rs.getString("rule");
        String ruleSet = rs.getString("ruleset");

        return new Rule(new Card(card), rule, ruleSet);
    }

    @Override
    public List<Rule> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Rule");

        ResultSet rs = stmt.executeQuery();
        List<Rule> rules = new ArrayList<>();

        while (rs.next()) {
            String card = rs.getString("card");
            String rule = rs.getString("rule");
            String ruleSet = rs.getString("ruleset");

            rules.add(new Rule(new Card(card), rule, ruleSet));
        }

        rs.close();
        stmt.close();
        connection.close();

        return rules;
    }
    @Override
    public void delete(String key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Rule WHERE ruleset = ?");

        stmt.setString(1, key);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    @Override
    public void add(Rule o) throws SQLException {
        if (!this.findAll().contains(o)) {
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Rule (card, rule, ruleset) "
                    + "VALUES (?, ?, ?);");
            stmt.setString(1, o.getCard().cardAsString());
            stmt.setString(2, o.getRule());
            stmt.setString(3, o.getRuleSetName());

            stmt.executeUpdate();
            stmt.close();
            connection.close();

            System.out.println("New rule added: " + o.getRule() + ", for card: " + o.getCard());
        } else {
            throw new SQLException("Adding new rule failed, card " + o.getCard() + " already has a rule");
        }
    }

    @Override
    public void update(Rule o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
