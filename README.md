# About 8-Puzzle Solver

The 8-Puzzle Solver is a comprehensive solution to the classic 8-Puzzle problem. This project, hosted on [GitHub](https://github.com/iman2693/8-Puzzle), is developed by `iman2693`.

## Features

The 8-Puzzle Solver employs a variety of search strategies to solve the 8-Puzzle problem. These strategies include:

- Depth-First Search (DFS)
- Breadth-First Search (BFS)
- Iterative Deepening Search (IDS)
- Uniform Cost Search (UCS)
- A* Search
- Iterative Deepening A* (IDA*)
- Bidirectional A* Search

In addition to these search strategies, the solver also utilizes the Linear Conflict Heuristic function to enhance the efficiency of the puzzle-solving process.

## Usage

The main class of the project is `Puzzle.java`. This file contains instances for the initial state of the puzzle, as well as the goal state. To use the solver, simply run the `Puzzle.java` file.

## Contribution

Contributions to the 8-Puzzle Solver are welcome. Feel free to fork the project, make your changes, and submit a pull request.

## License

Please see the [GitHub repository](https://github.com/iman2693/8-Puzzle) for information on the project's license.
## 8-Puzzle instances
### easy instances from 1 to 10 moves	 
		 int[] puzzle1 = { 1,2,3,-1,7,6,5,4,8 };
		 int[] puzzle2 = { -1,4,1,2,5,3,7,8,6 };
		 int[] puzzle3 = { 4,1,3,-1,2,6,7,5,8 };
		 int[] puzzle4 = { 1,2,3,-1,4,8,7,6,5 };
		 int[] puzzle5 = { 1,2,-1,4,8,3,7,6,5 };
		 int[] puzzle6 = { 1,-1,2,4,6,3,7,5,8 };
		 int[] puzzle7 = { -1,1,2,4,5,3,7,8,6 };
		 int[] puzzle8 = { 1,2,3,-1,4,5,7,8,6 };
		 int[] puzzle9 = { 1,2,3,4,-1,5,7,8,6 };
		 int[] puzzle10 = { 1,2,3,4,5,-1,7,8,6 };
		 int[] puzzle11 = { -1,1,3,4,2,5,7,8,6 };
		 int[] puzzle12 = { 2,3,5,1,-1,4,7,8,6 };
		 int[] puzzle13 = { 1,6,2,5,3,-1,4,7,8 };
		 int[] puzzle14 = { 1,8,2,-1,4,3,7,6,5 };
		 int[] puzzle15 = { 2,5,3,4,1,6,-1,7,8 };
		 int[] puzzle16 = { 1,2,3,4,6,8,7,5,-1 };
		 int[] puzzle17 = { 1,6,2,5,7,3,-1,4,8 };
		 int[] puzzle18 = { -1,4,1,5,3,2,7,8,6 };
		 int[] puzzle19 = { -1,5,2,1,8,3,4,7,6 };
		 int[] puzzle20 = { 1,2,3,-1,4,6,7,5,8 };
		 
		 
### medium instances from 11 to 20 moves
		 int[] puzzle1 = { 1,3,5,7,2,6,8,-1,4 };
		 int[] puzzle2 = { 4,1,2,3,-1,6,5,7,8 };
		 int[] puzzle3 = { 4,3,1,-1,7,2,8,5,6 };
		 int[] puzzle4 = { 5,2,1,4,8,3,7,6,-1 };
		 int[] puzzle5 = { 2,-1,8,1,3,5,4,6,7 };
		 int[] puzzle6 = { 3,5,6,1,4,8,-1,7,2 };
		 int[] puzzle7 = { 1,-1,2,7,5,4,8,6,3 };
		 int[] puzzle8 = { 5,1,8,2,7,3,4,-1,6 };
		 int[] puzzle9 = { 4,3,-1,6,1,8,2,7,5 };
		 int[] puzzle10 = { 2,4,3,1,6,5,8,-1,7 };
		 int[] puzzle11 = { 1,2,3,6,4,5,7,8,-1 };
		 int[] puzzle12 = { 3,1,2,4,5,6,7,8,-1 };
		 int[] puzzle13 = { 1,2,3,4,8,7,6,5,-1 };
		 int[] puzzle14 = { 1,3,2,5,4,6,7,8,-1 };
		 int[] puzzle15 = { 1,4,2,6,5,8,7,3,-1 };
		 
		 
### hard instances from 21 to 32
		 int[] puzzle1 = { 2,1,3,4,5,6,8,7,-1 };
		 int[] puzzle2 = { 2,3,1,6,5,4,8,7,-1 };
		 int[] puzzle3 = { 2,3,1,6,4,5,7,8,-1 };
		 int[] puzzle4 = { 1,2,3,6,5,4,8,7,-1 };
		 int[] puzzle5 = { 1,2,3,6,5,4,-1,8,7 };
		 int[] puzzle6 = { 4,5,3,2,8,-1,6,7,1 };
		 int[] puzzle7 = { 4,5,3,2,1,-1,8,7,6 };
		 int[] puzzle8 = { 1,2,4,3,5,-1,8,7,6 };
		 int[] puzzle9 = { 1,2,4,3,5,8,7,-1,6 };
		 int[] puzzle10 = { 2,1,3,4,5,8,7,-1,6 };
		 int[] puzzle11 = { 1,3,5,8,7,-1,6,2,4 };
		 int[] puzzle12 = { 4,3,1,6,5,8,-1,2,7 };
		 int[] puzzle13 = { 7,-1,4,8,5,1,6,3,2 };
		 int[] puzzle14 = { 8,7,2,1,5,-1,4,6,3 };
		 int[] puzzle15 = { 8,3,5,6,4,2,1,-1,7 };
		 int[] puzzle16 = { 1,6,4,-1,3,5,8,2,7 };
		 int[] puzzle17 = { 6,3,8,5,4,1,7,2,-1 };
		 int[] puzzle18 = { 5,8,7,1,4,6,3,-1,2 };
		 int[] puzzle19 = { 2,8,5,3,6,1,7,-1,4 };
		 int[] puzzle20 = { 8,7,6,5,4,3,2,1,-1 };
