package domain;

public class Vehicle {

    private String name;
    private int year;
    private float mileage;
    private boolean american;
    private int serie;

    public Vehicle() {
        this.name = "";
        this.year = -1;
        this.mileage = -1;
        this.american = false;
        this.serie = -1;
    } // constructor

    public Vehicle(String name, int year, float mileage, boolean american, int serie) {
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.american = american;
        this.serie = serie;
    } // constructor sobrecargado

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public boolean isAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    public String getAmerican(){
        if(this.american){
            return "Sí";
        }else{
            return "No";
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" + "serie=" + serie + ", name=" + name + ", year=" + year + ", mileage=" + mileage + ", american=" + american + '}';
    }
    
    public int sizeInBytes(){
        //long: necesita 2 bytes
        //String: necesita 2 bytes de escpacio
        return  this.name.length() * 2 + 4 + 4 + 1 + 4 ; // boolean
        
        // name (20 caracteres maximo)
        // year (int:32 bits, 4bytes)
        // mileage (float: 32bits, 4 bytes))
        // american (boolean)
        // serie (int: 32bits, 4 bytes)
    } // size

} // fin de la clase
