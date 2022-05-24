package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe {
	JFrame jf = new JFrame();
    JButton[] b = new JButton[9];
    Boolean p1 = true;
    Boolean Flag = true;
    Panel p = new Panel();
    JLabel l = new JLabel();

    public TicTacToe() {

        jf.setTitle("TIC TACK TOE");
        jf.setSize(500, 500);
        jf.getContentPane().setBackground(Color.BLACK);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);

        l.setBounds(178, 0, 200, 50);
        l.setText("O Turn");
        l.setFont(new Font("", Font.BOLD, 40));
        l.setForeground(Color.WHITE);

        p.setBounds(-2, 64, 500, 400);
        p.setLayout(new GridLayout(3, 3));

        for(int i = 0; i < 9; i++){
            b[i] = new JButton();
            b[i].setFont(new Font("", Font.BOLD, 100));
            b[i].addActionListener(a);
            b[i].setFocusable(false);
            p.add(b[i]);
        }

        jf.add(l);
        jf.add(p);
        jf.setVisible(true);
    }
    
    ActionListener a = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 9; i++) {
	            if (e.getSource() == b[i]) {
	                if (p1 && b[i].getText().equals("")) {
	                    b[i].setText("O");
	                    p1 = false;
	                    win();
	                    if (Flag) {
	                        l.setText("X Turn");
	                    } else if (!Flag) {
	                        l.setForeground(Color.green);
	                        l.setText("O Wins");
	                    }
	                    draw();
	                }
	                else if (!p1 && b[i].getText().equals("")) {
	                    b[i].setText("X");
	                    p1 = true;
	                    win();
	                    if (Flag) {
	                        l.setText("0 Turn");
	                    }  
	                    else if (!Flag) {
	                        l.setForeground(Color.green);
	                        l.setText("X Wins");
	                    }
	                    draw();
	                }
	            }
	        }
		}
	};  

	void win(){
        check(0, 1, 2);
        check(3, 4, 5);
        check(0, 3, 6);
        check(1, 4, 7);
        check(2, 5, 8);
        check(0, 4, 8);
        check(2, 4, 6);
        check(6, 7, 8);
    }
	
    void check(int x, int y, int z){
        if(b[x].getText().equals("O") && b[y].getText().equals("O") && b[z].getText().equals("O")){
            b[x].setForeground(Color.green);
            b[y].setForeground(Color.green);
            b[z].setForeground(Color.green);
            Flag = false;
            for(int i = 0; i < 9; i++){
                    b[i].removeActionListener(a);             
            }
        }
        else if(b[x].getText().equals("X") && b[y].getText().equals("X") && b[z].getText().equals("X")){
            b[x].setForeground(Color.green);
            b[y].setForeground(Color.green);
            b[z].setForeground(Color.green);
            Flag = false;
            for(int i = 0; i < 9; i++){
            	b[i].removeActionListener(a);
            }
        }
    }

    void draw(){
        if(!b[1].getText().equals("") && !b[2].getText().equals("") && !b[3].getText().equals("") && !b[4].getText().equals("") && !b[5].getText().equals("")
        && !b[6].getText().equals("") && !b[7].getText().equals("") && !b[8].getText().equals("")) {

            if(!b[1].getForeground().equals(Color.green) && !b[2].getForeground().equals(Color.green) && !b[3].getForeground().equals(Color.green)
                && !b[4].getForeground().equals(Color.green) && !b[5].getForeground().equals(Color.green) && !b[6].getForeground().equals(Color.green)
                && !b[7].getForeground().equals(Color.green) && !b[8].getForeground().equals(Color.green)) {

                l.setForeground(Color.red);
                l.setText("DRAW");
            }
        }
    }
}
