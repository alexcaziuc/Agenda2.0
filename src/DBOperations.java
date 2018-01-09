import java.sql.*;

public class DBOperations {

    public void displayAgenda() throws ClassNotFoundException, SQLException {

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
            System.out.print(" --- ");
            System.out.println(rs.getString("phone").trim());
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

    }

    public void addContact(Person p) throws ClassNotFoundException, SQLException {

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

        pSt.setString(1, p.getName());
        pSt.setString(2, p.getPhone());

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void editContact(Person p, String oldName) throws ClassNotFoundException, SQLException {


        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE AGENDA SET name=?, phone=? WHERE name=?");

        pSt.setString(1, p.getName());
        pSt.setString(2, p.getPhone());
        pSt.setString(3, oldName);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void deleteContact(Person p) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM AGENDA WHERE name=?");
        pSt.setString(1, p.getName());

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    public void searchContact(Person p) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/alexc7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("SELECT name,phone FROM AGENDA WHERE name LIKE ?");
        pSt.setString(1, p.getName() + "%");

        // 5. execute a query
        ResultSet rs = pSt.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("name").trim());
            System.out.print(" -> ");
            System.out.println(rs.getString("phone").trim());
        }

        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

