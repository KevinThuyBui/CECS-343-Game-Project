import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Room{

    GEORGE_ALLEN_FIELD(10, 80, "Japanese Garden, Pyramid, Rec Center, West Walkway"),
    JAPANESE_GARDEN(310, 20, "George Allen Field, Pyramid, Student Parking"),
    STUDENT_PARKING(705, 50, "Japanese Garden, Pyramid, Rec Center, Forbidden Garden"),
    PYRAMID(300, 190, "George Allen Field, Japanese Garden, Student Parking, Rec Center"),
    RECCENTER(320, 405, "George Allen Field, Pyramid, Forbidden Parking, West Walkway"),
    FORBIDDEN_PARKING(715, 420, "Student Parking, East Walkway, Rec Center"),
    WEST_WALKWAY(10, 470, "George Allen Field, Rec Center, North Hall, Library"),
    LIBRARY(10, 1170, "West Walkway, LA 5"),
    LA5(355, 1190, "Library, Elevators, Bratwurst Hall"),
    BRATWURST_HALL(760, 1190, "LA 5, East Walkway"),
    EAST_WALKWAY(1045, 700, "Forbidden Parking, South Hall, Bratwurst Hall"),
    COMPUTER_LAB(130, 640, "North Hall"),
    ECS302(440, 630, "North Hall, South Hall"),
    EAT_CLUB(740, 630, "South Hall"),
    CECS_CONFRENCE_ROOM(900, 640, "South Hall"),
    NORTH_HALL(125, 825, "West Walkway, Computer Lab, ECS 302, Elevators, Room of Retirement"),
    SOUTH_HALL(595, 825, "ECS 302, EAT Club, CECS Conference Room, Lactation Lounge, ECS 308, North Hall"),
    ROOM_OF_RETIREMENT(130, 970,"North Hall"),
    ELEVATORS(430, 970, "North Hall, LA 5"),
    ECS308(595, 970, "South Hall"),
    LACTATION_LOUNGE(880, 960, "South Hall");

    private final String roomAdjacency;
    private final int xDrawPosition;
    private final int yDrawPosition;

    Room(int xDrawPosition, int yDrawPosition, String roomAdjacency)
    {
        this.roomAdjacency = roomAdjacency;
        this.xDrawPosition = xDrawPosition;
        this.yDrawPosition = yDrawPosition;
    }

    public Point getDrawPosition()
    {
        return new Point(xDrawPosition, yDrawPosition);
    }

    public List<String> getAdjacentRoomStrings()
    {
        return processString(roomAdjacency);
    }


    public Room getEnum(String inputString)
    {
        return Room.valueOf(processEnumString(inputString));
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

