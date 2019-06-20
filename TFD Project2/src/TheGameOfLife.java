import java.util.Scanner;

// @author Harita Gandhi
// Description: This is a program for Conway’s “The Game of Life"

// This program does following things...
// 1. 2 dimensional grid 20 x 20 (2D Array) is created
// 2. Takes user input by asking Row and Column to make a cell alive
// 3. Finds the live neighbours for each cell
// 4.
// 5. 10 next patterns will be generated.

public class TheGameOfLife
{
   protected Scanner input = new Scanner(System.in);

   private final int ROW_COUNT = 20;
   private final int COLUMN_COUNT = 20;

   protected int[][] grid = new int[ROW_COUNT][COLUMN_COUNT];

   public static void main(String[] args) throws InterruptedException
   {
      TheGameOfLife game = new TheGameOfLife();
      System.out.println("\t\t\tThe Game of Life\n\t\t\t****************\n");

      game.takeUserInput();
      game.displyGrid();
      for (int i = 0; i < 10; i++)
      {
         game.generateNextPattern();
         game.displyGrid();
         Thread.sleep(1000);

      }
   }

   public void initalizeGrid()
   {
      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            grid[i][j] = 0;
         }

      }
   }

   public String displyGrid()
   {
      for (int i = 0; i < 10; i++)
      {
         System.out.println();
      }
      String gridDisply = "";

      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            String charToDisplay = ".";
            if (grid[i][j] == 1)
            {
               charToDisplay = "*";
            }

            if (j < grid[i].length - 1)
               gridDisply = gridDisply + "|" + charToDisplay;
            else
               gridDisply = gridDisply + "|" + charToDisplay + "|\n";

         }

      }
      System.out.println(gridDisply);

      return gridDisply;
   }

   //taking user input interms of row and column
   public void takeUserInput()
   {
      int row = 0;
      boolean isValidCell = true;
      System.out.println("Enter live cells\n*****************\n");

      while (row != -1)
      {
         System.out.print("\nEnter row number between 0 to 19(Enter -1 to stop): ");

         row = input.nextInt();
         if (row != -1)
         {

            System.out.print("Enter column number between 0 to 19: ");
            int column = input.nextInt();

            //Make the cell alive
            isValidCell = makeLiveCell(row, column);
            if (isValidCell == false)
            {
               System.out.println("Inavlid Input");
            }

         }
      }
      input.close();
   }

   public boolean makeLiveCell(int row, int column)
   {
      if ((row > ROW_COUNT - 1 || row < 0) || (column > COLUMN_COUNT - 1) || (column < 0))
      {
         return false;
      }
      else
      {
         grid[row][column] = 1;
         return true;
      }
   }

   //finding live neighbours
   public int findLiveNeighbours(int row, int column)
   {
      int liveCell = 0;

      int startI = -1, startJ = -1, endI = 1, endJ = 1;

      //Finding live cells for (0,0), (0,19),(19,0),(19,19)
      if ((row == 0 && column == 0) || (row == 0 && column == COLUMN_COUNT - 1) || (row == ROW_COUNT - 1 && column == 0)
            || (row == ROW_COUNT - 1 && column == COLUMN_COUNT - 1))
      {
         if ((row == 0 && column == 0))
         {
            startI = 0;
            endI = 1;
            startJ = 0;
            endJ = 1;
         }
         else if (row == 0 && column == COLUMN_COUNT - 1)
         {
            startI = 0;
            endI = 1;
            startJ = -1;
            endJ = 0;
         }
         else if (row == ROW_COUNT - 1 && column == 0)
         {
            startI = -1;
            endI = 0;
            startJ = 0;
            endJ = 1;
         }
         else if (row == ROW_COUNT - 1 && column == COLUMN_COUNT - 1)
         {
            startI = -1;
            endI = 0;
            startJ = -1;
            endJ = 0;
         }

      }
      //
      else if (((row == 0 || row == ROW_COUNT - 1) && (column > 0 && column < COLUMN_COUNT - 1))
            || ((row > 0 && row < ROW_COUNT - 1) && (column == 0 || column == COLUMN_COUNT - 1)))
      {
         if (row == 0 && (column > 0 && column < COLUMN_COUNT - 1))
         {
            startI = 0;
            endI = 1;
            startJ = -1;
            endJ = 1;
         }
         else if (row == ROW_COUNT - 1 && (column > 0 && column < COLUMN_COUNT - 1))
         {
            startI = -1;
            endI = 0;
            startJ = -1;
            endJ = 1;
         }
         else if ((row > 0 && row < ROW_COUNT - 1) && column == 0)
         {
            startI = -1;
            endI = 1;
            startJ = 0;
            endJ = 1;
         }
         else if ((row > 0 && row < ROW_COUNT - 1) && column == COLUMN_COUNT - 1)
         {
            startI = -1;
            endI = 1;
            startJ = -1;
            endJ = 0;
         }
      }
      // finding alive cells for any middle coordinate ex. (3,5)
      else
      {
         startI = -1;
         endI = 1;
         startJ = -1;
         endJ = 1;

      }
      for (int i = startI; i <= endI; i++)
      {
         for (int j = startJ; j <= endJ; j++)
         {
            if (i == 0 && j == 0)
            {
               continue;
            }
            if (grid[row + i][column + j] == 1)
            {
               liveCell++;
            }

         }
      }

      return liveCell;
   }

   //generating next pattern
   public void generateNextPattern()
   {
      int[][] nextPattern = new int[ROW_COUNT][COLUMN_COUNT];
      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            nextPattern[i][j] = grid[i][j];
         }
      }
      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            int liveNeighbours = findLiveNeighbours(i, j);

            if (grid[i][j] == 1)
            {

               if (liveNeighbours < 2)
               {
                  nextPattern[i][j] = 0;
               }
               else if (liveNeighbours > 3)
               {
                  nextPattern[i][j] = 0;
               }

            }
            else
            {
               if (liveNeighbours == 3)
               {
                  nextPattern[i][j] = 1;
               }

            }

         }
      }
      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            grid[i][j] = nextPattern[i][j];
         }
      }
   }

   public int getTotalAliveCells()
   {
      int countAliveCells = 0;
      for (int i = 0; i < grid.length; i++)
      {

         for (int j = 0; j < grid[i].length; j++)
         {
            if (grid[i][j] == 1)
               countAliveCells++;
         }
      }
      return countAliveCells;
   }

}