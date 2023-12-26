import java.sql.*;

public class DriverTest {
    public static void main(String[] args) {
        //test apakah database (localhost) sudah tersambung dengan VScode
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa", "root", "");
            Statement myStatement = myConn.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("select * from mahasiswa");

            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("Nama")+ ","+myResultSet.getInt("ID"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
