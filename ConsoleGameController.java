package gameOfLife5;

import java.awt.Point;
import java.util.Scanner;

public class ConsoleGameController implements GameController {
  
  /*
   * Bleibt möglichst dumm, kümmert sich nicht um den Spielablauf.
   * Steuert die Ein und Ausgabe an sich.
   */
  
  private Scanner inputScanner = new Scanner( System.in );
  
  /* (non-Javadoc)
   * @see gameOfLife5.GameController#getDirection()
   */
  @Override public Direction getDirection() {
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
  
  /* (non-Javadoc)
   * @see gameOfLife5.GameController#draw(gameOfLife5.Playground)
   */
  @Override public void draw(Playground pg) {
    // Raster mit Figuren zeichnen
    for ( int y = 0; y < pg.getRows(); y++ ) {
      for ( int x = 0; x < pg.getCollums(); x++ ) {
        Point p = pg.getPoint(x, y);
        if ( pg.getPlayer().isAtPosition( p ) )
          System.out.print( pg.getPlayer().getIcon() );
        else if ( pg.getSnake().isAtPosition( p ) )
          System.out.print( pg.getSnake().getIcon() );
        else if ( pg.getGold().isAtPosition( p ) )
          System.out.print( pg.getGold().getIcon() );
        else if ( pg.getDoor().isAtPosition( p ) )
          System.out.print( pg.getDoor().getIcon() );
        else
          System.out.print( '.' );
      }
      System.out.println();
    }
    
    if ( pg.hasWon() ) {
      System.out.println( "Gewonnen!" );
      return;
    }
    
    if ( pg.hasLost() ) {
      System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
    }
    
  }
  
}