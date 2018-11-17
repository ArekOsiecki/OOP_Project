public class Dive {
    public String place;
    public String date;
    public int depth;
    public int length;
    public Diver diver;

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public int getDepth() {
        return depth;
    }

    public int getLength() {
        return length;
    }


    public Diver getDiver() {
        return diver;
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

    public Dive(String place, String date, int depth, int length,String name, int age, int sac, int experienceLevel){
        setPlace(place);
        setDate(date);
        setDepth(depth);
        setLength(length);
        setDiver(new Diver(name,age,sac,experienceLevel));
    }
    public Dive(){
        new Dive("No place entered","No date entered",0,0,"No name entered",0,0,0);

    }

}
