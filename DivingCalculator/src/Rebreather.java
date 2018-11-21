//Device used by experienced divers that requires different calculations of required composition of breathing gas

public class Rebreather extends BreathingDevice{


    private boolean isClosedCircuit;
    private int filterUnitCapacity;

    public boolean isClosedCircuit() {
        return isClosedCircuit;
    }

    public int getFilterUnit() {
        return filterUnitCapacity;
    }


    public void setClosedCircuit(boolean closedCircuit) {
        isClosedCircuit = closedCircuit;
    }

    public void setFilterUnit(int filterUnit) {
        this.filterUnitCapacity = filterUnit;
    }


    public Rebreather(int tanks, int size, int filerUnit,boolean isClosedCircuit){
        super(tanks = 2, size = 3);
        setFilterUnit(180);
        setClosedCircuit(true);

    }
    public String toString(){
        String rebreatherToString = "Tanks: "+getTanks()+"\nVolume of tanks: "+getSize()+"\nFilter capacity: "+getFilterUnit()+" minutes";
        return rebreatherToString;
    }
}
