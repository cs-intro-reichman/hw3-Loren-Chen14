// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123)); 
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1 ;

		// if x2 is a negative number the addision is acually subtraction
		if ( x2 < 0 ){
			// subtractung to x1 1 |x2| times 
			for (int i = 0 ; i > x2 ; i --){
				sum-- ;
			}
			return sum;
		}

		// adding to x1 1 x2 times 
		for (int i = 0 ; i < x2 ; i ++){
			sum++ ;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1 ; 

		// if x2 is a negative number the subtraction is acually addision
		if ( x2 < 0 ){
			// adding to x1 1 |x2| times
			for (int i = 0 ; i > x2 ; i --){
				sum++ ;
			}
			return sum;
		}

		// subtractung to x1 1 x2 times
		for (int i = 0 ; i < x2 ; i ++){
			sum-- ;
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiplie = 0, temp;

		// if x1 is positive and x2 is negative , change the places because multiplication is commutative
		if ( x1 > 0 && x2 < 0 ) {
			temp = x1;
			x1 = x2;
			x2 = temp;
		} else if ( x1 < 0 && x2 < 0 ){		// if both x1 and x2 are negative , change the signs of both variable to positive
			temp = x1;
			for (int i = 0 ; i < 2 ; i++ ){
				temp = minus(temp, x1);
			}
			x1 = temp;
			temp = x2;

			for (int j = 0 ; j < 2 ; j++ ){
				temp = minus(temp, x2);
			}
			x2 = temp;
		}

		// adding to x1 itself x2 time == multiple x1 by x2
		for (int i = 0 ; i < x2 ; i++ ){
			multiplie = plus(multiplie, x1);
		}
		return multiplie;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int powerOf = x;
		if ( n == 0 ) return 1;		// x in the power of n = 0 equals to 1

		if (n == 1 ) return x ;		// x in the power of n = 1 equals to x itself

		// multiplie x by itself n times = x in the power of n
		for (int i = 2 ; i <= n ; i++ ){
			powerOf = times(powerOf, x);
		}
		return powerOf;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divide = 0, sign = 1, calc;

		if (x1 == 0) return 0;				// 0 divide any x != 0 equals to 0

		if ( x1 < 0 && x2 > 0 ) {			// if x1 is negative and x2 is positive sign will be negative and change x1 to positive 
			sign = -1;
			x1 = times(x1, -1);
		} else if ( x2 < 0 && x1 > 0 ) {	// if x2 is negative and x1 is positive sign will be negative and change x2 to positive
			sign = -1;
			x2 = times(x2, -1);
		} else if ( x2 < 0 && x1 < 0 ) {	// if both x1 and x2 are negative, sign will be 1 and change x1 and x2 to positive 
			sign = 1;
			x1 = times(x1, -1);
			x2 = times(x2, -1);
		}

		// if x1 > x2 the divition is 1 or greater then 1 
		if ( x1 > x2 ) {
			// checking how many times x2 enters in x1
			for ( calc = 0 ; plus(calc, x2) <= x1 ; calc = plus(calc, x2)){
				divide ++;
			}
		} else {							// if x1 is smaller the x2 it means x2 enter x1 0 times 
			return 0;
		}
		// adding the sign to the final result
		divide = times(divide, sign);
		return divide;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mode, calc;

		if ( x1 == 0 ) return 0;			// 0 divide any x equals to 0 which mean there is no remainder 

		// when x1 is smaller then x2 the remainder is always x1 
		if( x1 < x2 ) {
			return x1;
		} else {							// calculates the remainder 
			calc = div(x1, x2);
			calc = times(calc, x2);
			mode = minus(x1, calc);
		}

		return mode;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if ( x == 0 ) return 0;				// sqrt of 0 is 0
		else if ( x == 1 ) return 1;		//// sqrt of 1 is 1

		// checks which 2 numbers beteen 2 to (x-1) multiplie by itself is the most close to x
		for ( int i = 2; i < x ; i++ ){
			if ( (pow(i, 2) <= x ) && (pow(plus(i, 1), 2) > x  ) ) return i;
		}
		return -1;
	}	  	  
}