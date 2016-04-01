/* 
   Nalanda Sharadjaya
   APCS2 pd5
   HW22 -- Standardization
   2016-03-31
*/

import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {

    private ArrayList<T> _stack;

    //constructor
    public ALStack() 
    { 
	_stack = new ArrayList<T>();
    }

    //overloaded constructor allows for intial capacity declaration
    public ALStack( int size ) 
    { 
	_stack = new ArrayList<T>(size); //must typecast
    }

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty()
    {
	return _stack.size() == 0;
    }

    //Return top element of stack without popping it.
    public T peek() {
	if( isEmpty() ) return null;

	//access decremented index without decrementing _stackSize
	return _stack.get( _stack.size() - 1 );
    }

    //Pop and return top element of stack.
    public T pop()
    {
        if( isEmpty() ) return null;
        
	T ret = _stack.get( _stack.size() - 1 );
	_stack.remove( _stack.size() - 1 );
	
	return ret;
    }

    //Push an element onto top of this stack.
    public void push( T x )
    {
	_stack.add(x);
    }

    //main method for testing
    public static void main( String[] args ) {

	ALStack<String> tastyStack = new ALStack<String>(10);

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coocoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//joo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//ioo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//hoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//goo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//foo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//eoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//doo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//boo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//aoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	System.out.println( tastyStack.pop() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//end main()

}//end class ALStack
