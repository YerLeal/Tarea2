package business;

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleBusiness {
    private File file=new File("vehicle.dat");
    private VehicleFile vehicleFile;    

    public VehicleBusiness() throws IOException {
        this.vehicleFile = new VehicleFile(file);
    }

    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        return this.vehicleFile.addEndRecord(vehicle);
    } // addEndRecord

    public boolean isValid(int serie) throws IOException {
        return this.vehicleFile.isValid(serie);
    }

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

} // fin de la clase
