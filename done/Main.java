import javax.swing.JFrame;
public class Main{
   public static void main(String[] args){
      JFrame frame = new JFrame("Snake");
      frame.setSize(500, 600);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new gui());
      frame.setVisible(true);
   }
}

