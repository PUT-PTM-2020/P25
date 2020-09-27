import java.text.SimpleDateFormat;
import java.util.Date;

import com.fazecast.jSerialComm.*;
public final class MessageListener implements SerialPortPacketListener
{
   public static String presentData = new String("A0B0C0D0E0");
	
   @Override
   public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }

   @Override
   public int getPacketSize() { return 100; }

   @Override
   public void serialEvent(SerialPortEvent event)
   {
      byte[] newData = event.getReceivedData();
      //System.out.println("Received data of size: " + newData.length);
      String str = new String("");
      
      for (int i = 0; i < newData.length; ++i)
    	  str = str + (char)newData[i];
      presentData = "";
      for (int i = 0; i<str.length();i++) {
    	  if (str.charAt(i)!=0)
    		  presentData = presentData + String.valueOf(str.charAt(i));
      }
      presentData = presentData.split("X")[0];
      System.out.println(presentData);
   }
}