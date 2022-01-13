package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clasa care va realiza conexiunea cu baza de date
 */
public class ConnectionFactory {
    /**
     * LOGGER - atributul care va genera un log pentru a identifica posibilele erori care intervin in crearea conexiunii
     * DRIVER - driverul care va lega propriu-zis aplicatia Java de baza de date MySQL
     * DBURL - locatia, portul si numele schemei bazei de date
     * USER - username-ul folosit pentru conectarea la conexiune
     * PASS - parola folosita pentru conectarea la conexiune
     * singleInstance - singletonul conexiunii
     */
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/ordermanagement";
    private static final String USER = "root";
    private static final String PASS = "Caramida2015";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructorul clasei singleton ConnectionFactory, care seteaza driverul spre aceasta clasa
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda care realizeaza propriu-zis conexiunea cu baza de date
     *
     * @return Conexiunea spre baza de date
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            ex.printStackTrace();
        }
        return connection;
    }

    /**
     * Metoda care va permite preluarea conexiunii spre baza de date in toata aplicatia
     *
     * @return Conexiunea spre baza de date
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Metoda care va permite inchiderea conexiunii odata ce aceasta nu se mai foloseste
     *
     * @param connection Conexiunea care se va inchide
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Metoda care va permite inchiderea unei interogari, odata ce aceasta nu se mai foloseste
     *
     * @param statement Interogarea care se va inchide
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Metoda care va permite inchiderea unui set de rezultate, odata ce acesta nu se mai foloseste
     *
     * @param resultSet Setul de rezultate care se va inchide
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
