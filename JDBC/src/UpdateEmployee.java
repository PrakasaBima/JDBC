import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {

    //Driver
    private static final String URL = "jdbc:mysql://localhost:3306/mahasiswa";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static void updateEmployeeCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE mahasiswa SET Nama = ?, Umur = ? WHERE ID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE DATA LOGIN PEGAWAI----");
                System.out.print("ID Baru: ");
                int ID = scanner.nextInt();
                
                System.out.print("Nama Baru: ");
                String newNama = scanner.next();

                System.out.print("Umur : ");
                String newUmur = scanner.next();

                preparedStatement.setString(1, newNama);
                preparedStatement.setString(2, newUmur);
                preparedStatement.setInt(3, ID);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data login pegawai diupdate!");
                } else {
                    System.out.println("tidak ditemukan data pegawai dengan id tersebut");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
