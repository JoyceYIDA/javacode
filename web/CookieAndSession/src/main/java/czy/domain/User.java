package czy.domain;

public class User {
    //name和password就是bean属性
    //如果是getUserName，那么userName才是bean属性
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
