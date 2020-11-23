class bidirectional{
    int[][] Initial_State;
    int[][] Goal_State;
    Problem problem;
    static Queue front_queue=new Queue();
    static Queue front_queue_Close=new Queue();
    static Queue back_queue=new Queue();
    static Queue back_queue_Close=new Queue();
    static ActionSequence frontas;
    static ActionSequence backas;
    static boolean isgoal=false;
    static int counter=0;
    //constructor
    bidirectional(int[][] i,int[][] g, Problem p){
        this.Initial_State=i;
        this.Goal_State=g;
        problem=p;
    }
    ActionSequence calBidirectional(){
        AStar astar_front=new AStar(Goal_State,Initial_State,problem);
        astar_front.front=true;
        astar_front.is_in_Thread=true;
        AStar astar_back=new AStar(Initial_State,Goal_State,problem);
        astar_back.back=true;
        astar_back.is_in_Thread=true;
        astar_front.start();
        astar_back.start();
        return null;

    }
//print action sequences
    static void printas(){
        frontas.printList();
        //System.out.println();
        backas.printListreverse();
    }
    
}