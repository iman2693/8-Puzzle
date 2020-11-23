class QNode{
    PSTNode element; 
    QNode next,prev; 
    
    // Constructor: 
    // Create a node with the given element and next/prev nodes. 
    QNode(PSTNode e, QNode p, QNode n)
    {
        element = e; 
        prev=p;
        next =n; 
    }
   
}
