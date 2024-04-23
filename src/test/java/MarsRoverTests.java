import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTests {

    @Test
    public void testMoveForwardWest() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        //Act
        rover.move("f");

        //Assert
        Assertions.assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());

    }

    @Test
    public void testTurnLeftWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.move("lf");

        Assertions.assertEquals(new Coordinates2D(3, 2), rover.getCurrentLocation());

    }

    @Test
    public void testForwardBackward() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.move("ff");

        Assertions.assertEquals(new Coordinates2D(1, 3), rover.getCurrentLocation());

        rover.move("bbb");

        Assertions.assertEquals(new Coordinates2D(4, 3), rover.getCurrentLocation());

    }

    @Test
    public void testWrappingEast() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(360, 0), Direction.EAST);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(0, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 0), Direction.WEST);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(360, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingNorth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 90), Direction.NORTH);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(180, 90), rover.getCurrentLocation());

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(180, 89), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingSouth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, -90), Direction.SOUTH);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(180, -90), rover.getCurrentLocation());

        rover = new MarsRoverImpl(new Coordinates2D(181, -90), Direction.SOUTH);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(1, -90), rover.getCurrentLocation());
    }

    @Test
    public void testLongCommand() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 0), Direction.EAST);

        rover.move("frffrbblff");

        Assertions.assertEquals(new Coordinates2D(3,-4), rover.getCurrentLocation());
    }
}
