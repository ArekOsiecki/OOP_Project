public class Diver {


        private String name;
        private int age;
        private int sac; //SAC(Surface air consumption) is a unit of measure used to determine amount of air needed for particular dive in bars per minute
        public int experienceLevel; //Different experience levels allow for different depths

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSac() {
        return sac;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSac(int sac) {
        this.sac = sac;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Diver(String name, int age, int sac, int experienceLevel){
        setName(name);
        setAge(age);
        setSac(sac);
        setExperienceLevel(experienceLevel);
    }
    public Diver(){
        new Diver("No name entered",0,0,0);
    }

    @Override
    public String toString() {
        String diverToString = "\nDiver name: "+getName()+"\nDiver age: "+getAge()+"\nDiver SAC: "+getSac()+"\nDiver experience level: "+getExperienceLevel();
        return diverToString;
    }
}
