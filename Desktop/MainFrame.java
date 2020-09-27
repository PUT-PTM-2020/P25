import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener{
	public static String temp, hum, pre, air, hgh;
    boolean isEnd = false;
    JButton bWTemp, bWCis, bWWil, bWPow, bWDeszcz;
    JButton bSiec, bUstawienia, bWyjscie;
    JLabel lTytTemp, lTytCis, lTytWil, lTytPow, lTytDeszcz;
    JLabel lDaneTemp, lDaneCis, lDaneWil, lDanePow, lDaneDeszcz;
    JLabel lData;
    MainFrame(){
        setSize(500,500);
        setTitle("DestopApp");
        setLayout(null);
        
        //Temperatura
        lTytTemp = new JLabel("Temperature: ");
        lTytTemp.setBounds(50, 50, 100, 20);
        add(lTytTemp);
        
        lDaneTemp = new JLabel("NO DATA");
        lDaneTemp.setBounds(200, 50, 100, 20);
        add(lDaneTemp);
        
        bWTemp = new JButton("Graph");
        bWTemp.setBounds(350, 50, 100, 20);
        add(bWTemp);
        bWTemp.addActionListener(this);
        
        //Cisnienie
        lTytCis = new JLabel("Pressure: ");
        lTytCis.setBounds(50, 100, 100, 20);
        add(lTytCis);
        
        lDaneCis = new JLabel("NO DATA");
        lDaneCis.setBounds(200, 100, 100, 20);
        add(lDaneCis);
        
        bWCis = new JButton("Graph");
        bWCis.setBounds(350, 100, 100, 20);
        add(bWCis);
        bWCis.addActionListener(this);
        
        //Wilgotnosc
        lTytWil = new JLabel("Humidity: ");
        lTytWil.setBounds(50, 150, 100, 20);
        add(lTytWil);
        
        lDaneWil = new JLabel("NO DATA");
        lDaneWil.setBounds(200, 150, 100, 20);
        add(lDaneWil);
        
        bWWil = new JButton("Graph");
        bWWil.setBounds(350, 150, 100, 20);
        add(bWWil);
        bWWil.addActionListener(this);
        
        //Czystosc powietrza
        lTytPow = new JLabel("Air: ");
        lTytPow.setBounds(50, 200, 100, 20);
        add(lTytPow);
        
        lDanePow = new JLabel("NO DATA");
        lDanePow.setBounds(200, 200, 100, 20);
        add(lDanePow);
        
        bWPow = new JButton("Graph");
        bWPow.setBounds(350, 200, 100, 20);
        add(bWPow);
        bWPow.addActionListener(this);
        
        //Deszcz
        lTytDeszcz = new JLabel("Rain: ");
        lTytDeszcz.setBounds(50, 250, 100, 20);
        add(lTytDeszcz);
        
        lDaneDeszcz = new JLabel("NO DATA");
        lDaneDeszcz.setBounds(200, 250, 100, 20);
        add(lDaneDeszcz);
        
        bWDeszcz = new JButton("Graph");
        bWDeszcz.setBounds(350, 250, 100, 20);
        add(bWDeszcz);
        bWDeszcz.addActionListener(this);
        
        //Pozostale przyciski
        bSiec = new JButton("Network");
        bSiec.setBounds(50, 300, 100, 20);
        add(bSiec);
        bSiec.addActionListener(this);
        
        bUstawienia = new JButton("Settings");
        bUstawienia.setBounds(200, 300, 100, 20);
        add(bUstawienia);
        bUstawienia.addActionListener(this);
        
        bWyjscie = new JButton("Exit");
        bWyjscie.setBounds(350, 300, 100, 20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);
        
        lData = new JLabel(new Date().toString());
        lData.setBounds(150, 360, 300, 20);
        lData.setForeground(new Color(200, 69,69));
        add(lData);
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source==bWyjscie){
            isEnd = true;
            dispose();
            System.exit(0);
        }
		else if(source==bWTemp){
			DataCointaner.readTemp();
            GraphPanel.createAndShowGui();
        }
		else if(source==bWCis){
			DataCointaner.readPre();
            GraphPanel.createAndShowGui();
        }
		else if(source==bWDeszcz){
			DataCointaner.readHgh();
            GraphPanel.createAndShowGui();
        }
		else if(source==bWPow){
			DataCointaner.readAir();
            GraphPanel.createAndShowGui();
        }
		else if(source==bWWil){
			DataCointaner.readHum();
            GraphPanel.createAndShowGui();
        }
        //TODO reszta przysiskow
    }
    
    public static void main(String[] args){
        MainFrame frame_main = new MainFrame();
        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.setVisible(true);
        
       
        Thread t1 = new Thread(() ->{
            
            Communication.run();
            
        });
        Thread t2 = new Thread(() ->{
        	try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
        	while(true) {
        		if (new Date().getHours() == 15) {
        			DataCointaner.readTemp();
        			DataCointaner.data.add(Double.valueOf(temp));
        			DataCointaner.writeTemp();
        			
        			DataCointaner.readHum();
        			DataCointaner.data.add(Double.valueOf(hum));
        			DataCointaner.writeHum();
        			
        			DataCointaner.readPre();
        			DataCointaner.data.add(Double.valueOf(pre));
        			DataCointaner.writePre();
        			
        			DataCointaner.readAir();
        			DataCointaner.data.add(Double.valueOf(air));
        			DataCointaner.writeAir();
        			
        			DataCointaner.readHgh();
        			DataCointaner.data.add(Double.valueOf(hgh));
        			DataCointaner.writeHgh();
        		}
        		try{Thread.sleep(3300000);}catch(Exception e) {e.printStackTrace();}
        	}
        });
        Thread t = new Thread(() ->{
            
            frame_main.refresh();   
            
        });
        
        t.start();
        t1.start();
        t2.start();
    }
    
    public void refresh(){
    	String temp = new String();
    	String cis = new String();
    	String wil = new String();
    	String pow= new String();
    	String deszcz = new String();
        while(!isEnd){
        	try {
        		lData.setText(new Date().toString());
        		temp = MessageListener.presentData.split("B")[0].split("A")[1] ;
        		cis = MessageListener.presentData.split("C")[0].split("B")[1];
        		wil = MessageListener.presentData.split("D")[0].split("C")[1];
        		pow = MessageListener.presentData.split("E")[0].split("D")[1] ;
        		deszcz =MessageListener.presentData.split("E")[1];
        		lDaneTemp.setText(temp+ " °C");
        		lDaneCis.setText(cis + " hPa");
        		lDaneWil.setText(wil + " %");
        		lDanePow.setText(pow+ " %");
        		lDaneDeszcz.setText(deszcz + " n. p. m.");
        		MainFrame.temp = temp;
        		MainFrame.pre = cis;
        		MainFrame.hum = wil;
        		MainFrame.air = pow;
        		MainFrame.hgh = deszcz;
        	} catch (Exception e) {
				//e.printStackTrace();
			}
        }
    }
}