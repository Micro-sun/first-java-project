package wc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class charnumber {
    String REGEX =".";
    charnumber() throws IOException {
    System.out.println("Please enter path：");
	Scanner input=new Scanner(System.in);
	String path=input.nextLine();
	System.out.println(path);
	BufferedReader file =new BufferedReader(new FileReader(path));
	int charcount=0; 
    String w;
	Pattern p =Pattern.compile(REGEX);//匹配合适的字符

	while((w=file.readLine()) != null) {
		Matcher m =p.matcher(w);
		while(m.find()){    //找到对应字符时字符数+1
		   charcount ++;}
	}		
	System.out.println("number："+charcount);
	file.close();
}
}