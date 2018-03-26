/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author maikel
 */
public class vehicleBusiness {
    private File file=new File("vehicle.dat");
    private VehicleFile vehicleFile;
    
    public vehicleBusiness() throws IOException{
        this.vehicleFile=new VehicleFile(file);
    }
    
    public ArrayList<Vehicle> getAllVehicles() throws IOException {
        ArrayList<Vehicle> list=this.vehicleFile.getAllVehicles();
        return list;
        
    }
    public boolean deleteStudent(int serie) throws IOException {
        if(!this.vehicleFile.isValid(serie)){
            this.vehicleFile.deleteStudent(serie);
            return true;
        }else{
            return false;
        }
    }
}
