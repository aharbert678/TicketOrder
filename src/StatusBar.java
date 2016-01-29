import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class StatusBar extends JComponent{
	
		
		final int TOTAL_BAR_SIZE = 300;
		int X = 0; 
		int Y = 0; 
		int X1 = TOTAL_BAR_SIZE; 
		int Y1 = 25; 
		Color tempC = Color.blue; 
	
		
		public void paintComponent(Graphics g) {
			g.drawRect(0,0,TOTAL_BAR_SIZE,Y1);
			g.setColor(tempC);
			g.fillRect(X, Y, X1, Y1);
			
		}
		
		public void setNewValue (int remainingTicket, int totalTicket){
			X1 = ((TOTAL_BAR_SIZE * remainingTicket) / totalTicket); 
			repaint(); 
		}
		}
