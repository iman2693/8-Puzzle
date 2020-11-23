class ActionSequence {
    int size; 
    Action header, trailer; 
    
    //Constructor
    ActionSequence(){
        size=0; 
        header=new Action(null, null, null); 
        trailer=new Action(null, header, null); 
        header.next=trailer; 
    }
    
    
    //Add an element to the last of the action sequence. 
    void addLast(Action v){
        v.next=trailer; 
        v.prev=trailer.prev; 
        trailer.prev.next=v; 
        trailer.prev=v; 
        size++;                 
    }
    void addFirst(Action v){
        header.next.prev=v;
        v.next=header.next;
        header.next=v;
        v.prev=header;
        size++;
        
    }
    
    
    
    //Print all elements of the action sequence.
    void printList(){
        Action current=header.next; 
        while(current!=trailer){
            if(current.element=="d")
                System.out.print("\t"+"Down"); 
            else if(current.element=="u")
                System.out.print("\t"+"Up");
            else if(current.element=="l")
                System.out.print("\t"+"Left");
            else if(current.element=="r")
                System.out.print("\t"+"Right");
            current=current.next;
        }
        //System.out.println(); 
    }
    void printListreverse(){
        Action current=trailer.prev; 
        while(current!=header){
            if(current.element=="l")
                System.out.print("\tRight"); 
            else if(current.element=="r")
                 System.out.print("\tLeft"); 
            else if(current.element=="u")
                 System.out.print("\tDown"); 
            if(current.element=="d")
                 System.out.print("\tUp"); 
            current=current.prev;
        }
        System.out.println(); 
    }
    
    
}
