import java.sql.*;
import java.util.Scanner;

public class Phonebook {
    /**
     * Driver JDBC и database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/phonebook";

    /**
     * Пользователь и пароль
     */
    static final String User = "root";
    static final String Password = "root";


    public static void main(String[] args) {
        displayMenu();
    }

    public static void addUser(User user) {
        System.out.println("Сохранение контакта:" + " " + user.getLastname() + " " +
                user.getFirstname() + " " + user.getPatronymic() + " " +
                "Телефон: " + user.getPhoneNumber());

        String sql = "INSERT INTO users(lastname, firstname, patronomyc, age, sexid, living_address, phone_number)" +
                "VALUES( ?,?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(DATABASE_URL, User, Password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getLastname());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getPatronymic());
            ps.setInt(4, user.getAge());
            ps.setInt(5, user.getSexid());
            ps.setString(6, user.getLivingAddress());
            ps.setLong(7, user.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delUser(int ID) {
        String sql = "DELETE FROM users WHERE users.ID= ?";

        try (Connection con = DriverManager.getConnection(DATABASE_URL, User, Password);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void findUser(int ID) {
        String sql = "SELECT Lastname,Firstname,Patronomyc,Age,sexes.NAMERU as 'pol', " +
                " Living_address,phone_number " +
                " FROM users INNER JOIN sexes on users.sexid = sexes.id " +
                " WHERE users.ID = ?";

        try (Connection con = DriverManager.getConnection(DATABASE_URL, User, Password);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);

            try (ResultSet res = ps.executeQuery()) {
                while (res.next()) {
                    String Lastname = res.getString("Lastname");
                    String Firstname = res.getString("Firstname");
                    String Patronomyc = res.getString("Patronomyc");
                    int Age = res.getInt("Age");
                    String pol = res.getString("pol");
                    String Living_address = res.getString("Living_address");
                    String phone_number = res.getString("phone_number");

                    System.out.println("\n================\n");
                    System.out.println("ID: " + ID + " " + "Фамилия: " + Lastname + " " + "Имя: " + Firstname + " " + "Отчество: " + Patronomyc
                            + " " + "Возраст: " + Age + " " + "Пол: " + pol + " " + "Адресс проживания: " + Living_address +
                            " " + "Номер телефона: " + phone_number);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void displayMenu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Здравствуйте! Какое действие вы выберите? (1, 2, 3)\n");
        System.out.println("1.Добавить");
        System.out.println("2.Удалить");
        System.out.println("3.Найти");
        System.out.println("4.Посмотреть ");


        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("\n Как зовут пользователя, которого вы хотите добавить? ");
                System.out.println("\n Фамилия: ");

                User user = new User();
                user.setLastname(sc.next());

                System.out.println("\n Имя: ");
                user.setFirstname(sc.next());

                System.out.println("\n Отчество: ");
                user.setPatronymic(sc.next());

                System.out.println("\n Возраст: ");
                user.setAge(sc.nextInt());

                System.out.println("\n Укажите пол(Мужчина - 1, Женщина - 2)");
                user.setSexid(sc.nextInt());

                System.out.println("\n Адресс Проживания: ");
                user.setLivingAddress(sc.next());

                System.out.println("\n Номер  полььзователя, которого хотите сохранить?");
                user.setPhoneNumber(sc.nextLong());

                addUser(user);
                break;

            case 2:
                System.out.println("\n Укажите ID пользователя, которого хотите удалить: ");
                delUser(sc.nextInt());
                break;

            case 3:
                System.out.println("\n Укажите ID пользователя, которого хотите найти: ");
                findUser(sc.nextInt());
                break;

            case 4:
                System.out.println("\n Все добавленные контакты: ");
                JDBC.showUsersToConsole();
                System.out.println();
                displayMenu();
                break;

            default:
                break;
        }
    }
}