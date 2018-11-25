public class Diver {

        private static String name;
        private static int age;
        private static double sac; //SAC(Surface air consumption) is a unit of measure used to determine amount of air needed for particular dive in bars per minute
        private static int experienceLevel; //Different experience levels allow for different depths


    public static String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }

    public static double getSac() {
        return sac;
    }

    public static int getExperienceLevel() {
        return experienceLevel;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSac(double sac) {
        this.sac = sac;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }



    public Diver(String name, int age, double sac, int experienceLevel){
        this.name = name;
        this.age = age;
        this.sac = sac;
        this.experienceLevel = experienceLevel;
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
