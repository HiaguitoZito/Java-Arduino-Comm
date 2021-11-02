package de.mschoeffler.arduino.mavenproject2;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.util.Scanner;

public class main {
        public static void main(String[] args) throws IOException, InterruptedException{
            SerialPort serial = SerialPort.getCommPort("COM9");
            serial.setComPortParameters(9600, 8, 1, 0);
            serial.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING,0, 0);
            if(serial.openPort()){
                System.out.println("Port is Opened");
            } else{
                System.out.println("Port is not Opened");
            }
            boolean b = false;
            boolean h = false;
            char c = 'l';
            while(!b){
                char j = c;
                if(h == false){
                    Scanner objUs = new Scanner(System.in);
                    String userInp = objUs.next();
                    c = userInp.charAt(0);
                    h = true;
                }
                
            Scanner data = new Scanner(serial.getInputStream());
            
                try{
                    serial.getOutputStream().write(c);
                    System.out.println("Sent: " + c);
                }catch(Exception e){
                    
                }
            Thread.sleep(100);
            Scanner data2 = new Scanner(serial.getInputStream());
                try{
                    String t = data2.nextLine();
                    System.out.println("Recivied: " + t);
                    h = false;
                }
                catch(Exception e){
                    System.out.println("Oops!!");
                    h = false;
                }
        }
    }
}


