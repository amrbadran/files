import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class p_down extends JPanel implements ActionListener {

    public static ArrayList<String> titles= new ArrayList<String>();
    public static ArrayList<String> desc = new ArrayList<String>();

    public JButton b1,b2,b3,b4,b5;
    public JLabel l1,l2,l3;
    public static JTextField t1;
    public static JTextArea t2;
    public JList list1;
    public static JPanel p1,p11,p2,p22;
    public Box bx1;

    String []arr;
    public p_down(){
        setLayout(new BorderLayout(5,5));

        p1 = new JPanel();
        p11 = new JPanel();
        l1 = new JLabel("City Name  ");
        p1.add(l1);
        t1 = new JTextField(40);
        p1.add(t1);
        b1 = new JButton("Add New");
        b1.setSize(50,20);
        b1.addActionListener(this);
        p1.add(b1);
        b1.addActionListener(this);

        l2 = new JLabel("Description");
        l2.setVerticalAlignment(SwingConstants.NORTH);


        p11.add(l2);
        t2 = new JTextArea(6,40);

        p11.add(t2);
        p11.add(new JScrollPane(t2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        b2 = new JButton("  Cancel  ");
        b2.addActionListener(this);
        p11.add(b2);
        b2.addActionListener(this);
        t2.setLineWrap(true);

        add(p1, BorderLayout.NORTH);
        add(p11,BorderLayout.SOUTH);


        p1.setVisible(true);
        p11.setVisible(true);

        p2 = new JPanel(new BorderLayout(5,5));
        l3 = new JLabel("We Have "+titles.size()+" Cites");
        arr = new String[titles.size()];
        for(int i =0;i<titles.size();i++){
            String desc_test = desc.get(i);
            if(desc_test.length() > 70){
                desc_test = desc_test.substring(0,70) + "...";
            }
            String elem = titles.get(i) + " : " + desc_test;
            arr[i] = elem;
        }
        list1 = new JList(arr);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setVisibleRowCount(3);
        list1.setFixedCellWidth(50);
        b3 = new JButton("Delete Selected");
        b3.addActionListener(this);
        b4 = new JButton("Delete All");
        b4.addActionListener(this);
        b5 = new JButton("Hide List");
        b5.addActionListener(this);
        bx1 = Box.createVerticalBox();
        JLabel tmp_l1 = new JLabel(" ");
        JLabel tmp_l2 = new JLabel(" ");
        bx1.add(b3);
        bx1.add(tmp_l1);
        bx1.add(b4);
        bx1.add(tmp_l2);
        bx1.add(b5);
        p2.add(l3,BorderLayout.NORTH);
        p2.add(list1,BorderLayout.CENTER);
        JScrollPane s1 = new JScrollPane(list1);
        /*s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        s1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        */
        p2.add(s1);
        p2.add(bx1,BorderLayout.EAST);

        add(p2);
        p2.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b5 || e.getSource() == b2){
            p2.setVisible(false);
            p11.setVisible(false);
            p1.setVisible(false);
        }
        else if(e.getSource() == b4){
            if(!titles.isEmpty()) {
                titles.clear();
                desc.clear();
                String[] arr = {};
                list1.setListData(arr);
                l3.setText("We Have 0 Cites");
            }
        }
        else if(e.getSource() == b3){
            int idx = list1.getSelectedIndex();
            if(idx >= 0){
                titles.remove(idx);
                desc.remove(idx);
                UpdateList();
                l3.setText("We Have "+titles.size()+" Cites");
            }
        }
        else if(e.getSource() == b1){
            String title = t1.getText();
            String descr = t2.getText();
            if(!title.isEmpty())
                titles.add(title);
            if(!descr.isEmpty())
                desc.add(descr);

            t1.setText("");
            t2.setText("");

            UpdateList();
            l3.setText("We Have "+titles.size()+" Cites");

        }
    }
    private void UpdateList(){
        String arr2[] = new String[titles.size()];
        for(int i =0;i<titles.size();i++){
            String desc_test = desc.get(i);
            if(desc_test.length() > 70){
                desc_test = desc_test.substring(0,70)+"...";
            }
            String elem = titles.get(i) + " : " + desc_test;
            arr2[i] = elem;
        }
        list1.setListData(arr2);
    }
}
