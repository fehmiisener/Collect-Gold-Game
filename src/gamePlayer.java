
abstract class gamePlayer
{
	int map[][];
	
	int totalBalance=200;
	int maxMove=HomePage.hamleSayisi;
	int moveCost=HomePage.hareketPuani;
	
	private boolean hasTarget=false;
	
	int posX;
	int posY;

	int bestGoldX=Integer.MAX_VALUE;
	int bestGoldY=Integer.MAX_VALUE;
	
	abstract void setFirstPosPlayer(int boardWidth,int boardHeight);
	abstract void setPos(int i, int j);
	abstract void findTarget();
	
	public int[][] getGold(int xPos,int yPos)
	{
		totalBalance+=map[xPos][yPos]/13;
		map[xPos][yPos]=0;
		return map;
	}
	public int[] moveToGold(int posX,int posY)
	{
		int[] arr = new int[2];
		arr[0]=posX;
		arr[1]=posY;
		
		int goldPosX=bestGoldX;
		int goldPosY=bestGoldY;	
		int moveX=goldPosX-posX;
		int moveY=goldPosY-posY;
		
		if(moveX>0)
		{
			if(moveX < maxMove)
			{
				arr[0]+=moveX;
				int remainMove=maxMove-moveX;
				if(moveY > 0)
				{
					if(remainMove>moveY)
					{
						arr[1]+=moveY;
					}
					else if(remainMove<=moveY)
					{
						arr[1]+=remainMove;
					}
				}
				else if(moveY < 0)
				{
					if(remainMove>(0-moveY))
					{
						arr[1]+=moveY;
					}
					else if(remainMove<=(0-moveY))
					{
						arr[1]-=remainMove;
					}
				}
			}
			else if(moveX >= maxMove)
			{
				arr[0]+=maxMove;
			}
		}
		else if(moveX<0)
		{
			if( (0-moveX) < maxMove)
			{
				arr[0]+=moveX;
				int remainMove=maxMove+moveX;
				if(moveY > 0)
				{
					if(remainMove>moveY)
					{
						arr[1]+=moveY;
					}
					else if(remainMove<=moveY)
					{
						arr[1]+=remainMove;
					}
				}
				else if(moveY < 0)
				{
					if(remainMove>(0-moveY))
					{
						arr[1]+=moveY;
					}
					else if(remainMove<=(0-moveY))
					{
						arr[1]-=remainMove;
					}
				}
			}
			else if( (0-moveX) >= maxMove)
			{
				arr[0]-=maxMove;
			}
		}
		else
		{	
			int remainMove=3;
			if(moveY > 0)
			{
				if(remainMove>moveY)
				{
					arr[1]+=moveY;
				}
				else if(remainMove<=moveY)
				{
					arr[1]+=remainMove;
				}
			}
			else if(moveY < 0)
			{
				if(remainMove>(0-moveY))
				{
					arr[1]+=moveY;
				}
				else if(remainMove<=(0-moveY))
				{
					arr[1]-=remainMove;
				}
			}
		}	
		totalBalance=totalBalance-moveCost;
		return arr;	
	}
	public int[] getBestGoldPos()
	{
		int[] arr = new int[2];
		arr[0]=bestGoldX;
		arr[1]=bestGoldY;
		return arr;
	}
	public boolean hasTarget() 
	{
		return hasTarget;
	}
	public boolean isGold(int xPos,int yPos)
	{
		if( map[xPos][yPos]%13==0 &&  map[xPos][yPos]!=0) 
		{
			return true;
		}
		else 
			return false;
	}
	public void setHasTarget()
	{
		boolean control=isGold(bestGoldX, bestGoldY);
		hasTarget=control;
	}
	public void readMap(int map[][])
	{
		this.map=map;
	}
	protected void setHasTarget(boolean hasTarget)
	{
		this.hasTarget = hasTarget;
	}
}
