/*This program is a simple diving calculator/logbook. It allows user to create and update profile and enter data about a planned dive.
* Program also contains features allowing to calculate amount of air needed for the dive,
 * alerts about maximum dive time and surface interval for absolute safe second dive
 * and nitrox composition if using rebreathing open-circut device.
 * Recreational diving table is included and viewable for more precise planning.
  * Program also creates the dive log that can be viewed.*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class DivingGUI { //This contains global references, buttons and text fields creation code

        JButton createProfileButton = new JButton("Create Profile");
        JButton planDiveButton = new JButton("Plan Dive");
        JButton confirmButton = new JButton("Confirm");
        JButton showRdpButton = new JButton("Show RDP");
        JButton showLogButton = new JButton ("Show dive log");
        JButton exitButton = new JButton("Exit");
        JButton eraseButton = new JButton("Erase");
        JButton cancelButton = new JButton("Cancel"); //Buttons for GUI
        JTextArea logArea,RDPArea; //Text areas
        String divePlace, diveDate, diverName;
        int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
        boolean isReabreather; //Attributes for classes


    public DivingGUI() { //Code for GUI creation and event handler registration

        JFrame guiFrame = new JFrame("Dive Planner");
        GridLayout guiFlow = new GridLayout(); //Creating a grid layout to contain buttons
        guiFrame.setLayout(guiFlow);
        guiFrame.setSize(500,500);
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.add(createProfileButton);
        guiFrame.add(planDiveButton);
        guiFrame.add(showRdpButton);
        guiFrame.add(showLogButton); //Adding buttons to grid
        EventHandler menuButton = new EventHandler();
        createProfileButton.addActionListener(menuButton);
        planDiveButton.addActionListener(menuButton);
        showRdpButton.addActionListener(menuButton);
        showLogButton.addActionListener(menuButton);


    }

    public static void main(String args[]){

        DivingGUI divingApp= new DivingGUI(); //GUI instantiation

    }

    public class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent click){ //This part of the program contains methods to handle clicked button events

            


        }

    }



}
