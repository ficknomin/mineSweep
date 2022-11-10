import java.util.*;
import javax.swing.text.GapContent;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private boolean open = false;

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
		int x = this.xLocation;
		int y = this.yLocation;
		
			if(this.hasBomb() == true)
			{
				this.setImage("images/bomb.png");
			}
			else if(this.countBombs() == 0 && this.hasBomb() == false)
			{
				this.setImage("images/0.png");
				this.open = true;

				for(int i = x - 1; i <= x + 1; i++)
				{
					for(int o = y - 1; o <= y + 1; o++)
					{
						try{
							if(((BombSquare)board.getSquareAt(i, o)) != null && !((BombSquare)board.getSquareAt(i, o)).open && !((BombSquare)board.getSquareAt(i, o)).hasBomb())
							{
								((BombSquare)board.getSquareAt(i, o)).clicked();
								board.repaint();
							}
						}
						catch(Exception e){return;}
					}
				}
				
			}
			else if(this.countBombs() > 0)
			{
				this.setImage("images/" + this.countBombs() + ".png");
			}
	
	}

	public int countBombs()
	{
		int count = 0;

		int x = this.xLocation;
		int y = this.yLocation;


		for(int s = x - 1; s < x + 2; s++)
		{
				for(int g = y - 1; g < y + 2; g++)
				{
					if(((BombSquare) board.getSquareAt(s, g)) == null){continue;}
					if(s == x && g == y){continue;}
					if(((BombSquare) board.getSquareAt(s, g)).hasBomb() == true){count++;}
				}
		}
		
		return count;
	}


}
			