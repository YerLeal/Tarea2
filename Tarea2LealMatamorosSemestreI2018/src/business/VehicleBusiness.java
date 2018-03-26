package business;

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;

public class VehicleBusiness {

    private VehicleFile vehicleFile;

    public VehicleBusiness(File file) throws IOException {
        this.vehicleFile = new VehicleFile(file);
    }

    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        return this.vehicleFile.addEndRecord(vehicle);
    } // addEndRecord

    public boolean isValid(int serie) throws IOException {
        return this.vehicleFile.isValid(serie);
    }

} // fin de la clase
