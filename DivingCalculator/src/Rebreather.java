public class Rebreather extends BreathingDevice{

    private boolean isRebreather; //Device used by experienced divers that requires different calculations of required composition of breathing gas
    private int filterUnit;


    public boolean isRebreather() {
        return isRebreather;
    }

    public int getFilterUnit() {
        return filterUnit;
    }

    public void setRebreather(boolean isRebreather) {
        isRebreather = true;
    }

    public void setFilterUnit(int filterUnit) {
        this.filterUnit = filterUnit;
    }

    public Rebreather(int tanks, int size, boolean isRebreather){
        super(tanks = 2, size = 3);
        setRebreather(true);
        setFilterUnit(3);

    }
    public String toString(){
        String rebreatherToString = "Tanks: "+getTanks()+"\nVolume of tanks: "+getSize()+"\nFilter capacity: "+getFilterUnit()+" hours";
        return rebreatherToString;
    }
}
