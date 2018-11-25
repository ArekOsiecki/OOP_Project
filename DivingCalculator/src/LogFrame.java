import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogFrame  extends JFrame implements ActionListener {

    JFrame logFrame;

    JMenuBar guiMenuBar = new JMenuBar();
    JMenu diveMenu = new JMenu("Dive Menu");
    JMenuItem createProfile = new JMenuItem("Create Profile");
    JMenuItem planDive = new JMenuItem("Plan dive");
    JMenuItem showDiveLog = new JMenuItem("Show dive log");
    JMenuItem planAnotherDive = new JMenuItem("Plan Another Dive");//declaration of menu, menu bar and items
    JTextArea logArea, RDPArea; //Text areas


    public static void main(String[] args) {

        new LogFrame();

    }

    public LogFrame() {


        logFrame = new JFrame("Show dive log");
        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        diveMenu.add(createProfile);
        createProfile.addActionListener(this);//adding items to menus and registering listeners

        diveMenu.add(planDive);
        planDive.addActionListener(this);

        diveMenu.add(planAnotherDive);
        planAnotherDive.addActionListener(this);


        guiMenuBar.add(diveMenu);

        logFrame.setJMenuBar(guiMenuBar);

        logFrame.setSize(320, 640);
        logFrame.setLocationRelativeTo(null);
        logFrame.setVisible(true);
        logFrame.setFocusable(true);//adding menu bar to frame, setting visibility and size



        GridLayout diveFrameLayout = new GridLayout(0, 1);
        logFrame.setLayout(diveFrameLayout);
        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenu diveGridMenu = new JMenu("Dive Menu");
        diveGridMenu.setVisible(true);

        JTextField divePlaceText = new JTextField(20);//Creating fields for user input and corresponding labels
        divePlaceText.setBorder(BorderFactory.createTitledBorder("Where you plan to dive?"));

        JTextField diveDateText = new JTextField(20);
        diveDateText.setBorder(BorderFactory.createTitledBorder("When you plan to dive?"));

        JTextField diveDepthText = new JTextField(20);
        diveDepthText.setBorder(BorderFactory.createTitledBorder("Enter maximum planned depth in meters"));

        JTextField diveLengthText = new JTextField(20);
        diveLengthText.setBorder(BorderFactory.createTitledBorder("Enter planned length in minutes"));

        String[] choices = {"Regulator and cylinders ", "Rebreather (semi - closed circut)"}; //Creating drop down list, setting it to be uneditable by user and retrieving input
        final JComboBox<String> diveDropDown = new JComboBox<>(choices);
        diveDropDown.setBorder(BorderFactory.createTitledBorder("Choose your device"));
        diveDropDown.setVisible(true);
        diveDropDown.setEditable(false);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout buttonsLayout = new GridLayout(0, 2, 25, 0);
        buttonsPanel.setLayout(buttonsLayout);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        logFrame.setJMenuBar(guiMenuBar);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);
        logFrame.add(divePlaceText);
        logFrame.add(diveDateText);
        logFrame.add(diveDepthText);
        logFrame.add(diveLengthText);
        logFrame.add(diveDropDown);
        logFrame.add(buttonsPanel);
        //adding components to layout


        //adding menu bar to frame, setting visibility and size
        logFrame.setLocationRelativeTo(null);
        logFrame.setVisible(true);
        logFrame.setSize(320, 640);
    }

    public void actionPerformed(ActionEvent actionEvent) {


        if (actionEvent.getSource() == createProfile) {

            new ProfileFrame();
            logFrame.dispose();


        }

        if (actionEvent.getSource() == planDive) {

            new DiveFrame();
            logFrame.dispose();
        }


        if (actionEvent.getSource() == planAnotherDive) {

            new RdpFrame();
            logFrame.dispose();

        }


    }
}
