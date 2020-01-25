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
			int finalScore = addBalls(balls);
			System.out.println(balls.toString());
			System.out.println("Final Score: " + finalScore);
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
		String prevBall = null;
		String score = null;
		while(ball.hasNext()) {
			prevBall = score;
			score = ball.next();
			System.out.println("Score: " + score);
			switch (score){
				case "X":
					totalScore += getPoints(score, prevBall);
					if(ball.hasNext()) {
						prevBall = score;
						score = ball.next();
						totalScore += getPoints(score, prevBall);
						if(ball.hasNext()) {
							prevBall = score;
							totalScore += getPoints(ball.next(), prevBall);
							if(!ball.hasNext())
								break;
							ball.prev();
						}
						ball.prev();
					}
					break;
					
				case "/":
					totalScore += getPoints(score, prevBall);
					if(ball.hasNext()) {
						prevBall = score;
						totalScore += getPoints(ball.next(), prevBall);
						if(!ball.hasNext())
							break;
						ball.prev();
					}
					break;
					
				default:
					totalScore += Integer.parseInt(score);
			}
			System.out.println("Total Score: " + totalScore);
		}
		return totalScore;
	}
}
