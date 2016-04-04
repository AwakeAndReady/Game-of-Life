package gameOfLife5;

import java.awt.Point;
import java.util.Scanner;
import gameOfLife5.things.Door;
import gameOfLife5.things.Gold;
import gameOfLife5.things.Player;
import gameOfLife5.things.Snake;

public class Playground implements OnMoveListener {
  
  /*
   * contains rules, states, 
   */
  
  private final int collums;
  private final int rows;
  private final Point[][] points;
  
  private final Player player = new Player( new Point( 10, 9 ) );
  private final Snake snake = new Snake( new Point( 30, 2 ) );
  private final Gold gold = new Gold( new Point( 6, 6 ) );
  private final Door door = new Door( new Point( 0, 5 ) );
  
  private final GameController gc;
  
  public Playground( final int collums, final int rows, final GameController gc ) {
    this.collums = collums;
    this.rows = rows;
    this.gc = gc;
    this.gc.setOnMoveListener( this );
    this.points = new Point[rows][collums];
    
    for ( int y = 0; y < rows; y++ ) {
      for ( int x = 0; x < collums; x++ ) {
        points[y][x] = new Point( x, y );
      }
    }
  }
  
  public boolean hasWon() {
    return player.isRich() && player.isAtPosition( door );
  }
  
  public boolean hasLost() {
    return player.isAtPosition( snake );
  }
  
  public void play() {
    gc.draw( this );
    gc.run();
  }
  
  @Override public void onMove( Direction direction ) {
    player.move( direction );
    snake.follow( player );
    if ( player.isAtPosition( gold ) ) {
      player.setRich();
      gold.hide();
    }
    gc.draw( this );
  }
  
  public int getCollums() {
    return collums;
  }
  
  public int getRows() {
    return rows;
  }
  
  public Point getPoint( int x, int y ) {
    return points[y][x];
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public Snake getSnake() {
    return snake;
  }
  
  public Gold getGold() {
    return gold;
  }
  
  public Door getDoor() {
    return door;
  }
  
  public static void main( String[] args ) {
    
    Playground playground = new Playground( 40, 10, new ConsoleGameController() );
    
    playground.play();
    
  }


  
}
