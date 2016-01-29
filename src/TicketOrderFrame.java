import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketOrderFrame extends JFrame {
	StatusBar bar = new StatusBar();
	JLabel errorL = new JLabel();
	JLabel soldOutL = new JLabel();
	final int totalTickets = 75;
	TicketOrder order = new TicketOrder(totalTickets);
	JTextField amount = new JTextField(10);

	public TicketOrderFrame() {
		
		JFrame frame = new JFrame(); 
		JPanel panel = new JPanel(); 
		JButton button = new JButton("Purchase Tickets"); 
		JLabel label = new JLabel("Enter how many tickets you'd like to purchase (1-6):");

		bar.setPreferredSize(new Dimension(301, 26));
		
		ActionListener p = new purchaseClickListener(); 
		button.addActionListener(p); 
		
		panel.add(amount); 
	    panel.add(button); 
	    panel.add(errorL);
	    panel.add(bar); 
	
		
		frame.getContentPane().add(BorderLayout.NORTH, label);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, soldOutL);
		
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	class purchaseClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				errorL.setText("");
				order.decreaseTicket(Integer.parseInt(amount.getText()));
				errorL.setText(order.getErrorMsg());
				amount.setText("");
				int X = order.getTicketBalance();
				int Y = totalTickets; 
				bar.setNewValue(X, Y);
				if (X == 0) {
					soldOutL.setText("Event is sold out.");
				}
				
			} catch (NumberFormatException e) {
				errorL.setText("Please enter a number only.");
				amount.setText("");
			}
		}

	}

}
