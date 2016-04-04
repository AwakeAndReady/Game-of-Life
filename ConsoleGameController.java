package gameOfLife5;

import java.awt.Point;
import java.util.Scanner;

public class ConsoleGameController implements GameController {
  
  /*
   * Bleibt möglichst "dumm", kümmert sich nicht um den Spielablauf.
   * Steuert die Ein und Ausgabe an sich.
   */
  
  private Playground playground;
  
  private Scanner inputScanner = new Scanner( System.in );
  
  /* (non-Javadoc)
   * @see gameOfLife5.GameController#getDirection()
   */
  private Direction getDirection() {
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
  
  private void draw() {
    for ( int y = 0; y < playground.getRows(); y++ ) {
      for ( int x = 0; x < playground.getCollums(); x++ ) {
        Point p = playground.getPoint(x, y);
        if ( playground.getPlayer().isAtPosition( p ) )
          System.out.print( playground.getPlayer().getIcon() );
        else if ( playground.getSnake().isAtPosition( p ) )
          System.out.print( playground.getSnake().getIcon() );
        else if ( playground.getGold().isAtPosition( p ) )
          System.out.print( playground.getGold().getIcon() );
        else if ( playground.getDoor().isAtPosition( p ) )
          System.out.print( playground.getDoor().getIcon() );
        else
          System.out.print( '.' );
      }
      System.out.println();
    }
    
    if ( playground.hasWon() ) {
      System.out.println( "Gewonnen!" );
      return;
    }
    
    if ( playground.hasLost() ) {
      System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
    }
    
  }
  

  @Override public void run() {
    draw();
    
    while ( true ) {
      Direction direction = getDirection();
      
      if ( direction != null && playground != null ) {
        playground.onMove( direction );
        draw();
        
        if (playground.hasLost() || playground.hasWon()) {
          break;
        }
      }
      
    } // End while  
  }

  @Override public void setPlayground( Playground playground ) {
    this.playground = playground;
  }
  
}
