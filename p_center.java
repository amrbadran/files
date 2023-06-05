import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p_center extends JPanel implements ActionListener {
    public static JTextField t1;
    public String names[] = new String[40];

    public JButton btns[] = new JButton[names.length];
    public JPanel p1;
    public p_center(){
        set_array();
        setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(8,5));
        t1 = new JTextField(10);
        t1.setEditable(false);
        add(t1,BorderLayout.NORTH);
        for(int i=0;i<names.length;i++){
            btns[i] = new JButton(names[i]);
            btns[i].addActionListener(this);
            p1.add(btns[i]);

        }
        add(p1,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btns[28]){
            for(int i=0;i<=25;i++){
                char x = names[i].charAt(0);
                if(x >= 'A' && x < 'a'){
                    names[i] = names[i].toLowerCase();
                    btns[i].setText(names[i]);
                }
                else {
                    names[i] = names[i].toUpperCase();
                    btns[i].setText(names[i]);
                }

            }
        }
        else {
            String text,text2;
            for(int i=0;i<40;i++){
                if(e.getSource() == btns[28]) break;
                if(e.getSource()==btns[i]){

                    text = t1.getText();
                    text2 = (i==29 ? " " : names[i]);
                    t1.setText(text + text2);
                }
            }
        }
    }

    private void set_array(){
        int count = 0;
        for(char i='A';i<='Z';i++){
            names[count] = String.valueOf(i);
            count++;
        }
        names[26] = ":";
        names[27] = "\"";
        names[28] = "Shift";
        names[29] = "Spc";
        count = 30;
        for(int i=1;i<=9;i++){
            names[count]=String.valueOf(i);
            count++;
        }
        names[39] = String.valueOf(0);
    }
}
