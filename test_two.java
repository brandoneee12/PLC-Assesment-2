/*
Brandon Pinto
PLC Assesment 2 

In this problem you will be designing code that should be able to take in a file that is analyzed for lexical and syntactical correctness

This programming language should allow for the following type of outputs:
• switch
• foreach
• for
• while
• do-while
• block
• if
• assignment 
• return

*/


import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

public class test_two {

    public static void main(String[] args) throws FileNotFoundException{
    	
    	// Path to the file for the program to locate  
        File tester = new File("/Users/bpinto/eclipse-workspace/Test2/src/randomstuff.txt"); 
        // Reads the actual file
        FileReader read = null;
        
            try{
                read = new FileReader(tester);
               
                // Scanner to read the read the files input
                Scanner scan = new Scanner (tester);
                String output = scan.nextLine();
                
                
                
                // The list of Keywords I will be using
                String[]  word = output.split("\\s");
                
                
                   // Will be looping through each rule 
                while(output!=null)
                {
                    word = output.split("\\s");
                	for(int i = 0; i<word.length;i++)
                        
                    {
                    	                  	
                    	
                		 // The list of Keywords I will be using
                       if(word[i].equals("switch") || word[i].equals("static")  || word[i].equals("if") 
                            || word[i].equals("while") || word[i].equals("for") || word[i].equals("float")
                            || word[i].equals("do")  || word[i].equals("int") ||  word[i].equals("boolean") 
                            || word[i].equals("char")  || word[i].equals("long")|| word[i].equals("else if") || word[i].equals("else") 
                            || word[i].equals("void") || word[i].equals("main") || word[i].equals("public") 
                            || word[i].equals("do-while")   )
                    	
                    	System.out.println(word[i] + ": is a keyword\n");  	
                       
                       
                       // Determines if an Integer was found
                       else if(Pattern.matches("[0-9]*",word[i]))
                           System.out.println(word[i]+": is an: integer\n");
                       
                       
                       // Finds an identifier
                       else if(Pattern.matches("[a-zA-Z]*[0-9]*", word[i]))
                          	System.out.println(word[i]+": is an identifier\n");
                      
                       // Finds out if it is a floating point number
                       else if(Pattern.matches("[0-9]*[.]*[0-9]*", word[i]))
                           System.out.println(word[i]+": is a floating point number\n");
                        
                       // Determines if it's an assignment 
                       else if(word[i].equals("="))
                            System.out.println(word[i]+": is an assignment\n");
                       
                       // Determines if they are being compared                  
                       else if(word[i].equals("==") || word[i].equals("||") || word[i].equals("!="))
                            System.out.println(word[i]+": is a comparison\n");
                       
                       // Lists the types of operator and determines if there is one
                       else if(Pattern.matches("[/+*%]", word[i]))
                            System.out.println(word[i]+": is an operator\n");
                       
                       
                       // Prints out each individual token
                       else if(word[i].equals("("))
                            System.out.println(word[i]+": is an open paren\n");
                       else if(word[i].equals(")") )
                            System.out.println(word[i]+": is an closed paren\n"); 
                       else if(word[i].equals(";") )
                            System.out.println(word[i]+": is a semicolon\n");  
                       else if(word[i].equals("{"))
                           System.out.println(word[i]+": is an open bracket\n");
                      else if(word[i].equals("}"))
                    	   System.out.println(word[i]+": is a closed bracket\n");
                      else if(word[i].equals("//"))
                    	   System.out.println(word[i]+": is a comment\n");
                       
                       
                       
                   
                    }
                	
                	// Rule for the FOR EACH statement
                if(output.contains("for") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(":")) {
                	System.out.println("\n FOR EACH output- \n");

                    System.out.println("");

                    
                	System.out.println(output+"\n");
                	

                    
                } 
                	// Rule for the WHILE loop
                if(output.contains("while") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(";") && !output.contains("do"))  {
                    System.out.println("\n WHILE output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
                }
                
                	// Rule for the DO WHILE loop
                if(output.contains("do") && output.contains("while") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(";")) {
                    System.out.println("\n DO WHILE output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
                    
                }
                
                	// Rule for the RETURN statement
             	if(output.contains("return") && output.contains(";") && (output.contains("bool") || output.contains("int") || output.contains("string") || output.contains("float")|| output.contains("long") )) {
                    System.out.println("\n RETURN output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
             	}
                 
             		// Rule for the BLOCK statement 
             	if(output.contains("{") && output.contains("}") && !output.contains("if")  && !output.contains("for") && !output.contains("switch") && !output.contains("while") && !output.contains("return") ) {
                    System.out.println("\n BLOCK output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
                   
                    
               	}
             		// Rule for the SWITCH statement
             	if(output.contains("switch") && output.contains("case") && output.contains("break") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(";")) {
                    System.out.println("\n SWITCH output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
                    
               	}
             	
             		// Rule for the IF statement
             	if(output.contains("if") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(";")) {
                    System.out.println("\n IF output- \n");
                    
                    System.out.println("");

                    System.out.println(output+"\n");
             	}
             	
             	
             		// Rule for the FOR loop
             	if(output.contains("for") && output.contains("{") && output.contains("}") && output.contains("(") && output.contains(")") && output.contains(";") && !output.contains(":")) {
                    System.out.println("\n FOR output- \n");
                    
                    
                    System.out.println(output+"\n");
                                                     	            	                                    
               	}
             	
             	output=scan.nextLine();
                }
                  	

            }catch(Exception e){

            } 
            finally{
                try{
                    read.close();
                    

                }catch(Exception e){

                }
            }  
    }
}