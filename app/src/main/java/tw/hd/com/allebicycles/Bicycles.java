package tw.hd.com.allebicycles;

public class Bicycles {
    private String StationUID;
    private int StationID;
    private int ServieAvailable;
    private int AvailableRentBikes;
    private int AvailableReturnBikes;
    private String SrcUpdateTime;
    private String UpdateTime;

    public Bicycles() {
    }

    public Bicycles(String stationUID, int stationID, int servieAvailable, int availableRentBikes, int availableReturnBikes, String srcUpdateTime, String updateTime) {
        StationUID = stationUID;
        StationID = stationID;
        ServieAvailable = servieAvailable;
        AvailableRentBikes = availableRentBikes;
        AvailableReturnBikes = availableReturnBikes;
        SrcUpdateTime = srcUpdateTime;
        UpdateTime = updateTime;
    }

    public String getStationUID() {
        return StationUID;
    }

    public void setStationUID(String stationUID) {
        StationUID = stationUID;
    }

    public int getStationID() {
        return StationID;
    }

    public void setStationID(int stationID) {
        StationID = stationID;
    }

    public int getServieAvailable() {
        return ServieAvailable;
    }

    public void setServieAvailable(int servieAvailable) {
        ServieAvailable = servieAvailable;
    }

    public int getAvailableRentBikes() {
        return AvailableRentBikes;
    }

    public void setAvailableRentBikes(int availableRentBikes) {
        AvailableRentBikes = availableRentBikes;
    }

    public int getAvailableReturnBikes() {
        return AvailableReturnBikes;
    }

    public void setAvailableReturnBikes(int availableReturnBikes) {
        AvailableReturnBikes = availableReturnBikes;
    }

    public String getSrcUpdateTime() {
        return SrcUpdateTime;
    }

    public void setSrcUpdateTime(String srcUpdateTime) {
        SrcUpdateTime = srcUpdateTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }
}
