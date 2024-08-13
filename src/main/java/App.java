import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/schedule"; // 데이터베이스 URL
        String userName = "root"; // MySQL 사용자명
        String password = "lumen891103"; // MySQL 비밀번호


        try {
            // MySQL JDBC 드라이버 로드
            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");

            // 연결 종료
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
