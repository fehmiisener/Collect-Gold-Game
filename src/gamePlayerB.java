import java.util.ArrayList;
import java.util.TreeMap;

public class gamePlayerB extends gamePlayer
{
	int posX;
	int posY;
	private int defaultCalculateCost=10;

	@Override
	public void setFirstPosPlayer(int boardWidth, int boardHeight) {
		posX=boardWidth-boardWidth;
		posY=boardHeight-1;
		
		super.bestGoldX=boardWidth-1;
		super.bestGoldY=0;
			
		super.posX=boardWidth-boardWidth;
		super.posY=boardHeight-1;
	}
	public void setPos(int posX,int posY)
	{
		this.posX=posX;
		this.posY=posY;
		super.posX=posX;;
		super.posY=posY;
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
