import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p_right extends JPanel implements ActionListener {

    public static JTextArea t1;
    public JButton b1,b2;

    public JPanel p1;
    public p_right(){
        setLayout(new BorderLayout(0,20));
        p1 = new JPanel();
        b1 = new JButton("Edit");
        b2 = new JButton("Save");
        b1.addActionListener(this);
        b2.addActionListener(this);
        p1.add(b1);
        p1.add(b2);
        t1 = new JTextArea(22,18);
        t1.setLineWrap(true);
        t1.setEditable(false);
        add(t1,BorderLayout.NORTH);
        add(new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.NORTH);

        add(p1,BorderLayout.CENTER);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            if(!p_center.t1.getText().isEmpty()){
                t1.setEditable(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"You Should Write A Title");
            }

        }
        else if(e.getSource() == b2){
            String text1 = p_center.t1.getText();
            int idx = p_down.titles.indexOf(text1);
            if(idx >= 0){
                String text2 = p_right.t1.getText();
                p_down.desc.remove(idx);
                p_down.desc.add(text2);
            }
        }
    }
}
