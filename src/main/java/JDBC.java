import java.sql.*;

public class JDBC {
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

    public static void showUsersToConsole() {
        String sql = "SELECT users.ID,Lastname,Firstname,Patronomyc,Age,sexes.NAMERU as 'pol'," +
                "Living_Address,phone_number " +
                "FROM users INNER JOIN sexes on users.sexid = sexes.id";

        try (Connection con = DriverManager.getConnection(DATABASE_URL, User, Password);
             Statement st = con.createStatement();
             ResultSet res = st.executeQuery(sql)) {

            while (res.next()) {
                int ID = res.getInt("ID");
                String Lastname = res.getString("Lastname");
                String Firstname = res.getString("Firstname");
                String Patronomyc = res.getString("Patronomyc");
                int Age = res.getInt("Age");
                String pol = res.getString("pol");
                String Living_Address = res.getString("Living_address");
                String phone_number = res.getString("phone_number");

                System.out.println("\n================\n");
                System.out.println("ID: " + ID);
                System.out.println("Фамилия: " + Lastname);
                System.out.println("Имя: " + Firstname);
                System.out.println("Отчество: " + Patronomyc);
                System.out.println("Возраст: " + Age);
                System.out.println("Пол: " + pol);
                System.out.println("Адресс проживания: " + Living_Address);
                System.out.println("Номер телефона: " + phone_number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
