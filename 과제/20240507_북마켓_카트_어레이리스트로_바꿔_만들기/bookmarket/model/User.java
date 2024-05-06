package bookmarket.model;

abstract class User{
    String id;
    String password;
    String name;
    abstract boolean login(String id, String password);//로그인 성공 여부 반환
}
class Admin extends User{
    boolean login(String id, String password){
        return this.id.equals(id) && this.password.equals(password);
    }
}
class Customer extends User{
    String address;
    String phoneNumber;
    int point;
    boolean login(String id, String password){
        return this.id.equals(id) && this.password.equals(password);
    }
}
