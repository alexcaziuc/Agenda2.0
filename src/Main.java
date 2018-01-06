import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBOperations dbOperations = new DBOperations();

        int optiune;

        do {
            showMenu();
            System.out.print("Optiune -> ");
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            if (optiune >= 0 && optiune <= 5) {
                switch (optiune) {
                    case 1: {

                       dbOperations.demoDisplay();
                        break;
                    }

                    case 2: {
                        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati Nume si TEL");
        String numeCitit = scanner.nextLine();
        String phoneCitit = scanner.nextLine();

        Person p = new Person(numeCitit, phoneCitit);

                       dbOperations.demoAdd(p);
                        break;
                    }

                    case 3: {
                        dbOperations.demoDelete();
                        break;
                    }

                    case 4: {
                        dbOperations.demoEdit();
                        break;
                    }

                    case 5: {
                       dbOperations.demoSearch();
                        break;
                    }
                }
            } else {
                System.out.println("Optiune invalida");
            }
        } while (optiune != 0);
    }


    private static void showMenu() {
        System.out.println("1> Display Agenda");
        System.out.println("2> Add");
        System.out.println("3> Delete");
        System.out.println("4> Edit");
        System.out.println("5> Search");
        System.out.println("0> Exit");
    }

    private static String readName(String label) {

        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String numeCitit = scan.nextLine();

        return numeCitit;
    }

    private static String readPhone(String label) {

        System.out.print(label);
        Scanner scan = new Scanner(System.in);
        String telefonulCitit = scan.nextLine();

        return telefonulCitit;
    }

}
