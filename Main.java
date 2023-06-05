import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Virtual Cites");

        JPanel pm = new JPanel();

         p_left panel = new p_left();
        p_center panel2 = new p_center();
        p_right panel3 = new p_right();
        p_down panel4 = new p_down();
        JLabel label1 = new JLabel("Virtual Cites Program");
        pm.setLayout(new BorderLayout(15,15));
        pm.add(panel.panel,BorderLayout.WEST);
        pm.add(panel2,BorderLayout.CENTER);
        pm.add(panel3,BorderLayout.EAST);
        pm.add(panel4,BorderLayout.SOUTH);
        pm.add(label1,BorderLayout.NORTH);

        frame.setLayout(new FlowLayout());
        frame.add(pm,FlowLayout.LEFT);
       frame.setSize(800,700);
       frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }
}