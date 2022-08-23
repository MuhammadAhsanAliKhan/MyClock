import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author Ahsan
 */
public class App implements ActionListener {
    public Timer timer;
    public Renderer rend;
    public static JFrame jframe;
    public static App obj= new App();
    public final static int WIDTH=400, HEIGHT=100;
    
    public static void main(String[] args) {
        obj= new App();
    }
    public App() {
        jframe= new JFrame("MyClock");
        
        // JLabel jlabel= new JLabel(time());
        rend= new Renderer();
        timer= new Timer(10, this);
        jframe.add(rend);
        // jframe.getContentPane().add(jlabel);
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
            g.setColor(Color.blue);
		    g.drawString(time(), 25, 25);
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
			App.obj.repaint(g);
		}
}
