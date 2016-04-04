package gameOfLife5.things;

import java.awt.Point;

public class Snake extends Thing {
  
  public Snake( Point position ) {
    super( position, 'S' );
  }
  
  public void follow( Player player ) {
    if ( player.getX() < getX() )
      setX(getX() - 1);
    else if ( player.getX() > getX() )
      setX( getX() + 1 );
    if ( player.getY() < getY() )
      setY( getY() - 1);
    else if ( player.getY() > getY() )
      setY( getY() + 1);
  }
  
}
