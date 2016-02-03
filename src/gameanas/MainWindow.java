package gameanas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import com.threecoffee.control.GameWindow;

public class MainWindow extends GameWindow {
	
	public static StickMan player;
	public static int noofvillains=2;
	public static Villain villains[] = new Villain[3];
	Random r = new Random();
	Health healthbar;
	static boolean gamepaused = false;
	
	public static int score = 0;
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
		super(1000, 700);
		
		this.addMouseListener(new ML());
		this.addMouseMotionListener(new MML());
		
		initialize();		
		addToWindow();
		
		this.setVisible(true);
	}
	
	
	public static StickMan getPlayer()
	{
		return player;
	}
	
	public static void addAnotherVillain(Villain v1)
	{
		for(int i=0;i<noofvillains;i++)
		{
			if(villains[i].stop)
			{
				villains[i] = v1;
				return;
			}
		}
	}

	private void addToWindow() {
		// TODO Auto-generated method stub
		player.addTo(this);
		
		for(int i=0;i<noofvillains;i++)
		{
			villains[i].addTo(this);
		}
		
		healthbar.addTo(this);
		
		
		player.play();
		
		for(int i=0;i<noofvillains;i++)
		{
			villains[i].play();
		}
		
		healthbar.play();		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		player = new StickMan(2,2);

		for(int i=0;i<3;i++)
		{
			villains[i] = new Villain(r.nextInt(950), r.nextInt(610));
		}
		
		villains[2].stop=true;
		
		healthbar = new Health();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new MainWindow();
	}

	class ML extends MouseAdapter
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Ball b = new Ball(MainWindow.getPlayer().getX()+10, 
					MainWindow.getPlayer().getY() + 10, e.getX(),
					e.getY(), 1);

			b.addTo(MainWindow.getPlayer().getGameWindow());
			
			for(int i=0;i<2;i++)
			{
				b.addCollider(MainWindow.villains[i]);
			}
			b.play();			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
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
		
	}
	
	class MML extends MouseMotionAdapter
	{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
