
//The Main Class. 
import java.io.IOException;
import java.util.Scanner;
class Puzzle{
	public static void main(String args[]){
		int[][] goal_state={{1,2,3},{4,5,6},{7,8,-1}};
		//int[][] initial_state={{1, 2, -1},{4, 5, 3},{7, 8, 6}}; //solvable - very easy
		//int[][] initial_state={{1,-1,3},{8,6,4},{7,5,2}}; //solvable - easy
		//int[][] initial_state={{1,8,2},{-1,4,3},{7,6,5}}; //solvable - easy
		//int[][] initial_state = { {1,6,2},{5,7,3},{-1,4,8} }; //solveable -easy
		//int[][] initial_state={{3,6,4},{-1,1,2},{8,7,5}}; //unsolvable - easy
		//int[][] initial_state={{3,1,2},{4,5,6},{7,8,-1}}; // solveable - normal
		//int[][] initial_state= {{1,3,5},{7,2,6},{8,-1,4}}; // solveable - normal
		//int[][] initial_state= {{1,2,3},{6,5,4},{8,7,-1}}; // solveable - hard
		//int[][] initial_state={ {7,-1,4},{8,5,1},{6,3,2} }; // solveable - hard
		int[][] initial_state={{ 2,8,5},{3,6,1},{7,-1,4 }}; //hard
		//int[][] initial_state={{8,1,2},{-1,4,3},{7,6,5}};  //unsolveable
		Problem problem=new Problem(initial_state); 
		
		char choose;
		Scanner sc=new Scanner(System.in);
		if(problem.solveable()){
			do{
				System.out.println("Choose Your Strategy : \na) DFS\t\tb) BFS\t\tc) IDS\t\td) UCS\t\te) A*\t\tf) IDA*\t\tg) BiDirectional A* ");
				choose=sc.next().charAt(0);
				switch(choose){
					case 'a':
					case 'A':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("DFS");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'b':
					case 'B':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("BFS");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'c':
					case 'C':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("IDS");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'd':
					case 'D':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("UCS");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'e':
					case 'E':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("AStar");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'f':
					case 'F':{
						problem=new Problem(initial_state); 
						PSearcher searcher=new PSearcher(problem);
						double startTime = System.currentTimeMillis();
						ActionSequence AS=searcher.Search("IDAStar");
						double endtime= System.currentTimeMillis();
						AS.printList(); 
						System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
						break;
					}
					case 'g':
					case 'G':{
						
						problem=new Problem(initial_state); 
						bidirectional bd=new bidirectional(initial_state, goal_state, problem);
						bd.calBidirectional();
						break;
					}
					default:{
						System.out.println("Wrong selection");
					}
				}
				
				System.out.print("Do You Want to Continue(Y/N) ? ");
				choose = sc.next().charAt(0);
				
			}while(choose!='N' && choose!='n');
		}
		else
			System.out.println("This 8-Puzzle is not solveable.");
	
		
		
	}
}
