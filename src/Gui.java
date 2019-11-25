import javax.swing.*;
import java.awt.*;

public class Gui {

	private JFrame frmEuclidsAlgorithm;
	public static JTextField txtX;
	public static JTextField txtY;
	public static JCheckBox verbose_ck;
	public static JTextField a_input;
	public static JTextField b_input;
	public static JButton calc_btn;
	public static JButton rand_btn;
	public static JLabel gcd_lbl;
	public static JLabel valid_lbl;
	public JTextArea Console;

	public Gui() {
		if(mathproj.rungui == 'y') {
			initialize();
		}
		
		initialize(); //master override
		 
	}
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 700, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setMinimumSize(new Dimension(700,450));
		frmEuclidsAlgorithm.getContentPane().setLayout(new GridLayout(1, 1, 10, 10));
		
/*		JList list = new JList();
		panel_6.add(list);*/
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		frmEuclidsAlgorithm.getContentPane().add(splitPane);
		
		JPanel Left_Panel = new JPanel();
		splitPane.setLeftComponent(Left_Panel);
		Left_Panel.setLayout(new BorderLayout(5, 5));
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		Left_Panel.add(horizontalStrut_4, BorderLayout.WEST);
		
		JPanel Master_Inputs_Panel = new JPanel();
		Left_Panel.add(Master_Inputs_Panel, BorderLayout.CENTER);
		Master_Inputs_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		Master_Inputs_Panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("ax+by=1");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JTextPane txtpnIfAAnd = new JTextPane();
		txtpnIfAAnd.setBackground(UIManager.getColor("Button.background"));
		txtpnIfAAnd.setText("If a and b are positve, either x or y has to be negative, this program will prove by "
				+ "recursion if this statement is true or not according to the specified a and b values set below."
				+ "\nThis only solves for values such than x and y are less than the largest value between a and b.");
		txtpnIfAAnd.setEditable(false);
		panel_3.add(txtpnIfAAnd, BorderLayout.CENTER);
		
		JPanel inputs_panel = new JPanel();
		Master_Inputs_Panel.add(inputs_panel, BorderLayout.CENTER);
		inputs_panel.setLayout(new BorderLayout(5, 5));
		
		JPanel gcd_panel = new JPanel();
		inputs_panel.add(gcd_panel, BorderLayout.CENTER);
		gcd_panel.setLayout(new BorderLayout(0, 0));
		
		
		ImageIcon logo = new ImageIcon(Gui.class.getResource("/img/funny-quotes-math.jpg")); // load the image to a imageIcon
		Image image = logo.getImage(); // transform it 
		Image newimg = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // scale it the smooth way  
		logo = new ImageIcon(newimg);  // transform it back
		
		JLabel label = new JLabel("");
		label.setIcon(logo);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		gcd_panel.add(label, BorderLayout.CENTER);
		
		JTabbedPane inputs_tab = new JTabbedPane(JTabbedPane.TOP);
		inputs_panel.add(inputs_tab, BorderLayout.NORTH);
		
		JPanel inputs_subpanel = new JPanel();
		inputs_tab.addTab("Inputs", null, inputs_subpanel, null);
		inputs_subpanel.setLayout(new GridLayout(3, 3, 5, 1));
		
		JLabel a_lbl = new JLabel("a=");
		a_lbl.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		a_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		inputs_subpanel.add(a_lbl);
		
		a_input = new JTextField();
		inputs_subpanel.add(a_input);
		
		Component a_strut = Box.createHorizontalGlue();
		inputs_subpanel.add(a_strut);
		
		JLabel b_lbl = new JLabel("b=");
		b_lbl.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		b_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		inputs_subpanel.add(b_lbl);
		
		b_input = new JTextField();
		inputs_subpanel.add(b_input);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		inputs_subpanel.add(horizontalGlue_1);
		
		rand_btn = new JButton("Randomize");
		inputs_subpanel.add(rand_btn);
		
		calc_btn = new JButton("Calculate");
		inputs_subpanel.add(calc_btn);
		
		verbose_ck = new JCheckBox("Verbose Log");
		inputs_subpanel.add(verbose_ck);
		
		valid_lbl = new JLabel("Not Calculated Yet");
		valid_lbl.setEnabled(false);
		valid_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		inputs_panel.add(valid_lbl, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		Master_Inputs_Panel.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("© Jesse Sullivan 2016.");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_6, BorderLayout.SOUTH);
		
		gcd_lbl = new JLabel("gcd(a,b)=_____");
		gcd_lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_5.add(gcd_lbl, BorderLayout.NORTH);
		gcd_lbl.setVerticalAlignment(SwingConstants.TOP);
		gcd_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		Left_Panel.add(verticalStrut_1, BorderLayout.NORTH);
		
		JPanel Right_Panel = new JPanel();
		splitPane.setRightComponent(Right_Panel);
		Right_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel Master_Console_Panel = new JPanel();
		Right_Panel.add(Master_Console_Panel, BorderLayout.CENTER);
		Master_Console_Panel.setLayout(new BorderLayout(0, 0));
		
		JLabel Consolelog_lbl = new JLabel("Console Log");
		Consolelog_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Master_Console_Panel.add(Consolelog_lbl, BorderLayout.NORTH);
		
		JPanel Sol_Panel = new JPanel();
		Master_Console_Panel.add(Sol_Panel, BorderLayout.SOUTH);
		Sol_Panel.setLayout(new BorderLayout(0, 0));
		
		JLabel Sol_lbl = new JLabel("Solution(s)");
		Sol_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Sol_Panel.add(Sol_lbl, BorderLayout.NORTH);
		
		txtX = new JTextField();
		txtX.setEditable(false);
		txtX.setText("x=");
		Sol_Panel.add(txtX, BorderLayout.WEST);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setEditable(false);
		txtY.setText("y=");
		Sol_Panel.add(txtY, BorderLayout.EAST);
		txtY.setColumns(10);
		
		JPanel Console_Cont = new JPanel();
		Master_Console_Panel.add(Console_Cont, BorderLayout.CENTER);
		Console_Cont.setLayout(new BorderLayout(0, 0));
		
		JPanel Console_log_cont = new JPanel();
		Console_Cont.add(Console_log_cont, BorderLayout.CENTER);
		Console_log_cont.setLayout(new BorderLayout(0, 0));
		
		Console = new JTextArea();
		Console.setWrapStyleWord(true);
		Console.setLineWrap(true);
		Console.setEditable(false);
		Console.setRows(2);
		Console_log_cont.add(Console, BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane (Console, 
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Console_log_cont.add(scroll);
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		Right_Panel.add(verticalStrut_2, BorderLayout.SOUTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(10);
		Right_Panel.add(horizontalStrut_5, BorderLayout.EAST);
	}


	public JTextField getA_input() {
		return a_input;
	}
	public JTextField getB_input() {
		return b_input;
	}
	public void setA_input(int a) {
		a_input.setText(Integer.toString(a));
	}
	public void setB_input(int b) {
		b_input.setText(Integer.toString(b));
	}

	public JFrame getFrame() {
		return frmEuclidsAlgorithm;
	}
	public void setConsole(JTextArea Console) {
		this.Console = Console;
	}
	public JCheckBox getVerbose_ck() {
		return verbose_ck;
	}

	public void setFrame(JFrame frame) {
		this.frmEuclidsAlgorithm = frame;
		frmEuclidsAlgorithm.setFont(new Font("Dialog", Font.BOLD, 12));
		frmEuclidsAlgorithm.setTitle("Euclid's Algorithm");
	}


	public void consolelog(String a) {
		Console.append(a + "\n");
	}

	public void gcdrelbl(int a, int b, int gcd) {
		gcd_lbl.setText("gcd(" + Integer.toString(a) + "," + Integer.toString(b) + ")= " + Integer.toString(gcd));
		
	}
	
	public void validate(boolean valid) {
		valid_lbl.setEnabled(valid);
	}
	public void validrelbl(String a) {
		valid_lbl.setText(a);
	}
	

}
