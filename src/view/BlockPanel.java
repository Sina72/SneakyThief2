package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.commands.GridState;

public class BlockPanel extends JPanel
{
	public BlockPanel(){
		this.setLayout(new GridLayout(8,2));
		initBlocks();
		
	}
	
	public void initBlocks(){
		for(GridState state : GridState.values()){
			
			Block block = new Block(state);
			
			block.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
			
			add(block);
		}
	}
	
	private class Block extends JButton{
		GridState state;
		public Block(GridState state){
			this.state = state;
			setText(state.toString());
			setForeground(state.color().equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
			setBackground(state.color());
			setBorderPainted(false);
			setContentAreaFilled(false);
			setOpaque(true);
		}
	}
}
