package vesiputous.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) {
        this.databaseAddress = databaseAddress;
        this.init();
    }

    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            return DriverManager.getConnection(dbUrl);
        }

        return DriverManager.getConnection(databaseAddress);
    }

    public void init() {
        List<String> commands = this.sqliteCommands();

        // "try with resources" close the resources in the end
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String com : commands) {
                System.out.println("Running command >> " + com);
                st.executeUpdate(com);
            }

        } catch (Throwable t) {
            // if db is initialized -> failed to run commands and stop
            System.out.println("Error >> " + t.getMessage());
        }
    }

    private List<String> sqliteCommands() {
        ArrayList<String> list = new ArrayList<>();

        list.add("CREATE TABLE IF NOT EXISTS RuleSets ("
                + "id integer PRIMARY KEY, "
                + "name varchar(50), "
                + "CONSTRAINT constraint_name UNIQUE (name));");
        
        list.add("CREATE TABLE IF NOT EXISTS Rules ("
                + "id integer PRIMARY KEY, "
                + "card varchar(20), "
                + "rule varchar(255), "
                + "CONSTRAINT constraint_card UNIQUE (card), "
                + "game_id integer, "
                + "FOREIGN KEY (game_id) REFERENCES Game(id));");
                
        return list;
    }
}
