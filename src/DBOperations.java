import java.sql.*;
import java.util.Scanner;

public class DBOperations {
//
//   // try {
//        //demo CRUD operations
//        //demoAdd();
//        //demoDisplay();
//        //demoEdit();
//        //demoDelete();
//
//        // demoBlobInsert();
//        // demoBlobRead();
//
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }



    public void demoDisplay() throws ClassNotFoundException, SQLException{

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT name,phone FROM AGENDA");

        // 6. iterate the result set and print the values
        while (rs.next()) {
            System.out.print(rs.getString("name").trim());
            System.out.print("---");
            System.out.println(rs.getString("phone").trim());
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

    }

    public void demoAdd(Person p) throws ClassNotFoundException, SQLException{

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO AGENDA (name, phone) VALUES (?,?)");

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Dati Nume si TEL");
//        String numeCitit = scanner.nextLine();
//        String phoneCitit = scanner.nextLine();

        pSt.setString(1, p.getName());
        pSt.setString(2, p.getPhone());


        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void demoEdit() throws ClassNotFoundException, SQLException {


        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE AGENDA SET name=?, phone=? WHERE id=?"); //so we have 3 params

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dati id pentru inlocuire");
        long id = scanner.nextLong();

        System.out.println("nume de citit");
        String numeCitit = scanner.next();

        System.out.println("phone de citit");
        String phoneCitit = scanner.next();


        pSt.setString(1, numeCitit);
        pSt.setString(2, phoneCitit);
        pSt.setLong(3, id);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void demoDelete()  throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM AGENDA WHERE id=?");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dati id pentru stergere");
        long id = scanner.nextLong();

        pSt.setLong(1, id);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void demoSearch() throws ClassNotFoundException, SQLException{

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        //prepare statement aici
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT name,phone FROM AGENDA WHERE name LIKE ?%");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati Nume de cautat");
        String numeCitit = scanner.next();
        //String phoneCitit = scanner.nextLine();

//        rs.setString(1, numeCitit);
//        //pSt.setString(2, phoneCitit);
//
//        while (rs.next()) {
//            System.out.print(rs.getString("name").trim());
//            System.out.print("---");
//            System.out.println(rs.getString("phone").trim());
//        }
//
//
//        // 6. close the objects
//        pSt.close();
//        conn.close();
    }
}
