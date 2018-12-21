package vesiputous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vesiputous.domain.RuleSet;

public class RuleSetDao implements Dao<RuleSet, String> {

    private Database database;

    public RuleSetDao(Database db) {
        this.database = db;
    }

    @Override
    public RuleSet findOne(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RuleSet> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM RuleSet");

        ResultSet rs = stmt.executeQuery();
        List<RuleSet> ruleSets = new ArrayList<>();

        while (rs.next()) {
            String name = rs.getString("name");

            ruleSets.add(new RuleSet(name));
        }

        rs.close();
        stmt.close();
        connection.close();

        return ruleSets;
    }

    @Override
    public void delete(String key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM RuleSet WHERE name = ?");

        stmt.setString(1, key);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    @Override
    public void add(RuleSet o) throws SQLException {
        if (!this.findAll().contains(o)) {
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO RuleSet (name) "
                    + "VALUES (?);");
            stmt.setString(1, o.toString());

            stmt.executeUpdate();
            stmt.close();
            connection.close();

            System.out.println("New ruleset added: " + o.toString());
        } else {
            throw new SQLException("Adding new ruleset failed, name " + o.toString() + " already exists");
        }
    }

    @Override
    public void update(RuleSet o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
