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
		System.out.println("������ʾ��");
		System.out.println("-c �����ļ� file.c ���ַ�����");
		System.out.println(" -w �����ļ� file.c �Ĵʵ���Ŀ ");
		System.out.println(" -l �����ļ� file.c ������");
		System.out.println(" -x ͼ�λ�");
		System.out.println("���Ϊ��");

		Scanner input=new Scanner(System.in); //�Ӽ���������ָ�ִ��
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
	      //����һ���������f����������Ϊ"һ���򵥴���"     
	      JFrame  f = new JFrame("ͼ�λ�");

	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setBounds(100,100,500,500);
	      
	     // f.setResizable(false);
	      Container c=f.getContentPane();
	      c.setLayout(new FlowLayout());
	      

	      
	      JLabel l=new JLabel("������ѡ�񣺣�ʾ����-c��-w��-l��");
	      l.setPreferredSize(new Dimension (200,20)); 
	      c.add(l);
	      
	      JTextField jt=new JTextField();
	      jt.setPreferredSize(new Dimension (200,20)); 
	      c.add(jt);
	      
	      JButton btnone=new JButton("ȷ��");
	      btnone.setBounds(0,0,10,10);
	      c.add(btnone);
	      
	      
	      JLabel path=new JLabel("������·����");
	      path.setPreferredSize(new Dimension (200,20)); 
	      c.add(path);
	      
	      JTextField pathtext=new JTextField();
	      pathtext.setPreferredSize(new Dimension (200,20)); 
	      c.add(pathtext);
	      
	      JButton btntwo=new JButton("���");
	      btntwo.setBounds(0,0,10,10);
	      c.add(btntwo);
	      
	      JLabel ansertext=new JLabel("������");
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
			    String reg = " +";//���ն���ո��������и�
			    String[] arr ;  
			    int wordnumber=0;
			 	BufferedReader file = null;
				try {
					file = new BufferedReader(new FileReader(pathtext.getText()));
				} catch (FileNotFoundException e2) {
					// TODO �Զ����ɵ� catch ��
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
						// TODO �Զ����ɵ� catch ��
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
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
					int charcount=0; 
				    String w;
					Pattern p =Pattern.compile(REGEX);//ƥ����ʵ��ַ�

				try {
					while((w=file.readLine()) != null) {
						Matcher m =p.matcher(w);
						while(m.find()){    //�ҵ���Ӧ�ַ�ʱ�ַ���+1
						   charcount ++;}
					}
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}		
				answer.setText(String.valueOf(charcount));
					System.out.println("number��"+charcount);
				try {
					file.close();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
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
