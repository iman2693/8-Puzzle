class Queue {
    int size; 
    QNode header, trailer; 
    
    //Constructor
    Queue(){
        size=0; 
        header=new QNode(null, null, null); 
        trailer=new QNode(null, header, null); 
        header.next=trailer; 
    }
    
    //Add an element to the first of the queue
    void addFirst(QNode v){
        v.next=header.next; 
        v.prev=header; 
        header.next.prev=v; 
        header.next=v; 
        size++; 
    }
    
    //Add an element to the last of the queue. 
    void addLast(QNode v){
        v.next=trailer; 
        v.prev=trailer.prev; 
        trailer.prev.next=v; 
        trailer.prev=v; 
        size++;                 
    }

    // Priori add with g(n)
    void addPriory(QNode v){
        if(size==0){
            addFirst(v);
        }
        else{
            QNode temp=header.next;
            while(temp.next!=null){
                if(v.element.path_cost<=temp.element.path_cost){
                    break;
                }
                temp=temp.next;
            }
            if(temp.next==null)
                addLast(v);
            else{
                v.prev=temp.prev;
                v.next=temp;
                temp.prev.next=v;
                temp.prev=v;
                size++;
            }
        }
        
    }

    // Priory add with f(n)
    void addPrioryA(QNode v){
        if(size==0){
            addFirst(v);
        }
        else{
            QNode temp=header.next;
            while(temp.next!=null){

                if(v.element.path_cost+v.element.heuristic<temp.element.path_cost+temp.element.heuristic){
                    break;
                }
                temp=temp.next;
            }
            if(temp.next==null)
                addLast(v);
            else{
                v.prev=temp.prev;
                v.next=temp;
                temp.prev.next=v;
                temp.prev=v;
                size++;
            }
        }
    }
    
    //Add an element v after a given element u
    void addAfter(QNode u, QNode v){
        v.prev=u; 
        v.next=u.next; 
        u.next.prev=v; 
        u.next=v; 
        size++; 
    }
    
    //Remove an element from head (first of the queue)
    QNode removeFirst(){ 
        // print an error if the queue is empty. 
        if (header.next==trailer) {
            System.out.println("The queue is empty. ");
            return null;
        }
        
        QNode t; 
        t=header.next; 
        header.next=t.next; 
        t.next.prev=header; 
        t.next=null; 
        t.prev=null; 
        size--;
	return t;  
    }
    void removeNode(QNode n){
        if (header.next==trailer) {
            System.out.println("The queue is empty. ");
            return;
        }
        QNode temp=header.next;
        while(temp.next!=null){
            if(temp.next==n){
                n.prev.next=n.next;
                n.next.prev=temp;
                n.next=null;
                n.prev=null;
                size--;
                return;
            }
            temp=temp.next;
        }
        
    }
    // QNode isin(int[][] state){
    //     if(header.next==trailer)
    //         System.out.print(size);
    //         System.out.println("hello");
    //     QNode temp=header.next;
    //     while(temp.next!=null){
    //         if(equalstates(state, temp.element.state))
    //             return temp;
    //         temp=temp.next;
    //     }
    //     return null;
    // }
    QNode isin(QNode state){
        if(header.next==trailer || header.next==null || size==0)
            return null;
        QNode temp=header.next;
        try {
            
        do{
            if(equalstates(state.element.state, temp.element.state))
                return temp;
            temp=temp.next;
        }while(temp.next!=null);
        //  Block of code to try
        }catch(Exception e){
            return null;
        }
        return null;
    }
    Boolean equalstates(int[][] s,int[][] v){
        for(int i=0 ; i<=2;i++)
                for(int j=0;j<=2;j++)
                    if(s[i][j]!=v[i][j]){
                        return false;
                    }
        return true;

    }
    Boolean ishigherthan(int g){
        QNode temp=header.next;
        while(temp.next!=null){
            if(temp.element.path_cost>=g)
                return false;
            temp=temp.next;
        }
        return true;
    }
    
    
    //Print all elements of the queue
    void printQueue(){
        QNode current=header.next; 
        while(current!=trailer){
            System.out.print("\t"+current.element.action); 
            current=current.next;
        }
    }
    
}
