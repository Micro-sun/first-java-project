package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class linenumber {
	linenumber() throws IOException {
    System.out.println("Please enter path£º");
	Scanner input=new Scanner(System.in);
	String path=input.nextLine();
    int line = 0;

 	BufferedReader file =new BufferedReader(new FileReader(path));
    try {
   
        String tempString = null;
 
        while ((tempString = file.readLine()) != null) {
            line++;
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
    System.out.println("line number:"+line );
}
}