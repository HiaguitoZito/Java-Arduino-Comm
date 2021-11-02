package de.mschoeffler.arduino.mavenproject2;
import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;

public class main {

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
        while(true){
            char i = 'd';
            sp.getOutputStream().write(i);
            sp.getOutputStream().flush();
            Thread.sleep(1000);
            i = 'l';
            sp.getOutputStream().write(i);
            sp.getOutputStream().flush();
            Thread.sleep(1000);
        }
        
        
    }
}

