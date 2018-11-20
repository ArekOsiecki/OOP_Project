/*This program is a simple diving calculator/logbook. It allows user to create and update profile and enter data about a planned dive.
* Program also contains features allowing to calculate amount of air needed for the dive,
 * alerts about maximum dive time and surface interval for absolute safe second dive
 * and nitrox composition if using rebreathing open-circuit device.
 * Recreational diving table is included and viewable for more precise planning.
  * Program also creates the dive log that can be viewed.*/

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.IllegalFormatException;

import static java.lang.System.exit;

public class DivingGUI implements ActionListener{ //This contains global references, buttons and text fields creation code


        JMenuBar guiMenuBar = new JMenuBar();
        JMenu profileMenu = new JMenu("Profile");
        JMenu diveMenu = new JMenu("Dive Menu");
        JMenu rdpMenu = new JMenu("Check Deco Table");
        JMenuItem createProfile = new JMenuItem("Create Profile");
        JMenuItem updateProfile = new JMenuItem("Update Profile");
        JMenuItem planDive = new JMenuItem("Plan dive");
        JMenuItem showDiveLog = new JMenuItem("Show dive log");
        JMenuItem showRDP = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
        JTextArea logArea,RDPArea; //Text areas
        String divePlace, diveDate, diverName,diverAgeText,diverSacText;
        int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
        boolean isReabreather; //Attributes for classes


    public DivingGUI() { //Code for GUI creation

        JFrame guiFrame = new JFrame("Dive Planner");
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        profileMenu.add(createProfile);
        createProfile.addActionListener(this);//adding items to menus and registering listeners

        profileMenu.add(updateProfile);
        updateProfile.addActionListener(this);

        diveMenu.add(planDive);
        planDive.addActionListener(this);

        diveMenu.add(showDiveLog);
        showDiveLog.addActionListener(this);

        rdpMenu.add(showRDP);
        showRDP.addActionListener(this);

        guiMenuBar.add(profileMenu);
        guiMenuBar.add(diveMenu);
        guiMenuBar.add(rdpMenu);//adding menus to bar



        guiFrame.setJMenuBar(guiMenuBar);

        guiFrame.setSize(320,640);
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true); //adding menu bar to frame, setting visibility and size
    }


    public static void main(String args[]){

        DivingGUI divingApp= new DivingGUI(); //GUI instantiation

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource()==createProfile){

            JFrame profileFrame = new JFrame("Create Profile");
            GridLayout profileFrameLayout = new GridLayout(0,1);
            profileFrame.setLayout(profileFrameLayout);
            profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


            JMenu profileGridMenu = new JMenu("Profile Menu");
            profileGridMenu.setVisible(true);


            JTextField nameText = new JTextField(20);
            nameText.setBorder(BorderFactory.createTitledBorder("Enter name"));


            JTextField ageText = new JTextField(20);
            ageText.setBorder(BorderFactory.createTitledBorder("Enter age"));
            diverAgeText = ageText.getText();


            JTextField sacText = new JTextField(20);
            sacText.setBorder(BorderFactory.createTitledBorder("Enter SAC"));
            diverSacText = sacText.getText();//Creating fields for user input and corresponding labels, assigning attributes to input

            String [] choices = {"Open Water Diver","Advanced Diver","Divemaster"};
            final JComboBox<String> profileDropDown = new JComboBox<>(choices);
            profileDropDown.setBorder(BorderFactory.createTitledBorder("Experience level"));
            profileDropDown.setVisible(true);
            profileDropDown.setEditable(false);
            //Creating drop down list, setting it to be uneditable by user and retrieving input


            //add exceptions to methods, change buttons and textbox layout
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBorder(new EmptyBorder(15,15,15,15));
            GridLayout buttonsLayout = new GridLayout(0,2,25,0);
            buttonsPanel.setLayout(buttonsLayout);

            JButton confirmButton = new JButton("Confirm");
            JButton cancelButton = new JButton("Cancel");


            confirmButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Profile created","Success",JOptionPane.INFORMATION_MESSAGE);
                diverSac = Integer.parseInt(diverSacText);
                diverAge = Integer.parseInt(diverAgeText);
                diverExp = profileDropDown.getSelectedIndex();
                Diver profile = new Diver (diverName,diverAge,diverSac,diverExp);
            });

            cancelButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Profile creation canceled","Canceled",JOptionPane.WARNING_MESSAGE);
                //profileFrame.setVisible(false);//disposing of current frame
                //profileFrame.setDefaultCloseOperation((actionPerformed((int)e.getSource() ==cancelButton);

            });//adding action listeners to buttons using lambda statements

            buttonsPanel.add(confirmButton);
            buttonsPanel.add(cancelButton);

            profileFrame.add(nameText);
            profileFrame.add(ageText);
            profileFrame.add(sacText);
            profileFrame.add(profileDropDown);
            profileFrame.add(buttonsPanel);//adding components to layout


            profileFrame.setLocationRelativeTo(null);
            //how to make every frame appear exactly in the middle of the screen?
            profileFrame.setVisible(true);
            profileFrame.setSize(320,640);//adding menu bar to frame, setting visibility and size


        }
        if(actionEvent.getSource()==updateProfile){

        }
        if(actionEvent.getSource()==planDive){

        }
        if(actionEvent.getSource()==showDiveLog){

        }
        if(actionEvent.getSource()==showRDP){

        }

    }



}
