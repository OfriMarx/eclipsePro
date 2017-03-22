package spaceShooter;

import java.awt.Color;

public class PowerUp {

	private Space_Player p;
	private Color previousColor;
	
	public PowerUp(Space_Player p)
	{
		this.p = p;
		this.previousColor = p.getColor();
		activate();
	}
	
	public void activate()
	{
		p.setColor(Color.YELLOW);
		p.setInvincible(true);
	}
	
	public void deactivate()
	{
		p.setColor(previousColor);
		p.setInvincible(false);
	}
}
