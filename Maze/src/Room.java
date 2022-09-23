import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Room extends Container implements ActionListener {

    Color room_color;
    int RoomsListNumber;
    Maze_Window frame;
    JLabel RoomJlabel;
    ImageIcon WhiteSquareIcon;

    ArrayList<JButton> Buttons;


    public Room(Maze_Window main_window){
        room_color = new Color(255,255,255);
        frame=main_window;
        RoomsListNumber=frame.Rooms.size()-1;
        this.setLayout(null);

        WhiteSquareIcon = new ImageIcon("src\\Images\\image_room_dark.png");
        RoomJlabel = new JLabel(WhiteSquareIcon);
        RoomJlabel.setBounds(0,0,WhiteSquareIcon.getIconWidth(),WhiteSquareIcon.getIconHeight());

        this.setSize(WhiteSquareIcon.getIconWidth(),WhiteSquareIcon.getIconHeight());
        this.add(RoomJlabel);
        Setup_Buttons();


       }



       private  void Setup_Buttons(){
            Buttons = new ArrayList<>();


            for(int i=0; i<4; i++) {
                Buttons.add(new JButton());
                Buttons.get(i).setBackground(Color.gray);
                Buttons.get(i).setForeground(Color.gray);
                Buttons.get(i).addActionListener(this);
                Buttons.get(i).setFocusable(true);
                Buttons.get(i).setOpaque(false);
                Buttons.get(i).setContentAreaFilled(false);
                Buttons.get(i).setBorderPainted(false);


                this.add(Buttons.get(i));
            }

           Buttons.get(0).setBounds(0,this.getHeight()/2-15,10,30);
           Buttons.get(1).setBounds(this.getWidth()-10,this.getHeight()/2-15,10,30);
           Buttons.get(2).setBounds(this.getWidth()/2-15,0,30,10);
           Buttons.get(3).setBounds(this.getWidth()/2-15,this.getHeight()-10,30,10);

       }


       public void Add_Room(int width, int height)  {

           frame.Rooms.add(new Room(frame));
           frame.Rooms.get(frame.Rooms.size()-1).setBounds(this.getLocation().x+width,this.getLocation().y+height,this.getWidth(),this.getHeight());
           frame.add(frame.Rooms.get(frame.Rooms.size()-1));
           frame.repaint();

       }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if(source == Buttons.get(0)){
            Add_Room(-this.getWidth(),0);
        }
        if(source == Buttons.get(1)){
            Add_Room(this.getWidth(),0);
        }
        if(source == Buttons.get(2)){
            Add_Room(0,-this.getHeight());
        }
        if(source == Buttons.get(3)){
            Add_Room(0,this.getHeight());
        }
    }
}










