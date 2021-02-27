package clientname.mods.impl;

import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class FovMod extends ModDraggable {
	
	private static float savedFOV = 0;
	
	

	 public int getWidth()
	    {
		 return font.getStringWidth("[Fullbright On]");
	    }

	    @Override
	    public int getHeight()
	    {
	    	return font.FONT_HEIGHT;
	    }
	    


		@Override
		public void render(ScreenPosition pos) {
			// font.drawString("[fov mod On]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
			if(mc.thePlayer.isSprinting()) {
				Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
				}
			else if(mc.thePlayer.isPotionActive(1)) {
				Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
			}
			else if(mc.thePlayer.capabilities.isFlying) {
				Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
		}
		}
	}
				
			
	
