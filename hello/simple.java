package hello;

public class simple{
	Player p1;
	Player p2;
	simple(Player p1,Player p2)
	{
		this.p1=p1;
		this.p2=p2;
		
	}
	int start()
	{
		Game g1=new Game(3, 1, '1');
		g1.draw();
		return g1.winner;
	}
	
	//start the game
}
