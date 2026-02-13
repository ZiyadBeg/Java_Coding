package src.com.java.code;

import java.awt.*;

interface  Bank{
    void account();
}

class PersonalAccount implements  Bank{

    @Override
    public void account() {
        System.out.println("Personal Account");


    }
}
class JoinedAccount implements  Bank{
    @Override
    public void account() {
        System.out.println("JoinedAccount Account");
    }
}
class BussinessAccount implements  Bank{
    @Override
    public void account() {
        System.out.println("BussinessAccount Account");
    }
}
class FactoryDesignPattern{
    private  FactoryDesignPattern(){};
    public  static Bank getInstance(String instanceName){
        if(instanceName==null)
            return null;
        return switch (instanceName) {
            case "PersonalAccount" -> new PersonalAccount();
            case "JoinedAccount" -> new JoinedAccount();
            case "BussinessAccount" -> new BussinessAccount();
            default -> throw new RuntimeException("Unknown Object:" + instanceName);
        };
    }

}


public class Main {
    public static void main(String[] args) {
       Bank bank= FactoryDesignPattern.getInstance("BussinessAccount");
    bank.account();
    }
}


