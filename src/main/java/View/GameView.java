package View;

import java.awt.BorderLayout;
import model.Piece;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Board;

public class GameView implements MouseListener {
	private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel panelGreen = new JPanel();
    private JPanel contentPane = new JPanel();
    private Board playing_board;
    private JPanel[][] list_of_labels;
    private JLayeredPane click1label = null;
    private JLayeredPane selected_square = null;
    //private List<JLayeredPane> selected_squares = new ArrayList<JLayeredPane>();
    
    // Initiates a view of the game board based on the model
    public GameView(Board playing_board) {
    	frame.setBounds(100, 100, 900, 900);
    	frame.setMinimumSize(new Dimension(650,650));
    	frame.addComponentListener(new ComponentAdapter() {
    	      public void componentResized(ComponentEvent evt) {
    	        Dimension size = frame.getSize();
    	        Dimension min = frame.getMinimumSize();
    	        if (size.getWidth() < min.getWidth()) {
    	          frame.setSize((int) min.getWidth(), (int) size.getHeight());
    	        }
    	        if (size.getHeight() < min.getHeight()) {
    	          frame.setSize((int) size.getWidth(), (int) min.getHeight());
    	        }
    	      }
    	    });
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    	frame.setContentPane(contentPane);
    	contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 8, 0, 0));
		this.playing_board = playing_board;

    	
    	
		list_of_labels = new JPanel[8][8];
		for(int row = 0; row <= 7; row++) {
			for(int column = 0;column <= 7;column++) {
			    JLayeredPane lpane = new JLayeredPane();
			    JPanel square = new JPanel();
			    JLabel piece = new JLabel();
			    lpane.setPreferredSize(new Dimension(75,75));
			    square.setSize(100, 100);
			    piece.setSize(75, 75);
			    String square_colour = playing_board.getBoard()[row][column].getColour();
			    boolean square_occupied = playing_board.getBoard()[row][column].isOccupied();
			    
			    //setup yellow (light) squares
			    if (square_colour.equals("White")) {
			    	square.setBackground(new Color(254,254,190));
			    	
			    }
			    
			    //setup brown (dark) squares
			    if (square_colour.equals("Black")){
			    	square.setBackground(new Color(149,75,0));
			    }
			    
			    
			    //setup black castles
			    if(square_occupied) {
			    	Piece occupying_piece = playing_board.getBoard()[row][column].getOccupyingPiece();
			    	placePiece(occupying_piece, piece);
			    }
			    
			    lpane.addMouseListener(this);
			    
			    
			    lpane.add(square, 0, 0);
			    lpane.add(piece, 0, 0);
			    panel.add(lpane);
		        list_of_labels[row][column] = square;

			}
		}
		
        frame.pack();
        frame.setVisible(true);
    }
    
    /* Private helper that takes a Piece object, and places the corresponding image on the
     * JLabel passed to the function.
     */
    private void placePiece(Piece piece_to_place, JLabel piece) {
    	String piece_type = piece_to_place.getPieceName();
    	String piece_colour = piece_to_place.getColour();
    	String img_name = "img/" + piece_colour + "_" + piece_type + ".png";
    	BufferedImage img = null;
    	
    	try {
			URL url = getClass().getResource(img_name);
			File file = new File(url.getPath());
		    img = ImageIO.read(file);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//System.out.println(piece.getWidth());
		Image dimg = img.getScaledInstance(piece.getWidth(),piece.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		piece.setIcon(imageIcon);
    	
    }
    
    public void mouseClicked(MouseEvent me) {
    	
    }
    
    
    // De-select the blue square isn't working. 
    public void mousePressed(MouseEvent e) {
    	click1label = (JLayeredPane) e.getSource();
    	if (selected_square != click1label) {
	    	JPanel highlight_square = new JPanel();
	    	highlight_square.setSize(100, 100);
	    	highlight_square.setBackground(new Color(0,0,255,75));
	    	click1label.add(highlight_square);
	    	int i = click1label.getIndexOf(highlight_square);
	    	click1label.setPosition(highlight_square, 0);
	    	System.out.println(click1label.getIndexOf(highlight_square));
	    	if(selected_square != null) {
	    		
	    		selected_square.remove(0);
	    		frame.repaint();
	    	}
	    	selected_square = click1label;
	    	frame.repaint();
    	}
     }

     public void mouseReleased(MouseEvent e) {

     }

     public void mouseEntered(MouseEvent e) {

     }

     public void mouseExited(MouseEvent e) {

     }
     
     public static void main(String[] args) {
     	Board playing_board = new Board();
         new GameView(playing_board);
     }

}
