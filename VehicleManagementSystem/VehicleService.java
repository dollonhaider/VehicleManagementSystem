import java.sql.Connection;
import java.sql.*;

public class VehicleService {


    public void addVehicle(Vehicle v)
    {
        Connection conn = null;
        conn = Db.connection();
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO Vehicle (ModelNumber,EnginePower,TireSize,EngineType,Turbo,Weight,VehicleType) " +
                    "VALUES ('"+v.getModelNumber()+"','"+v.getEnginePower()+"','"+v.getTireSize()+"','"+v.getEngineType()+"',FALSE, NULL, '"+VehicleType.NORMAL.getValue()+"')";
            stmt.executeUpdate(sql);
        }  catch ( Exception e ) {
            System.out.println("Error in query :" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public void addSportsVehicle(SportsVehicle s){
        Connection conn = null;
        conn = Db.connection();
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO Vehicle (ModelNumber,EnginePower,TireSize,EngineType,Turbo,Weight,VehicleType) " +
                    "VALUES ('"+s.getModelNumber()+"','"+s.getEnginePower()+"','"+s.getTireSize()+"','"+s.getEngineType()+"','"+s.getTurbo()+"', NULL , '"+VehicleType.SPORTS.getValue()+"')";
            stmt.executeUpdate(sql);

            sql = "UPDATE Visitor set ExpectedVisitor = ExpectedVisitor + 20 where VisitorId=1;";
            stmt.executeUpdate(sql);
        }  catch ( Exception e ) {
            System.out.println("Error in query :" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");

    }

    public void addHeavyVehicle(HeavyVehicle h){
        Connection conn = null;
        conn = Db.connection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Vehicle (ModelNumber,EnginePower,TireSize,EngineType,Turbo,Weight,VehicleType) " +
                    "VALUES ('"+h.getModelNumber()+"','"+h.getEnginePower()+"','"+h.getTireSize()+"','"+h.getEngineType()+"',FALSE , '"+h.getWeight()+"' , '"+VehicleType.HEAVY.getValue()+"')";
            stmt.executeUpdate(sql);
        }  catch ( Exception e ) {
            System.out.println("Error in query :"+ e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");

    }
    public void removeVehicle(int v)
    {
        Connection conn = null;
        conn = Db.connection();
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Vehicle WHERE  VehicleId='"+v+"';" );
            String vehicleType = rs.getString("VehicleType");
            if(vehicleType.equals(VehicleType.SPORTS.getValue()) ){
                String sqlQuery = "UPDATE Visitor set ExpectedVisitor = ExpectedVisitor - 20 where VisitorId=1 AND ExpectedVisitor >= 20;";
                stmt.executeUpdate(sqlQuery);
            }

            String sql = "DELETE from Vehicle where VehicleId = '"+v+"'";
            System.out.println("Deleted Successfully");
            stmt.executeUpdate(sql);
        }  catch ( Exception e ) {
            System.out.println("\nError in Input :" + e.getMessage());
        System.exit(0);
        }


    }
    public void showVehiclesDetails()
    {
        Connection conn = null;
        conn = Db.connection();
        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Vehicle;" );

            System.out.println("List of The Vehicles Are Given Below: ");
            while ( rs.next() ) {
                int VehicleId = rs.getInt("vehicleId");
                String ModelNumber = rs.getString("ModelNumber");
                int EnginePower = rs.getInt("EnginePower");
                String TireSize = rs.getString("TireSize");
                String engineType = rs.getString("EngineType");
                String Turbo = rs.getString("Turbo");
                String Weight = rs.getString("Weight");
                String VehicleType = rs.getString("VehicleType");

                System.out.println("\nId = " + VehicleId);
                System.out.println("Model Number = " + ModelNumber);
                System.out.println("Engine Power = " + EnginePower);
                System.out.println("Tire Size = " + TireSize);
                System.out.println("Engine Type = " + engineType);
                System.out.println("Turbo = " + Turbo);
                System.out.println("Weight = " + Weight);
                System.out.println("Vehicle Type = " + VehicleType);
            }

            rs.close();
        } catch ( Exception e ) {
            System.out.println("Error Occur :" + e.getMessage());
            System.exit(0);
        }
    }
    public void showVehiclesWithVisitorCount()
    {
        Connection conn = null;
        conn = Db.connection();
        Statement stmt = null;
        try
        {
            showVehiclesDetails();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Visitor;" );
            int ExpectedVisitor = rs.getInt("ExpectedVisitor");
            System.out.print("\nExpected visitor count = " + ExpectedVisitor);
            rs.close();

        }  catch ( Exception e ) {
            System.out.println("Error Occur :"+ e.getMessage());
            System.exit(0);
        }

    }

}
