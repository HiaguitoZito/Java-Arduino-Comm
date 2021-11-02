import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GenFrame extends JFrame{
    GenFrame(){
        this.setSize(360,640);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30,30,30));
        this.setTitle("Supervisory System");
        this.setIconImage(new ImageIcon("Logo.png").getImage());
        this.setVisible(true);
    }
}
