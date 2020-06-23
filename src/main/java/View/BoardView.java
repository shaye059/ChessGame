package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardView frame = new BoardView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoardView() {
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 8, 0, 0));
		
		JLabel[] list_of_labels = new JLabel[64];
		for(int row = 0; row <= 7; row++) {
			for(int column = 0;column <= 7;column++) {
				JLabel label = new JLabel();
				label.setHorizontalAlignment(JLabel.CENTER);
		        label.setVerticalAlignment(JLabel.CENTER);
		        label.setSize(100, 100);

		        
		        BufferedImage img = null;
				if ((row+column)%2 == 0) {
					try {
						URL url = getClass().getResource("img/Brown_Black_Bishop.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(label.getWidth());
					Image dimg = img.getScaledInstance((int) Math.round(label.getWidth()*0.75), (int) Math.round(label.getHeight()*0.75),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					label.setIcon(imageIcon);
					
					panel.add(label);
			        list_of_labels[row*8 +column] = label;
				}else {
					try {
						URL url = getClass().getResource("img/Yellow_Black_Bishop.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(label.getWidth());
					Image dimg = img.getScaledInstance((int) Math.round(label.getWidth()*0.75), (int) Math.round(label.getHeight()*0.75),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					label.setIcon(imageIcon);
					
					panel.add(label);
			        list_of_labels[row*8 +column] = label;
				}
				//list_of_labels[row*8 +column] = label;
				//frame.getContentPane().add(list_of_labels[row*8 +column]);
			}
		}
	}

}
