import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GenButton extends JButton implements ActionListener{
    GenImage image = null;
    JButton button;
    int x, y, w, h;
    GenButton(String name, int x, int y, int w, int h){
        this.setBounds(x, y, w, h);
        this.setName("Desligado");
        this.addActionListener(this);
        this.setText(name);
    }
    GenButton(String name, int x, int y, int w, int h, GenImage image){
        this.setBounds(x, y, w, h);
        this.setName("Desligado");
        this.setText(name);
        this.setBackground(new Color(133, 105, 156));
        this.setForeground(Color.WHITE);
        this.addActionListener(this);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        button = this;
        
        this.image = image;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
            if(e.getSource()==this){
                if(image.getName() == "Desligado"){
                    image.setName("Ligado");
                    image.setIcon(new ImageIcon("MotorLigado.png"));
                }else{
                    image.setName("Desligado");
                    image.setIcon(new ImageIcon("MotorDesligado.png"));
                }
            }
        
    }
}
