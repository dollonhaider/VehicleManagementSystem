public class Vehicle {
    private int vehicleId;
    private String modelNumber;
    private int enginePower;
    private String tireSize;
    private String engineType;
    private String vehicleType;

    public Vehicle() {
    }

    public Vehicle(String modelNumber, int enginePower, String tireSize, String engineType, String vehicleType) {
        this.modelNumber = modelNumber;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.engineType = engineType;
        this.vehicleType = vehicleType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getTireSize() {
        return tireSize;
    }

    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
