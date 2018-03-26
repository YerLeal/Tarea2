/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yer
 */
public class VehicleFileTest {

    VehicleFile vehicleFile;
    File file;

    public VehicleFileTest() throws IOException {
        this.file = new File("vehicle.dat");
        this.vehicleFile = new VehicleFile(file);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //@Test
    public void addNewVehicle() throws IOException {
        Vehicle v = new Vehicle("Cadillac", 2010, 100, true, 123);
        vehicleFile.addEndRecord(v);
    }

    @Test
    public void allVehicles() throws IOException {
        ArrayList<Vehicle> vehicles = vehicleFile.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    //@Test
    public void isAmerican() throws IOException {
        System.out.println(vehicleFile.isValid(1));
    }

   @Test
    public void deleteVehicleFile() throws IOException {
        vehicleFile.deleteStudent(123);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
