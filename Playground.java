package gameOfLife4;

import java.awt.Point;
import java.util.Scanner;
import gameOfLife4.things.Door;
import gameOfLife4.things.Gold;
import gameOfLife4.things.Player;
import gameOfLife4.things.Snake;

public class Playground {
  
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
  
  public void play() {
    
    // Instanziere Spielobjekte
    Player player = new Player( new Point( 10, 9 ) );
    Snake snake = new Snake( new Point( 30, 2 ) );
    Gold gold = new Gold( new Point( 6, 6 ) );
    Door door = new Door( new Point( 0, 5 ) );
    
    while ( true ) {
      
      // Raster mit Figuren zeichnen
      for ( int y = 0; y < 10; y++ ) {
        for ( int x = 0; x < 40; x++ ) {
          java.awt.Point p = new java.awt.Point( x, y );
          if ( player.isAtPosition( p ) )
            System.out.print( player.getIcon() );
          else if ( snake.isAtPosition( p ) )
            System.out.print( snake.getIcon() );
          else if ( gold.isAtPosition( p ) )
            System.out.print( gold.getIcon() );
          else if ( door.isAtPosition( p ) )
            System.out.print( door.getIcon() );
          else
            System.out.print( '.' );
        }
        System.out.println();
      }
      
      // Status feststellen
      
      if ( player.isRich() && player.isAtPosition( door ) ) {
        System.out.println( "Gewonnen!" );
        break;
      }
      
      if ( player.isAtPosition( snake ) ) {
        System.out.println( "ZZZZZZZ. Die Schlange hat dich!" );
        break;
      }
      
      if ( player.isAtPosition( gold ) ) {
        player.setRich();
        gold.hide();
      }
      
      // Bewegungen des Spielers und der Schlange
      
      Direction direction = getDirection();
      
      if ( direction != null ) {
        player.move( direction );
        snake.follow( player );
      }
      
    } // End while
    
  }
  
  public static void main( String[] args ) {
    
    Playground playground = new Playground();
    
    playground.play();
    
  }
  
}
