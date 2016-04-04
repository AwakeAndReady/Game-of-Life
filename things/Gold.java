package gameOfLife5.things;

import java.awt.Point;

public class Gold extends Thing {
  
  public Gold( Point position ) {
    super( position, '€' );
  }
  
  public void hide() {
    setLocation( -1, -1 );
  }
  
}
