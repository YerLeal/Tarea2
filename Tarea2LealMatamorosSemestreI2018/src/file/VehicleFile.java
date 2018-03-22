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
    } // MUY IMPORTANTE, cerrar nuestros archivos

    public int fileSize() {
        return this.regsQuantity;
    } // indica la cantidad de registros de nuestro archivo

    public boolean putValue(int position, Vehicle vehicle) throws IOException {
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
    } // insertar un nuevo registro en una posición específica

    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        boolean success = putValue(this.regsQuantity, vehicle);
        if (success) {
            ++this.regsQuantity;
        } // if
        return success;
    } // insertar al final del archivo

    public Vehicle getVehicle(int position) throws IOException {
        if (position >= 0 && position <= this.regsQuantity) {
            this.randomAccessFile.seek(position * this.regSize);
            Vehicle tempVehicle = new Vehicle();
            tempVehicle.setName(this.randomAccessFile.readUTF());
            tempVehicle.setYear(this.randomAccessFile.readInt());
            tempVehicle.setMileage(this.randomAccessFile.readFloat());
            tempVehicle.setAmerican(this.randomAccessFile.readBoolean());
            tempVehicle.setSerie(this.randomAccessFile.readInt());

            if (tempVehicle.getSerie() == -1) {
                return null;
            } else {
                return tempVehicle;
            }
        } else {
            System.err.println("1003 - position is out of bouns");
            return null;
        }
    } // obtener un vehículo

    public boolean deleteStudent(int serie) throws IOException {
        Vehicle vehicle;
        for (int i = 0; i < this.regsQuantity; i++) {
            vehicle = this.getVehicle(i);
            if (vehicle.getSerie() == serie) {
                vehicle.setSerie(-1);
                return this.putValue(i, vehicle);
            }
        }
        return false;
    } // eliminar vehicle

    public ArrayList<Vehicle> getAllVehicles() throws IOException {
        ArrayList<Vehicle> vehiclesArray = new ArrayList<Vehicle>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Vehicle vehicleTemp = this.getVehicle(i);
            if (vehicleTemp != null) {
                vehiclesArray.add(vehicleTemp);
            }
        } // for
        return vehiclesArray;
    } // getAllVehicles
    
} // fin de la clase
