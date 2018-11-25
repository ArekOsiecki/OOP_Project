import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiveDriver{


    public static void main(String[]args){



    }

    public static String validateText(String text) throws RuntimeException{ //creating validation methods


        String textToValidate = text;
        for (char c : textToValidate.toCharArray()) {
            System.out.println("1");
            if (!Character.isLetter(c)){
                throw new RuntimeException("You must use only letters to enter name while you used "+textToValidate+"");

            }

        }
        return textToValidate;
    }
    public static boolean validateNumber(String number) throws RuntimeException {

        boolean valid = false;
        String numberToValidate = number;

        while (!valid) {
            for (char c : numberToValidate.toCharArray()) {
                System.out.println("2");
                if (!Character.isDigit(c)) {
                    throw new RuntimeException("You must use numbers for input while you used " + numberToValidate + "");

                } else {

                    valid = true;
                }
            }
        }

        return valid;
    }
    public static boolean validateAgeRange(String diverAgeText) throws RuntimeException{

        boolean valid;
        int ageRangeToValidate = Integer.parseInt(diverAgeText);
        if(ageRangeToValidate < 10 || ageRangeToValidate > 85) {
            System.out.println("3");
            throw new RuntimeException("Age is " + ageRangeToValidate +" and should be more than 6 and less than 85");
        }else{
            valid = true;
        }

        return valid;
    }
    public static boolean validateSacRange(String diverSacText) throws RuntimeException{

        boolean valid;
        int sacRangeToValidate = Integer.parseInt(diverSacText);

        if(sacRangeToValidate < 10 || sacRangeToValidate > 25) {
            System.out.println("4");
            throw new RuntimeException("SAC is " + sacRangeToValidate+ " and should be more than 10 and less than 25");
        }else{
            valid = true;
        }

        return valid;
    }
    public static boolean validateExperience(int level, double age) throws RuntimeException{
        boolean valid;

        if(level == 3 && age<18){
            throw new RuntimeException("You need to be at least 18 years old to become a Divemaster!");
        }else if(level == 2 && age<12){
            throw new RuntimeException("You need to be at least 12 years old to hold Advanced Certificate!");
        }else if(level == 1 && age<10){
            throw new RuntimeException("You need to be at least 10 years old to become a Open Water Diver!");
        }else if(level == 0 && age>15){
            throw new RuntimeException("You should upgrade your certificate!");
        }else{
            valid = true;
        }
        return valid;

    }

    public static double validateDepth(String depth,int exp) throws RuntimeException {


        double depthToValidate = Double.parseDouble(depth);
        double validatedDepth;


        if (depthToValidate > 40) {

            validatedDepth = 42;

        } else if (depthToValidate < 40 && depthToValidate > 34) {

            validatedDepth = 40;

        } else if (depthToValidate < 35 && depthToValidate > 29) {

            validatedDepth = 35;

        } else if (depthToValidate < 30 && depthToValidate >24) {

            validatedDepth = 30;

        } else if (depthToValidate < 25 && depthToValidate > 21) {

            validatedDepth = 25;

        } else if (depthToValidate < 22 && depthToValidate > 19) {

            validatedDepth = 22;

        } else if (depthToValidate < 20 && depthToValidate > 17) {

            validatedDepth = 20;

        } else if (depthToValidate < 18 && depthToValidate > 15) {

            validatedDepth = 18;

        } else if (depthToValidate < 16 && depthToValidate > 13) {

            validatedDepth = 16;

        } else if (depthToValidate < 14 && depthToValidate > 11) {

            validatedDepth = 14;

        } else if (depthToValidate < 12 && depthToValidate > 9) {

            validatedDepth = 12;

        } else {
            validatedDepth = 10;
        }
        System.out.println(validatedDepth);

        if (validatedDepth > 13 && exp<= 1) {
            throw new RuntimeException("You need to hold Advanced Certificate to dive below 13 meters deep!");
        } else if (validatedDepth > 30 && exp <= 2) {
            throw new RuntimeException("You need to be a Divemaster to dive below 30 meters deep!");
        }else if (validatedDepth == 42) {
            throw new RuntimeException("You should never dive that deep!");
        } else {
            return validatedDepth;
        }
    }
    public static boolean validateLength(String depth,String length) throws RuntimeException{

        boolean valid;
        int depthToValidate = Integer.parseInt(depth);
        int lengthToValidate = Integer.parseInt(length);
        if(depthToValidate == 42 && lengthToValidate > 7 || depthToValidate == 40 && lengthToValidate > 8 ||
                depthToValidate == 35 && lengthToValidate > 13 || depthToValidate == 30 && lengthToValidate > 19 ||
                depthToValidate == 25 && lengthToValidate > 28 || depthToValidate == 22 && lengthToValidate > 36 ||
                depthToValidate == 20 && lengthToValidate > 45 || depthToValidate == 18 && lengthToValidate > 55 ||
                depthToValidate == 16 && lengthToValidate > 71 || depthToValidate == 14 && lengthToValidate > 97 ||
                depthToValidate == 12 && lengthToValidate > 146
                || depthToValidate == 10 && lengthToValidate > 217  ) {
            System.out.println("4");
            throw new RuntimeException("That dive will require decompression! Do not plan recreational dives in this range!");
        }else{
            valid = true;
        }

        return valid;
    }
    public  static boolean validateBreathingDevice(int device, int exp) throws RuntimeException{

        boolean valid;

        if(device == 1 && exp<=1){
            throw new RuntimeException("You need to hold Advanced Certificate in order to use Rebreather!!");

        }else{
            valid = true;
        }
        return valid;

    }

    public static String rebreatherDive (double depth, double length, int filter) throws RuntimeException{


        double nitroxCalc = ((((depth)/10)+1)*1.4)*10;
        String nitroxTimeDepth;

        if (filter>length){

            throw new RuntimeException("You have entered "+length+" , while your filter have capacity of "+filter+" in minutes!");

        }else {
            nitroxTimeDepth = String.format("For your planned maximum depth your breathing mixture should contain " + nitroxCalc + "% nitrox" +
                    "\n You can dive up to 3 hours" +
                    "\n You can dive again after completing post-dive and pre-dive procedures on surface","%.2d");
        }
        return nitroxTimeDepth;
    }

    public  static double airVolume (double depth,double length, double sac) {



        double air = (depth/10)+1;
        double volume = sac*length;
        return air*volume;


    }

    public static double tanksNeeded (double size){

        double tankSize = 14;
        double firstPart = size/tankSize;
        double secondPart = (firstPart/10)+5;
        return Math.round(secondPart*10);

    }


}


