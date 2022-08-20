package com.mycompany.clock;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
/**
 *
 * @author Ahsan
 */
public class Main implements ActionListener {
    public Timer timer;
    public Renderer rend;
    public static JFrame jframe;
    public static Main obj= new Main();
    public final static int WIDTH=400, HEIGHT=100;
    
    public static void main(String[] args) {
        obj= new Main();
    }
    public Main() {
        jframe= new JFrame("MyClock");
        
        JLabel jlabel= new JLabel(time());
        rend= new Renderer();
        timer= new Timer(10, this);
        jframe.add(rend);
        jframe.getContentPane().add(jlabel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
        timer.start();
    }
    public String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String time_var= dtf.format(now);
        return time_var;  
    }
    
    public void repaint(Graphics g) 
    {
            //paint background
            g.setColor(Color.yellow);
            g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rend.repaint();
    }
}

class Renderer extends JPanel
	{

		private static final long serialVersionUID = 1L;
		
		@Override
		public void paint(Graphics g) 
		{
			super.paintComponents(g);
			Main.obj.repaint(g);
		}
}
