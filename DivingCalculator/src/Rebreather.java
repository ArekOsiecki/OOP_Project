public class Rebreather extends BreathingDevice{

    //private boolean isRebreather; //Device used by experienced divers that requires different calculations of required composition of breathing gas
    private int filterUnitCapacity;



    public int getFilterUnit() {
        return filterUnitCapacity;
    }


    public void setFilterUnit(int filterUnit) {
        this.filterUnitCapacity = filterUnit;
    }

    public Rebreather(int tanks, int size, boolean isRebreather){
        super(tanks = 2, size = 3);
        setFilterUnit(3);

    }
    public String toString(){
        String rebreatherToString = "Tanks: "+getTanks()+"\nVolume of tanks: "+getSize()+"\nFilter capacity: "+getFilterUnit()+" hours";
        return rebreatherToString;
    }
}
