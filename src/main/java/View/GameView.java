package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameView {
	private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel panelGreen = new JPanel();
    private JPanel contentPane = new JPanel();
    
    public GameView() {
    	frame.setBounds(100, 100, 900, 900);
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    	frame.setContentPane(contentPane);
    	contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 8, 0, 0));

    	
    	
		JPanel[] list_of_labels = new JPanel[64];
		for(int row = 0; row <= 7; row++) {
			for(int column = 0;column <= 7;column++) {
			    JLayeredPane lpane = new JLayeredPane();
			    JPanel square = new JPanel();
			    JLabel piece = new JLabel();
			    lpane.setPreferredSize(new Dimension(75,75));
			    square.setSize(100, 100);
			    piece.setSize(75, 75);
			    BufferedImage img = null;
			    
			    //setup yellow (light) squares
			    if ((row+column)%2 == 0) {
			    	square.setBackground(new Color(254,254,190));
			    	
			    }
			    
			    //setup brown (dark) squares
			    if ((row+column)%2 == 1){
			    	square.setBackground(new Color(149,75,0));
			    }
			    
			    
			    //setup black castles
			    if(row*8 + column == 0 || row*8 + column == 7) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_Castle.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    
			    //setup black rooks
			    if(row*8 + column == 1 || row*8 + column == 6) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_Rook.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    //setup black bishops
			    if(row*8 + column == 2 || row*8 + column == 5) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_Bishop.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    //setup black queen
			    if(row*8 + column == 3) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_Queen.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    //setup black king
			    if(row*8 + column == 4) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_King.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    //setup black pawns
			    if(row == 1) {
			    	
			    	try {
						URL url = getClass().getResource("img/Black_Pawn.png");
						File file = new File(url.getPath());
					    img = ImageIO.read(file);
					} catch (IOException e) {
					    e.printStackTrace();
					}
					System.out.println(piece.getWidth());
					Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
					        Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					
					piece.setIcon(imageIcon);
					
			    }
			    
			    lpane.add(square, 0, 0);
			    lpane.add(piece, 0, 0);
			    panel.add(lpane);
		        list_of_labels[row*8 +column] = square;

			}
		}
		
        frame.pack();
        frame.setVisible(true);
        /*
        panelBlue.setBackground(Color.BLUE);
        panelBlue.setBounds(0, 0, 100, 100);
        panelBlue.setOpaque(true);
        panelGreen.setBackground(Color.GREEN);
        panelGreen.setBounds(200, 100, 100, 100);
        panelGreen.setOpaque(true);
        lpane.add(panelBlue, 0, 0);
        lpane.add(panelGreen, 0, 0);
        frame.pack();
        frame.setVisible(true);
        */
    }
    
    public static void main(String[] args) {
        new GameView();
    }
}
