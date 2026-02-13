package src.com.java.code;

class Address {
    String address;
    Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
    Address(){};
}

class Employee implements Cloneable {
    int id;
    String name;
    private Address address;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        //  System.out.println(id+"  "+name);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee empClone=(Employee)super.clone();
        empClone.setAddress(new Address());
        return empClone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

public class ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp = new Employee(14, "Ziyad");
        Address add = new Address("Kurla");
        emp.setAddress(add);

        Employee emp2 = (Employee) emp.clone();
        emp2.id = 145;
        emp2.name = "Zaid";
        emp2.getAddress().address = "Mumbai";

        System.out.println(emp);
        System.out.println(emp2);

    }
}
