package hello;
import java.util.*;
public class Tournament {
	public static class details
	{
		Player p1;
		int won=0;
		int loss=0;
		int draw=0;
		details(Player p1)
		{
			this.p1=p1;
			this.won=0;
			this.loss=0;
			this.draw=0;
		}
	}
	public Vector<Player> v=new Vector<>();
	public Tournament(Vector<Player> a) {
		System.out.println("hello");
		for(Player i:a)v.add(i);
		startgame();
	}
	public static void sortpair(Vector<details> arr) {
		arr.sort(new Comparator<details>() {
			public int compare(details o1, details o2) {
				long val = o1.won - o2.won;
				if (val == 0){
					int v2=o1.loss-o2.loss;
					if(v2>0)return 1;
					else if(v2<0)return -1;
					else
					{
						int d=o1.draw-o2.draw;
						if(d>0)return 1;
						else if(d<0)return -1;
						else return 0;
					}
				}
				else if (val > 0)
					return -1;
				else
					return 1;
			}
		});
	}

	public void startgame()
	{
		HashMap<String,details> map=new HashMap<>();
		for(Player i:v)
		{
			map.put(i.name, new details(i));
		}
		for(int i=0;i<v.size();i++)
		{
			for(int j=i+1;j<v.size();j++)
			{
				System.out.println("The Game is Between :"+v.get(i).name+" "+v.get(j).name);
				Game a=new Game(3, 1, '1');
				a.draw();
				details d1=map.get(v.get(i).name);
				details d2=map.get(v.get(j).name);
				if(a.winner==1)
				{
					
					d1.won+=1;
					d2.loss+=1;
				}
				else
				{
					d2.won+=1;
					d1.loss+=1;
				}

			}
		}
		Vector<details> g=new Vector<>();
		for(Map.Entry<String,details> m:map.entrySet())
		{
			g.add(m.getValue());
		}
		sortpair(g);
		int r=1;
		for(details i:g)
		{
			System.out.println("Rank "+r+" is :"+i.p1.name);
			r++;
		}
		
	}

}
