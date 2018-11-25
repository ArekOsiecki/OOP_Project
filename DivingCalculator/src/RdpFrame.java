import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RdpFrame  extends JFrame implements ActionListener {

    JFrame rdpFrame;

    JMenuBar guiMenuBar = new JMenuBar();
    JMenu diveMenu = new JMenu("Dive Menu");
    JMenuItem createProfile = new JMenuItem("Create Profile");
    JMenuItem planDive = new JMenuItem("Plan dive");
    JMenuItem showDiveLog = new JMenuItem("Show dive log");
    JMenuItem planAnotherDive = new JMenuItem("Plan Another Dive");//declaration of menu, menu bar and items
    JTextArea logArea, RDPArea; //Text areas


    public static void main(String[] args) {

        new RdpFrame();

    }

    public RdpFrame() {


        rdpFrame = new JFrame("Plan second dive");
        rdpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        diveMenu.add(createProfile);
        createProfile.addActionListener(this);//adding items to menus and registering listeners

        diveMenu.add(planDive);
        planDive.addActionListener(this);

        diveMenu.add(showDiveLog);
        showDiveLog.addActionListener(this);

        guiMenuBar.add(diveMenu);
      //adding menus to bar

        rdpFrame.setJMenuBar(guiMenuBar);

        rdpFrame.setSize(320, 640);
        rdpFrame.setLocationRelativeTo(null);
        rdpFrame.setVisible(true);
        rdpFrame.setFocusable(true);//adding menu bar to frame, setting visibility and size

        GridLayout diveFrameLayout = new GridLayout(0, 1);
        rdpFrame.setLayout(diveFrameLayout);
        rdpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        rdpFrame.setJMenuBar(guiMenuBar);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);
        rdpFrame.add(divePlaceText);
        rdpFrame.add(diveDateText);
        rdpFrame.add(diveDepthText);
        rdpFrame.add(diveLengthText);
        rdpFrame.add(diveDropDown);
        rdpFrame.add(buttonsPanel);
        //adding components to layout


        //adding menu bar to frame, setting visibility and size
        rdpFrame.setLocationRelativeTo(null);
        rdpFrame.setVisible(true);
        rdpFrame.setSize(320, 640);


    }

    public void actionPerformed(ActionEvent actionEvent) {


        if (actionEvent.getSource() == createProfile) {

            new ProfileFrame();
            rdpFrame.dispose();


        }

        if (actionEvent.getSource() == planDive) {

            new DiveFrame();
            rdpFrame.dispose();



        }
        if (actionEvent.getSource() == showDiveLog) {

            new LogFrame();
            rdpFrame.dispose();


        }
    }
}
