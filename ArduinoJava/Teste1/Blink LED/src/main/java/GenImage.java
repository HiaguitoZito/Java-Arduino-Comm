import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GenImage extends JLabel{
    GenImage(String image, int x, int y){
        this.setIcon(new ImageIcon(image));
        this.setName("Desligado");
        this.setBounds(x, y, 100, 100);
    }
    
}
