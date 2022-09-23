import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maze_Window extends JFrame {

    ArrayList<Room> Rooms;
    int monitor_height;
    int monitor_width;
    public Maze_Window() {

        Rooms = new ArrayList<>();

        monitor_height= getToolkit().getScreenSize().height;
        monitor_width = getToolkit().getScreenSize().width;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(monitor_width/2,monitor_height/3*2);
        setLocation(monitor_width/2/2,(monitor_height-monitor_height/3*2)/2);
        getContentPane().setBackground(new Color(60,63,65));

        this.setLayout(null);

        Room room1 = new Room(this);
        this.add(room1);
        room1.setBounds(this.getWidth()/2-room1.getWidth()/2,this.getHeight()/2-room1.getHeight()/2-15,room1.getWidth(),room1.getHeight());



        repaint();

        setVisible(true);



}


}
