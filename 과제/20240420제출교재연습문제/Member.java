package challenge_chap04;

public class Member {
    private String name;
    private String id;
    private String password;
    private byte age;

    public Member(String name, String id, String password, byte age){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public Member(){};

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }
    public void setId(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public byte getAge(){
        return age;
    }
    public void setAge(byte age){
        this.age = age;
    }
}
