package UserController;

public class User {

    String name;
    boolean logged;

    public boolean isLogged(){
        return logged;
    }
    public void setLogged(boolean l){
        logged = l;
    }
    public void setName(String n){name=n;}
}
