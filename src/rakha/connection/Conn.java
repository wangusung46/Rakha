package rakha.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    private static java.sql.Connection koneksi;

    public static java.sql.Connection getConnection() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/rakha";
                String user = "root";
                String password = "";

                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException exception) {
                System.out.println("Error Membuat Koneksi");
            }
        }
        return koneksi;

    }
}
