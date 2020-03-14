package wc;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrameDemo1.java
import javax.swing.*;  

public class shape {
	private static void shapetwo(){
	    //定义一个窗体对象f，窗体名称为"一个简单窗口"        
	    JFrame  f = new JFrame("一个简单窗口");
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setBounds(300,200,500,200);
	    Container c=f.getContentPane();
	    c.setLayout(new FlowLayout());
	    
	    JLabel l=new JLabel("这是一个船体");
	    c.add(l);
	    
	    JButton btn=new JButton("A");
	    c.add(btn);
	    btn.addActionListener(new ActionListener(){
	  	  public void actionPerformed(ActionEvent e){
	  		  l.setText("zheshi");
	  	  }
	    });
	}

}
