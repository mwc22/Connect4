package logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLogic {

	@Test
	public void testFastWin() {
		GameBoard testBoard = new GameBoard();
		testBoard.print();
		assertFalse("Game not over",testBoard.gameOver());
		assertEquals("Red player goes first","RED",testBoard.getPlayer());
		assertTrue("Red Player places a piece",testBoard.placePiece(0));
		assertEquals("Black player goes second","BLACK",testBoard.getPlayer());
		assertFalse("Game not over",testBoard.gameOver());
		testBoard.print();
		assertTrue("Black Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertEquals("Red player's turn again","RED",testBoard.getPlayer());
		assertTrue("Red Player places a piece",testBoard.placePiece(1));
		testBoard.print();
		assertTrue("Black Player places a piece",testBoard.placePiece(1));
		testBoard.print();
		assertTrue("Red Player places a piece",testBoard.placePiece(2));
		testBoard.print();
		assertFalse("Game not over",testBoard.gameOver());
		assertTrue("Black Player places a piece",testBoard.placePiece(2));
		testBoard.print();
		assertTrue("Red Player places a piece",testBoard.placePiece(3));
		testBoard.print();
		assertTrue("Red Player wins the game",testBoard.gameOver());
		assertEquals("Red player is still active","RED",testBoard.getPlayer());
	}
	
	@Test
	public void testFullColumn() {
		GameBoard testBoard = new GameBoard();
		testBoard.print();
		assertTrue("Red Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertTrue("Black Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertTrue("Red Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertTrue("Black Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertTrue("Red Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertTrue("Black Player places a piece",testBoard.placePiece(0));
		testBoard.print();
		assertFalse("Red Player can't place a piece there",testBoard.placePiece(0));
		testBoard.print();
		assertEquals("Red Player still","RED",testBoard.getPlayer());
	}

}
