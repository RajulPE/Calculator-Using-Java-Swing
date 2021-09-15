package calculator;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;




public class Calculator extends JFrame implements ActionListener {

	JTextField tf;
	JButton[] buttons=new JButton[10];
	JButton[] operators=new JButton[8];
	JButton AddButton;
	JButton MinButton;
	JButton MulButton;
	JButton DivButton;
	JButton EqlButton;
	JButton DecButton;
	JPanel panel;
	JLabel label;
	Font Myfont=new Font("SansSerif",Font.BOLD,20);

	Double num1,num2,res;
	char operator;
	
	Calculator(){
		
		tf=new JTextField();
		tf.setBounds(20,20,300,50);
//		tf.setEditable(false);
		tf.setFont(Myfont);
		
		for(int i=0;i<10;i++)
		{
			buttons[i]=new JButton(String.valueOf(i));
			buttons[i].setLayout(null);
			buttons[i].setSize(10,10);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		
		}
		AddButton=new JButton("+");
		MinButton=new JButton("-");
		MulButton=new JButton("X");
		DivButton=new JButton("/");
		EqlButton=new JButton("=");
		DecButton=new JButton(".");
		
		operators[0]=AddButton;
		operators[1]=MinButton;
		operators[2]=MulButton;
		operators[3]=DivButton;
		operators[4]=EqlButton;
		operators[5]=DecButton;
		
		
		for(int i=0;i<6;i++)
		{
			operators[i].addActionListener(this);
			operators[i].setFocusable(false);
			operators[i].setFont(Myfont);
		}
		label=new JLabel("Calculator");
		label.setBounds(20,10,300,10);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setBackground(new Color(75, 242, 148));
		label.setOpaque(true);
		
		panel=new JPanel();
		panel.setBounds(20,70,300,370);
		panel.setBackground(new Color(4,4,5,5));
		panel.setLayout(new GridLayout(4,4,5,5));
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,500);
		this.setTitle("Calculator");
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(64, 164, 227));
		this.add(tf);
		this.add(label);
		
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(AddButton);
		panel.add(buttons[3]);
		panel.add(buttons[4]);
		panel.add(buttons[5]);
		panel.add(MinButton);
		panel.add(buttons[6]);
		panel.add(buttons[7]);
		panel.add(buttons[8]);
		panel.add(MulButton);
		panel.add(buttons[9]);
		panel.add(DivButton);
		panel.add(DecButton);
		panel.add(EqlButton);
		
		
		this.add(panel);
		
		
		
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			for(int i=0;i<10;i++)
			{
				if(e.getSource()==buttons[i])
				{
					tf.setText(tf.getText().concat(String.valueOf(i)));
				}
			}
			if(e.getSource()==DecButton)
			{
				tf.setText(tf.getText().concat("."));
			}
			if(e.getSource()==AddButton)
			{
				num1=Double.parseDouble(tf.getText());
				operator='+';
				tf.setText("");
			}
			if(e.getSource()==MinButton)
			{
				num1=Double.parseDouble(tf.getText());
				operator='-';
				tf.setText("");
			}
			if(e.getSource()==MulButton)
			{
				num1=Double.parseDouble(tf.getText());
				operator='*';
				tf.setText("");
			}
			if(e.getSource()==DivButton)
			{
				num1=Double.parseDouble(tf.getText());
				operator='/';
				tf.setText("");
			}
			if(e.getSource()==EqlButton)
			{
					num2=Double.parseDouble(tf.getText());
					
					
					switch(operator)
					{
						case '+':
							res=num1+num2;
							break;
						case '-':
							res=num1-num2;
							break;
						case '*':
							res=num1*num2;
							break;
						case '/':
							res=num1/num2;
							break;
							
					}
					tf.setText(String.valueOf(res));
					num1=res;
	
			}
		}
		
	
	public static void main(String[] args) {
		
		Calculator calc=new Calculator();
	}
}
