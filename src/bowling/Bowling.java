package bowling;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bowling {
	
	public static void main(String[] args) {
		int done = 0;
		while(done == 0) {
			String scoreSheet = JOptionPane.showInputDialog("Enter Your Scoresheet\n(Separate each frame with hyphens)\nExample \"50-X-X-5/-X-12-36-90-X-X6/\"");
			if(scoreSheet == null || scoreSheet.equals(""))
				System.exit(0);
			ArrayList<String> balls = new ArrayList<String>();
			for(String frames:scoreSheet.split("-")) {
				for(String ball:frames.split(""))
					balls.add(ball);
			}
			System.out.println(balls.toString());
			//JOptionPane.showMessageDialog(null, "Score Sheet Entered: " + scoreSheet + "\n" + "Final Score: " + finalScore);
			done = JOptionPane.showConfirmDialog(null, "Would you like to enter another score sheet?");
		}
	}

}
