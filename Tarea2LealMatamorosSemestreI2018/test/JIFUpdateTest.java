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

public class JIFUpdateTest {

    VehicleBusiness vehicleBusiness;
    
    public JIFUpdateTest() throws IOException {
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
    public void orderList() throws IOException{
        ArrayList<Vehicle> list = vehicleBusiness.getAllVehicles();
        
        Vehicle temp;
        for(int i=0; i<list.size(); i++){
            for(int j=i; j<list.size(); j++){
                if(list.get(i).getSerie()>list.get(j).getSerie()){
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        
        for (Vehicle vehicle : list) {
            System.out.println(vehicle.getSerie());
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
