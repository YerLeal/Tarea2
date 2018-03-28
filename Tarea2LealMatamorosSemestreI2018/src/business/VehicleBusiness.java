package business;

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleBusiness {

    private File file = new File("vehicle.dat");
    private VehicleFile vehicleFile;

    public VehicleBusiness() throws IOException {
        this.vehicleFile = new VehicleFile(this.file);
    } // constructor

    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        return this.vehicleFile.addEndRecord(vehicle);
    } // addEndRecord

    public boolean isValid(int serie) throws IOException {
        return this.vehicleFile.isValid(serie);
    } // isValid

    public ArrayList<Vehicle> getAllVehicles() throws IOException {
        return this.vehicleFile.getAllVehicles();
    }//getAllVehicles

    public boolean deleteStudent(int serie) throws IOException {
        if (!this.vehicleFile.isValid(serie)) {
            this.vehicleFile.deleteStudent(serie);
            return true;
        } else {
            return false;
        }
    }//deleteStudent
    
    public boolean updateRecord(Vehicle newDataVehicle) throws IOException {
        return this.vehicleFile.updateRecord(newDataVehicle);
    } // updateRecord
    
    public Vehicle getVehicle(int position) throws IOException{
        return this.vehicleFile.getVehicle(position);
    } // getVehicle
    
    public int getPosition(int serie) {
        return this.vehicleFile.getPosition(serie);
    } // getPosition

} // fin de la clase
