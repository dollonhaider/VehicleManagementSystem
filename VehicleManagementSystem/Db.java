import java.sql.*;

public class Db {

        public static Connection connection() {
            Connection conn = null;
            try {

                String url = "jdbc:sqlite:vehicle.db";
                conn = DriverManager.getConnection(url);
                return conn;

            } catch (SQLException e) {
                System.out.println("Connection Error :");
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (conn == null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Connection Error :" + ex.getMessage());;
                }
            }
            return null;
        }

        public static void dbTableCreate(){
            Connection conn = null;
            try {
                conn = Db.connection();
                String sql = "CREATE TABLE IF NOT EXISTS Vehicle " +
                        "(VehicleId	INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " ModelNumber	TEXT    NOT NULL, " +
                        " EnginePower	INT     NOT NULL, " +
                        " TireSize	TEXT, " +
                        " EngineType	TEXT," +
                        " VehicleType	TEXT, " +
                        " Turbo	NUMERIC ," +
                        " Weight	INT)" ;
                Statement stmt = conn.createStatement();
                stmt.execute(sql);

                sql = "CREATE TABLE IF NOT EXISTS Visitor " +
                        "(VisitorId    INT, " +
                        " ExpectedVisitor	INT  NOT NULL)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO Visitor (VisitorId , ExpectedVisitor) " + "VALUES ('"+1+"','"+30+"')";
                stmt.executeUpdate(sql);
                conn.close();
            } catch ( Exception e ) {
                System.out.println("Error Occurs in Create Table :" + e.getMessage());
                System.exit(0);
            }
    }

}
