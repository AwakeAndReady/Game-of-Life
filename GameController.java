package gameOfLife5;

public interface GameController {
  
  /**
   * Draw Playground
   * 
   * @param pg Playground to draw.
   */
  void draw( Playground pg );
  

  /**
   * Start the event loop.
   */
  public void run();
  
  /**
   * 
   * 
   * @param listener
   */
  void setOnMoveListener(OnMoveListener listener);
  
}