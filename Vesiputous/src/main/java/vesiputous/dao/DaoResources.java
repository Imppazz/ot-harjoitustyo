package vesiputous.dao;

/**
 *
 * @author Ilmari
 */
public interface DaoResources {

    /**
     *
     */
    Database DATABASE = new Database("jdbc:sqlite:VesiputousDatabase.db");

    /**
     *
     */
    Dao RULEDAO = new RuleDao(DATABASE);

    /**
     *
     */
    Dao RULESETDAO = new RuleSetDao(DATABASE);   
}
