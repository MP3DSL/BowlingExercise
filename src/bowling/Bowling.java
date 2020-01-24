package bowling;

import javax.swing.JOptionPane;

public class Bowling {
	
	public static void main(String[] args) {
		int done = 0;
		while(done == 0) {
			String scoreSheet = JOptionPane.showInputDialog("Enter Your Scoresheet\n(Separate each frame with hyphens)\nExample \"50-X-X-5/-X-12-36-90-X-X6/\"");
			if(scoreSheet == null || scoreSheet.equals(""))
				System.exit(0);
			String[] dividedScoreSheet = scoreSheet.split("-");
			int finalScore = addFrames(dividedScoreSheet);
			System.out.println("Score Sheet Entered: " + scoreSheet);
			System.out.println("Final Score: " + finalScore);
			JOptionPane.showMessageDialog(null, "Final Score: " + finalScore);
			done = JOptionPane.showConfirmDialog(null, "Would you like to enter another score sheet?");
		}
	}
	
	private static int addFrame(String frame) {
		int totalScore = 0;
		for(String score:frame.split("")) {
			switch(score) {
				case "X":
					totalScore = 10;
					break;
					
				case"/":
					totalScore = 10;
					break;
					
				default:
					totalScore += Integer.parseInt(score);
			}
		}
		return totalScore;
	}
	
	private static int addFrames(String[] frames) {
		int totalScore = 0;
		for(int i = 0; i<frames.length; i++) {
			if(frames[i].contains("X") && i<8)
				totalScore += (addFrame(frames[i]) + addFrame(frames[i+1]) + addFrame(frames[i+2]));
			else if(frames[i].contains("/") && i<9)
				totalScore += (addFrame(frames[i] + addFrame(frames[i+1])));
			else
				totalScore += addFrame(frames[i]);
		}
		return totalScore;
	}

}
