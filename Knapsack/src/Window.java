
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	JLabel L1, L2, L4, L5;
    JTextField numItemsLabel = new JTextField();
    JTextField maxWeightLabel = new JTextField();
    JTextField valuesLabel = new JTextField();
    JTextField weightsLabel = new JTextField();
    JTextField txt = new JTextField("Result: ");
    JTextField elapsedTime = new JTextField("Elapsed Time: ");
    ButtonGroup bg;
    JCheckBox chkbox1, chkbox2;
    JButton start = new JButton("Run");
    Font roboto = new Font("Roboto", Font.BOLD, 14);

    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel paneltwo = new JPanel();
        paneltwo.setLayout(new GridLayout(6, 2));
        JPanel panelthree = new JPanel();
        panelthree.setLayout(new GridLayout(3, 1));

        L1 = new JLabel("Number of Items");
        L1.setFont(roboto);
        L2 = new JLabel("Max Weight Value");
        L2.setFont(roboto);
        L4 = new JLabel("List of Values (ex. 13 4 5 6)");
        L4.setFont(roboto);
        L5 = new JLabel("List of Weights (ex. 2 1 11 6)");
        L5.setFont(roboto);
        
        chkbox1 = new JCheckBox("Bruteforce");
        chkbox1.setFont(roboto);
        chkbox2 = new JCheckBox("Dynamic Programming");
        chkbox2.setFont(roboto);

        ButtonGroup bg = new ButtonGroup();
        bg.add(chkbox1);
        bg.add(chkbox2);
        System.out.println();

        panel.add(paneltwo, BorderLayout.WEST);
        paneltwo.setBackground(Color.LIGHT_GRAY);
        panelthree.setBackground(Color.LIGHT_GRAY);
        panel.setBackground(Color.GRAY);

        paneltwo.add(numItemsLabel);
        paneltwo.add(L1);
        paneltwo.add(maxWeightLabel);
        paneltwo.add(L2);
        paneltwo.add(valuesLabel);
        paneltwo.add(L4);
        paneltwo.add(weightsLabel);
        paneltwo.add(L5);
        panelthree.add(chkbox1);
        panelthree.add(chkbox2);
        panelthree.add(start);
        panelthree.add(txt);
        panelthree.add(elapsedTime);
        paneltwo.add(panelthree);

        this.setResizable(true);
        this.setVisible(true);
        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        new KnapsackProblem();
    }

    public void paint(Graphics d) {
        d.setColor(Color.red);        //default color for drawing
        super.paint(d);
        
        start.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
	                if (chkbox1.isSelected()) {  
	                    KnapsackProblem kp = new KnapsackProblem();
        	            txt.setText("Result: " + kp.bruteForceSol());
        	            elapsedTime.setText("Elapsed Time: " + kp.getRunTime()/1000000 + " ms");
	                }
	                if (chkbox2.isSelected()) {  
	                    KnapsackProblem kp = new KnapsackProblem();
        	            txt.setText("Result: " + kp.dynamicProgrammingSol());
        	            elapsedTime.setText("Elapsed Time: " + kp.getRunTime()/1000000 + " ms");
	                }
        		}  
         });  

        Graphics2D d2 = (Graphics2D) d;
        

        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}