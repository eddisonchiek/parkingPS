package sg.edu.sg.c346.id21034014.weatherps;

public class Parking {

    private String carpark_number;
    private String update_datetime;
    private String lot_type;
    private String total_lots;
    private String lots_available;



    public Parking(String carpark_number, String update_datetime, String lot_type,String lots_available, String total_lots){
        this.carpark_number = carpark_number;
        this.update_datetime = update_datetime;
        this.lot_type = lot_type;
        this.total_lots = total_lots;
        this.lots_available = lots_available;
    }

    public String getCarpark_number() {
        return carpark_number;
    }

    public void setCarpark_number(String carpark_number) {
        this.carpark_number = carpark_number;
    }

    public String getUpdate_datetime() {
        return update_datetime;
    }

    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }

    public String getLot_type() {
        return lot_type;
    }

    public void setLot_type(String lot_type) {
        this.lot_type = lot_type;
    }

    public String getTotal_lots() {
        return total_lots;
    }

    public void setTotal_lots(String total_lots) {
        this.total_lots = total_lots;
    }

    public String getLots_available() {
        return lots_available;
    }

    public void setLots_available(String lots_available) {
        this.lots_available = lots_available;
    }

    public String toString(){
return "carpark Number: " + getCarpark_number() + " \ndate and time: " + getUpdate_datetime() + "\nLot type " + getLot_type() +     "\nLot available "+getLots_available()+"\nTotal lots " + getTotal_lots();
}
}
