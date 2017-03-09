package model;

public class SummaryReport {
    private long deviceId;
    private String deviceName;
    private double distance; // meters
    private double averageSpeed; // knots
    private double maxSpeed; // knots
    private long engineHours; // milliseconds
    private int numStops;

    public SummaryReport(long deviceId, String deviceName, double distance,
            double averageSpeed, double maxSpeed, long engineHours, int numStops) {
        super();
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.maxSpeed = maxSpeed;
        this.engineHours = engineHours;
        this.numStops = numStops;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public long getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(long engineHours) {
        this.engineHours = engineHours;
    }

    public int getNumStops() {
        return numStops;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

}
