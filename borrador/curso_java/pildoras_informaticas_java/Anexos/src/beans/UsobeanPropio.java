package beans;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UsobeanPropio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsobeanPropio frame = new UsobeanPropio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsobeanPropio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 800, 600);
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		VisorDeImagenesBean visorDeImagenesBean = new VisorDeImagenesBean();
		visorDeImagenesBean.setEscogeImagen("C:\\Users\\Jonathan\\Desktop\\kny3.png");
		visorDeImagenesBean.setBounds(67, 73, 600, 400);
		contentPane.add(visorDeImagenesBean);
	}
}
