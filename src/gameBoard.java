
	import java.util.Random;
	import java.util.ArrayList;
	import java.util.Collections;


	public class gameBoard
	{
		private Random rand = new Random();
		private ArrayList<Integer> goldList;
		private ArrayList<Integer> secretGoldList;
		HomePage home= new HomePage();
		public int width=home.satir;
		public int height=home.sutun;
		
		private int maxGold=(width*height)/5;
		private int secretMaxGold=maxGold/5;
		
		private int mapMatrix[][];
		private int goldValue[] = {5,10,15,20};
		
		private gamePlayerA playerA;
		private gamePlayerB playerB;
		private gamePlayerC playerC;
		private gamePlayerD playerD;
		
		private void setGold()
		{
			goldList = new ArrayList<Integer>();
	        for (int i=2; i<(width*height); i++) 
	        {
	        	if(i==height|| i==(width*height)-height+1) 
	        	{
	        		continue;
	        	}
	        	else 
	        	{
	        		goldList.add(i);	
	        	}
	        }
	        
	        Collections.shuffle(goldList);
	        goldList.removeIf(x-> (goldList).indexOf(x)>maxGold-1);
	         
	        for(int i=0; i<maxGold; i++)
	        {
	        	int xPos,yPos;
	        	if( goldList.get(i)%height==0 )
	        	{
	        		xPos=(goldList.get(i)/height)-1;
	        		yPos=height-1;
	        		int randomGoldNumber=rand.nextInt(4);
	            	mapMatrix[xPos][yPos]=goldValue[randomGoldNumber]*13;
	        	}
	        	else
	        	{
	            	xPos=goldList.get(i)/height;
	            	yPos=(goldList.get(i)%height)-1; 
	            	int randomGoldNumber=rand.nextInt(4);
	            	mapMatrix[xPos][yPos]=goldValue[randomGoldNumber]*13;
	        	}        	
	        }
		}
		private void setSecretGold()
		{
			secretGoldList = new ArrayList<Integer>();
	        for (int i=2; i<(width*height); i++) 
	        {
	        	if(i==height|| i==(width*height)-height+1)
	        	{
	        		continue;
	        	}
	        	else 
	        	{
	        		secretGoldList.add(i);	
	        	}
	        }
	        
	        Collections.shuffle(secretGoldList);
	        secretGoldList.removeAll(goldList);
	        secretGoldList.removeIf(x-> (secretGoldList).indexOf(x)>secretMaxGold);
	           
	        for(int i=0; i<=secretMaxGold; i++)
	        {
	        	int xPos,yPos;
	        	if( secretGoldList.get(i)%height==0 )
	        	{
	        		xPos=(secretGoldList.get(i)/height)-1;
	        		yPos=height-1;
	        		int randomGoldNumber=rand.nextInt(4);
	            	mapMatrix[xPos][yPos]=goldValue[randomGoldNumber]*17;
	        	}
	        	else
	        	{
	            	xPos=secretGoldList.get(i)/height;
	            	yPos=(secretGoldList.get(i)%height)-1; 
	            	int randomGoldNumber=rand.nextInt(4);
	            	mapMatrix[xPos][yPos]=goldValue[randomGoldNumber]*17;
	        	}        	
	        }
		}
		public boolean hasGold()
		{
			for(int i=0; i<mapMatrix.length; i++)
			{
				for(int j=0; j<mapMatrix[i].length; j++)
				{
					if( (mapMatrix[i][j] % 13)==0 && (mapMatrix[i][j])!=0 )
					{			
						return true;
					}
				}
			}
			return false;
		}
		public int[][] getMapMatrix()
		{
			return mapMatrix;
		}	
		public gameBoard() 
		{
			mapMatrix = new int[width][height];
			setGold();
			setSecretGold();
			
			playerA= new gamePlayerA();
			playerA.setFirstPosPlayer(width, height);
			
			playerB= new gamePlayerB();
			playerB.setFirstPosPlayer(width, height);
			
			playerC= new gamePlayerC();
			playerC.setFirstPosPlayer(width, height);
			
			playerD= new gamePlayerD();
			playerD.setFirstPosPlayer(width, height);
	   	}
		public gamePlayerA getPlayerA()
		{
			return playerA;
		}
		public gamePlayerB getPlayerB()
		{
			return playerB;
		}
		public gamePlayerC getPlayerC()
		{
			return playerC;
		}
		public gamePlayerD getPlayerD()
		{
			return playerD;
		}
		public void setMapMatrix(int[][] mapMatrix)
		{
			this.mapMatrix = mapMatrix;
		}
	}
