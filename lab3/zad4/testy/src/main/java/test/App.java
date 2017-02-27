package test;

public class App 
{
	public int[][] plansza = new int[5][5]; 

	public void setXforAll()
	{
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				plansza[i][j] = 1;
	}
	
	public void clear()
	{

		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				plansza[i][j] = 0;
	}
	
	public String show()
	{
		String output = "";
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				output = output + plansza[i][j] + " ";
				System.out.print(plansza[i][j]+" ");
			}
			output = output + "\n";
			System.out.println();
		}
		return output;		
	}
}

