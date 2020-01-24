package bowling;

import javax.swing.JOptionPane;

public class Bowling {
	
	private static int finalScore = 0;

	public static void main(String[] args) {
		String scoreSheet = JOptionPane.showInputDialog("Enter Your Scoresheet\n(Separate each frame with hyphens)\nExample \"50-X-X-5/-X-12-36-90-X-X6/\"");
		String[] dividedScoreSheet = scoreSheet.split("-");
		for(String score:dividedScoreSheet) {
			System.out.println(score+"\n");
			finalScore += addFrame(score);
		}
		System.out.println("Score Sheet Entered: " + scoreSheet);
		System.out.println("Final Score:" + finalScore);
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

}
