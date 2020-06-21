package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class GameView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameView window = new GameView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(8, 8, 0, 0));
		
		JLabel[] list_of_labels = new JLabel[64];
		for(int row = 0; row <= 7; row++) {
			for(int column = 0;column <= 7;column++) {
				JLabel label = new JLabel(Integer.toString(row*8 + column));
				label.setHorizontalAlignment(JLabel.CENTER);
		        label.setVerticalAlignment(JLabel.CENTER);
				
				if ((row+column)%2 == 0) {
					label.setIcon(new ImageIcon(getClass().getResource("brown_square.png")));
				}else {
					label.setIcon(new ImageIcon(getClass().getResource("pale_square.png")));
				}
				list_of_labels[row*8 +column] = label;
				frame.getContentPane().add(list_of_labels[row*8 +column]);
			}
		}
		

	}

}
