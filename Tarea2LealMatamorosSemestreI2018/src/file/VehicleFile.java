package file;

import domain.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class VehicleFile {

    private RandomAccessFile randomAccessFile;
    private int regsQuantity;
    private int regSize;
    private String myFilePath;

    public VehicleFile(File file) throws IOException {
        this.myFilePath = file.getPath();
        this.regSize = 100;
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " is an invalid file");
        } else {
            this.randomAccessFile = new RandomAccessFile(file, "rw");
            this.regsQuantity = (int) Math.ceil((double) this.randomAccessFile.length() / (double) regSize);
        }
    } // constructor

    private void close() throws IOException {
        randomAccessFile.close();
    } // close: MUY IMPORTANTE, cerrar nuestros archivos

    public int fileSize() {
        return this.regsQuantity;
    } // fileSize: indica la cantidad de registros de nuestro archivo

    private boolean putValue(int position, Vehicle vehicle) throws IOException {
        if (!(position >= 0 && position <= this.regsQuantity)) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (vehicle.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size id out of bounds");
                return false;
            } else {
                this.randomAccessFile.seek(position * this.regSize);
                this.randomAccessFile.writeUTF(vehicle.getName());
                this.randomAccessFile.writeInt(vehicle.getYear());
                this.randomAccessFile.writeFloat(vehicle.getMileage());
                this.randomAccessFile.writeBoolean(vehicle.isAmerican());
                this.randomAccessFile.writeInt(vehicle.getSerie());
                return true;
            } // if (vehicle.sizeInBytes() > this.regSize)
        } // if (!(position >= 0 && position <= this.regsQuantity))
    } // putValue: insertar un nuevo registro en una posición específica

    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        boolean success = putValue(this.regsQuantity, vehicle);
        if (success) {
            ++this.regsQuantity;
        } // if
        return success;
    } // addEndRecord: insertar al final del archivo

    public Vehicle getVehicle(int position) throws IOException {
        if (position >= 0 && position <= this.regsQuantity) {
            this.randomAccessFile.seek(position * this.regSize);
            Vehicle tempVehicle = new Vehicle();
            tempVehicle.setName(this.randomAccessFile.readUTF());
            tempVehicle.setYear(this.randomAccessFile.readInt());
            tempVehicle.setMileage(this.randomAccessFile.readFloat());
            tempVehicle.setAmerican(this.randomAccessFile.readBoolean());
            tempVehicle.setSerie(this.randomAccessFile.readInt());

            return tempVehicle;

        } else {
            System.err.println("1003 - position is out of bouns");
            return null;
        }
    } // getVehicle: obtiene vehiculo segun posicion

    public void deleteStudent(int serie) throws IOException {
        Vehicle vehicleTemp;
        ArrayList<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < this.regsQuantity; i++) {
            vehicleTemp = this.getVehicle(i);
            if (vehicleTemp.getSerie() != serie) {
                list.add(vehicleTemp);
            }//if
        }//for
        File file = new File(myFilePath);
        file.delete();
        this.randomAccessFile = new RandomAccessFile(myFilePath, "rw");
        this.regsQuantity = 0;
        for (int i = 0; i < list.size(); i++) {
            this.addEndRecord(list.get(i));
        }//for

    } // eliminar vehicle: elimina los Vehiculos del archivo

    public ArrayList<Vehicle> getAllVehicles() throws IOException {
        ArrayList<Vehicle> vehiclesArray = new ArrayList<Vehicle>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Vehicle vehicleTemp = this.getVehicle(i);
            if (vehicleTemp != null) {
                vehiclesArray.add(vehicleTemp);
            }
        } // for
        return vehiclesArray;
    } // getAllVehicles: retorna todos los vehiculos registrados

    public boolean isValid(int serie) throws IOException {
        ArrayList<Vehicle> list = getAllVehicles();
        for (Vehicle vehicle : list) {
            if (vehicle.getSerie() == serie) {
                return false;
            }
        }
        return true;
    } // is Valid: verifica que la serie no esté repetida.

    public int getPosition(int serie) {
        int seek;
        for (int i = 0; i <= this.regsQuantity; i++) {
            try {
                seek = i * this.regSize;
                this.randomAccessFile.seek(i * this.regSize);
                Vehicle vehicle = new Vehicle();
                vehicle.setName(this.randomAccessFile.readUTF());
                vehicle.setYear(this.randomAccessFile.readInt());
                vehicle.setMileage(this.randomAccessFile.readFloat());
                vehicle.setAmerican(this.randomAccessFile.readBoolean());
                vehicle.setSerie(this.randomAccessFile.readInt());
                if (serie == vehicle.getSerie()) {
                    return i;
                } // if
            } // for
            catch (IOException ex) {
                return -1;
            }
        }
        return -1;
    } // getPosition: retorna posicion de registro según serie

    public boolean updateRecord(Vehicle newDataVehicle) throws IOException {
        return putValue(getPosition(newDataVehicle.getSerie()), newDataVehicle);
    } // updateRecord: actualiza registro

} // fin de la clase
