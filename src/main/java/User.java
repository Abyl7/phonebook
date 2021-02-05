public class User {
    private String lastname;
    private String firstname;
    private String patronymic;
    private int age;
    private int sexid;
    private String livingAddress;
    private long phoneNumber;

    public User() {
    }

    public User(String lastname, String firstname, String patronymic, int age, int sexid, String livingAddress, long phoneNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.age = age;
        this.sexid = sexid;
        this.livingAddress = livingAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSexid() {
        return sexid;
    }

    public void setSexid(int sexid) {
        this.sexid = sexid;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
