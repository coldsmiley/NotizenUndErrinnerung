package com.coldsmiley.reminder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class View2 extends JFrame {
	
	private JPanel newNotePnl;
	private JButton createNoteBtn;
	private JTextArea newNoteTxtar;
	private View view;
	
	public View2(View view) {
		
		this.view = view;
		
		this.setUndecorated(true);
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(400-(100/2), 638-(100));
		//this.setBackground(new Color(0,0,0,200));
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		pnl.setBorder(new LineBorder(new Color(150, 150, 150), 1));
		//pnl.setBackground(new Color(255,255,255,100));
		
		
		this.createNoteBtn = new JButton("Erstelle Notiz");
		createNoteBtn.setBackground(Color.WHITE);
		createNoteBtn.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
		createNoteBtn.setFont(new Font("Arial", Font.PLAIN , 19));
		createNoteBtn.setPreferredSize(new Dimension(300, 50));
		createNoteBtn.setFocusable(false);
		createNoteBtn.setForeground(Color.GRAY);
		createNoteBtn.addActionListener(new CreateNoteBtnListener());
		
		this.newNoteTxtar = new JTextArea("\n   Notiz hier erstellen...");
		newNoteTxtar.setForeground(Color.DARK_GRAY);
		newNoteTxtar.setFont(new Font("Arial", Font.PLAIN , 17));
		newNoteTxtar.setBackground(new Color(245, 245, 245));
		newNoteTxtar.setEditable(true);
		
		
		this.add(pnl);
		pnl.add(createNoteBtn, BorderLayout.AFTER_LAST_LINE);
		pnl.add(newNoteTxtar, BorderLayout.CENTER);
		
		
	}
	
	public class CreateNoteBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String test = newNoteTxtar.getText();
			View2.this.view.setNotesTextar(test);
			
			View2.this.view.setVisible(true);
			View2.this.setVisible(false);
			
		}
		
	}
}
