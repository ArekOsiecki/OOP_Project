public class BreathingDevice {

    private double tanks;
    private double size; //Volume of tanks in liters

    public double getTanks() {
        return tanks;
    }

    public double getSize() {
        return size;
    }

    public void setTanks(double tanks) {
        this.tanks = tanks;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BreathingDevice(double tanks, double size){
        setTanks(tanks);
        setSize(size);

    }

    public BreathingDevice(){
        new BreathingDevice(0,0);
    }

    public String toString(){
        String bdToString = "Number of tanks :" +getTanks()+"\nAir volume : "+getSize();
        return bdToString;

    }




}
