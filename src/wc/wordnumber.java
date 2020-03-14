package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class wordnumber {
    String reg = " +";//按照多个空格来进行切割
    String[] arr ;  
    int wordnumber=0;
	   wordnumber() throws IOException {
	    System.out.println("Please enter path：");
		Scanner input=new Scanner(System.in);
		String path=input.nextLine();
		BufferedReader file =new BufferedReader(new FileReader(path));

		  try {
			   
		        String tempString = null;
		 
		        while ((tempString = file.readLine()) != null) {
		        	arr = tempString.split(reg);
		        	for(int i=0;i<arr.length;i++)
					{
		        		wordnumber++;

					}
	
		           // System.out.println(tempString);
		        }
		
		        file.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (file != null) {
		            try {
		            	file.close();
		            } catch (IOException e1) {
		            }
		        }
		    }
		  System.out.println(wordnumber);

	}
}