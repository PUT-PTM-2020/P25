import com.fazecast.jSerialComm.*;

public class Communication {
static public void run()
{
   SerialPort comPort = SerialPort.getCommPorts()[0];
   System.out.println(comPort.openPort());
   MessageListener listener = new MessageListener();
   comPort.addDataListener(listener);
   try { Thread.sleep(10000000); } catch (Exception e) { e.printStackTrace(); }
   comPort.removeDataListener();
   comPort.closePort();
}


}
