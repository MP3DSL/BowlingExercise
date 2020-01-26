package JUnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bowling.Bowling;
import util.CustomList;
import util.CustomIterator;
import util.Node;

class ExerciseTesting {

	@Test
	void bowlingTest() {
		//\/\/\/\/\/\/ Testing Ball to Point Conversion \/\/\/\/\/\/\//
		System.out.println("\n//\\/\\/\\/\\/\\/\\/ Testing Ball to Point Conversion \\/\\/\\/\\/\\/\\/\\//");
		assertEquals(10, Bowling.getPoints("X", null));
		assertEquals(9, Bowling.getPoints("9", null));
		assertEquals(10, Bowling.getPoints("X", "9"));
		assertEquals(10, Bowling.getPoints("X", "1"));
		assertEquals(1, Bowling.getPoints("/", "9"));
		assertEquals(-1, Bowling.getPoints("/", null));
		
		
		//\/\/\/\/\/\/ Testing Adding List of Balls Together \/\/\/\/\/\/\//
		System.out.println("\n//\\/\\/\\/\\/\\/\\/ Testing Adding List of Balls Together \\/\\/\\/\\/\\/\\/\\//");
		CustomList<String> balls = new CustomList<String>();
		for(int i = 1; i<=5; i++)
			balls.add(""+i);
		assertEquals(15, Bowling.addBalls(balls));
		balls.add("/");
		System.out.println();
		assertEquals(20, Bowling.addBalls(balls));
		balls.add("X");
		System.out.println();
		assertEquals(30, Bowling.addBalls(balls));
		balls.add("X");
		System.out.println();
		assertEquals(50, Bowling.addBalls(balls));
		balls.add("X");
		System.out.println();
		assertEquals(60, Bowling.addBalls(balls));
		
		//\/\/\/\/\/\/ Testing Score Calculation \/\/\/\/\/\/\//
		System.out.println("\n//\\/\\/\\/\\/\\/\\/ Testing Score Calculation \\/\\/\\/\\/\\/\\/\\//");
		assertEquals(300, Bowling.calcScore("X-X-X-X-X-X-X-X-X-XXX"));
		System.out.println();
		assertEquals(150, Bowling.calcScore("50-X-X-5/-X-12-36-90-X-X6/"));
		System.out.println();
		assertEquals(158, Bowling.calcScore("50-X-X-5/-X-12-36-90-X-XX4"));
		System.out.println();
		assertEquals(144, Bowling.calcScore("50-X-X-5/-X-12-36-90-X-6/X"));
		System.out.println();
		assertEquals(140, Bowling.calcScore("50-X-X-5/-X-12-36-90-9/-6/X"));
		System.out.println();
		assertEquals(154, Bowling.calcScore("50-X-X-5/-X-12-36-90-9/-XXX"));
		System.out.println();
		assertEquals(80, Bowling.calcScore("44-44-44-44-44-44-44-44-44-44"));
		System.out.println();
		assertEquals(190, Bowling.calcScore("9/-9/-9/-9/-9/-9/-9/-9/-9/-9/9"));
	}

	@Test
	void customDataStructure() {
		//\/\/\/\/\/\/ Testing Node Class \/\/\/\/\/\/\//
		System.out.println("\n\\/\\/\\/\\/\\/\\/ Testing Node Class \\/\\/\\/\\/\\/\\/\\//");
		Node<String> num = new Node<String>("6", null, null);
		assertEquals("6", num.getData());
		num.setNext(num);
		assertEquals("6", num.getNext().getData());
		assertEquals(null, num.getPrev());
		
		//\/\/\/\/\/\/ Testing CustomList Class \/\/\/\/\/\/\//
		System.out.println("\n//\\/\\/\\/\\/\\/\\/ Testing CustomList Class \\/\\/\\/\\/\\/\\/\\//");
		CustomList<String> list = new CustomList<String>();
		for(int i = 0; i<5; i++)
			list.add("" + i);
		assertEquals(5, list.size());
		assertEquals("0", list.getHead().getData());
		assertEquals("4", list.getTail().getData());
		assertEquals("0, 1, 2, 3, 4", list.toString());
		
		
		//\/\/\/\/\/\/ Testing CustomIterator Class \/\/\/\/\/\/\//
		System.out.println("\n//\\/\\/\\/\\/\\/\\/ Testing CustomIterator Class \\/\\/\\/\\/\\/\\/\\//");
		CustomIterator<String> iter = list.iterator();
		assertEquals(true, iter.hasNext());
		assertEquals(false, iter.hasPrev());
		assertEquals("0", iter.next());
		assertEquals("1", iter.next());
		assertEquals(true, iter.hasPrev());
		assertEquals("1", iter.prev());
		assertEquals("0", iter.prev());
		iter.next();
		iter.next();
		iter.next();
		iter.next();
		assertEquals("4", iter.next());
		assertEquals(false, iter.hasNext());		
	}
}
