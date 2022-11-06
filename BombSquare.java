import java.util.*;

public class BombSquare extends GameSquare
{
	//private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public boolean hasBomb()
	{
		return thisSquareHasBomb;
	}

	public void clicked()
	{
		if(thisSquareHasBomb == true)
		{
			System.out.println(board.getSquareAt(this.xLocation, this.yLocation).thisSquareHasBomb);
			this.setImage("images/bomb.png");
			System.out.println(board.getSquareAt(this.xLocation, this.yLocation).thisSquareHasBomb);
		}
		else
		{
			this.setImage("images/" + this.countBombs() + ".png");
		}
	}

	public int countBombs()
	{
		int count = 0;

		int x = this.xLocation;
		int y = this.yLocation;


		for(int s = x; s < x + 2; s++)
		{
			for(int g = y; g < y + 2; g++)
			{
				if(board.getSquareAt(s, g).thisSquareHasBomb == true){count++;}
			}
			for(int d = y - 1; d > y - 2; d--)
			{
				if(board.getSquareAt(s, d).thisSquareHasBomb == true){count++;}
			}
		}

		for(int s = x - 1; s > x - 2; s--)
		{
			for(int d = y; d < y + 2; d++)
			{
				if(board.getSquareAt(s, d).thisSquareHasBomb == true){count++;}
			}
			for(int d = y - 1; d > y - 2; d--)
			{
				if(board.getSquareAt(s, d).thisSquareHasBomb == true){count++;}
			}
		}
		
		System.out.println(count);
		return count;
	}

	public int countvombs(int x, int y)
	{
		x = this.xLocation;
		y = this.yLocation;

		return x;
	}
}
