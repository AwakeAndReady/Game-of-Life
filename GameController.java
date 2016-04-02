package gameOfLife4;

import java.util.Scanner;

public class GameController {
  
  private Scanner inputScanner = new Scanner( System.in );
  
  public Direction getDirection() {
    switch ( inputScanner.next() ) {
      case "w":
        return Direction.NORTH;
      case "s":
        return Direction.SOUTH;
      case "a":
        return Direction.WEST;
      case "d":
        return Direction.EAST;
      default:
        return null;
    }
  }
  
}
