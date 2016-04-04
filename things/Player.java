package gameOfLife5.things;

import java.awt.Point;
import java.util.Scanner;
import gameOfLife5.Direction;

public class Player extends Thing {
  
  private boolean isRich = false;
  
  public Player( Point position ) {
    super( position, '&' );
  }
  
  public boolean isRich() {
    return isRich;
  }
  
  public void setRich() {
    isRich = true;
  }
  
  public void move( Direction direction) {
    switch ( direction ) {
      case NORTH:
        setY(Math.max( 0, getY() - 1 ));
        break;
      case SOUTH:
        setY(Math.min( 9, getY() + 1 ));
        break;
      case WEST:
        setX(Math.max( 0, getX() - 1 ));
        break;
      case EAST:
        setX(Math.min( 39, getX() + 1 ));
        break;
    }
    
  }
  
}
