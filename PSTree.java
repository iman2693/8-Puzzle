// 8-puzzle search tree
class PSTree { 
    PSTNode root; 
    
    //Constructor: create an empty search tree with a empty elements. 
    //This node will refer to the search node (corresponding node for initiall state)
	
    PSTree(PSTNode search_node){
        root=search_node; 
    }

    
    void addNodeUp(PSTNode node, PSTNode parent){
	    parent.up_child=node; 
	    node.parent=parent; 
	    node.action="up"; 
	    node.depth=parent.depth+1; 
	    node.path_cost=parent.path_cost+1; 
    }

    void addNodeDown(PSTNode node,PSTNode parent) {
	    parent.down_child=node;
	    node.parent=parent; 
	    node.action="down"; 
	    node.depth=parent.depth+1; 
	    node.path_cost=parent.path_cost; 
    }

    void addNodeLeft(PSTNode node,PSTNode parent){
	    parent.left_child=node;
	    node.parent=parent; 
	    node.action="left"; 
	    node.depth=parent.depth+1; 
	    node.path_cost=parent.path_cost+1; 
    }

    void addNodeRight(PSTNode node,PSTNode parent){
	    parent.right_child=node; 
	    node.parent=parent; 
	    node.action="right"; 
	    node.depth=parent.depth+1; 
	    node.path_cost=parent.path_cost+1; 
    }

}

