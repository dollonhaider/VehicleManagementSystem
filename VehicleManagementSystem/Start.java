import java.util.Scanner;

public class Start {
    public static void main(String args[])
    {
        Db.dbTableCreate();
        System.out.println("Choose among the following options 1,2,3 or 4");
        System.out.println("\t1.Add Vehicle"+"\n\t2.Remove Vehicle"+"\n\t3.Show list of vehicles with current expected visitor count"+"\n\t4.Show list of vehicles with details");
        int input;

        try {
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            VehicleService vehicleService = new VehicleService();
            if(input == 1)
            {
                int enginePower,turbo,weight,engineType;
                String modelNumber,tireSize;

                System.out.println("Enter Vehicle Info: ");
                int vehicleInput;
                System.out.println("\nWhich type of Vehicle you want to add?"+"\nChoose among option 1,2 and 3"+"\n\t1.Normal Vehicle"+"\n\t2.Sports Vehicle"+"\n\t3.Heavy Vehicle ");
                vehicleInput = sc.nextInt();
                if (vehicleInput == 1){

                    System.out.println("Enter Model Number: ");
                    modelNumber = sc.next();
                    System.out.println("Enter Engine Power in HP: ");
                    enginePower = sc.nextInt();
                    System.out.println("Enter Tire Size: ");
                    tireSize = sc.next();
                    System.out.println("\nWhich type of Engine type you prefer?"+"\nChoose among option 1,2 and 3."+"\n\t1.Oil"+"\n\t2.Gas"+"\n\t3.Diesel ");
                    engineType = sc.nextInt();
                    Vehicle vehicle = new Vehicle();
                    vehicle.setModelNumber(modelNumber);
                    vehicle.setEnginePower(enginePower);
                    vehicle.setTireSize(tireSize);
                    if(engineType == 1)
                    {
                        vehicle.setEngineType(EngineType.OIL.getValue());
                    }
                    else if (engineType == 2 )
                    {
                        vehicle.setEngineType(EngineType.GAS.getValue());
                    }
                    else if(engineType == 3)
                    {
                        vehicle.setEngineType(EngineType.DIESEL.getValue());
                    }
                    else {
                        System.out.println("\nInvalid Input!!!");
                    }

                    vehicleService.addVehicle(vehicle);

                }
                else if (vehicleInput == 2)
                {
                    System.out.println("Enter Model Number: ");
                    modelNumber = sc.next();
                    System.out.println("Enter Engine Power in HP: ");
                    enginePower = sc.nextInt();
                    System.out.println("Enter Tire Size: ");
                    tireSize = sc.next();
                    System.out.println("Do you want turbo in your engine??"+"\nChoose among option 1 or 2."+"\n\t1.If you want to add turbo."+"\n\t2.If you are not willing to add turbo.");
                    turbo=sc.nextInt();
                    SportsVehicle sportsVehicle = new SportsVehicle();
                    if (turbo == 1)
                    {
                        sportsVehicle.setTurbo(true);
                    }
                    else if (turbo == 2)
                    {
                        sportsVehicle.setTurbo(false);
                    }
                    else {
                        System.out.println("Invalid Input!!");
                    }
                    sportsVehicle.setModelNumber(modelNumber);
                    sportsVehicle.setEnginePower(enginePower);
                    sportsVehicle.setTireSize(tireSize);
                    sportsVehicle.setEngineType(EngineType.OIL.getValue());
                    vehicleService.addSportsVehicle(sportsVehicle);
                }
                else if (vehicleInput == 3){

                    System.out.println("Enter Model Number: ");
                    modelNumber = sc.next();
                    System.out.println("Enter Engine Power in HP: ");
                    enginePower = sc.nextInt();
                    System.out.println("Enter Tire Size: ");
                    tireSize = sc.next();
                    System.out.println("Enter Weight : ");
                    weight = sc.nextInt();

                    HeavyVehicle heavyVehicle = new HeavyVehicle();
                    heavyVehicle.setModelNumber(modelNumber);
                    heavyVehicle.setEnginePower(enginePower);
                    heavyVehicle.setTireSize(tireSize);
                    heavyVehicle.setWeight(weight);
                    heavyVehicle.setEngineType(EngineType.DIESEL.getValue());
                    vehicleService.addHeavyVehicle(heavyVehicle);

                }
                else
                {
                    System.out.println("\nInvalid Input!!!");
                }
            }
            else if (input == 2)
            {
                int vehicleId;
                System.out.println("Enter the Vehicle Id which you want to remove: ");
                vehicleId = sc.nextInt();
                vehicleService.removeVehicle(vehicleId);
            }
            else if (input == 3)
            {
                vehicleService.showVehiclesWithVisitorCount();
            }
            else if (input == 4)
            {
                vehicleService.showVehiclesDetails();
            }
            else {
                System.out.println("\nInvalid Input!!!");
            }
        } catch (Exception ex){
            System.out.println("Invalid User Input :"+ ex.getMessage());
        }
    }
}
