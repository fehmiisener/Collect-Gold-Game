import java.util.ArrayList;
import java.util.TreeMap;

public class gamePlayerA extends gamePlayer
{	
	int posX;
	int posY;
	private int defaultCalculateCost=5;
	
	@Override
	public void setFirstPosPlayer(int boardWidth, int boardHeight) {
		posX=boardWidth-boardWidth;
		posY=boardHeight-boardHeight;
		
		super.bestGoldX=boardWidth-1;
		super.bestGoldY=boardHeight-1;
		
		super.posX=boardWidth-boardWidth;
		super.posY=boardHeight-boardHeight;
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
					double dist= Math.sqrt( Math.pow((i-posX), 2) + Math.pow(j-posY, 2) );
					
					ArrayList <Integer> GoldPos = new ArrayList<>();
					
					GoldPos.add(i);
					GoldPos.add(j);
					target.put(dist, GoldPos);	
				}
			}
		}
		bestGoldX=target.entrySet().stream().skip(0).findFirst().get().getValue().get(0);
		bestGoldY=target.entrySet().stream().skip(0).findFirst().get().getValue().get(1);
		totalBalance=totalBalance-defaultCalculateCost;
		setHasTarget(true);
	}
}
