import java.awt.*;

enum Room {

    GEORGE_ALLEN_FIELD("George Allen Field", 10, 80),
    JAPANESE_GARDEN("Japanese Garden", 310, 20),
    STUDENT_PARKING("Student Parking", 705, 50),
    PYRAMID("Pyramid", 300, 190),
    REC_CENTER("Rec Center", 320, 405),
    FORBIDDEN_PARKING("Forbidden Parking", 715, 420),
    WEST_WALKWAY("West Walkway", 10, 470),
    LIBRARY("Library", 10, 1170),
    LA_5("LA 5", 355, 1190),
    BRATWURST_HALL("Bratwurst Hall", 760, 1190),
    EAST_WALKWAY("East Walkway", 1045, 700),
    COMPUTER_LAB("Computer Lab", 130, 640),
    ECS_302("ECS 302", 440, 630),
    EAT_CLUB("Eat Club", 740, 630),
    CECS_CONFERENCE_ROOM("CECS Conference Room", 900, 640),
    NORTH_HALL("North Hall", 125, 825),
    SOUTH_HALL("South Hall", 595, 825),
    ROOM_OF_RETIREMENT("Room of Retirement", 130, 970),
    ELEVATORS("Elevators", 430, 970),
    ECS_308("ECS_308", 595, 970),
    LACTATION_LOUNGE("Lactation Lounge", 880, 960);

    static {
        GEORGE_ALLEN_FIELD.adjacentRooms = new Room[]{JAPANESE_GARDEN, PYRAMID, REC_CENTER, WEST_WALKWAY};
        JAPANESE_GARDEN.adjacentRooms = new Room[]{GEORGE_ALLEN_FIELD, PYRAMID, STUDENT_PARKING};
        STUDENT_PARKING.adjacentRooms = new Room[]{JAPANESE_GARDEN, PYRAMID, REC_CENTER, FORBIDDEN_PARKING};
        PYRAMID.adjacentRooms = new Room[]{GEORGE_ALLEN_FIELD, JAPANESE_GARDEN, STUDENT_PARKING, REC_CENTER};
        REC_CENTER.adjacentRooms = new Room[]{GEORGE_ALLEN_FIELD, PYRAMID, FORBIDDEN_PARKING, WEST_WALKWAY};
        FORBIDDEN_PARKING.adjacentRooms = new Room[]{STUDENT_PARKING, EAST_WALKWAY, REC_CENTER};
        WEST_WALKWAY.adjacentRooms = new Room[]{GEORGE_ALLEN_FIELD, REC_CENTER, NORTH_HALL, LIBRARY};
        LIBRARY.adjacentRooms = new Room[]{WEST_WALKWAY, LA_5};
        LA_5.adjacentRooms = new Room[]{LIBRARY, ELEVATORS, BRATWURST_HALL};
        BRATWURST_HALL.adjacentRooms = new Room[]{LA_5, EAST_WALKWAY};
        EAST_WALKWAY.adjacentRooms = new Room[]{FORBIDDEN_PARKING, SOUTH_HALL, BRATWURST_HALL};
        COMPUTER_LAB.adjacentRooms = new Room[]{NORTH_HALL};
        ECS_302.adjacentRooms = new Room[]{NORTH_HALL, SOUTH_HALL};
        EAT_CLUB.adjacentRooms = new Room[]{SOUTH_HALL};
        CECS_CONFERENCE_ROOM.adjacentRooms = new Room[]{SOUTH_HALL};
        NORTH_HALL.adjacentRooms = new Room[]{WEST_WALKWAY, COMPUTER_LAB, ECS_302, ELEVATORS, ROOM_OF_RETIREMENT};
        SOUTH_HALL.adjacentRooms = new Room[]{ECS_302, EAT_CLUB, CECS_CONFERENCE_ROOM, LACTATION_LOUNGE, ECS_308, NORTH_HALL};
        ROOM_OF_RETIREMENT.adjacentRooms = new Room[]{NORTH_HALL};
        ELEVATORS.adjacentRooms = new Room[]{NORTH_HALL, LA_5};
        ECS_308.adjacentRooms = new Room[]{SOUTH_HALL};
        LACTATION_LOUNGE.adjacentRooms = new Room[]{SOUTH_HALL};
    }

    private final String name;
    private Room[] adjacentRooms;
    private final int xDrawPosition;
    private final int yDrawPosition;

    Room(String name, int xDrawPosition, int yDrawPosition) {
        this.name = name;
        this.xDrawPosition = xDrawPosition;
        this.yDrawPosition = yDrawPosition;
    }

    /**
     * @return the Point at which the Player token should be dreawn
     */
    public Point getDrawPosition() {
        return new Point(xDrawPosition, yDrawPosition);
    }

    public String getName() {
        return name;
    }

    public Room[] getAdjacentRooms() {
        return adjacentRooms;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return name;
    }
}