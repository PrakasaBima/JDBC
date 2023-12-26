import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateNewEmployee {

    private static final String URL = "jdbc:mysql://localhost:3306/mahasiswa";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertEmployeeData(Scanner scanNEW) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Mahasiswa (ID, Nama, Umur) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----MEMBUAT DATA LOGIN BARU----");

                System.out.print("Enter value for ID (integer): ");
                int IDValue = scanNEW.nextInt();

                System.out.print("Enter value for Nama: ");
                String NamaValue = scanNEW.next();

                System.out.print("Enter value for Umur: ");
                String UmurValue = scanNEW.next();

                preparedStatement.setInt(1, IDValue);
                preparedStatement.setString(2, NamaValue);
                preparedStatement.setString(3, UmurValue);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil menambah data login baru");
                } else {
                    System.out.println("Tidak dapat menambah data login baru");
                }

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
