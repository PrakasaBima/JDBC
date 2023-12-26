
import java.util.Scanner;
public class SupermarketApp {
    public static void main(String[] args) {
        
        //update username dan password
        Scanner scanner = new Scanner(System.in);
        UpdateEmployee.updateEmployeeCredentials(scanner);
        System.out.println("");

        //membuat data pegawai baru
        Scanner scanNEW = new Scanner(System.in);
        CreateNewEmployee.insertEmployeeData(scanNEW);
        System.out.println("");
        
        //hapus pegawai
        DeleteEmployee.deleteEmployeeById();
        System.out.println("");
        
        //login employee
        Captcha login = new Captcha();

        //faktur pembelian
        Customer customer = new Customer("", "", " ", " ");
        customer.displaySupermarketInfo();
        System.out.println("-----DATA PELANGGAN-----");
        customer.inputCustomerData();

        Purchase purchase = new Purchase("", "");
        System.out.println("--DATA PEMBELIAN BARANG-");
        purchase.inputPurchaseData();
        purchase.displayPurchaseData();

        
    }
}