import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p_left extends JPanel implements ActionListener{

    String names[] = {"Description","Add City","List of Cites","Clear","About"};
    JButton bttns[] = new JButton[names.length];
    JPanel panel = new JPanel();

   public p_left(){
       panel.setLayout(new GridLayout(5,1,0,50));
       for(int i=0;i< names.length;i++){
           bttns[i] = new JButton(names[i]);
           bttns[i].setPreferredSize(new Dimension(150, 30));
           bttns[i].addActionListener(this);
           panel.add(bttns[i]);
       }
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bttns[4]){
            JOptionPane.showMessageDialog(null,"This program programmed by amr");
        }
        else if (e.getSource() == bttns[3]){
            p_center.t1.setText("");
            p_right.t1.setText("");
            p_down.t1.setText("");
            p_down.t2.setText("");
        }
        /*else if (e.getSource() == bttns[0]){
            String text1 = p_center.t1.getText();
            int idx = p_down.titles.indexOf(text1);
            if(idx >= 0){
                p_right.t1.setText(p_down.desc.get(idx));
            }
            else {
                p_right.t1.setText("Not Found");
            }

        }*/
        else if (e.getSource() == bttns[0]){
            String text1 = p_center.t1.getText();
            String text2;
            int idx = -1;
            int size = p_down.titles.size();
            for(int i=0;i<size;i++){
                text2 = p_down.titles.get(i);
                if(text1.compareToIgnoreCase(text2) == 0){
                    idx = i;
                    break;
                }
            }
            if(idx >= 0){
                p_right.t1.setText(p_down.desc.get(idx));
            }
            else {
                p_right.t1.setText("Not Found");
            }

        }
        else if(e.getSource() == bttns[1]){
            p_down.p1.setVisible(true);
            p_down.p11.setVisible(true);
            p_down.p2.setVisible(false);
        }
        else if(e.getSource() == bttns[2]){
            p_down.p1.setVisible(false);
            p_down.p11.setVisible(false);
            p_down.p2.setVisible(true);
        }
    }
}
