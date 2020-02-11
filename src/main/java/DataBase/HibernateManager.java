package DataBase;

import LoginPanel.LoginController;
import RegisterPanel.RegisterController;
import org.hibernate.Session;

public class HibernateManager {
    public static void sendLoginData(LoginData loginData){
        HibernateConfig.getSessionFactory().openSession();
        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String funcQuery = String.format("SELECT checkIfDataCorrect('%s','%s')", loginData.getLogin(), loginData.getPassword());
        Boolean result = (Boolean) session.createSQLQuery(funcQuery).uniqueResult();
        System.out.println(loginData.getLogin() + " " + loginData.getPassword());
        session.close();
        if(result)
            LoginController.performLogin(loginData.getLogin());
        else
            LoginController.rejectLogin();
    }
    public static void sendDataToRegister(String login, String password){
        HibernateConfig.getSessionFactory().openSession();
        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String funcQuery = String.format("SELECT checkIfCanBeRegistered('%s','%s')", login, password);
        Boolean result = (Boolean) session.createSQLQuery(funcQuery).uniqueResult();
        System.out.println(login + " " + password);
        session.close();
        if(result)
            RegisterController.performCreation();
        else
            RegisterController.rejectCreation();
    }
}
