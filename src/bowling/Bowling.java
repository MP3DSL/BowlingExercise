package bowling;

import javax.swing.JOptionPane;

import util.CustomIterator;
import util.CustomList;

public class Bowling {
	
	public static void main(String[] args) {
		int done = 0;
		while(done == 0) {
			//Get ScoreSheet from the user
			String scoreSheet = JOptionPane.showInputDialog("Enter Your Scoresheet\n(Separate each frame with hyphens)\nExample \"50-X-X-5/-X-12-36-90-X-X6/\"");
			if(scoreSheet == null || scoreSheet.equals(""))
				System.exit(0);
			System.out.println(scoreSheet);
			int finalScore = calcScore(scoreSheet);
			System.out.println("Final Score: " + finalScore);
			JOptionPane.showMessageDialog(null, "Score Sheet Entered: " + scoreSheet + "\n" + "Final Score: " + finalScore);
			//Prompts User if they want to continue calculate more score sheets
			done = JOptionPane.showConfirmDialog(null, "Would you like to enter another score sheet?");
		}
	}
	
	/**
	 * Takes in a score sheet, breaks it down into balls thrown, and returns the final score
	 * @param scoreSheet game sheet with all of the values of each ball thrown in the form of a String
	 * @return the final score
	 */
	public static int calcScore(String scoreSheet) {	//Made public for testing purposes
		CustomList<String> balls = new CustomList<String>();
		//Breaks down the score sheet and adds the balls thrown to the list
		for(String frames:scoreSheet.split("-")) {
			for(String ball:frames.split(""))
				balls.add(ball);
		}
		int finalScore = addBalls(balls);
		return finalScore;
	}
	
	/**
	 * Takes in a list of balls thrown to calculate their total score
	 * @param balls list to be added
	 * @return total score of the list
	 */
	public static int addBalls(CustomList<String> balls) { //Made public for testing purposes
		int totalScore = 0;
		CustomIterator<String> ball = balls.iterator();
		String prevBall = null;
		String score = null;
		while(ball.hasNext()) {
			prevBall = score;
			score = ball.next();
			System.out.println("Score: " + score);
			switch (score){
				//If current ball is a Strike, check and add the next two balls' score to this one
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
						if(!ball.hasNext())
							break;
						ball.prev();
					}
					break;
				
				//If current ball is a Spare, check and add the next ball's score to this one
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
				
				//Add all other numbers to the total score
				default:
					totalScore += Integer.parseInt(score);
			}
			System.out.println("Total Score: " + totalScore);
		}
		return totalScore;
	}
	
	/**
	 * Gets the point value of the current thrown ball (Converts the string to an integer)
	 * @param ball Current thrown ball 
	 * @param prevBall Ball thrown prior to the current ball to calculate spare points if the current ball is a spare
	 * @return point value of the current thrown ball in the form of an integer
	 */
	public static int getPoints(String ball, String prevBall) { //Made public for testing purposes
		switch(ball) {
			//If it's a Strike
			case "X":
				return 10;
			//If it's a Spare
			case "/":
				if(prevBall == null) {
					System.out.println("Spare Needs to have a reference to the ball before it");
					return -1;
				}
				return 10 - Integer.parseInt(prevBall);
			//If it's any other number
			default:
				return Integer.parseInt(ball);				
		}
	}
}
