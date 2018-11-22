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

        JFrame guiFrame;
        JMenuBar guiMenuBar = new JMenuBar();
        JMenu profileMenu = new JMenu("Profile");
        JMenu diveMenu = new JMenu("Dive Menu");
        JMenu rdpMenu = new JMenu("Check Deco Table");
        JMenuItem createProfile = new JMenuItem("Create Profile");
        JMenuItem planDive = new JMenuItem("Plan dive");
        JMenuItem showDiveLog = new JMenuItem("Show dive log");
        JMenuItem showRDP = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
        JTextArea logArea,RDPArea; //Text areas
        String divePlace, diveDate,nameU, diverName,diverAgeText,diverSacText;
        int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
        boolean isReabreather; //Attributes for classes



    public DivingGUI() { //Code for GUI creation

        guiFrame = new JFrame("Dive Planner");
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        profileMenu.add(createProfile);
        createProfile.addActionListener(this);//adding items to menus and registering listeners


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
        guiFrame.setVisible(true);
        guiFrame.setFocusable(true);//adding menu bar to frame, setting visibility and size
    }


    public static void main(String args[]){

        DivingGUI divingApp= new DivingGUI(); //GUI instantiation

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        if(actionEvent.getSource()==createProfile){

             new ProfileFrame();
             guiFrame.dispose();

        }

        if(actionEvent.getSource()==planDive){

        }
        if(actionEvent.getSource()==showDiveLog){

        }
        if(actionEvent.getSource()==showRDP){

        }



    }




  /*  public static String nameValidation (String name) throws IllegalArgumentException {
        int spaceIndex = name.indexOf(' ');
        String validName ="";

        boolean isValidName = false;

        while (!isValidName)
            try{
            for (int i = 0; i <= name.length() - 1; i++) {

                if (!Character.isLetter(name.charAt(i))) {
                    throw new IllegalArgumentException("Name must contain only letters!");

                }else{
                            validName = name;
                 }
                }

            } catch (IllegalArgumentException nameException) {
            JOptionPane.showMessageDialog(null, nameException, "Name incorrect", JOptionPane.WARNING_MESSAGE);
            }
        return validName;
    }*/

}
