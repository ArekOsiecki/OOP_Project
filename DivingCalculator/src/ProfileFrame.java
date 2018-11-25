

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ProfileFrame extends JFrame implements ActionListener {


    JFrame profileFrame;
    JMenuBar guiMenuBar = new JMenuBar();
    JMenu diveMenu = new JMenu("Dive Menu");
    JMenuItem createProfile = new JMenuItem("Create Profile");
    JMenuItem planDive = new JMenuItem("Plan dive");
    JMenuItem showDiveLog = new JMenuItem("Show dive log");
    JMenuItem planAnotherDive = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
    JTextArea logArea,RDPArea; //Text areas

    String diverName;
    int diverAge, diverSac, diverExp; //Attributes for class
    Diver diver;




    public static void main(String[] args) {
        new ProfileFrame();

    }


    ProfileFrame() {

            profileFrame = new JFrame("Create Profile");
            profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method


        diveMenu.add(planDive);
        planDive.addActionListener(this);


        diveMenu.add(planAnotherDive);
        planAnotherDive.addActionListener(this);

        diveMenu.add(showDiveLog);
        showDiveLog.addActionListener(this);


            guiMenuBar.add(diveMenu);
            //adding menus to bar

        profileFrame.setJMenuBar(guiMenuBar);

        profileFrame.setSize(320,640);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
        profileFrame.setFocusable(true);//adding menu bar to frame, setting visibility and size

        GridLayout profileFrameLayout = new GridLayout(0, 1);
        profileFrame.setLayout(profileFrameLayout);

        JMenu profileGridMenu = new JMenu("Profile Menu");
        profileGridMenu.setVisible(true);


        JTextField nameText = new JTextField(20);//Creating fields for user input and corresponding labels
        nameText.setBorder(BorderFactory.createTitledBorder("Enter name"));


        JTextField ageText = new JTextField(20);
        ageText.setBorder(BorderFactory.createTitledBorder("Enter age"));

        JTextField sacText = new JTextField(20);
        sacText.setBorder(BorderFactory.createTitledBorder("Enter SAC in liters per minute"));

        String[] choices = {"Junior Open Water Diver","Open Water Diver", "Advanced Diver", "Divemaster"};//Creating drop down list and setting it to be uneditable by user
        final JComboBox<String> profileDropDown = new JComboBox<>(choices);
        profileDropDown.setBorder(BorderFactory.createTitledBorder("Experience level"));
        profileDropDown.setVisible(true);
        profileDropDown.setEditable(false);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout buttonsLayout = new GridLayout(0, 2, 25, 0);
        buttonsPanel.setLayout(buttonsLayout);

        JButton confirmButton = new JButton("Confirm");//adding components to layout
        JButton cancelButton = new JButton("Cancel");
        profileFrame.setJMenuBar(guiMenuBar);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);
        profileFrame.add(nameText);
        profileFrame.add(ageText);
        profileFrame.add(sacText);
        profileFrame.add(profileDropDown);
        profileFrame.add(buttonsPanel);

        //adding menu bar to frame, setting visibility and size
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
        profileFrame.setSize(320, 640);


        confirmButton.addActionListener(e -> {  //adding action listeners to buttons using lambda statements

            boolean valid = false;

                try {
                    while(!valid) {


                        DiveDriver.validateText(nameText.getText());
                        DiveDriver.validateNumber(ageText.getText());
                        DiveDriver.validateAgeRange(ageText.getText());
                        DiveDriver.validateNumber(sacText.getText());
                        DiveDriver.validateSacRange(sacText.getText());
                        DiveDriver.validateExperience(profileDropDown.getSelectedIndex(),Integer.parseInt(ageText.getText()));

                            diverName = nameText.getText();
                            diverAge = Integer.parseInt(ageText.getText());
                            diverSac = Integer.parseInt(sacText.getText());
                            diverExp = profileDropDown.getSelectedIndex();

                        valid = true;


                        diver = new Diver(diverName,diverAge,diverSac,diverExp);

                        JOptionPane.showMessageDialog(null, "Profile created"+diver.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);

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

        });


    }

    public void actionPerformed(ActionEvent actionEvent) {


        if(actionEvent.getSource()==planDive){

            new DiveFrame();
            profileFrame.dispose();


        }
        if (actionEvent.getSource() == showDiveLog) {

            new LogFrame();
            profileFrame.dispose();

        }
        if (actionEvent.getSource() == planAnotherDive) {

            new RdpFrame();
            profileFrame.dispose();

        }



    }
}

