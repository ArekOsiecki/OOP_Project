//Device used by experienced divers that requires different calculations of required composition of breathing gas

import java.io.Serializable;

public class Rebreather extends BreathingDevice implements Serializable {


    private static boolean isClosedCircuit;
    private static int filterUnitCapacity;
    private static int tanks;
    private static int size;

    public static boolean isClosedCircuit() {
        return isClosedCircuit;
    }

    public static int getFilterUnit() {
        return filterUnitCapacity;
    }

    public static int getTanks() {
        return tanks;
    }

    public static int getSize() {
        return size;
    }

    public void setTanks(int tanks) {
        this.tanks = tanks;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setClosedCircuit(boolean closedCircuit) {
        this.isClosedCircuit = closedCircuit;
    }

    public void setFilterUnit(int filterUnit) {
        this.filterUnitCapacity = filterUnit;
    }


    public Rebreather(int deviceTanks, int deviceSize, int filterUnitCapacity, boolean isClosedCircuit){
        super(deviceTanks,deviceSize);
        setClosedCircuit(true);
        this.filterUnitCapacity = filterUnitCapacity;

    }

    public String toString(){
        String rebreatherToString = "\nTanks: "+getTanks()+"\nVolume of tanks: "+getSize()+"\nFilter capacity: "+getFilterUnit()+" minutes";
        return rebreatherToString;
    }
}
