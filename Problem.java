//The problem formulation 
class Problem {
	int[][] initial_state; 

	Problem(int[][] initialState){
		this.initial_state=initialState; 
	}

	public int[][] Successor(int[][] s, String action) {
		int[][] state=new int[3][3];
		for(int k1=0; k1<=2; k1++)
			for(int k2=0; k2<=2; k2++)
				state[k1][k2]=s[k1][k2]; 
		int i=find_i(state); 
		int j=find_j(state); 
		if(i==-1 || j==-1) {
			System.out.println("Error: I couldn't find the empty place !!!!!!"); 
			return state;  		
		}

		switch(action){
			case "u": 
				if(i!=0){
					state[i][j]=state[i-1][j]; 
					state[i-1][j]=-1; 
				}
				break; 


			case "d": 
				if(i!=2) { 
					state[i][j]=state[i+1][j]; 
					state[i+1][j]=-1; 
				}
				break; 

			case "l": 
				if(j!=0) {
					state[i][j]=state[i][j-1]; 
					state[i][j-1]=-1; 
				}
				break; 

			case "r": 
				if(j!=2) { 
					state[i][j]=state[i][j+1]; 
					state[i][j+1]=-1; 
				}
				break; 
		
		}
		
		
		return state; 
	}



	// public boolean Goal_Test(int[][] state){
	// 	if(state[0][0]==1 && state[0][1]==2 && state[0][2]==3
	// 			&& state[1][0]==8 && state[1][1]==-1 && state[1][2]==4
	// 			&& state[2][0]==7 && state[2][1]==6 && state[2][2]==5)
	// 		return true; 
	// 	else 
	// 		return false; 
	// }
	public boolean Goal_Test(int[][] state){
		if(state[0][0]==1 && state[0][1]==2 && state[0][2]==3
				&& state[1][0]==4 && state[1][1]==5 && state[1][2]==6
				&& state[2][0]==7 && state[2][1]==8 && state[2][2]==-1)
			return true; 
		else 
			return false; 
	}
	





	 int find_i(int[][] state){
		for(int i=0; i<=2; i++)
			for(int j=0; j<=2; j++)
				if(state[i][j]==-1) return i;
		return -1;  
	}

	int find_j(int[][] state) { 
		for(int i=0; i<=2; i++)
			for(int j=0; j<=2; j++)
				if(state[i][j]==-1) return j; 
		return -1; 
	}
	Boolean solveable(){
		int[] state=new int[8];
		int k=0;
		for(int i=0;i<=2;i++)
			for(int j=0;j<=2;j++)
				if(this.initial_state[i][j]!=-1){
					state[k]=this.initial_state[i][j];
					k++;
				}
		int inversions=0;
		for(int i=0;i<8;i++)
			for(int j=i+1;j<8;j++)
				if(state[j]>state[i]){
					inversions++;
				}
		if(inversions%2==1)
			return false;		
		return true;
	}
}
