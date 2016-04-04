package gameOfLife5.things;

import java.awt.Point;

public class Thing {
  
  private Point position;
  private char icon;
  
  public Thing( Point position, char icon ) {
    this.position = position;
    this.icon = icon;
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition( Point position ) {
    this.position = position;
  }

  public char getIcon() {
    return icon;
  }
  
  public int getX() {
    return position.x;
  }
  
  public void setX(int x) {
    position.x = x;
  }
  
  public void setY(int y) {
    position.y = y;
  }
  
  public int getY() {
    return position.y;
  }

  public void setLocation( int x, int y ) {
    position.setLocation( x, y );
  }
  
  public boolean isAtPosition(Point p) {
    return position.equals( p );
  }
  
  public boolean isAtPosition(Thing t) {
    return position.equals( t.getPosition() );
  }

}
