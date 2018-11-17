//ArkadiuszOsiecki.java
/*This program handles two arrays - one for months and other for mean monthly temperature.
 *Two-buttoned GUI allows user to generate statistics as outlined in the sheet or to sort data and display
 *it in text area on the different window. program terminates when close button is clicked.  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ArkadiuszOsiecki{ //array(s) creation and other global references go here

    JButton statsButton;
    JButton sortButton;
    String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    double mmt[] = {7.3,7.2,8.1,9.3,11.5,13.6,15.3,15.4,13.9,11.5,9.3,7.8};
    JTextArea textArea;

    public ArkadiuszOsiecki() //GUI creation code + event-handler registration
    {
        JFrame windowFrame = new JFrame("Valentia temperatures");

        FlowLayout flowLayout = new FlowLayout();

        windowFrame.setLayout(flowLayout);

        windowFrame.setSize(300,100);

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statsButton = new JButton("Generate Statistics");

        windowFrame.add(statsButton);

        sortButton = new JButton("Sort Data");

        windowFrame.add(sortButton);

        EventHandler buttonH = new EventHandler();

        statsButton.addActionListener(buttonH);

        sortButton.addActionListener(buttonH);

        windowFrame.setVisible(true);

    }

    public static void main(String args[])
    {
        ArkadiuszOsiecki guiApp = new ArkadiuszOsiecki();
    }

    private class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            double total=0, average, highest=0;
            String aboveAvg="", highestMonth="";

            //Event-handling code
            if(e.getSource()==statsButton)
            {

                for(int i=0; i<months.length; i++)

                {
                    total = total + mmt[i];
                    average = total/12;
                    if(mmt[i]>average)
                    {
                        aboveAvg+=months[i]+" ";
                    }
                    if(mmt[i]>highest)
                    {
                        highest=mmt[i];
                        highestMonth=months[i];
                    }


                }

                JOptionPane.showMessageDialog(null,"Average MMT: "+
                        String.format("%.2f",average)+"\nHighest MMT: "+
                        highest+" Month:"+highestMonth+"\nList of moths with above average MMT:"+
                        aboveAvg,"Temperature Stats",JOptionPane.INFORMATION_MESSAGE);

            }
            if(e.getSource()==sortButton)
            {
                JOptionPane.showMessageDialog(null,selectionSort(months , mmt),"Sorted Temperatures",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public JTextArea selectionSort(String months[],double mmt[])
    {
        String smalString, temString, text = "";
        double smallest, temp;
        int sub;
        textArea = new JTextArea(200,200);
        Font font = new Font("monospaced",12,Font.PLAIN);
        textArea.setFont(font);


        text+=String.format("%.2f%-10s","MMT","Month");
        text+=String.format("%.2f%-10s","---","---------");
        textArea.append(text);
        for(int i=0; i<mmt.length;i++)
        {
            smallest=mmt[i];
            sub=i;
            for(int j=i+1;j<mmt.length-1;j++)
            {
                smallest=mmt[j];
                sub=j;
            }

            temp = mmt[i];
            mmt[i] = mmt[sub];
            mmt[sub] = temp;

            temString = months[i];
            months[i] = months[sub];
            months[sub] = temString;

            text+=String.format("%.2f%-10s",mmt[i],months[i]);
            textArea.append(text);

        }
        return textArea;	}

}