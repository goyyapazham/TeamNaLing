/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
      1. Steal underpants.
      2. ...
      5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
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
	if( expr.lastIndexOf("(") == -1 ) return expr;
	
	String before = expr.substring(0, expr.lastIndexOf("("));
	String innermost =
	    expr.substring(expr.lastIndexOf("("),
			   expr.substring(expr.lastIndexOf("(")).indexOf(")")
			   + expr.lastIndexOf("(") + 1);
	String after =
	    expr.substring(expr.substring(expr.lastIndexOf("(")).indexOf(")")
			   + expr.lastIndexOf("(") + 1);

	String[] tmp = innermost.split(" ");
	Stack<String> exp = new Stack<String>();
	int op = 0;
	if( tmp[1].equals("+") )
	    op = 1;
	if( tmp[1].equals("-") )
	    op = 2;
	if( tmp[1].equals("*") )
	    op = 3;
        for( int i = tmp.length - 2; i > 1; i-- )
	    exp.push(tmp[i]);

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
	int fin = Integer.parseInt( numbers.pop() );
	
	if( op < 3 ) {
	    while( numbers.peek() != null ) {
		if( op == 1 ) fin += Integer.parseInt( numbers.pop() );
		else fin -= Integer.parseInt( numbers.pop() );
	    }
	}
	else {
	    while( numbers.peek() != null ) {
		fin *= Integer.parseInt( numbers.pop() );
	    }
	}

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
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
