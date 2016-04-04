/* 
   Team NaLing- Nalanda Sharadjaya and Ling Cheng
   APCS2 pd5
   HW24 -- Schemin
   2016-04-04
*/

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *    1. Iterate through the inputted string and obtain innermost expression.
 *    2. Evaluate this expression.
 *    3. Insert this value into, and recurse on, the full expression.
 *    4. Repeat steps 1, 2 and 3 until the expression is fully evaluated.
 *
 * STACK OF CHOICE: ALStack by Nalanda Sharadjaya
 * It shouldn't matter which Stack we choose, since we never interact with the actual _stack's data structure itself -- only the methods of class Stack. Thus, our choice was completely arbitrary.
 ******************************************************/

import java.util.ArrayList;

public class Scheme {

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr )
    {
	//if you're done, you're done!
	if( expr.lastIndexOf("(") == -1 ) return expr;

	/* The nature of infix notation is such that the further embedded an
	   expression is, the earlier it gets evaluated. The following lines
	   split the expression into things BEFORE and AFTER the innermost
	   "nugget", which will be meaningful later. */
	
	//everything before the innermost expression
	String before = expr.substring(0, expr.lastIndexOf("("));

	//the innermost expression
	String innermost =
	    expr.substring(expr.lastIndexOf("("),
			   expr.substring(expr.lastIndexOf("(")).indexOf(")")
			   + expr.lastIndexOf("(") + 1);

	//everything after the innermost expression
	String after =
	    expr.substring(expr.substring(expr.lastIndexOf("(")).indexOf(")")
			   + expr.lastIndexOf("(") + 1);

	//for convenience sake (easier to do indices w/ arrays than strings)
	String[] tmp = innermost.split(" ");

	//store operation for unload call
	int op = 0;
	if( tmp[1].equals("+") )
	    op = 1;
	if( tmp[1].equals("-") )
	    op = 2;
	if( tmp[1].equals("*") )
	    op = 3;

	//load VALUES from "nugget" expression into stack for unload call
	Stack<String> exp = new Stack<String>();
        for( int i = tmp.length - 2; i > 1; i-- )
	    exp.push(tmp[i]);

	//evaluate the BEFORE, the nugget, and the AFTER
	return evaluate(before + unload(op, exp) + after);
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	//"fin" for end!!
	int fin = Integer.parseInt( numbers.pop() );

        //iterate thru nums and behave as per designated operation
	while( numbers.peek() != null ) {
	    int i = Integer.parseInt( numbers.pop() );
	    if( op == 1 ) fin += i;
	    if( op == 2 ) fin -= i;
	    if( op == 3 ) fin *= i;
	}

	//make simplified expression a string
	return "" + fin;
    }//end unload()

    
    //main method for testing
    public static void main( String[] args ) {

	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7
	
	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17
	
	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4

	String zoo5 = "( + ( + 1 1 ) ( + 1 1 ) ( + 1 1 ) )";
	System.out.println(zoo5);
	System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
	//...6

	String zoo6 = "( + 1 ( + 1 1 ) )";
	System.out.println(zoo6);
	System.out.println("zoo6 eval'd: " + evaluate(zoo6) );
	//...3

	String zoo7 = "( + ( + 1 1 ) 1 )";
	System.out.println(zoo7);
	System.out.println("zoo7 eval'd: " + evaluate(zoo7) );
	//...3

	String zoo8 = "( + 1 ( + 1 1 ) 1 )";
	System.out.println(zoo8);
	System.out.println("zoo8 eval'd: " + evaluate(zoo8) );
	//...4
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
