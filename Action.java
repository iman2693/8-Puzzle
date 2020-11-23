class Action{
    String element; 
    Action next,prev; 
    
    // Constructor: 
    // Create a node with the given element and next node. 
    Action(String e, Action p, Action n)
    {
        element = e; 
        prev=p;
        next =n; 
    }
   
}
