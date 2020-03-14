package wc;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class helloworld {
	public static void main(String[] args) throws IOException{
	while(true) {
		System.out.println("输入显示：");
		System.out.println("-c 返回文件 file.c 的字符数：");
		System.out.println(" -w 返回文件 file.c 的词的数目 ");
		System.out.println(" -l 返回文件 file.c 的行数");
		System.out.println(" -x 图形化");
		System.out.println("输出为：");

		Scanner input=new Scanner(System.in); //从键盘上输入指令并执行
		String commend=input.nextLine();
		switch (commend) {
		case "-c":
		charnumber ch = new charnumber();
		break;
		case "-l":
		linenumber line = new linenumber();
		break;
		case "-w":
		wordnumber word = new wordnumber();
		break;
		case "-x":
		 shape();
		break;
		}

		}	
}

	private static void shape() {
	      //定义一个窗体对象f，窗体名称为"一个简单窗口"     
	      JFrame  f = new JFrame("图形化");

	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setBounds(100,100,500,500);
	      
	     // f.setResizable(false);
	      Container c=f.getContentPane();
	      c.setLayout(new FlowLayout());
	      

	      
	      JLabel l=new JLabel("请输入选择：（示例：-c、-w、-l）");
	      l.setPreferredSize(new Dimension (200,20)); 
	      c.add(l);
	      
	      JTextField jt=new JTextField();
	      jt.setPreferredSize(new Dimension (200,20)); 
	      c.add(jt);
	      
	      JButton btnone=new JButton("确定");
	      btnone.setBounds(0,0,10,10);
	      c.add(btnone);
	      
	      
	      JLabel path=new JLabel("请输入路径：");
	      path.setPreferredSize(new Dimension (200,20)); 
	      c.add(path);
	      
	      JTextField pathtext=new JTextField();
	      pathtext.setPreferredSize(new Dimension (200,20)); 
	      c.add(pathtext);
	      
	      JButton btntwo=new JButton("清空");
	      btntwo.setBounds(0,0,10,10);
	      c.add(btntwo);
	      
	      JLabel ansertext=new JLabel("数量：");
	      ansertext.setPreferredSize(new Dimension (200,20)); 
	      c.add(ansertext);
	      
	      JTextField answer=new JTextField();
	      answer.setPreferredSize(new Dimension (200,20)); 
	      c.add(answer);
     
	      f.setVisible(true);
	      
	      
	      btnone.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    			switch (jt.getText()) {
	    			case "-c":
	    				c();
	    			break;
	     			case "-l":
	    				l();
	    			break;
	    			case "-w":
	    				w();
	    			break;
	    			}
	    	
	   	  }

			private void w() {
			    String reg = " +";//按照多个空格来进行切割
			    String[] arr ;  
			    int wordnumber=0;
			 	BufferedReader file = null;
				try {
					file = new BufferedReader(new FileReader(pathtext.getText()));
				} catch (FileNotFoundException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}

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
					answer.setText(String.valueOf(wordnumber));
				  System.out.println(wordnumber);
				
			}

			private void l() {
				  int line = 0;

				 	BufferedReader file = null;
					try {
						file = new BufferedReader(new FileReader(pathtext.getText()));
					} catch (FileNotFoundException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					}
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
					answer.setText(String.valueOf(line));
				
			}

			private void c() {
				String REGEX =".";
				BufferedReader file = null;
				try {
					file = new BufferedReader(new FileReader(pathtext.getText()));
				} catch (FileNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
					int charcount=0; 
				    String w;
					Pattern p =Pattern.compile(REGEX);//匹配合适的字符

				try {
					while((w=file.readLine()) != null) {
						Matcher m =p.matcher(w);
						while(m.find()){    //找到对应字符时字符数+1
						   charcount ++;}
					}
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}		
				answer.setText(String.valueOf(charcount));
					System.out.println("number："+charcount);
				try {
					file.close();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
	      });
	      btntwo.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		  jt.setText("");
	    		  pathtext.setText("");
	    		  answer.setText("");
	   	  }
	      });
	}}
