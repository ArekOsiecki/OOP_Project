public class Dive {

    private String place;
    private String date;
    private double depth;
    private double length;
    private static Diver diver;
    private BreathingDevice breathingDevice;

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public double getDepth() {
        return depth;
    }

    public double getLength() {
        return length;
    }

    public static Diver getDiver() {
        return diver;
    }

    public BreathingDevice getBreathingDevice() {
        return breathingDevice;
    }


    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDiver(Diver diver) {
        this.diver = diver;
    }

    public void setBreathingDevice(BreathingDevice breathingDevice) {
        this.breathingDevice = breathingDevice;
    }

    public Dive(String place, String date, double depth, double length,Diver diver,BreathingDevice breathingDevice){
        this.place = place;
        this.date = date;
        this.depth = depth;
        this.length = length;
        this.diver = diver;
        this.breathingDevice = breathingDevice;

    }
    public Dive(){
        new Dive("No place entered","No date entered",0,0,getDiver(),getBreathingDevice());

    }

}
