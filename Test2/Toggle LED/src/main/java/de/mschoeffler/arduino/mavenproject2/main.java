package de.mschoeffler.arduino.mavenproject2;
import com.fazecast.jSerialComm.SerialPort;
import javax.swing.JFrame;
import java.io.IOException;

public class main {
    public static boolean temp = false;
    public static void main(String args[]) throws IOException, InterruptedException{
        
        
        SerialPort  sp = SerialPort.getCommPort("COM4");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        if(sp.openPort()){
            System.out.println("Port is opened");
        }else{
            System.out.println("port is closed");
            return;
        }
        JFrame frame = new JFrame();
        frame.setSize(360,640);
        frame.setResizable(false);
        frame.setVisible(true);
        GenButton button = new GenButton("Ligar/Deslig",30,20,100,30);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            if(temp == true){
            char i = 'd';
            sp.getOutputStream().write(i);
            sp.getOutputStream().flush();
            }
            if(temp == false){
            char i = 'l';
            sp.getOutputStream().write(i);
            sp.getOutputStream().flush();
            }
        }
        
        
    }
}

