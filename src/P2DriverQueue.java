  /*  This driver goes in the level above data_structures
    Driver for program #1.  This simple tester/driver is just a sample.
    The fact that your program might run without errors with this driver
    does not in any way guarantee that it is error free.  You are responsible
    for testing your program.
    Alan Riggins
    CS310 Fall 2017
*/    


import data_structures.*;

public class P2DriverQueue {
    private Queue<Integer> list;
    
    public P2DriverQueue() {
        list = new Queue<Integer>();
        runTests();
        }
        
    private void runTests() {
        for(int i=10; i >= 1; i--) 
            list.enqueue(i);
        System.out.println("Should now print 10 .. 1");
        for(Integer i : list)
            System.out.println(i);
        for(int i=1; i <= 10; i++) 
            if(list.dequeue() == null)
                throw new RuntimeException("ERROR with removeFirst");
        for(Integer i : list)
            System.out.println(i); 
            
        if(!list.isEmpty())
            throw new RuntimeException("ERROR in inEmpty");  
        if(list.size() != 0)
            throw new RuntimeException("ERROR in size");
            
        for(int i=1; i <= 1000; i++) {
            for(int j=7; j >= 1; j--)
                list.enqueue(j);
            for(int j=7; j >= 1; j--)                
                list.dequeue();
            }
            
        for(int i=1; i <= 1000; i++) {
            for(int j=1; j <= 7; j++)
                list.enqueue(j);
            for(int j=1; j <= 7; j++)                
                list.dequeue();
            }
            
        list.makeEmpty();
        list.enqueue(-1);
        if(list.peek() != -1)   
            throw new RuntimeException("ERROR in peekLast"); 
            
        list.makeEmpty();
        for(int i=10; i >= 1; i--)
            list.enqueue(i);
                
        for(int i=1; i <= 10; i++)
            if(!list.contains(i))
                throw new RuntimeException("ERROR in find");                           
        
                                
       }
        
    public static void main(String [] args) {
        new P2DriverQueue();
        }
    }
