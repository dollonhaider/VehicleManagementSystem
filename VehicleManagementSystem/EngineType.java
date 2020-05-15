public enum EngineType {

    OIL("OIL"), GAS("GAS"), DIESEL("DIESEL");

    private String value;
    public String getValue()
    {
        return this.value;
    }

    private EngineType(String value) {
        this.value = value;
    }
}
