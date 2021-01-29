import java.util.ArrayList;
import java.util.TreeMap;

public class gamePlayerD extends gamePlayer
{
	int posX;
	int posY;
	private int defaultCalculateCost=20;
	
	private int targetPlayer;

	@Override
	public void setFirstPosPlayer(int boardWidth, int boardHeight) {
		posX=boardWidth-1;
		posY=boardHeight-boardHeight;
		
		super.bestGoldX=boardWidth-1;
		super.bestGoldY=0;
			
		super.posX=boardWidth-1;
		super.posY=boardHeight-boardHeight;
	}
	public void setPos(int posX,int posY)
	{
		this.posX=posX;
		this.posY=posY;
		super.posX=posX;;
		super.posY=posY;
	}
	public boolean canReach(int playerInfo[][])
	{
		int dStep=0;
		int otherStep=0;
		for(int i=0; i<3; i++)
		{
			
			otherStep+=Math.abs(playerInfo[i][0]-playerInfo[i][2]);
			otherStep+=Math.abs(playerInfo[i][1]-playerInfo[i][3]);
				
			dStep+=Math.abs(posX-playerInfo[i][2]);
			dStep+=Math.abs(posY-playerInfo[i][3]);
		
			if(dStep<otherStep)
				return true;
		}
		return false;
	}
	public void setTarget(int playerInfo[][])
	{
		bestGoldX=playerInfo[targetPlayer][2];
		bestGoldY=playerInfo[targetPlayer][3];
		setHasTarget(true);
		totalBalance=totalBalance-defaultCalculateCost;
	}
	@Override
	public void findTarget()
	{
		TreeMap<Double, ArrayList<Integer>> target = new TreeMap<Double, ArrayList<Integer>>();
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if( (map[i][j] % 13)==0 && (map[i][j])!=0 )
				{	
					double moveCost=(Math.abs(i-posX)+Math.abs(j-posY))/maxMove;
					moveCost=Math.round(moveCost)*5;
					double totalCost=(map[i][j] / 13 )-moveCost-defaultCalculateCost;
						
					ArrayList <Integer> GoldPos = new ArrayList<>();
					
					GoldPos.add(i);
					GoldPos.add(j);
					target.put(totalCost, GoldPos);
				}
			}
		}
		bestGoldX=target.entrySet().stream().skip(target.size()-1).findFirst().get().getValue().get(0);
		bestGoldY=target.entrySet().stream().skip(target.size()-1).findFirst().get().getValue().get(1);
		totalBalance=totalBalance-defaultCalculateCost;
		setHasTarget(true);
	}
}
