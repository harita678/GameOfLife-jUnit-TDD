import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TheGameOfLifeTest
{
   TheGameOfLife gol;

   //Creating object
   @BeforeEach
   public void beforEach()
   {
      gol = new TheGameOfLife();
   }

   //initialize Grid
   @Test
   public void Test001InitializeGrid()
   {
      gol.initalizeGrid();
      assertEquals(0, gol.getTotalAliveCells());
   }

   //testing display of game
   @Test
   public void Test002DisplyGrid()
   {

      //@formatter:off
      String expectedDisplay = 
              "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" ;
      //@formatter:on
      gol.initalizeGrid();
      String actualDisplay = gol.displyGrid();

      assertEquals(expectedDisplay, actualDisplay);

   }

   //testing display of game
   @Test
   public void Test003DisplyGrid()
   {

      //@formatter:off
      String expectedDisplay = 
              "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|*|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|*|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|*|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|*|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" 
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n"
            + "|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" ;
      //@formatter:on
      gol.initalizeGrid();
      gol.makeLiveCell(1, 1);
      gol.makeLiveCell(2, 2);
      gol.makeLiveCell(3, 3);
      gol.makeLiveCell(4, 4);
      String actualDisplay = gol.displyGrid();

      assertEquals(expectedDisplay, actualDisplay);

   }

   //test for taking valid user input
   @Test
   public void Test004TakeUserInputValid()
   {
      gol.input = new Scanner(new ByteArrayInputStream("1 1 2 2 2 3 2 4 -1".getBytes()));
      gol.takeUserInput();
      assertTrue(gol.grid[1][1] == 1 && gol.grid[2][2] == 1 && gol.grid[2][3] == 1 && gol.grid[2][4] == 1);
   }

   //test for taking invalid row input
   @Test
   public void Test005TakeUserInputInValidRow()
   {
      gol.input = new Scanner(new ByteArrayInputStream("20 1 2 2 2 3 2 4 -1".getBytes()));
      gol.takeUserInput();
      assertTrue(gol.grid[2][3] == 1 && gol.grid[2][2] == 1 && gol.grid[2][3] == 1 && gol.grid[2][4] == 1);
   }

   //test for taking invalid column input
   @Test
   public void Test006TakeUserInputInValidColumn()
   {
      gol.input = new Scanner(new ByteArrayInputStream("2 1 2 20 2 3 2 4 -1".getBytes()));
      gol.takeUserInput();
      assertTrue(gol.grid[2][1] == 1 && gol.grid[2][3] == 1 && gol.grid[2][4] == 1);
   }

   //test for taking invalid row and column input
   @Test
   public void Test007TakeUserInputInValidRowColumn()
   {
      gol.input = new Scanner(new ByteArrayInputStream("2 1 20 20 2 3 2 4 -1".getBytes()));
      gol.takeUserInput();
      assertTrue(gol.grid[2][1] == 1 && gol.grid[2][3] == 1 && gol.grid[2][4] == 1);
   }

   //test of making live cell
   @Test
   public void Test008MakeLiveCell()
   {

      assertTrue(gol.makeLiveCell(3, 4));

   }

   //test of making live cell where row number >19
   @Test
   public void Test009MakeLiveCellWithMoreThan20Row()
   {

      assertFalse(gol.makeLiveCell(20, 4));

   }

   //test of making live cell where column number >19
   @Test
   public void Test010MakeLiveCellWithMoreThan20Column()
   {

      assertFalse(gol.makeLiveCell(3, 20));

   }

   //test of making live cell where column number and row number >19
   @Test
   public void Test011MakeLiveCellWithMoreThan20RowColumn()
   {

      assertFalse(gol.makeLiveCell(20, 20));

   }

   //test of making live cell where row number < -1
   @Test
   public void Test012MakeLiveCellWithnegativeRow()
   {

      assertFalse(gol.makeLiveCell(-1, 1));

   }

   //test of making live cell where column number < -1
   @Test
   public void Test013MakeLiveCellWithnegativeColumn()
   {

      assertFalse(gol.makeLiveCell(1, -1));

   }

   //test of making live cell where column number and row number < -1
   @Test
   public void Test014MakeLiveCellWithnegativeColumnRow()
   {

      assertFalse(gol.makeLiveCell(-1, -1));

   }

   //test for counting number of alive cells at (3,4)
   @Test
   public void Test015FindLiveNeighbours()
   {

      gol.makeLiveCell(2, 4);
      gol.makeLiveCell(2, 3);
      gol.makeLiveCell(3, 5);
      //   gof.makeLiveCell(3, 4);
      assertEquals(3, gol.findLiveNeighbours(3, 4));
   }

   //test for counting number of alive cells at (0,0)
   @Test
   public void Test016FindLiveNeighbours()
   {

      gol.makeLiveCell(1, 1);

      assertEquals(1, gol.findLiveNeighbours(0, 0));
   }

   //test for counting number of alive cells at (1,19)
   @Test
   public void Test017FindLiveNeighbours()
   {

      gol.makeLiveCell(2, 19);
      gol.makeLiveCell(1, 18);
      gol.makeLiveCell(0, 19);
      assertEquals(3, gol.findLiveNeighbours(1, 19));
   }

   //test for counting number of alive cells at (19,3)
   @Test
   public void Test018FindLiveNeighbours()
   {

      gol.makeLiveCell(19, 2);
      gol.makeLiveCell(18, 3);

      assertEquals(2, gol.findLiveNeighbours(19, 3));
   }

   //test for counting number of alive cells at (19,18)
   @Test
   public void Test019FindLiveNeighbours()
   {

      gol.makeLiveCell(19, 19);
      gol.makeLiveCell(18, 17);

      assertEquals(2, gol.findLiveNeighbours(19, 18));
   }

   //test for counting number of alive cells at (7,0)
   @Test
   public void Test020FindLiveNeighbours()
   {

      gol.makeLiveCell(8, 0);
      gol.makeLiveCell(6, 0);

      assertEquals(2, gol.findLiveNeighbours(7, 0));
   }

   //test for counting number of alive cells at (0,18)
   @Test
   public void Test021FindLiveNeighbours()
   {

      gol.makeLiveCell(1, 18);

      assertEquals(1, gol.findLiveNeighbours(0, 18));
   }

   //test for counting number of alive cells at (19,19)
   @Test
   public void Test022FindLiveNeighbours()
   {

      gol.makeLiveCell(18, 19);
      gol.makeLiveCell(18, 18);

      assertEquals(2, gol.findLiveNeighbours(19, 19));
   }

   //test for counting number of alive cells at (0,19)
   @Test
   public void Test023FindLiveNeighbours()
   {

      gol.makeLiveCell(0, 18);

      gol.makeLiveCell(1, 19);
      assertEquals(2, gol.findLiveNeighbours(0, 19));
   }

   //test for counting number of alive cells at (19,0)
   @Test
   public void Test024FindLiveNeighbours()
   {

      gol.makeLiveCell(18, 0);

      gol.makeLiveCell(19, 1);
      assertEquals(2, gol.findLiveNeighbours(19, 0));
   }

   //test for counting number of alive cells at (0,1)
   @Test
   public void Test025FindLiveNeighbours()
   {

      gol.makeLiveCell(18, 0);

      gol.makeLiveCell(19, 1);
      assertEquals(2, gol.findLiveNeighbours(19, 0));
   }

   //Test for finding Total Alive cell
   @Test
   public void Test026GetTotalAliveCells()
   {
      gol.makeLiveCell(2, 5);
      gol.makeLiveCell(2, 6);
      gol.makeLiveCell(2, 7);
      gol.makeLiveCell(3, 5);
      assertEquals(4, gol.getTotalAliveCells());
   }

   //Tests for different types of patterns

   //Test Blinker pattern
   // *
   // * -> * * *
   // *
   @Test
   public void Test027generateNextPatternBlinker()
   {
      gol.makeLiveCell(4, 3);
      gol.makeLiveCell(4, 4);
      gol.makeLiveCell(4, 5);
      gol.generateNextPattern();

      assertEquals(3, gol.getTotalAliveCells());
   }

   //Test Block pattern  
   // *  * -> *  *
   // *  *    *  *
   @Test
   public void Test028generateNextPatternBlock()
   {

      gol.makeLiveCell(4, 4);
      gol.makeLiveCell(4, 5);
      gol.makeLiveCell(5, 4);
      gol.makeLiveCell(5, 5);
      gol.generateNextPattern();

      assertEquals(4, gol.getTotalAliveCells());
   }

   //Test 10 cell row pattern  
   //                            * * * * * * * *
   //  * * * * * * * * * *  -->  * * * * * * * *
   //                            * * * * * * * *
   @Test
   public void Test029generateNextPattern10CellRow()
   {

      gol.makeLiveCell(4, 4);
      gol.makeLiveCell(4, 5);
      gol.makeLiveCell(4, 6);
      gol.makeLiveCell(4, 7);
      gol.makeLiveCell(4, 8);
      gol.makeLiveCell(4, 9);
      gol.makeLiveCell(4, 10);
      gol.makeLiveCell(4, 11);
      gol.makeLiveCell(4, 12);
      gol.makeLiveCell(4, 13);

      gol.generateNextPattern();

      assertEquals(24, gol.getTotalAliveCells());
   }

   //Test for Random Pattern
   @Test
   public void Test030generateNextPattern()
   {
      gol.makeLiveCell(2, 5);
      gol.makeLiveCell(2, 6);
      gol.makeLiveCell(2, 7);
      gol.makeLiveCell(3, 5);
      gol.makeLiveCell(3, 7);
      gol.makeLiveCell(4, 5);
      gol.makeLiveCell(4, 6);
      gol.makeLiveCell(4, 7);

      gol.generateNextPattern();

      assertEquals(8, gol.getTotalAliveCells());

   }

}
