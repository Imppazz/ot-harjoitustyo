package vesiputous.dao;

public interface DaoResources {
    Database DATABASE = new Database("jdbc:sqlite:VesiputousDatabase.db");
    Dao RULEDAO = new RuleDao(DATABASE);
    Dao RULESETDAO = new ruleSetDao(DATABASE);   
}
