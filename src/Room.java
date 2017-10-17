import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Rooms {

    GEORGE_ALLEN_FIELD("George Allen Field", 10, 80, "Japanese Garden, Pyramid, Rec Center, West Walkway"),
    JAPANESE_GARDEN("Japanese Garden", 310, 20, "George Allen Field, Pyramid, Student Parking"),
    STUDENT_PARKING("Student Parking", 705, 50, "Japanese Garden, Pyramid, Rec Center, Forbidden Garden"),
    PYRAMID("Pyramid", 300, 190, "George Allen Field, Japanese Garden, Student Parking, Rec Center"),
    RECCENTER("Rec Center", 320, 405, "George Allen Field, Pyramid, Forbidden Parking, West Walkway"),
    FORBIDDEN_PARKING("Forbidden Parking", 715, 420, "Student Parking, East Walkway, Rec Center"),
    WEST_WALKWAY("West Walkway", 10, 470, "George Allen Field, Rec Center, North Hall, Library"),
    LIBRARY("Library", 10, 1170, "West Walkway, LA 5"),
    LA_5("LA 5", 355, 1190, "Library, Elevators, Bratwurst Hall"),
    BRATWURST_HALL("Bratwurst Hall", 760, 1190, "LA 5, East Walkway"),
    EAST_WALKWAY("East Walkway", 1045, 700, "Forbidden Parking, South Hall, Bratwurst Hall"),
    COMPUTER_LAB("Computer Lab", 130, 640, "North Hall"),
    ECS_302("ECS 302", 440, 630, "North Hall, South Hall"),
    EAT_CLUB("Eat Club", 740, 630, "South Hall"),
    CECS_CONFERENCE_ROOM("CECS Conference Room", 900, 640, "South Hall"),
    NORTH_HALL("North Hall", 125, 825, "West Walkway, Computer Lab, ECS 302, Elevators, Room of Retirement"),
    SOUTH_HALL("South Hall", 595, 825, "ECS 302, EAT Club, CECS Conference Room, Lactation Lounge, ECS 308, North Hall"),
    ROOM_OF_RETIREMENT("Room of Retirement", 130, 970, "North Hall"),
    ELEVATORS("Elevators", 430, 970, "North Hall, LA 5"),
    ECS_308("ECS_308", 595, 970, "South Hall"),
    LACTATION_LOUNGE("Lactation Lounge", 880, 960, "South Hall");

    public final String roomName;
    public final String roomAdjacency;
    public final int xDrawPosition;
    public final int yDrawPosition;

    Rooms(String roomName, int xDrawPosition, int yDrawPosition, String roomAdjacency) {
        this.roomName = roomName;
        this.roomAdjacency = roomAdjacency;
        this.xDrawPosition = xDrawPosition;
        this.yDrawPosition = yDrawPosition;
    }

}
public class Room
{
    private Rooms currentRoom;
    public Room(){
        currentRoom = Rooms.ECS_308;
    }
    //Returns the Point at which the Player token should be dreawn
    public Point getDrawPosition()
    {
        return new Point(currentRoom.xDrawPosition, currentRoom.yDrawPosition);
    }

    //Returns a List of Strings of the name of the adjacent rooms
    List<String> getAdjacentRoomStrings()
    {
        return processString(currentRoom.roomAdjacency);
    }

    //When given the string chosen from List<String> from getAdjacentRoomStrings returns the Enum type for processing
    void setRoom(String inputString)
    {
        currentRoom = Rooms.valueOf(processEnumString(inputString));
    }

    public String getName()
    {
        return currentRoom.roomName;
    }


    private String processEnumString(String inputString)
    {
        return inputString.toUpperCase().replace(' ', '_');
    }

    private List<String> processString(String inputString) {
        return new ArrayList<>(
                Arrays.asList(inputString.split(","))
        );
    }


}