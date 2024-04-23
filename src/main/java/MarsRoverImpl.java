public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;

    private Direction direction;

    public MarsRoverImpl(Coordinates2D startingPosition, Direction startingDirection){
        x = startingPosition.x();
        y = startingPosition.y();
        direction = startingDirection;
    }

    @Override
    public void move(String commands){
        for (char c : commands.toLowerCase().toCharArray()) {
            switch (c) {
                case 'f':
                    moveInFacingDir(1);
                    break;
                case 'b':
                    moveInFacingDir(-1);
                    break;
                case 'l', 'r':
                    turn(c);
                    break;
                default:
                    break;
            }
        }
    }

    //använder standarden för ett geografisk koordinat system latitud 0,360 longitud -90,90
    //märkte på efterhand att jag använt latituden fel och att det borde vara 180 öst och väst
    private void moveInFacingDir(int heading) {
        switch (direction) {
            case EAST:
                if(x == 360) {
                    x = 0;
                } else {
                    x+=heading;
                }
                break;
            case WEST:
                if(x == 0) {
                    x = 360;
                } else {
                    x-=heading;
                }
                break;
            case NORTH:
                if(y == 90) {
                    direction = Direction.SOUTH;
                    if(x > 180) {
                        x-=180;
                    } else {
                        x+=180;
                    }
                } else {
                    y+=heading;
                }
                break;
            case SOUTH:
                if(y == -90) {
                    direction = Direction.NORTH;
                    if(x > 180) {
                        x-=180;
                    } else {
                        x+=180;
                    }
                } else {
                    y-=heading;
                }
                break;
        }
    }

    private void turn(char dir) {
        if(dir == 'l') {
            switch (direction) {
                case EAST -> direction = Direction.NORTH;
                case NORTH -> direction = Direction.WEST;
                case WEST -> direction = Direction.SOUTH;
                case SOUTH -> direction = Direction.EAST;
            }
        } else {
            switch (direction) {
                case EAST -> direction = Direction.SOUTH;
                case SOUTH -> direction = Direction.WEST;
                case WEST -> direction = Direction.NORTH;
                case NORTH -> direction = Direction.EAST;
            }
        }
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }
}
