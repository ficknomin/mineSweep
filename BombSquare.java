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

		this.open = true;
		
		
			if(this.hasBomb() == true)
			{
				this.setImage("images/bomb.png");
				return;
			}
			else if(this.countBombs() == 0)
			{

				this.setImage("images/0.png");

				for(int i = x - 1; i < x + 2; i++)
				{
					for(int o = y - 1; o <= y + 1; o++)
					{
						try{
							if(board.getSquareAt(i, o) != null && !((BombSquare)board.getSquareAt(i, o)).open)
							{
								((BombSquare)board.getSquareAt(i, o)).clicked();
								((BombSquare)board.getSquareAt(i, o)).clicked();
							}
						}
						catch(Exception e){return;}
					}
				}
			
			}
			else if(this.countBombs() > 0)
			{
				this.setImage("images/" + this.countBombs() + ".png");
				return;
			}
	
		

		/*if(this.hasBomb() == true)
			{
				this.setImage("images/bomb.png");
				return;
			}
			else if(this.countBombs() == 0 && !this.open && this != null)
			{

				this.setImage("images/0.png");
				this.open = true;
				((BombSquare)board.getSquareAt(x + 1, y)).clicked();
				((BombSquare)board.getSquareAt(x - 1, y)).clicked();
				((BombSquare)board.getSquareAt(x, y - 1)).clicked();
				((BombSquare)board.getSquareAt(x, y + 1)).clicked();

			}
			else if(this.countBombs() > 0)
			{
				this.open = true;
				this.setImage("images/" + this.countBombs() + ".png");
				return;
			}*/

	}

	public int countBombs()
	{
		int count = 0;

		int x = this.xLocation;
		int y = this.yLocation;


		for(int s = x - 1; s < x + 2; s++)
		{
			for(int g = y; g < y + 2; g++)
			{
				try
				{
					if(((BombSquare) board.getSquareAt(s, g)).hasBomb() == true){count++;}
				} catch (Exception e){
					break;
				}
			}
			for(int d = y - 1; d > y - 2; d--)
			{
				try
				{
					if(((BombSquare) board.getSquareAt(s, d)).hasBomb() == true){count++;}
				} catch (Exception e){
					break;
				}
				
			}
		}

		
		System.out.println(count);
		return count;
	}


}
