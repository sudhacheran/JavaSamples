import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiTest2 {
    private static JTextField gRatio = new JTextField("Enter G Ratio");
    private static JTextField sRatio = new JTextField("Enter S Ratio");
    private static JTextField hRatio = new JTextField("Enter H Ratio");
    private static JTextField bond1 = new JTextField("BO4");
    private static JTextField bond2 = new JTextField("BB");
    private static JTextField bond3 = new JTextField("55");
    private static JTextField bond4 = new JTextField("B5");
    private static JTextField bond5 = new JTextField("B1");
    private static JTextField bond6 = new JTextField("405");
    private static JTextField dp = new JTextField("Enter DP");
    private static JPanel panel = new JPanel();
    private static JButton button = new JButton("Run");
    private static int ligninG;
    private static int ligninS;
    private static int ligninH;
    private static int chainLength;
    private static int BO4;
    private static int BB;
    private static int c5;
    private static int B5;
    private static int B1;
    private static int o5;


    public static void displayGUI() {
        final JFrame frame = new JFrame("GuiTest2");
        JCheckBox gBox = new JCheckBox("G", false);
        JCheckBox sBox = new JCheckBox("S", false);
        JCheckBox hBox = new JCheckBox("H", false);
    	JLabel monomerType = new JLabel("Choose the Monomer Type:");

    	monomerType.setBounds(50, 13, 200, 15);
        gBox.setBounds(75, 25, 50, 50);
        sBox.setBounds(150, 25, 50, 50);
        hBox.setBounds(225, 25, 50, 50);

        
        JLabel monomerRatio = new JLabel("Enter the Monomer ration in %:");
        //get inputs for ratio of different lignin monomer types
        //JTextField gRatio = new JTextField("Enter G ratio");
        monomerRatio.setBounds(10, 10, 75, 25);
        gRatio.setEnabled(true);
        gRatio.setBounds(50, 75, 75, 25);


        //JTextField sRatio = new JTextField("Enter S ratio");
        sRatio.setBounds(125,75, 75, 25);
        sRatio.setEnabled(true);


        //JTextField hRatio = new JTextField("Enter H ratio");
        hRatio.setBounds(200, 75, 75, 25);
        hRatio.setEnabled(true);

        gRatio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ligninG = Integer.parseInt(gRatio.getText());
                System.out.println("g ratio: " + ligninG);
            }
        });

        sRatio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ligninS = Integer.parseInt(sRatio.getText());
                System.out.println("s ratio: " + ligninS);

            }
        });

        hRatio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ligninH = Integer.parseInt(hRatio.getText());
                System.out.println("H ratio: " + ligninH);
            }
        });


        //get ratio of different bond types

        bond1.setBounds(50, 125, 30, 25);
        bond1.setEnabled(true);
        bond1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BO4 = Integer.parseInt(bond1.getText());
                System.out.println("BO4 ratio: " + BO4);
            }
        });

        //JTextField bond2 = new JTextField("BB");
        bond2.setBounds(90, 125, 30, 25);
        bond2.setEnabled(true);
        bond2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BB = Integer.parseInt(bond2.getText());
                System.out.println("BB ratio: " + BB);
            }
        });

        //JTextField bond3 = new JTextField("55");
        bond3.setBounds(130, 125, 30, 25);
        bond3.setEnabled(true);
        bond3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                c5 = Integer.parseInt(bond3.getText());
                System.out.println("55 ratio: " + c5);
            }
        });

        //JTextField bond4 = new JTextField("B5");
        bond4.setBounds(170, 125, 30, 25);
        bond4.setEnabled(true);
        bond4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                B5 = Integer.parseInt(bond4.getText());
                System.out.println("B5 ratio: " + B5);
            }
        });

        //JTextField bond5 = new JTextField("B1");
        bond5.setBounds(210, 125, 30, 25);
        bond5.setEnabled(true);
        bond5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                B1 = Integer.parseInt(bond5.getText());
                System.out.println("B1 ratio: " + B1);
            }
        });

        //JTextField bond6 = new JTextField("405");
        bond6.setBounds(250, 125, 30, 25);
        bond6.setEnabled(true);
        bond6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                o5 = Integer.parseInt(bond6.getText());
                System.out.println("405 ratio: " + o5);
            }
        });

        dp.setBounds(120, 170, 100, 25);
        dp.setEnabled(true);
        dp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                chainLength = Integer.parseInt(dp.getText());
                System.out.println("DP: " + chainLength);
            }
        });

        button.setBounds(120, 200, 100, 25);
        button.setEnabled(true);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GeneratePolymer.main();
            }
        });


        //JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(monomerType);
        panel.add(gBox);
        panel.add(sBox);
        panel.add(hBox);

        //System.out.print(gBox.isSelected());

        panel.add(gRatio);
        panel.add(sRatio);
        panel.add(hRatio);
        panel.add(bond1);
        panel.add(bond2);
        panel.add(bond3);
        panel.add(bond4);
        panel.add(bond5);
        panel.add(bond6);
        panel.add(dp);
        panel.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().add(panel);
        frame.setVisible(true);


    }

    public static int[] getMonomerRatio(){

        int[] monomerRatio = {ligninG, ligninH, ligninS};
        return monomerRatio;

    }

    public static int[] getBondRatio(){

        int[] bondRatio = {BO4, BB, c5, B5, B1, o5};
        return bondRatio;

    }

    public static int getChainlength(){

        return chainLength;

    }

    public static void output(String polymer){
        JCheckBox x = new JCheckBox(polymer);
        x.setBounds(50, 220, 200, 100);
        panel.add(x);
        System.out.println(polymer);
        panel.revalidate();
        panel.repaint();
    }




}
