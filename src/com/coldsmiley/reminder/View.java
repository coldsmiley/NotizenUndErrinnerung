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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class View extends JFrame {
	
	private View2 view2;
	
	private JPanel pnl;
	private JButton newNoteBtn;
	private JTextArea notesTxtar;
	private JScrollPane notesScrllPn;
	
	public View() {
		
		this.setUndecorated(true);
		this.setSize(300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(400, 638);
		
		//this.setBackground(new Color(0,0,0,200));
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		pnl.setBorder(new LineBorder(new Color(150, 150, 150), 1));
		//pnl.setBackground(new Color(255,255,255,100));
		
		
		this.newNoteBtn = new JButton("Neue Notiz");
		newNoteBtn.setBackground(Color.WHITE);
		newNoteBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200)));
		newNoteBtn.setFont(new Font("Arial", Font.PLAIN , 19));
		newNoteBtn.setPreferredSize(new Dimension(300, 50));
		newNoteBtn.setFocusable(false);
		newNoteBtn.setForeground(Color.GRAY);
		newNoteBtn.addActionListener(new NewNoteBtnListener());
		
		this.notesTxtar = new JTextArea("\n   - Keine Notizen verfügbar");
		notesTxtar.setForeground(Color.DARK_GRAY);
		notesTxtar.setFont(new Font("Arial", Font.PLAIN , 17));
		notesTxtar.setBackground(new Color(245, 245, 245));
		notesTxtar.setEditable(false);
		
		this.notesScrllPn = new JScrollPane(notesTxtar);
		notesScrllPn.setBorder(null);
		notesScrllPn.getViewport().setBackground(Color.WHITE);
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.GREEN));
		
		
		this.add(pnl);
		pnl.add(newNoteBtn, BorderLayout.BEFORE_FIRST_LINE);
		pnl.add(notesScrllPn, BorderLayout.CENTER);
		
		this.setVisible(true);
		long now = System.currentTimeMillis();
		int i = 2;
		while (this.getSize().getWidth()<400) {
			now = System.currentTimeMillis();
			if ((now%5)==0) {
				this.setSize(300+i, 400+i);
				this.setLocation(400-(i/2), 638-(i));
				i=i+2;
			}
		}
		
		View.this.view2 = new View2(this);
		
	}
	
	public void setNotesTextar(String notiz) {
		this.notesTxtar.append(notiz);
	}
	
	public class NewNoteBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
			View.this.view2.setVisible(true);
			View.this.setVisible(false);
			
		}
		
	}
}
