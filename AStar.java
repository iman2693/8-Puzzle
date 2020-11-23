import java.nio.file.Path;

class AStar extends Thread {
    int[][] goal_state;
    int[][] initial_state;
	Queue queue;
	Problem problem;
	boolean is_in_Thread=false;
	boolean front,front_is_running=true;
	boolean back,back_is_running=true;
	String[] Moves = {"u","d","l","r"};
	boolean Is_Goal_state;
    
    AStar(int[][] goal,int[][] initial , Problem p){
        initial_state=initial;
		goal_state=goal;
		Is_Goal_state=false;
		//generate a search node according to initial state. 
		PSTNode search_node = new PSTNode(initial_state, null, null, 0, 0, null, null, null, null);
		//add the generated search node to the search queue. 
		QNode qn=new QNode(search_node, null, null); 
		queue=new Queue(); 
		queue.addFirst(qn);
		problem=p;
	}
	public void run() {
		CalculateAStar();

	}



	 ActionSequence CalculateAStar(){
		double startTime = System.currentTimeMillis();
		QNode current; 
		Queue close=new Queue();
		current=queue.removeFirst();	

		if(is_in_Thread && back){
			current.element.heuristic=current.element.ManhattanBack(goal_state);
			bidirectional.back_queue.addFirst(current);
		}

		else if(is_in_Thread && front){
			current.element.heuristic=current.element.ManhattanDistance();
			bidirectional.front_queue.addFirst(current);
		}
			
		do{
			if(is_in_Thread && back){
			current=bidirectional.back_queue.removeFirst();
			}
			else if(is_in_Thread && front){
			current=bidirectional.front_queue.removeFirst();
			}
			ActionSequence as=null;
			if(!bidirectional.isgoal && is_in_Thread && front && bidirectional.back_queue_Close.isin(current)!=null){
				bidirectional.isgoal=true;
				double endtime= System.currentTimeMillis();
				System.out.println("\n\nRun Time : "+(endtime-startTime) + " ms");
				bidirectional.frontas=Path2Root(current.element);
				bidirectional.backas=Path2Root(bidirectional.back_queue_Close.isin(current).element);
				bidirectional.printas();	
				return as;
			}
			else if(!bidirectional.isgoal && is_in_Thread && back && bidirectional.front_queue_Close.isin(current)!=null ){
				bidirectional.isgoal=true;
				// printState(current.element.state);
				// printState(bidirectional.front_queue_Close.isin(current).element.state);
				long endtime= System.currentTimeMillis();
				System.out.println(endtime-startTime);
				bidirectional.backas=Path2Root(current.element);
				bidirectional.frontas=Path2Root(bidirectional.front_queue_Close.isin(current).element);
				bidirectional.printas();	
				return as;
			}
			else if(bidirectional.isgoal){
				return as;
			}

			int findi=problem.find_i(current.element.state);
			int findj=problem.find_j(current.element.state);
			QNode[] Nodes=new QNode[4];
			int i=0;
			for(String s:Moves){
				if((findi==0 && s=="u") || (findi==2 && s=="d") || (findj==0 && s=="l") || (findj==2 && s=="r")){
						Nodes[i]=null;
						i++;
						continue;
				}
				PSTNode child=Expand(current.element,Moves[i]);
				QNode childnode= new QNode(child,null, null);
				Nodes[i]=childnode;
				i++;
			}
			for(QNode node:Nodes){
				if (node!=null){
				int successor_current_cost=current.element.path_cost+1;

				if (is_in_Thread && front){
					QNode queueisin=bidirectional.front_queue.isin(node);
					QNode closeisin=bidirectional.front_queue_Close.isin(node);
					if(queueisin!=null){
						if(queueisin.element.path_cost<=successor_current_cost){
							continue;
						}
					}
					else if(closeisin!=null){
						if(closeisin.element.path_cost<=successor_current_cost){
							continue;
							
					}
						
						bidirectional.front_queue_Close.removeNode(closeisin);
						bidirectional.front_queue.addPrioryA(closeisin);
					}
					else{
						node.element.heuristic=node.element.ManhattanDistance();
						bidirectional.front_queue.addPrioryA(node);
					}
					node.element.path_cost=successor_current_cost;
					node.element.parent=current.element;

				}
				
				else if(is_in_Thread && back){
					QNode queueisin=bidirectional.back_queue.isin(node);
					QNode closeisin=bidirectional.back_queue_Close.isin(node);
					if(queueisin!=null){
						if(queueisin.element.path_cost<=successor_current_cost){
							continue;
						}
					}
					else if(closeisin!=null){
						if(closeisin.element.path_cost<=successor_current_cost){
							continue;
							
					}
						bidirectional.back_queue_Close.removeNode(closeisin);
						bidirectional.back_queue.addPrioryA(closeisin);
					}
					else{
						node.element.heuristic=node.element.ManhattanBack(goal_state);
						bidirectional.back_queue.addPrioryA(node);
					}
					node.element.path_cost=successor_current_cost;
					node.element.parent=current.element;
					
				}
				else if(close.isin(current)==null){
					close.addFirst(current);
					queue.addLast(node);
					if(current.element.heuristic==0){
						return Path2Root(current.element);
					}
				}
			}
		}
		if(is_in_Thread && front)
			bidirectional.front_queue_Close.addFirst(current);
		else if(is_in_Thread && back)
			bidirectional.back_queue_Close.addFirst(current);		
		}while(!Is_Goal_state);

		return null;
	}


    //this method expands a given node according to different actions. 
	private PSTNode Expand(PSTNode node, String action){ 
		int[][] s=new int[3][3]; 
		s=problem.Successor(node.state,action);
		PSTNode child=new PSTNode(s, node, action, node.depth+1
						, node.path_cost+1, null, null, null, null); 
		return child; 			 
	}
	public boolean Goal_Test(int[][] state){
		if(state[0][0]==goal_state[0][0] && state[0][1]==goal_state[0][1] && state[0][2]==goal_state[0][2]
				&& state[1][0]==goal_state[1][0] && state[1][1]==goal_state[1][1] && state[1][2]==goal_state[1][2]
				&& state[2][0]==goal_state[2][0] && state[2][1]==goal_state[2][1] && state[2][2]==goal_state[2][2])
			return true; 
		else 
			return false; 
	}
	//this method returns the path from a node to the root in the search tree. 
	private ActionSequence Path2Root(PSTNode node) {
		ActionSequence path=new ActionSequence(); 
		while(node.parent!=null){
			Action action=new Action(node.action, null, null);
			path.addFirst(action);
			node=node.parent; 
		}

		return path; 
	}
	//Print a given state
	private void printState(int[][] state) {
		System.out.println("\n\n\n"); 
		for (int i=0;i<=2;i++)
			System.out.println(" \t\t\t"+state[i][0]+"\t"+state[i][1]+"\t"+state[i][2]);
	}
}