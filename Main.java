package com.mycompany.clock;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Ahsan
 */
public class Main {
    public Timer timer;
    public static JFrame jframe;
    public static Main obj= new Main();
    public final static int WIDTH=400, HEIGHT=100;
    
    public static void main(String[] args) {
        obj.window();
    }
    public void window() {
        jframe= new JFrame("MyClock");
        
        JLabel jlabel= new JLabel(obj.time());
        
        jframe.getContentPane().add(jlabel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
    public String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String time_var= dtf.format(now);
        return time_var;  
    }
}
