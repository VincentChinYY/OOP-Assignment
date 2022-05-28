public class Customer {
    private String id;
    private String name;
    private byte age;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer() {
        this.id = "";
        this.name = "";
        this.age = 0;
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
    }

    public Customer(String id, String name, byte age, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
