package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmIgraci extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList listIgraci = new JList();
	private JTextField txtIgrac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgraci frame = new FrmIgraci();
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
	public FrmIgraci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 447);
		setTitle("Evidencija igraca");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		
		JLabel lblDusanTadic = new JLabel("Dusan Tadic");
		
		JLabel lblNemanjaGudelj = new JLabel("Nemanja Gudelj");
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnKolarov.isSelected()) {
					dlm.addElement(lblAleksandarKolarov.getText());
				}
			}
		});
		
		JToggleButton tglbtnTadic = new JToggleButton("Tadic");
		tglbtnTadic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnTadic.isSelected()) {
					dlm.addElement(lblDusanTadic.getText());
				}
			}
		});
		
		JToggleButton tglbtnGudelj = new JToggleButton("Gudelj");
		tglbtnGudelj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnGudelj.isSelected()) {
					dlm.addElement(lblNemanjaGudelj.getText());
				}
			}
		});
		
		btnGroup.add(tglbtnKolarov);
		btnGroup.add(tglbtnTadic);
		btnGroup.add(tglbtnGudelj);
		
		JScrollPane scrollPaneIgraci = new JScrollPane();
		
		JLabel lblUnesiIgraca = new JLabel("Unesi igraca:");
		
		txtIgrac = new JTextField();
		txtIgrac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtIgrac.getText());
				}
			}
		});
		txtIgrac.setColumns(10);
		
		JLabel lblOdaberiIgraca = new JLabel("Odaberi igraca");
		
		JComboBox cbxIgraci = new JComboBox();
		cbxIgraci.addItem("Nemanja Matic");
		cbxIgraci.addItem("Dusan Vlahovic");
		cbxIgraci.addItem("Aleksandar Mitrovic");
		
		JButton btnDodajOdabranogIgraca = new JButton("Dodaj odabranog igraca");
		btnDodajOdabranogIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxIgraci.getSelectedItem());
			}
		});
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listIgraci.isSelectionEmpty()) {
					dlm.removeElement(listIgraci.getSelectedValue());
				} else {
					JOptionPane.showMessageDialog(null, "Nije selektovan nijedan igrac iz liste!");
				}
			}
		});
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(tglbtnGudelj, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tglbtnTadic, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tglbtnKolarov, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblUnesiIgraca))
							.addGap(20)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_pnlCenter.createSequentialGroup()
											.addGap(18)
											.addComponent(cbxIgraci, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(txtIgrac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(btnDodajOdabranogIgraca)
									.addContainerGap(265, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnIzbrisi)
										.addGroup(gl_pnlCenter.createSequentialGroup()
											.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAleksandarKolarov)
												.addComponent(lblDusanTadic)
												.addComponent(lblNemanjaGudelj))
											.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
											.addComponent(scrollPaneIgraci, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)))
									.addGap(68))))
						.addComponent(lblOdaberiIgraca)))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnKolarov)
								.addComponent(lblAleksandarKolarov))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnTadic)
								.addComponent(lblDusanTadic))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnGudelj)
								.addComponent(lblNemanjaGudelj)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPaneIgraci, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIzbrisi)
					.addGap(37)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnesiIgraca)
						.addComponent(txtIgrac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOdaberiIgraca)
						.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDodajOdabranogIgraca))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		
		scrollPaneIgraci.setViewportView(listIgraci);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispisi");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test Button");
			}
		});
		pnlSouth.add(btnIspisi);
		
		listIgraci.setModel(dlm); // bindovanje modela (dlm) na listu (listIgraci)
		
	}

}
