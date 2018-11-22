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


        String[] choices = {"Open Water Diver", "Advanced Diver", "Divemaster"};
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
                while (!valid){
                    if (nameText.getText().isEmpty() || sacText.getText().isEmpty() || ageText.getText().isEmpty()) {
                        throw new RuntimeException("All fields must be entered");
                    } else {
                        for (char c : nameText.getText().toCharArray()) {
                            System.out.println("You must use only letters to enter name");
                            if (!Character.isLetter(c)) {
                                throw new RuntimeException("You must use only letters to enter name");
                            }
                                for (char d : ageText.getText().toCharArray())
                                    if (!Character.isDigit(d)) {
                                        System.out.println("You must use numbers to enter age");
                                        throw new RuntimeException("You must use numbers to enter age");
                                    }
                                        if ((Integer.parseInt(ageText.getText()) < 5 || (Integer.parseInt(ageText.getText()) > 85))) {
                                            System.out.println("Age is " + (Integer.parseInt(ageText.getText()) + " and should be more than 6 and less than 85"));
                                            throw new RuntimeException("Age is " + (Integer.parseInt(ageText.getText()) + " and should be more than 6 and less than 85"));
                                        }
                                            for (char b : sacText.getText().toCharArray())
                                                if (!Character.isDigit(b)) {
                                                    System.out.println("You must use numbers to enter SAC");
                                                    throw new RuntimeException("You must use numbers to enter SAC");
                                                }
                                                    System.out.println("koniec");
                                                    valid = true;
                                                }
                                        }
                                    }





            } catch (RuntimeException myException) {
                JOptionPane.showMessageDialog(profileFrame, myException.getMessage(), "Incorrect input!", JOptionPane.WARNING_MESSAGE);

            }
            if (valid == true) {

                diverName = nameText.getText();
                diverAge = Integer.parseInt(ageText.getText());
                diverSac = Integer.parseInt(sacText.getText());
                diverExp = profileDropDown.getSelectedIndex();

                Diver profile = new Diver(diverName, diverAge, diverSac, diverExp);

                JOptionPane.showMessageDialog(profileFrame, "Profile created", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(profileFrame, "Profile creation canceled", "Canceled", JOptionPane.WARNING_MESSAGE);
            profileFrame.setVisible(false);//disposing of current frame

        });//adding action listeners to buttons using lambda statements


    }
}

