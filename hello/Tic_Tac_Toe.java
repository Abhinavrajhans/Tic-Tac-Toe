package hello;
import java.util.*;
public class Tic_Tac_Toe {
	
	
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        
        
        System.out.println("Welcome to Tic-Tac-Toe");
        while(true)
        {
        	 System.out.println("Enter 1 : To play a Simple Tic-Tac-Toe Game");
             System.out.println("Enter 2 : To play a Tournament");
             System.out.println("Enter 3 : To play Against A Bot ");
             int n=obj.nextInt();
             if(n==1)
             {
            	 String p1=obj.next();
            	 String p2=obj.next();
            	 Player a1=new Player(p1);
            	 Player a2=new Player(p2);
            	 simple s1=new simple(a1,a2);
            	 int winner =s1.start();
            	 if(winner==1)System.out.println(p1+"  has won the game");
            	 else if(winner==2)System.out.println(p2+" has won the game");
            	 else System.out.println("The game is Drawn");
             }
             else if(n==2)
             {
            	 System.out.println("Enter Number of Players :"); 
            	 int t=obj.nextInt();
            	 Vector<Player> v=new Vector<>();
            	 for(int i=0;i<t;i++)
            	 {
            		 System.out.println("Enter the name of the player : ");
            		 String s=obj.next();
            		 v.add(new Player(s));
            	 }
            	 Tournament a=new Tournament(v);
             }
             else if(n==3)
             {

             }
             else
             {
                 System.out.println("INVALID OPTION");
                 break;
             }
        }
       
    }
}
