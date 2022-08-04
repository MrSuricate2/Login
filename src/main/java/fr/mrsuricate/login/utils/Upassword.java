package fr.mrsuricate.login.utils;

public class Upassword {

    private final String name;
    private final String password;

    public Upassword(String name, String password){
        this.name = name;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
