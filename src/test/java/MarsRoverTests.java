import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTests {

    @Test
    public void TestMoveForwardOneTimeLeftEdgeToRightEdge() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Point2d(0, 3), Direction.West);

        //Act
        rover.Move("f");

        //Assert
        Assertions.assertEquals(new Point2d(5, 3), rover.GetCurrentPosition());
    }
}
