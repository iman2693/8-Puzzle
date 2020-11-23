# 8-Puzzle
8-Puzzle Solver with DFS , BFS , IDS , UCS , A* , IDA* , Bidirectional A* strategies With Linear Conflict Hiruestic Function

## 8-Puzzle instances
### easy instances from 1 to 10 moves	 
		 int[] puzzle1 = { 1,2,3,0,7,6,5,4,8 };
		 int[] puzzle2 = { 0,4,1,2,5,3,7,8,6 };
		 int[] puzzle3 = { 4,1,3,0,2,6,7,5,8 };
		 int[] puzzle4 = { 1,2,3,0,4,8,7,6,5 };
		 int[] puzzle5 = { 1,2,0,4,8,3,7,6,5 };
		 int[] puzzle6 = { 1,0,2,4,6,3,7,5,8 };
		 int[] puzzle7 = { 0,1,2,4,5,3,7,8,6 };
		 int[] puzzle8 = { 1,2,3,0,4,5,7,8,6 };
		 int[] puzzle9 = { 1,2,3,4,0,5,7,8,6 };
		 int[] puzzle10 = { 1,2,3,4,5,0,7,8,6 };
		 int[] puzzle11 = { 0,1,3,4,2,5,7,8,6 };
		 int[] puzzle12 = { 2,3,5,1,0,4,7,8,6 };
		 int[] puzzle13 = { 1,6,2,5,3,0,4,7,8 };
		 int[] puzzle14 = { 1,8,2,0,4,3,7,6,5 };
		 int[] puzzle15 = { 2,5,3,4,1,6,0,7,8 };
		 int[] puzzle16 = { 1,2,3,4,6,8,7,5,0 };
		 int[] puzzle17 = { 1,6,2,5,7,3,0,4,8 };
		 int[] puzzle18 = { 0,4,1,5,3,2,7,8,6 };
		 int[] puzzle19 = { 0,5,2,1,8,3,4,7,6 };
		 int[] puzzle20 = { 1,2,3,0,4,6,7,5,8 };
		 
		 
### medium instances from 11 to 20 moves
		 int[] puzzle1 = { 1,3,5,7,2,6,8,0,4 };
		 int[] puzzle2 = { 4,1,2,3,0,6,5,7,8 };
		 int[] puzzle3 = { 4,3,1,0,7,2,8,5,6 };
		 int[] puzzle4 = { 5,2,1,4,8,3,7,6,0 };
		 int[] puzzle5 = { 2,0,8,1,3,5,4,6,7 };
		 int[] puzzle6 = { 3,5,6,1,4,8,0,7,2 };
		 int[] puzzle7 = { 1,0,2,7,5,4,8,6,3 };
		 int[] puzzle8 = { 5,1,8,2,7,3,4,0,6 };
		 int[] puzzle9 = { 4,3,0,6,1,8,2,7,5 };
		 int[] puzzle10 = { 2,4,3,1,6,5,8,0,7 };
		 int[] puzzle11 = { 1,2,3,6,4,5,7,8,0 };
		 int[] puzzle12 = { 3,1,2,4,5,6,7,8,0 };
		 int[] puzzle13 = { 1,2,3,4,8,7,6,5,0 };
		 int[] puzzle14 = { 1,3,2,5,4,6,7,8,0 };
		 int[] puzzle15 = { 1,4,2,6,5,8,7,3,0 };
		 
		 
		 
### hard instances from 21 to 32
		 int[] puzzle1 = { 2,1,3,4,5,6,8,7,0 };
		 int[] puzzle2 = { 2,3,1,6,5,4,8,7,0 };
		 int[] puzzle3 = { 2,3,1,6,4,5,7,8,0 };
		 int[] puzzle4 = { 1,2,3,6,5,4,8,7,0 };
		 int[] puzzle5 = { 1,2,3,6,5,4,0,8,7 };
		 int[] puzzle6 = { 4,5,3,2,8,0,6,7,1 };
		 int[] puzzle7 = { 4,5,3,2,1,0,8,7,6 };
		 int[] puzzle8 = { 1,2,4,3,5,0,8,7,6 };
		 int[] puzzle9 = { 1,2,4,3,5,8,7,0,6 };
		 int[] puzzle10 = { 2,1,3,4,5,8,7,0,6 };
		 int[] puzzle11 = { 1,3,5,8,7,0,6,2,4 };
		 int[] puzzle12 = { 4,3,1,6,5,8,0,2,7 };
		 int[] puzzle13 = { 7,0,4,8,5,1,6,3,2 };
		 int[] puzzle14 = { 8,7,2,1,5,0,4,6,3 };
		 int[] puzzle15 = { 8,3,5,6,4,2,1,0,7 };
		 int[] puzzle16 = { 1,6,4,0,3,5,8,2,7 };
		 int[] puzzle17 = { 6,3,8,5,4,1,7,2,0 };
		 int[] puzzle18 = { 5,8,7,1,4,6,3,0,2 };
		 int[] puzzle19 = { 2,8,5,3,6,1,7,0,4 };
		 int[] puzzle20 = { 8,7,6,5,4,3,2,1,0 };
