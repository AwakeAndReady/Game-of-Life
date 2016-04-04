package gameOfLife5;

public interface GameController {

  /**
   * Start the event loop.
   */
  public void run();
  
  /**
   * 
   * 
   * @param listener
   */
  void setPlayground(Playground playground);
  
}