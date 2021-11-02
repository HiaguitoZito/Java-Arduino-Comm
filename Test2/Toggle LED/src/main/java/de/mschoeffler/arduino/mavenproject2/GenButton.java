package de.mschoeffler.arduino.mavenproject2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class GenButton extends JButton implements ActionListener{
    
    GenButton(String name, int x, int y, int w, int h){
        this.setBounds(x,y,w,h);
        this.setText(name);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        main temp2 = new main();
        if(temp2.temp == false){
            temp2.temp = true;
        }else{
            temp2.temp = false;
        }
    }
}
