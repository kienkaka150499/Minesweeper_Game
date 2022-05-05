package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends JFrame implements MouseListener,ActionListener {

	int MAX=100;
	int columnNum[]= {9,16,30};
	int rowNum[]= {9,16,16};
	int rowSize[]= {392,636,1190};
	int columnSize[]= {460,700,700};
	int mineNum[]= {10,40,99};
	Container cont;
	int column=0;
	int row=0;
	int weight=0;
	int height=0;
	int lv=0;
	int mines=0;
	int countMine=0;
	int a[][]= new int[MAX][MAX];
	boolean opened[][]=new boolean[MAX][MAX];
	int mineAround[][]=new int[MAX][MAX];
	boolean flag[][]=new boolean[MAX][MAX];
	
	public Game (int lv) {
		super("Minesweeper");
		this.lv=lv;
		this.row=rowNum[lv-1];
		this.column=columnNum[lv-1];
		this.weight=rowSize[lv-1];
		this.height=columnSize[lv-1];
		this.mines=mineNum[lv-1];
		cont = init();
	}
	
	public Container init() {
		Container cont = this.getContentPane();
		initMine();
	}
	
	public void initMine() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				a[i][j]=0;
				mineAround[i][j]=0;
				opened[i][j]=false;
				flag[i][j]=false;
			}
		}
		int rowIndex, columnIndex;
		while(countMine<mines) {
			do {
				rowIndex=(int) Math.random()*row;
				columnIndex=(int) (Math.random()*column);
			}while(a[rowIndex][columnIndex]==1);
			a[rowIndex][columnIndex]=1;
			countMine++;
			doubleMine(rowIndex,columnIndex);
		}
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++) {
				if(a[i][j]==1) {
					for(int h=i-1;h<=i+1;h++) {
						for(int k=j-1;k<=j+1;k++) {
							if(check(h,k)&&a[h][k]==0)
								mineAround[h][k]++;
						}
					}
					mineAround[i][j]=9;
				}
			}
		
	}
	
	public void doubleMine(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		for(int i=rowIndex-1;i<=rowIndex+1;i++)
			for(int j=columnIndex-1;j<=columnIndex+1;j++) {
				if(check(i,j)&&a[i][j]==0&&countMine<mines&&Math.random()<0.05) {
					a[i][j]=1;
					countMine++;
					doubleMine(i, j);
				}
			}
	}

	public boolean check(int i, int j) {
		// TODO Auto-generated method stub
		if(i<0||i>=row||j<0||j>=column)
			return false;
		return true;
	}

	public static void main(String[] args) {
		new Game(1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
