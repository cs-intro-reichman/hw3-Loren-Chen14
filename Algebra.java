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
		System.out.println(sqrt(10));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1 ;

		if ( x2 < 0 ){
			for (int i = 0 ; i > x2 ; i --){
				sum-- ;
			}
			return sum;
		}

		for (int i = 0 ; i < x2 ; i ++){
			sum++ ;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1 ; 

		if ( x2 < 0 ){
			for (int i = 0 ; i > x2 ; i --){
				sum++ ;
			}
			return sum;
		}

		for (int i = 0 ; i < x2 ; i ++){
			sum-- ;
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiplie = 0, temp;

		if ( x1 > 0 && x2 < 0 ) {
			temp = x1;
			x1 = x2;
			x2 = temp;
		} else if ( x1 < 0 && x2 < 0 ){
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

		for (int i = 0 ; i < x2 ; i++ ){
			multiplie = plus(multiplie, x1);
		}
		return multiplie;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int powerOf = x;
		if ( n == 0 ) return 1;

		if (n == 1 ) return x ;

		for (int i = 2 ; i <= n ; i++ ){
			powerOf = times(powerOf, x);
		}
		return powerOf;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divide = 0, sign = 1, calc;

		if (x1 == 0) return 0;

		if ( x1 < 0 && x2 > 0 ) {
			sign = -1;
			x1 = times(x1, -1);
		} else if ( x2 < 0 && x1 > 0 ) {
			sign = -1;
			x2 = times(x2, -1);
		} else if ( x2 < 0 && x1 < 0 ) {
			sign = 1;
			x1 = times(x1, -1);
			x2 = times(x2, -1);
		}

		if ( x1 > x2 ) {
			for ( calc = 0 ; plus(calc, x2) <= x1 ; calc = plus(calc, x2)){
				divide ++;
			}
		} else {
			return 0;
		}
		divide = times(divide, sign);
		return divide;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mode, calc;
		if ( x2 == 0 ) return -1;
		if ( x1 == 0 ) return 0;

		if( x1 < x2 ) {
			return x1;
		} else {
			calc = div(x1, x2);
			calc = times(calc, x2);
			mode = minus(x1, calc);
		}

		return mode;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if ( x == 0 ) return 0;
		else if ( x < 0 ) return -1;
		else if ( x == 1 ) return 1;

		for ( int i = 2; i < x ; i++ ){
			if ( (pow(i, 2) <= x ) && (pow(plus(i, 1), 2) > x  ) ) return i;
		}
		return -1;
	}	  	  
}