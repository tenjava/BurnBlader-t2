package com.tenjava.entries.BurnBlader.t2.effects;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.tenjava.entries.BurnBlader.t2.TenJava;

public class WaterEffect extends Effect {

	public WaterEffect(int cost) {
		super(cost);
	}
	
	private int id = 0;
	
	private int i = 4 * 4;

	@Override
	protected void effect(final Player p) {
		id = Bukkit.getScheduler().scheduleSyncRepeatingTask(TenJava.get(), new Runnable() {

			@Override
			public void run() {
				i--;
				if(i == 0 || p.getLocation().getBlock().getType() == Material.WATER) {
					Bukkit.getScheduler().cancelTask(id);
				}
				
				p.setVelocity(p.getLocation().getDirection().multiply(2.0).setY(0.0));
			}
			
		}, 0L, 5L);
	}

}
