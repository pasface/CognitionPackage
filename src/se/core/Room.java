package se.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nikki
 */
import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(RoomAdapter.class)
public final class Room extends JLabel {

    // fields
    private static final SecureRandom RAND = new SecureRandom();
    private final PeekButton peekButton;
    private final SearchButton searchButton;
    private final EmptyRoom roomFace = new EmptyRoom();
    private JLayeredPane roomPane;
    private static String state = "";
    private int roomId;
    private Target target = new Target();
    private ArrayList<Indicator> indicators;
    private JPanel panel = new JPanel();

    // constructor
    public Room() {
        this.peekButton = new PeekButton(0);
        this.searchButton = new SearchButton(0);
        this.indicators = new ArrayList<>();
        this.roomId = 0;
        this.roomPane = new JLayeredPane();
    }

    public Room(ArrayList<Indicator> indicators, Target target, int id, JPanel panel) {
        this.roomFace.setName("" + id);
        this.roomPane = new JLayeredPane();
        
        //initialize fields
        this.indicators = indicators;
        this.target = target;
        this.roomId = id;

        //peek settings
        this.peekButton = new PeekButton(id);

        //search settings
        this.searchButton = new SearchButton(id);

        //layered pane settings
        this.roomPane.setBorder(BorderFactory.createTitledBorder("Room " + id));

        this.placeComponents();

        //set level on pane
        this.orderComponents(target, this.roomFace, indicators);

        panel.add(this.roomPane);
        this.panel = panel;
    }

    // getters
    public ArrayList<Indicator> getIndicatorList() {
        return indicators;
    }

    public Target getTarget() {
        return target;
    }

    public int getRoomId() {
        return roomId;
    }

    public EmptyRoom getRoomFace() {
        return roomFace;
    }

    public PeekButton getPeekButton() {
        return peekButton;
    }

    public PeekButton getPeekButtonById(int id) {

        return peekButton;
    }

    public SearchButton getSearchButton() {
        return searchButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLayeredPane getRoomPane() {
        return roomPane;
    }

    //setters
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomFaceIcon(ImageIcon icon) {
        roomFace.setIcon(icon);
    }

    public void setState(String state) {
        Room.state = state;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setIndicators(ArrayList<Indicator> indicators) {
        this.indicators = indicators;
    }

    // method to create and populate a room array
    public static ArrayList<Room> roomArrayGenerator(int totalRooms, JPanel panel) {
        ArrayList<Room> r = new ArrayList<>();
        // create variable for roomArray number
        int currentRoom = 0;
        // create a bool to check if target exists
        boolean b = false;
        // while loop to randomize target location
        while (currentRoom < totalRooms) {
            int randInt = RAND.nextInt(2);
            ArrayList<Indicator> indicatorList;
            // randomly place a target into a roomArray 
            // (if no target built, chancee to build a target in current roomArray
            //  OR if on last roomArray w/o target, build target in last roomArray)
            if ((randInt == 1 && b == false) || (currentRoom == totalRooms - 1 && b == false)) {
                Target t1 = new Target("target");
                //t1.setIcon(IconFinder.setIconFinder("target"));
                indicatorList = modifiedIndicatorList(1);
                r.add(new Room(indicatorList, t1, (currentRoom + 1), panel));
                currentRoom++;
                b = true;
            } else {
                // enter empty target in current roomArray
                Target t0 = new Target();
                r.add(new Room(modifiedIndicatorList(0), t0, (currentRoom + 1), panel));
                currentRoom++;
            }
        }
        return r;
    }

    // ArrayList that stores all possible Indicators
    private static ArrayList<Indicator> indicatorList() {
        ArrayList<Indicator> indicators = new ArrayList<>();
        // create indicator objects (location x, location y, imagename)
        Indicator i0 = new Indicator("1");
        Indicator i1 = new Indicator("2");
        Indicator i2 = new Indicator("3");
        Indicator i3 = new Indicator("4");
        Indicator i4 = new Indicator("5");

        // add indicator objects to indicators list
        indicators.add(i0);
        indicators.add(i1);
        indicators.add(i2);
        indicators.add(i3);
        indicators.add(i4);
        // return indicator list
        return indicators;
    }

    // ArrayList that builds and stores indicators for a room
    private static ArrayList<Indicator> modifiedIndicatorList(int i) {
        ArrayList<Indicator> modList = new ArrayList<>();
        int randInt;

        if (i == 0) {
            // used when target is not present
            boolean b = true;
            if (b == RAND.nextBoolean()) {
                // randomly add indicator to empty roomArray
                randInt = RAND.nextInt(indicatorList().size());
                modList.add(indicatorList().get(randInt));
                int currentPosition = 0;
                for (Indicator indi : modList) {
                    currentPosition++;
                    indi.setIndicatorId(currentPosition);
                }
            }
            return modList;
        } else {
            // used when target is present
            // randomly add indicator from list of options
            randInt = RAND.nextInt(indicatorList().size());
            modList.add(indicatorList().get(randInt));
            // randomly add indicator from list of options
            randInt = RAND.nextInt(indicatorList().size());
            modList.add(indicatorList().get(randInt));
            int currentPosition = 0;
            for (Indicator indi : modList) {
                currentPosition++;
                indi.setIndicatorId(currentPosition);
            }
            return modList;
        }
    }

    //ArrayList for room labels
    private ArrayList<JLabel> labelList(Target target, JLabel roomFace, ArrayList<Indicator> indicators) {
        ArrayList<JLabel> list = new ArrayList<>();
        list.add(roomFace);
        list.add(target);
        for (Indicator indicator : indicators) {
            list.add(indicator);
        }
        return list;
    }

    //change the state of the room based on mouse click
    public void changeState() {
        if ("search".equals(Room.state)) {          // search state
            roomPane.moveToFront(target);
            roomPane.moveToBack(roomFace);
            for (Indicator indicator : indicators) {
                roomPane.moveToBack(indicator);
            }
            Room.state = "";
        } else if ("peek".equals(Room.state)) {     // peek state
            for (Indicator indicator : indicators) {
                roomPane.moveToFront(indicator);
            }
            roomPane.moveToBack(roomFace);
            roomPane.moveToBack(target);
            Room.state = "";
        } else {                                    // default state
            roomPane.moveToFront(roomFace);
        }
    }

    //place component levels on teh 
    public void placeComponents() {
        ComponentSettings s = new ComponentSettings();

        Point originP = new Point(s.getOrigin(), s.getOrigin() * 2);
        Point buttonOrigin = new Point(s.getRfW() - (s.getBtnW() * 2), s.getRfH() + s.getOrigin());

        //set bounds of components
        peekButton.setBounds(buttonOrigin.x, (buttonOrigin.y + s.getOrigin() * 2), s.getBtnW(), s.getBtnH());
        searchButton.setBounds((buttonOrigin.x + s.getBtnW() + 10), (buttonOrigin.y + s.getOrigin() * 2), s.getBtnW(), s.getBtnH());
        roomFace.setBounds(originP.x, originP.y, s.getRfW(), s.getRfH());
        target.setBounds((originP.x + s.getOffset()), (originP.y + s.getOffset()), s.getItemHW(), s.getItemHW());
        for (Indicator indicator : indicators) {
            int indiOffset = s.getItemHW() * indicator.getIndicatorId();
            indicator.setBounds((originP.x + indiOffset), (originP.y + 60), s.getItemHW(), s.getItemHW());
        }
    }

    public void orderComponents(Target target, JLabel roomFace, ArrayList<Indicator> indicators) {
        //function vars
        int order = 0;

        //set component order
        roomPane.setComponentZOrder(peekButton, 0);
        roomPane.setComponentZOrder(searchButton, 1);
        ArrayList<JLabel> list = labelList(target, roomFace, indicators);
        for (JLabel item : list) {
            roomPane.setComponentZOrder(item, order);
            order++;
        }
        changeState();
    }

    //toString
    @Override
    public String toString() {
        return "{" + "Room Id = " + roomId + ",  Target = " + target.toString() + ",  Indicators = " + indicators.toString() + "    \n";
    }
}
