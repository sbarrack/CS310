/*  Here is an additional test program for your first project.  Look at and try to
    understand what the tester is doing and why.  Be sure to add additionals tests
    on your own.  The fact that your program may work with this tester without error
    does not mean your code is error free.
    
    Alan Riggins
    CS310 Fall 2017
*/    

import data_structures.*;

public class P2TesterStack {
    private Stack<Integer> list;
    
    public P2TesterStack() {
        list = new Stack<Integer>();
        runTests();
        }
        
    private void runTests() {
        if(list.peek() != null) print("ERROR in peekFirst");  
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.push(8); 
        list.push(9);
        list.push(10);
        print("Should now print 1 2 3 4 5 6 7 8 9 10 backwards");
        for(int i : list)
            print(i); 
        print("\n");
        list.remove(3);
        list.remove(8);
        print("The 3 and the 8 have been removed");
        print("Should now print 1 2 4 5 6 7 9 10 backwards");
        for(int i : list)
            print(i); 
        print("\n"); 
        if(list.contains(3)) print ("ERROR, contains removed element");
        if(list.contains(8)) print ("ERROR, contains removed element");  
        if(list.contains(3)) print("ERROR in get, found removed element");
        if(list.contains(8)) print("ERROR in get, found removed element");
        if(list.size() != 8) print("ERROR, size() returns incorrect value");
        list.push(3);
        list.push(8);
        //if(list.addLast(11)) print("ERROR, add to full structure");          
        
        for(int i=1; i <= 10; i++) {
            if(!list.remove(i)) print("ERROR in remove");
        }
        if(list.peek() != null) print("ERROR in peekFirst");
        if(list.size() != 0) print("ERROR, size() returns incorrect value");

       }
       
    private void print(String s) {
        System.out.println(s);
        }
        
    private void print(int i) {
        System.out.print(" "+i);
        }        
        
    public static void main(String [] args) {
        new P2TesterStack();
        }
    }
