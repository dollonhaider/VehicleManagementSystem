public enum VehicleType {

    NORMAL("NORMAL"), SPORTS("SPORTS"), HEAVY("HEAVY");

    private String value;
    public String getValue()
    {
        return this.value;
    }

    private VehicleType(String value) {
        this.value = value;
    }
}
