import org.w3c.dom.ranges.RangeException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.IllegalFormatException;


public class ProfileFrame {

    String divePlace, diveDate, nameU, diverName, diverAgeText, diverSacText;
    int diverAge, diverSac, diverExp, diveDepth, diveLength, deviceTanks, deviceSize, deviceFilter;
    boolean isReabreather; //Attributes for classes
    JMenuBar guiMenuBar = new JMenuBar();


    public static void main(String[] args) {
        new ProfileFrame();
    }


    public ProfileFrame() {
        JFrame profileFrame = new JFrame("Create Profile");
        GridLayout profileFrameLayout = new GridLayout(0, 1);
        profileFrame.setLayout(profileFrameLayout);
        profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JMenu profileGridMenu = new JMenu("Profile Menu");
        profileGridMenu.setVisible(true);


        JTextField nameText = new JTextField(20);
        nameText.setBorder(BorderFactory.createTitledBorder("Enter name"));
        //diverName = nameText.getText();


        JTextField ageText = new JTextField(20);
        ageText.setBorder(BorderFactory.createTitledBorder("Enter age"));
        //diverAgeText = ageText.getText();


        JTextField sacText = new JTextField(20);
        sacText.setBorder(BorderFactory.createTitledBorder("Enter SAC"));
        //diverSacText = sacText.getText();//Creating fields for user input and corresponding labels, assigning attributes to input


        String[] choices = {"Junior Open Water Diver","Open Water Diver", "Advanced Diver", "Divemaster"};
        final JComboBox<String> profileDropDown = new JComboBox<>(choices);
        profileDropDown.setBorder(BorderFactory.createTitledBorder("Experience level"));
        profileDropDown.setVisible(true);
        profileDropDown.setEditable(false);
        //diverExp = profileDropDown.getSelectedIndex();//Creating drop down list, setting it to be uneditable by user and retrieving input


        //add exceptions to methods
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout buttonsLayout = new GridLayout(0, 2, 25, 0);
        buttonsPanel.setLayout(buttonsLayout);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        profileFrame.setJMenuBar(guiMenuBar);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);
        profileFrame.add(nameText);
        profileFrame.add(ageText);
        profileFrame.add(sacText);
        profileFrame.add(profileDropDown);
        profileFrame.add(buttonsPanel);
        //adding components to layout


        profileFrame.setLocationRelativeTo(guiMenuBar);
        profileFrame.setVisible(true);
        profileFrame.setSize(320, 640);//adding menu bar to frame, setting visibility and size


        confirmButton.addActionListener(e -> {
            boolean valid = false;


                try {
                    while(!valid) {

                        validateName(nameText.getText());
                        validateNumber(ageText.getText());
                        validateAgeRange(ageText.getText());
                        validateNumber(sacText.getText());
                        validateSacRange(sacText.getText());
                        validateExperience(profileDropDown.getSelectedIndex(),Integer.parseInt(ageText.getText()));

                            diverName = nameText.getText();
                            diverAge = Integer.parseInt(ageText.getText());
                            diverSac = Integer.parseInt(sacText.getText());
                            diverExp = profileDropDown.getSelectedIndex();

                        valid = true;

                        Diver diver = new Diver(diverName, diverAge, diverSac, diverExp);
                        JOptionPane.showMessageDialog(profileFrame, "Profile created"+diver.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (RuntimeException f) {
                    JOptionPane.showMessageDialog(profileFrame, f.getMessage(), "Incorrect input!", JOptionPane.WARNING_MESSAGE);
                }
            }
        );

        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(profileFrame, "Leaving profile creation", "Canceled", JOptionPane.WARNING_MESSAGE);
            profileFrame.setVisible(false);
            new DivingGUI();//disposing of current frame

        });//adding action listeners to buttons using lambda statements


    }

    public String validateName(String diverName) throws RuntimeException{

        boolean valid = false;
        String nameToValidate = diverName;
        for (char c : nameToValidate.toCharArray()) {
            System.out.println("1");
            if (!Character.isLetter(c)){
                throw new RuntimeException("You must use only letters to enter name while you used "+nameToValidate+"");

            }
            else{
                valid = true;
            }
        }
        return nameToValidate;
    }
    public boolean validateNumber(String number) throws RuntimeException {

        boolean valid = false;
        String numberToValidate = number;
        int validatedNumber;
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
    public boolean validateAgeRange(String diverAgeText) throws RuntimeException{

        boolean valid = false;
        int ageRangeToValidate = Integer.parseInt(diverAgeText);
        if(ageRangeToValidate < 10 || ageRangeToValidate > 85) {
            System.out.println("3");
            throw new RuntimeException("Age is " + ageRangeToValidate +" and should be more than 6 and less than 85");
        }else{
            valid = true;
        }

    return valid;
}
    public boolean validateSacRange(String diverSacText) throws RuntimeException{

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
    public boolean validateExperience(int level, int age) throws RuntimeException{
        boolean valid;
        int levelToValidate = level;
        int ageToValidate = age;
        if(levelToValidate == 3 && ageToValidate<18){
            throw new RuntimeException("You need to be at least 18 years old to become a Divemaster!");
        }else if(levelToValidate == 2 && ageToValidate<12){
            throw new RuntimeException("You need to be at least 12 years old to hold Advanced Certificate!");
        }else if(levelToValidate == 1 && ageToValidate<10){
            throw new RuntimeException("You need to be at least 10 years old to become a Open Water Diver!");
        }else if(levelToValidate == 0 && ageToValidate>15){
            throw new RuntimeException("You should upgrade your certificate!");
        }else{
            valid = true;
        }
        return valid;

    }
}

