public interface MarsRover {
    void move(String commands);
    Coordinates2D getCurrentLocation();
    Direction getCurrentDirection();
}
