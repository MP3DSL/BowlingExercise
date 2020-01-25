package bowling;

import javax.swing.JOptionPane;

import util.CustomIterator;
import util.CustomList;

public class Bowling {
	
	public static void main(String[] args) {
		int done = 0;
		while(done == 0) {
			String scoreSheet = JOptionPane.showInputDialog("Enter Your Scoresheet\n(Separate each frame with hyphens)\nExample \"50-X-X-5/-X-12-36-90-X-X6/\"");
			if(scoreSheet == null || scoreSheet.equals(""))
				System.exit(0);
			CustomList<String> balls = new CustomList<String>();
			for(String frames:scoreSheet.split("-")) {
				for(String ball:frames.split(""))
					balls.add(ball);
			}
			System.out.println(balls.toString());
			int finalScore = addBalls(balls);
			JOptionPane.showMessageDialog(null, "Score Sheet Entered: " + scoreSheet + "\n" + "Final Score: " + finalScore);
			done = JOptionPane.showConfirmDialog(null, "Would you like to enter another score sheet?");
		}
	}
	
	private static int getPoints(String ball, String prevBall) {
		switch(ball) {
			case "X":
				return 10;
			case "/":
				return 10 - Integer.parseInt(prevBall);
			default:
				return Integer.parseInt(ball);				
		}
	}
	
	private static int addBalls(CustomList<String> balls) {
		int totalScore = 0;
		CustomIterator<String> ball = new CustomIterator<String>(balls);
		while(ball.hasNext()) {
			String prevBall = null;
			String score = ball.next();
			switch (score){
				case "X":
					totalScore += 10;
					if(ball.hasNext()) {
						totalScore += getPoints(ball.next(), prevBall);
						if(ball.hasNext())
							totalScore += getPoints(ball.next(), prevBall);
						ball.prev();
					}
					break;
					
				case "/":
					if(ball.hasNext())
						totalScore += getPoints(ball.next(), prevBall);
					break;
					
				default:
					totalScore += Integer.parseInt(score);
			}
		}
		return totalScore;
	}
}
