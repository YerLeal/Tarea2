
import business.VehicleBusiness;
import domain.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleFileTest {

    VehicleBusiness vehicleBusiness;

    public VehicleFileTest() throws IOException {
        vehicleBusiness = new VehicleBusiness();
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
    public void addNewVehicle() throws IOException{
        vehicleBusiness.addEndRecord(new Vehicle("Prueba", 1, 2, true, 99));
    }
    
    //@Test
    public void allVehicles() throws IOException {
        ArrayList<Vehicle> list = vehicleBusiness.getAllVehicles();
        for (Vehicle vehicle : list) {
            System.out.println(vehicle.toString());
        }
    } // allVehicles

    //@Test
    public void getPosition() throws IOException {
        ArrayList<Vehicle> list = vehicleBusiness.getAllVehicles();
        for (Vehicle vehicle : list) {
            System.out.println(vehicleBusiness.getPosition(vehicle.getSerie()));
        }
    }//getPosition

    //@Test
    public void getVehicleSerie() throws IOException {
        System.out.println(vehicleBusiness.getVehicle(vehicleBusiness.getPosition(288)));
    }

    //@Test
    public void updateVehicle() throws IOException {
        Vehicle vehicle = vehicleBusiness.getVehicle(vehicleBusiness.getPosition(99));
        
        System.out.println("Registro anterior:" + vehicle.toString());
        
        vehicle.setName("PruebaActualizada");
        
        vehicleBusiness.updateRecord(vehicle);
        
        System.out.println("Registro nuevo:" + vehicleBusiness.getVehicle(vehicleBusiness.getPosition(99)));
    } // updateVehicle

} // fin de la clase
