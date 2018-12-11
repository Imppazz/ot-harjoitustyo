package vesiputous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vesiputous.domain.ruleSet;

public class ruleSetDao implements Dao<ruleSet, String> {

    private Database database;

    public ruleSetDao(Database db) {
        this.database = db;
    }

    @Override
    public ruleSet findOne(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ruleSet> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM RuleSet");

        ResultSet rs = stmt.executeQuery();
        List<ruleSet> ruleSets = new ArrayList<>();

        while (rs.next()) {
            String name = rs.getString("name");

            ruleSets.add(new ruleSet(name));
        }

        rs.close();
        stmt.close();
        connection.close();

        return ruleSets;
    }

    @Override
    public void delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(ruleSet o) throws SQLException {
        if (!this.findAll().contains(o)) {
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Rules (name) "
                    + "VALUES (?);");
            stmt.setString(1, o.getName());

            stmt.executeUpdate();
            stmt.close();
            connection.close();

            System.out.println("New ruleset added: " + o.getName());
        } else {
            throw new SQLException("Adding new ruleset failed, name " + o.getName() + " already exists");
        }
    }

    @Override
    public void update(ruleSet o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
