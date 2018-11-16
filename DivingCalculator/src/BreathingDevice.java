public class BreathingDevice {
    private int tanks;
    private int size; //Volume of tanks in liters

    public int getTanks() {
        return tanks;
    }

    public int getSize() {
        return size;
    }

    public void setTanks(int type) {
        this.tanks = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BreathingDevice(int tanks, int size){
        setTanks(tanks);
        setSize(size);

    }

    public BreathingDevice(){
        new BreathingDevice(0,0);
    }

    public String toString(){
        String bdToString = "Number of tanks :" +getTanks()+"\nFull volume "+getSize();
        return bdToString;

    }




}
