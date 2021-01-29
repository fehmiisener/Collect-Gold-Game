import java.awt.Image;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.ImageIcon;

public class gamePlayerC extends gamePlayer
{
	int posX;
	int posY;
	private int defaultCalculateCost=15;
	
	public TreeMap<Double, ArrayList<Integer>> secretGolds;
	
	@Override
	public void setFirstPosPlayer(int boardWidth, int boardHeight) {
		posX=boardWidth-1;
		posY=boardHeight-1;
		
		super.bestGoldX=0;
		super.bestGoldY=0;
		
		super.posX=boardWidth-1;
		super.posY=boardHeight-1;
	}
	public void setPos(int posX,int posY)
	{
		this.posX=posX;
		this.posY=posY;
		super.posX=posX;;
		super.posY=posY;
	}
	
	public void findSecretGold()
	{	
		secretGolds = new TreeMap<Double, ArrayList<Integer>>(); 
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if( (map[i][j] % 17)==0 && (map[i][j])!=0 )
				{		
					ArrayList <Integer> secretGoldPos = new ArrayList<>();
					double distSecretGold= Math.sqrt( Math.pow((i-posX), 2) + Math.pow(j-posY, 2) );
					secretGoldPos.add(i);
					secretGoldPos.add(j);
					secretGolds.put(distSecretGold, secretGoldPos);
				}
			}
		}
	}
	public int[][] openSecretGold()
	{
		Image imgSecretGold=new ImageIcon(this.getClass().getResource("/goldSecret30.png")).getImage();
		Image imgSecretGold5=new ImageIcon(this.getClass().getResource("/goldSecret30-5.png")).getImage();
		 Image imgSecretGold10=new ImageIcon(this.getClass().getResource("/goldSecret30-10.png")).getImage();
		 Image imgSecretGold15=new ImageIcon(this.getClass().getResource("/goldSecret30-15.png")).getImage();
		 Image imgSecretGold20=new ImageIcon(this.getClass().getResource("/goldSecret30-20.png")).getImage();
		 
		int counter=1;
		while(secretGolds.size()>0 && counter<=2)
		{
			if(secretGolds.size()==1)
			{
				int firstX,firstY;
				firstX=secretGolds.entrySet().stream().skip(counter-1).findFirst().get().getValue().get(0);
				firstY=secretGolds.entrySet().stream().skip(counter-1).findFirst().get().getValue().get(1);
				map[firstX][firstY]=(map[firstX][firstY]/17)*13;
				switch(map[firstX][firstY]/13) {
         	   case 5:
         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold5));
         		  
         		   break;
         	   case 10:
         		   
         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold10));
         		   break;
         	   case 15:
         		   
         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold15));
         		   break;
         	   case 20:
         		   
         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold20));
         		   break;
         	  
         	   }
				
				return map;
			}
			else
			{
				int firstX,firstY;
				firstX=secretGolds.entrySet().stream().skip(counter-1).findFirst().get().getValue().get(0);
				firstY=secretGolds.entrySet().stream().skip(counter-1).findFirst().get().getValue().get(1);
				map[firstX][firstY]=(map[firstX][firstY]/17)*13;
				switch(map[firstX][firstY]/13) {
	         	   case 5:
	         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold5));
	         		  
	         		   break;
	         	   case 10:
	         		   
	         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold10));
	         		   break;
	         	   case 15:
	         		   
	         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold15));
	         		   break;
	         	   case 20:
	         		   
	         		  GamePage.buton[firstX][firstY].setIcon(new ImageIcon(imgSecretGold20));
	         		   break;
	         	  
	         	   }
				counter++;
			}	
		}
		return map;
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
