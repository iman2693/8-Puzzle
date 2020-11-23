// search tree node stucture for 8-puzzle problem. 
class PSTNode{
    int state[][]; 
    PSTNode parent; 
    String action; 
    int depth;
    int path_cost; 
    PSTNode up_child; 
    PSTNode down_child; 
    PSTNode left_child; 
    PSTNode right_child; 
    int heuristic;
    // Constructor: 
    // Create a node with the given element and next node. 
    PSTNode(int state[][], PSTNode parent,String action, int depth, int path_cost, PSTNode up_child, PSTNode down_child, PSTNode left_child, PSTNode right_child)
    {
        this.state=state; 
	this.parent=parent; 
	this.action=action; 
	this.depth=depth; 
	this.path_cost=path_cost;
	this.up_child=up_child; 
	this.down_child=down_child; 
	this.left_child=left_child; 
    this.right_child=right_child; 
    }
    int ManhattanBack(int[][] goalState){ // For Bidirectional Goal to Strat ( <=== )
        int h_n=0;
        for(int i=0; i<3; i++)
                for(int j=0; j<3; j++) {
                    int target = goalState[i][j];
                    if (target!=-1){
                    for (int k = 0; k < 3; k++)
                        for (int l = 0; l < 3; l++) { // Note: Deeply-nested for loop is not a bottle neck here due to PUZZLE_SIZE limit
                            if(state[k][l]==target) {
                                    h_n += Math.abs(k-i) + Math.abs(l-j);
                            }
                        }
                    }
                }
        return h_n;
    }

    int ManhattanDistance(){
        int h=0;
        for(int i=0;i<=2;i++)
            for(int j=0; j<=2;j++)
                if(this.state[i][j]!=-1){
                     if(this.state[i][j]==1)
                        h+=(i+j);
                    else if(this.state[i][j]==2)
                        h+=i+Math.abs(j-1);
                    else if(this.state[i][j]==3)
                        h+=i+Math.abs(j-2);
                    else if(this.state[i][j]==4)
                        h+=Math.abs(i-1)+j;
                    else if(this.state[i][j]==5)
                        h+=Math.abs(i-1)+Math.abs(j-1);
                    else if(this.state[i][j]==6)
                        h+=Math.abs(i-1)+Math.abs(j-2);
                    else if(this.state[i][j]==7)
                        h+=Math.abs(i-2)+j;
                    else if(this.state[i][j]==8)
                        h+=Math.abs(i-2)+Math.abs(j-1);
                }
        return h+(linearHorizontalConflict()+linearVerticalConflict());  
    }
    
    private int linearVerticalConflict() {
		int linearConflict = 0;
		
		for (int row = 0; row < 3; row++){
			int max = -1;
			for (int column = 0;  column < 3; column++){
				int cellValue = this.state[row][column];
				//is tile in its goal row ?
				if (cellValue != -1 && (cellValue - 1) / 3 == row){
					if (cellValue > max){
						max = cellValue;
					}else {
						//linear conflict, one tile must move up or down to allow the other to pass by and then back up
						//add two moves to the manhattan distance
						linearConflict += 2;
					}
				}
				
			}
			
		}
		return linearConflict;
	}

    
    int linearHorizontalConflict() {
		
		int linearConflict = 0;
		
		for (int column = 0; column < 3; column++){
			int max = -1;
			for (int row = 0;  row < 3; row++){
				int cellValue = this.state[row][column];
				//is tile in its goal row ?
				if (cellValue != -1 && cellValue % 3 == column + 1){
					if (cellValue > max){
						max = cellValue;
					}else {
						//linear conflict, one tile must move left or right to allow the other to pass by and then back up
						//add two moves to the manhattan distance
						linearConflict += 2;
					}
				}
				
			}
			
		}
		return linearConflict;
    }
    

    //  private int linearVerticalConflictReverse(int[][] goal) {
    //      int[] goal_ver;
    //      int[] state_ver;
    //     int linearConflict = 0;
    //     for (int i =0 ; i<3 ; i++){
    //         goal_ver=goal[i];
    //         state_ver=state[i];
    //         for(int j=0 ; j<3 ; j++){
    //             int cellValue = goal_ver[j];
    //             if(cellValue!=-1){
    //                 boolean flag=true;
    //                 for(int k=0; k<3;k++){
    //                     if(cellValue==state_ver[k]){
    //                         goal_ver[j]=k;
    //                         flag=false;
    //                     }
    //                 }
    //                 if(flag)
    //                     goal_ver[j]=-1;
    //             }
    //         }
    //         int max = -1;
    //         for(int j=0;j<3;j++){
    //             int cellValue = goal_ver[j];
    //             if (cellValue != -1){
    //                 if (cellValue > max){
	// 					max = cellValue;
	// 				}else {
	// 					//linear conflict, one tile must move up or down to allow the other to pass by and then back up
	// 					//add two moves to the manhattan distance
	// 					linearConflict += 2;
	// 				}
    //             }

    //         }
    //     }
	// 	return linearConflict;
	// }

    
    //  int linearHorizontalConflictReverse(int[][] goal) {
		
	// 	int[] goal_ver=new int[3];
    //      int[] state_ver=new int[3];
    //     int linearConflict = 0;
    //     for (int i =0 ; i<3 ; i++){
    //         for(int j=0 ; j<3 ; j++){
    //             goal_ver[i]=goal[j][i];
    //             state_ver[i]=state[j][i];
    //             int cellValue = goal_ver[j];
    //         }
    //     }
            
	// 	return linearConflict;
	// }
}
   
