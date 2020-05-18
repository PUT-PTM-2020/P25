import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener{
    boolean isEnd = false;
    JButton bWTemp, bWCis, bWWil, bWPow, bWDeszcz;
    JButton bSiec, bUstawienia, bWyjscie;
    JLabel lTytTemp, lTytCis, lTytWil, lTytPow, lTytDeszcz;
    JLabel lDaneTemp, lDaneCis, lDaneWil, lDanePow, lDaneDeszcz;
    JLabel lData;
    MainFrame(){
        setSize(500,400);
        setTitle("DestopApp");
        setLayout(null);
        
        //Temperatura
        lTytTemp = new JLabel("Temperatura: ");
        lTytTemp.setBounds(50, 50, 100, 20);
        add(lTytTemp);
        
        lDaneTemp = new JLabel("NO DATA");
        lDaneTemp.setBounds(200, 50, 100, 20);
        add(lDaneTemp);
        
        bWTemp = new JButton("Wykres");
        bWTemp.setBounds(350, 50, 100, 20);
        add(bWTemp);
        bWTemp.addActionListener(this);
        
        //Cisnienie
        lTytCis = new JLabel("Ciśnienie: ");
        lTytCis.setBounds(50, 100, 100, 20);
        add(lTytCis);
        
        lDaneCis = new JLabel("NO DATA");
        lDaneCis.setBounds(200, 100, 100, 20);
        add(lDaneCis);
        
        bWCis = new JButton("Wykres");
        bWCis.setBounds(350, 100, 100, 20);
        add(bWCis);
        bWCis.addActionListener(this);
        
        //Wilgotnosc
        lTytWil = new JLabel("Wilgotność: ");
        lTytWil.setBounds(50, 150, 100, 20);
        add(lTytWil);
        
        lDaneWil = new JLabel("NO DATA");
        lDaneWil.setBounds(200, 150, 100, 20);
        add(lDaneWil);
        
        bWWil = new JButton("Wykres");
        bWWil.setBounds(350, 150, 100, 20);
        add(bWWil);
        bWWil.addActionListener(this);
        
        //Czystosc powietrza
        lTytPow = new JLabel("Czystość Powietrza: ");
        lTytPow.setBounds(50, 200, 100, 20);
        add(lTytPow);
        
        lDanePow = new JLabel("NO DATA");
        lDanePow.setBounds(200, 200, 100, 20);
        add(lDanePow);
        
        bWPow = new JButton("Wykres");
        bWPow.setBounds(350, 200, 100, 20);
        add(bWPow);
        bWPow.addActionListener(this);
        
        //Deszcz
        lTytDeszcz = new JLabel("Deszcz: ");
        lTytDeszcz.setBounds(50, 250, 100, 20);
        add(lTytDeszcz);
        
        lDaneDeszcz = new JLabel("NO DATA");
        lDaneDeszcz.setBounds(200, 250, 100, 20);
        add(lDaneDeszcz);
        
        bWDeszcz = new JButton("Wykres");
        bWDeszcz.setBounds(350, 250, 100, 20);
        add(bWDeszcz);
        bWDeszcz.addActionListener(this);
        
        //Pozostale przyciski
        bSiec = new JButton("Sieć");
        bSiec.setBounds(50, 300, 100, 20);
        add(bSiec);
        bSiec.addActionListener(this);
        
        bUstawienia = new JButton("Ustawienia");
        bUstawienia.setBounds(200, 300, 100, 20);
        add(bUstawienia);
        bUstawienia.addActionListener(this);
        
        bWyjscie = new JButton("Wyjscie");
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
        }
        //TODO reszta przysiskow
    }
    
    public static void main(String[] args){
        MainFrame frame_main = new MainFrame();
        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.setVisible(true);
        
        Thread t = new Thread(() ->{
            
            frame_main.refresh();   
            
        });
        t.start();
    }
    
    public void refresh(){
        while(!isEnd){
            lData.setText(new Date().toString());
        }
    }
}