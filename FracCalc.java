/*Aniket Mishra
 * Pd 1
 * Frac Calc Checkpoint Final
 * 12/18/17
 */

package fracCalc;
import java.util.Scanner;


public class FracCalc { 
     public static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter a fraction problem");
            String userChoice = sc.nextLine();
            while(!userChoice.equalsIgnoreCase("quit")) {
                System.out.println(produceAnswer(userChoice));    
                System.out.println("Enter a fraction problem");
                userChoice = sc.nextLine();

            }
            
            System.out.println(produceAnswer(userChoice));    }
     public static long gcm(long x, long y) {
    	    return y == 0 ? x : gcm(y, x % y); 
    	   
    	}

    	public static String asFraction(long x, long y) {
    	    long gcm1 = gcm(x, y);
    	   
    	   int gcm = (int) Math.abs(gcm1);
    	   //System.out.println("gcm is " + gcm);
   	    
    	    int xx = (int) (x /gcm);
    	    int yy = (int) (y /gcm);
    	   
    	    if(yy == 1 || yy == -1) {
    	    	 return "" + (xx);
    	    }
    	    if(Math.abs(xx)> Math.abs(yy)) {
    	    	System.out.println(xx);
    	    	System.out.println(yy);

    	    	int quotient = (int) ((xx)/ (yy));
    	    	//System.out.println(quotient);
    	    	int remainder = Math.abs((xx)-(quotient* yy));
    	    	//System.out.println(remainder);

    	    	return quotient + "_" + remainder + "/" + Math.abs(yy);
    	    }
    	    if(xx < 0 && yy > 0){
        	    return (x / gcm) + "/" + (y / gcm);

    	    }
    	    if(yy < 0 && xx > 0){
    	    	return -xx + "/"  + Math.abs(yy);
    	    }
    	    return (x / gcm) + "/" + (y / gcm);


    	}
   
            // TODO: Read the input from the user and call produceAnswer with an equation

        
        
        // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
        // This function takes a String 'input' and produces the result
        //
        // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
        //      e.g. input ==> "1/2 + 3/4"
        //        
        // The function should return the result of the fraction after it has been calculated
        //      e.g. return ==> "1_1/4"


		public static String produceAnswer(String input)
        { 
        	
            String temp = input; 
            String operand1 = temp.substring(0, temp.indexOf(' '));
            temp =  temp.substring(temp.indexOf(' ') + 1);
            String operator = temp.substring(0, temp.indexOf(' '));
            temp =  temp.substring(temp.indexOf(' ') + 1);
            String operand2 = temp;
            
            String op1Whole = findWhole(operand1);
            String op1Numb = findNumb(operand1);
            String op1Denomin = findDenom(operand1);
            
            String op2Whole = findWhole(operand2);
            String op2Numb = findNumb(operand2);
            String op2Denomin = findDenom(operand2);
            
            
            String check2Answer = "whole:" + op2Whole + " numerator:" + op2Numb + " denominator:" + op2Denomin;

    

            String answer = "";
           
       
        

            // TODO: Implement this function to produce the solution to the input
			if(operator.equals("+")) {
			    
			    String top1 = op1Numb;
			    int result1 = Integer.parseInt(top1);
			    
			    
			    String top5 = op1Whole;
			    int result5 = Integer.parseInt(top5);
			    
			    
			    String bottom1 = op1Denomin;
			    int result2 = Integer.parseInt(bottom1);
			    
			    String top6 = op2Whole;
			    int result6 = Integer.parseInt(top6);
			    
			    String top2 = op2Numb;
			    int result3 = Integer.parseInt(top2);
			    
			    
			    
			    String bottom2 = op2Denomin;
			    int result4 = Integer.parseInt(bottom2);
			
	        		        	//4_3/4 + 4_3/4
			   // -3_3/4 + 2_2/4
			    //-3_3/4 + 2_2/4
			    //-3_3/4 + 2_2/4 				-1_1/4
			   

			    if(result5 == 0) {
			    	if(result2 == result4) {
			    		int finaltopfirsthalf = result5 * result2 + result1;
			    		 int finaltopsecondhalf = result6 * result4 + result3;
			    		 int finaltop = finaltopfirsthalf + finaltopsecondhalf;
				    	 //String strI = "" +  finaltop + "/" + result4;
			    		
				    	return asFraction(finaltop, result2);
				    	// return strI;
			    	}
			    	 int finaltopsecondhalf = result6 * result4 + result3;
			    	 String strI = "" +  finaltopsecondhalf + "/" + result4;
				    	System.out.println(finaltopsecondhalf);

			    	System.out.println(result4);
			    	 
			    	 asFraction(finaltopsecondhalf, result4);
			    	 
			    	
			    }
			    if(result2 == 1 && result4 == 1) {
			    	System.out.println("maybe");
			    	int answering = result5 + result6;
			    	String strI = "" + answering;
			    	answer = strI ;
			    	
			    	return strI;
			    }
			    if(result5 < 0 && result6 < 0) {
	        		int finaltopfirsthalf = result5 * result2 - result1;
				      
				      System.out.println(finaltopfirsthalf);
				      int finaltopsecondhalf = result6 * result4 - result3;
				      System.out.println(finaltopsecondhalf);
				      int finaltopfirsthalf1 = finaltopfirsthalf * result4;
				      int finaltopsecondhalf1 = finaltopsecondhalf * result2;
				      int finaltophalf = finaltopfirsthalf1 +  finaltopsecondhalf1;
				      int bottomfinal = result2 * result4;
				      answer = finaltophalf + "/"  + result2;
				      if(finaltophalf == 0) {
				    	  String zero = "0";
				    	  return zero;
				      }
				      System.out.println(finaltophalf);
				      System.out.println(bottomfinal);
				      return asFraction(finaltophalf, bottomfinal);
				      
			        	//return asFraction(finaltophalf,result2);
	        	}
			    if(result5 < 0 ){
			    	
			    	if(result2 == result4) { 	
			    		//System.out.println("yah yeet");
					      int finaltopfirsthalf = result5 * result2 - result1;
					      System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf1 = result6 * result4 + result3;
					      System.out.println(finaltopsecondhalf1);

					      int finaltop = finaltopfirsthalf + finaltopsecondhalf1;
					      
					      
					      if(result6 == 0) {
					    	  String strI = "" + finaltopfirsthalf;
					    		return strI;
					    	}
					      //System.out.println(finaltopfirsthalf);
					     
					      
					      

					      int finaltopsecondhalf = result6 * result4 + result3;
					     //  System.out.println(finaltopsecondhalf);
					      if(result2 == 0 && result4 == 0) {
					    	  String strI = "" + finaltopfirsthalf;
					    	  String strJ = "" + finaltopsecondhalf;
					    	  answer = strI + strJ ;
					    	  return answer;
					      }
					      int finaltophalf = finaltopfirsthalf + finaltopsecondhalf;
					      //   System.out.println(finaltophalf);
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					      if(finaltophalf == result2) {
					    	  String one = "1";
							return one ;
					      }
					      if(result2 == 1) {
					    	  String finaltophalf1 = "" + finaltophalf;
							answer = finaltophalf1;
					      }
					      System.out.println(result2);
					      answer = finaltophalf + "/"  + result2;
					     
					     
				        	return asFraction(finaltop,result2);
					        }
	        		int finaltopfirsthalf = result5 * result2 + result1;
				      
	        		// System.out.println(finaltopfirsthalf);
				      int finaltopsecondhalf = result6 * result4 - result3;
				      // System.out.println(finaltopsecondhalf);

				      int finaltophalf = finaltopfirsthalf + finaltopsecondhalf;
				      

				      answer = finaltophalf + "/"  + result2; 
				      
				      if(finaltophalf == 0) {
				    	  String zero = "0";
				    	  return zero;
				      }
			        	return asFraction(finaltophalf,result2);
	        	}
			       
			        if(result6 < 0 ){
				    	System.out.println("please plesa please");
				    	if(result2 == result4) { 	
				    		System.out.println("yah yeet");
						      int finaltopfirsthalf = result5 * result2 + result1;
						      if(result6 == 0) {
						    	  String strI = "" + finaltopfirsthalf;
						    		return strI;
						    	}
						     
						    
						      System.out.println(finaltopfirsthalf);
						     
						      
						      

						      int finaltopsecondhalf = result6 * result4 - result3;
						      System.out.println(finaltopsecondhalf);
						      if(result2 == 1 && result4 == 1) {
						    	  System.out.println("Are we ther eyet");
						    	  String strI = "" + finaltopfirsthalf;
						    	  String strJ = "" + finaltopsecondhalf;
						    	  answer = strI + strJ ;
						    	  return answer;
						      }
						      if(result5 == 0) {
						    	  String strI = "" + finaltopsecondhalf;
						    		return strI;
						    	}
						     //  System.out.println(finaltopsecondhalf);
						      
						      
						      int finaltophalf = finaltopfirsthalf + finaltopsecondhalf;
						         System.out.println(finaltophalf);
						      if(finaltophalf == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
						      if(finaltophalf == result2) {
						    	  String one = "1";
								return one ;
						      }
						      if(result2 == 1) {
						    	  String finaltophalf1 = "" + finaltophalf;
								answer = finaltophalf1;
						      }
						      System.out.println(result2);
						      answer = finaltophalf + "/"  + result2;
						     
						     
					        	return asFraction(finaltophalf,result2);
						        }
				    	//System.out.println("djawoa");
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		// System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					      // System.out.println(finaltopsecondhalf);

					      int finaltophalf = finaltopfirsthalf + finaltopsecondhalf;
					      

					      answer = finaltophalf + "/"  + result2;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
				        	return asFraction(finaltophalf,result2);
		        	}
				        if(result2 == result4) { 	
				        	System.out.println("waodhiwaoja");
				      int finaltopfirsthalf = result5 * result2 + result1;
				     System.out.println(finaltopfirsthalf);
				     
				      
				      

				      int finaltopsecondhalf = result6 * result4 + result3;
				      //  System.out.println(finaltopsecondhalf);

				      int finaltophalf = finaltopfirsthalf + finaltopsecondhalf;
				      //   System.out.println(finaltophalf);

				      
				      answer = finaltophalf + "/"  + result2;
				      if(finaltophalf == 0) {
				    	  String zero = "0";
				    	  return zero;
				      }
				      if(finaltophalf == result2) {
				    	  String one = "1";
						return one ;
				      }
				      
			        	return asFraction(finaltophalf,result2);
				        }else {
				        		//System.out.println("Cmon BRUH");
						      int finaltopfirsthalf = result5 * result2 + result1;
						      int finaltopsecondhalf = result6 * result4 + result3;
						      int tophalf1 = finaltopfirsthalf * result4;
						      int
						      tophalf2 = finaltopsecondhalf * result2;
						      int tophalffinal = tophalf1 + tophalf2;
						      int bottomfinal = result2 * result4;
						      
						      answer = tophalffinal + "/" + bottomfinal;
						      if(tophalffinal == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
						      System.out.println("Does it reach here");
				        	return asFraction(tophalffinal,bottomfinal);
								


						        
				        }
				       
			        
			        	
			        
				       
			   
			}
			if(operator.equals("-")) {
				 String top1 = op1Numb;
				    int result1 = Integer.parseInt(top1);
				    
				    
				    String top5 = op1Whole;
				    int result5 = Integer.parseInt(top5);
				    
				    
				    String bottom1 = op1Denomin;
				    int result2 = Integer.parseInt(bottom1);
				    
				    String top6 = op2Whole;
				    int result6 = Integer.parseInt(top6);
				    
				    String top2 = op2Numb;
				    int result3 = Integer.parseInt(top2);
				    
				    
				    
				    String bottom2 = op2Denomin;
				    int result4 = Integer.parseInt(bottom2);
				    
				    System.out.println(result2);
				    System.out.println(result4);
				    System.out.println(result5);
				    System.out.println(result6);
				
		        		        	//4_3/4 + 4_3/4
				    				//-3_3/4 - 2_2/4
				    //-12_3/7 - -20_2/3
				    //-3_3/4 - -2_2/4
				
				    	   if(result2 == 1 && result4 == 1) {
						    	System.out.println("maybe");
						    	int answering = result5 - result6;
						    	String strI = "" + answering;
						    	answer = strI ;
						    	return answer;
				    }
				    if(result5 < 0 && result6 < 0) {
				    	if(result2 == result4) {
				        	
						      int finaltopfirsthalf = result5 * result2 - result1;
						      
						      //   System.out.println(finaltopfirsthalf);
						      int finaltopsecondhalf = result6 * result4 - result3;
						      //  System.out.println(finaltopsecondhalf);
						     
						      
						      int finaltophalf = finaltopfirsthalf - finaltopsecondhalf;
						      //  System.out.println(finaltophalf);

						      answer = finaltophalf + "/"  + result2;
						      if(finaltophalf == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
					        	return asFraction(finaltophalf,result2);
						        }
					      

		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//   System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					      //  System.out.println(finaltopsecondhalf);
					      int finaltophalf1 = finaltopfirsthalf * result4;
					      //   System.out.println(finaltophalf1);
					      int finaltophalf2 = finaltopsecondhalf * result2;
					      //   System.out.println(finaltophalf2);
					      int finaltophalf = finaltophalf1 - finaltophalf2;
					      //    System.out.println(finaltophalf);
					      int bottomfinal = result2 * result4;
					      //   System.out.println(bottomfinal);
					      
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
		        	if(result5 < 0 ) {
		        		//-3_3/4 + 2_2/4 		-1_1/4

		        		if(result2 == result4) {
				        	
						      int finaltopfirsthalf = result5 * result2 - result1;
						      
						      //     System.out.println(finaltopfirsthalf);
						      int finaltopsecondhalf = result6 * result4 + result3;
						      //     System.out.println(finaltopsecondhalf);
						      
						      int finaltophalf = finaltopfirsthalf - finaltopsecondhalf;
						      

						      answer = finaltophalf + "/"  + result2;
						     
						      if(finaltophalf == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
					        	return asFraction(finaltophalf,result2);
						        }
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//    System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 + result3;
					      //   System.out.println(finaltopsecondhalf);

					      int finaltophalf1 = finaltopfirsthalf * result4;
					      int finaltophalf2 = finaltopsecondhalf * result2;
					      int finaltop = finaltophalf1 - finaltophalf2;
					      int bottomfinal = result2 * result4;

					      
					      

					      answer = finaltop + "/"  + result2;
					      if(finaltop == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
				        	return asFraction(finaltop,bottomfinal);
		        	}
		        	if(result6 < 0) {
		        		System.out.println("wdwaawad");
		        		int finaltopfirsthalf = result5 * result2 + result1;
					      
		        		 System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					       System.out.println(finaltopsecondhalf);

					      int finaltophalf = finaltopfirsthalf - finaltopsecondhalf;
					      
					      System.out.println(finaltophalf);
					      int bottomfinal = result2 * result4;
					      int tophalf1 = finaltopfirsthalf * result4;
					      int tophalf2 = finaltopsecondhalf * result2;
					      int topfinalll = tophalf1 - tophalf2;
					     
					      answer = finaltophalf + "/"  + result2;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					      if(result2 == 1 || result4 == 1) {
					    	  String str = "" + finaltophalf;
					    	  return str;
					      }
					      return asFraction(topfinalll, bottomfinal );
		        	}
				        if(result2 == result4) {
				        	
				      int finaltopfirsthalf = result5 * result2 + result1;
				      
				      //   System.out.println(finaltopfirsthalf);
				      int finaltopsecondhalf = result6 * result4 + result3;
				      //  System.out.println(finaltopsecondhalf);

				      int finaltophalf = finaltopfirsthalf - finaltopsecondhalf;
				      

				      answer = finaltophalf + "/"  + result2;
				      if(finaltophalf == 0) {
				    	  String zero = "0";
				    	  return zero;
				      }
			        	return asFraction(finaltophalf,result2);
				        }else {
						      int finaltopfirsthalf = result5 * result2 + result1;
						      int finaltopsecondhalf = result6 * result4 + result3;
						      int tophalf1 = finaltopfirsthalf * result4;
						      int
						      tophalf2 = finaltopsecondhalf * result2;
						      int tophalffinal = tophalf1 - tophalf2;
						      int bottomfinal = result2 * result4;
						      answer = tophalffinal + "/" + bottomfinal;
						      if(tophalffinal == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
					        	return asFraction(tophalffinal,bottomfinal);

				        }
				        	
			}
			if(operator.equals("*")) {
				 String top1 = op1Numb;
				    int result1 = Integer.parseInt(top1);
				    
				    
				    String top5 = op1Whole;
				    int result5 = Integer.parseInt(top5);
				    
				    
				    String bottom1 = op1Denomin;
				    int result2 = Integer.parseInt(bottom1);
				    
				    String top6 = op2Whole;
				    int result6 = Integer.parseInt(top6);
				    
				    String top2 = op2Numb;
				    int result3 = Integer.parseInt(top2);
				    
				    
				    
				    String bottom2 = op2Denomin;
				    int result4 = Integer.parseInt(bottom2);
				
		        		        	//4_3/4 + 4_3/4
				    //1_27/41 * -3_140/23
				    if(result5 < 0 && result6 < 0) {
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//   System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					      //   System.out.println(finaltopsecondhalf);

					      int finaltophalf = finaltopfirsthalf * finaltopsecondhalf;
					      //    System.out.println(finaltophalf);
					      int bottomfinal = result2 * result4;
					      //   System.out.println(bottomfinal);
					      
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
				    if(result5 < 0) {
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//   System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 + result3;
					      //  System.out.println(finaltopsecondhalf);

					      int finaltophalf = finaltopfirsthalf * finaltopsecondhalf;
					      //   System.out.println(finaltophalf);
					      int bottomfinal = result2 * result4;
					      //    System.out.println(bottomfinal);
					      
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
				    if(result6 < 0) {
		        		int finaltopfirsthalf = result5 * result2 + result1;
					      
		        		//    System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					      //   System.out.println(finaltopsecondhalf);

					      int finaltophalf = finaltopfirsthalf * finaltopsecondhalf;
					      //    System.out.println(finaltophalf);
					      int bottomfinal = result2 * result4;
					      //    System.out.println(bottomfinal);
					      
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
				   
						      int finaltopfirsthalf = result5 * result2 + result1;
						      

						      int finaltopsecondhalf = result6 * result4 + result3;
						      
						   

						      int tophalffinal = finaltopfirsthalf *  finaltopsecondhalf;
						      System.out.println(tophalffinal);
						      int bottomfinal = result2 * result4;
						      System.out.println(bottomfinal);
						      
						      
						     
						    		  
						      
						     if(bottomfinal == 1 || bottomfinal == -1) {
						    	  System.out.println("hello");
						    	  String str = "" + tophalffinal;
						    	  return str;
						      }
						      
						      if(tophalffinal == 0) {
						    	  String zero = "0";
						    	  return zero;
						      }
						      
						     return asFraction(tophalffinal, bottomfinal);
						    		 
						     
						      
						    /* 
						      
					        	return asFraction(tophalffinal,bottomfinal);
*/
			}
			if(operator.equals("/")) {
				String top1 = op1Numb;
			    int result1 = Integer.parseInt(top1);
			    
			    
			    String top5 = op1Whole;
			    int result5 = Integer.parseInt(top5);
			    
			    
			    String bottom1 = op1Denomin;
			    int result2 = Integer.parseInt(bottom1);
			    
			    String top6 = op2Whole;
			    int result6 = Integer.parseInt(top6);
			    
			    String top2 = op2Numb;
			    int result3 = Integer.parseInt(top2);
			    
			    
			    
			    String bottom2 = op2Denomin;
			    int result4 = Integer.parseInt(bottom2);
			
	        		        	//-38_3/72 / -4_82/37
			    //4_3/4 + 4_3/4
	        	//4_3/4 + 4_3/4
				    if(result5 < 0 && result6 < 0) {
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//    System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					      //    System.out.println(finaltopsecondhalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int finaltophalf = finaltopfirsthalf * result4;
					         System.out.println(finaltophalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int bottomfinal = finaltopsecondhalf * result2;
					      System.out.println(bottomfinal);
					      if(bottomfinal == 1 || bottomfinal == -1) {
						    	System.out.println("iwahdaopjoawigdou");
						    	int newbruh = finaltophalf/bottomfinal;
					    	  String str = "" + newbruh;
					    	  return str;
					      }
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
				    if(result5 < 0) {
		        		int finaltopfirsthalf = result5 * result2 - result1;
					      
		        		//    System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 + result3;
					      //    System.out.println(finaltopsecondhalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int finaltophalf = finaltopfirsthalf * result4;
					          System.out.println(finaltophalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int bottomfinal = finaltopsecondhalf * result2;
					        System.out.println(bottomfinal);
					        System.out.println("monkey");
					      
					      answer = finaltophalf + "/"  + bottomfinal;
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
				    if(result6 < 0) {
				    	  

		        		int finaltopfirsthalf = result5 * result2 + result1;
					      
		        		//    System.out.println(finaltopfirsthalf);
					      int finaltopsecondhalf = result6 * result4 - result3;
					       //  System.out.println(finaltopsecondhalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int finaltophalf = finaltopfirsthalf * result4;
					      //    System.out.println(finaltophalf);
					      //    System.out.println(result2);
					      //    System.out.println(result4);
					      int bottomfinal = finaltopsecondhalf * result2;
					      //  System.out.println(bottomfinal);
					      
					     // answer = finaltophalf + "/"  + bottomfinal;
					      if(result2 == 1 && result4 == 1) {
					    	  System.out.println("is it hereeee1");
					    	  int bruh = finaltophalf/result6;
					    	  String str = "" + bruh;
					    	  return str;
					      }
					      if(result2 == 1) {
					    	  System.out.println("is it hereeee2");
					    	  String str = "" + finaltopsecondhalf;
					    	  return str;
					      }
					      if(result4 == 1) {
					    	  System.out.println("is it hereee3e");
					    	  String str = "" + finaltopfirsthalf;
					    	  return str;
					      }
					      if(finaltophalf == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
					     
				        	return asFraction(finaltophalf,bottomfinal);
		        	}
					      int finaltopfirsthalf = result5 * result2 + result1;
					      int finaltopsecondhalf = result6 * result4 + result3;
					   
					      int tophalffinal = finaltopfirsthalf *  result4;
					      int bottomfinal = result2 * finaltopsecondhalf;
					      answer = tophalffinal + "/" + bottomfinal;
					      if(tophalffinal == 0) {
					    	  String zero = "0";
					    	  return zero;
					      }
				        	return asFraction(tophalffinal,bottomfinal);
			}
			return answer;
			}
			

        
       

        public static void addition(String op2Whole, String op2Denomin) {
                
                
            }

        // TODO: Fill in the space below with any helper methods that you think you will need
        public static String findWhole(String str) {
            if(str.contains("_")) {
                return str.substring(0, str.indexOf('_'));
            }
            else if(str.contains("/")) {
                return "0";
            }else return str;

        }
        
        public static String findNumb(String str) {
            if(str.contains("_")) {
                return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
                
            }else if (str.contains("/")) {
                return str.substring(0, str.indexOf('/'));
            }else {
                return "0";
            }
                
                    
        }
        public static String findDenom(String str) {
            if(str.contains("/")) {
                return str.substring(str.indexOf("/") + 1);
                }else {
                    return "1";
                    
                }
        }
    }