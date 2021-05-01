package century.guis.quickplay;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import CenturyClient.Client;
import century.guis.GUIClientMenu;
import century.mods.impl.ModQuickPlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldSettings;

public class ArcadeQuickPlay extends GuiScreen  {
	private final GuiScreen field_146598_aaaaa;

	
	private GuiButton field_146596_f;
	private GuiButton field_146597_g;
	private String field_146599_h = "survival";
	private boolean field_146600_i;

	public ArcadeQuickPlay(GuiScreen p_i1055_1_dada_) {
		this.field_146598_aaaaa = p_i1055_1_dada_;
	}

	public void initGui() {

		GuiButton guibutton;
		
		this.buttonList.add(new GuiButton(100, this.width / 4+117, this.height / 2 - 70, 80, 20, I18n.format("Lobby", new Object[0])));
		
		this.buttonList.add(new GuiButton(101, this.width / 4+117, this.height / 2 - 40, 80, 20, I18n.format("Hole In The Wall", new Object[0])));
		
		this.buttonList.add(new GuiButton(102, this.width / 4+117, this.height / 2 - 10, 80, 20, I18n.format("Football", new Object[0])));
		
		this.buttonList.add(new GuiButton(103, this.width / 4+117, this.height / 2 + 20, 80, 20, I18n.format("Bounty Hunters", new Object[0])));
		
		this.buttonList.add(new GuiButton(104, this.width / 4+117, this.height / 2 + 50, 80, 20, I18n.format("Pixel Painters", new Object[0])));
		
		this.buttonList.add(new GuiButton(105, this.width / 4+117, this.height / 2 + 80, 80, 20, I18n.format("Dragon Walls", new Object[0])));
		
		this.buttonList.add(new GuiButton(106, this.width / 4+117, this.height / 2 + 110, 80, 20, I18n.format("Ender Spleef", new Object[0])));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------
		
		this.buttonList.add(new GuiButton(107, this.width / 4+20, this.height / 2 - 70, 80, 20, I18n.format("Galaxy Wars", new Object[0])));
		
		this.buttonList.add(new GuiButton(108, this.width / 4+20, this.height / 2 - 40, 80, 20, I18n.format("Throw Out", new Object[0])));
		
		this.buttonList.add(new GuiButton(109, this.width / 4+20, this.height / 2 - 10, 80, 20, I18n.format("Capture The Wool", new Object[0])));
		
		this.buttonList.add(new GuiButton(110, this.width / 4+20, this.height / 2 + 20, 80, 20, I18n.format("Party Games", new Object[0])));
		
		this.buttonList.add(new GuiButton(112, this.width / 4+20, this.height / 2 + 50, 80, 20, I18n.format("Farm Hunt", new Object[0])));
		
		this.buttonList.add(new GuiButton(113, this.width / 4+20, this.height / 2 + 80, 80, 20, I18n.format("Zombies Dead End", new Object[0])));
		
		this.buttonList.add(new GuiButton(114, this.width / 4+20, this.height / 2 + 110, 80, 20, I18n.format("Zombies Bad Blood", new Object[0])));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------
		
		this.buttonList.add(new GuiButton(115, this.width / 4+230, this.height / 2 - 70, 80, 20, I18n.format("Zombies Alien Arcadium", new Object[0])));
		
		this.buttonList.add(new GuiButton(116, this.width / 4+230, this.height / 2 - 40, 80, 20, I18n.format("Hide & Seek Prop Hunt", new Object[0])));
		
		this.buttonList.add(new GuiButton(117, this.width / 4+230, this.height / 2 - 10, 80, 20, I18n.format("Hide & Seek Party Pooper", new Object[0])));
		
		this.buttonList.add(new GuiButton(118, this.width / 4+230, this.height / 2 + 20, 80, 20, I18n.format("Hypixel Says", new Object[0])));
		
		this.buttonList.add(new GuiButton(119, this.width / 4+230, this.height / 2 + 50, 80, 20, I18n.format("Mini Walls", new Object[0])));
		
		this.buttonList.add(new GuiButton(121, this.width / 4+230, this.height / 2 + 80, 80, 20, I18n.format("Blocking Dead", new Object[0])));
		
		//this.buttonList.add(new GuiButton(121, this.width / 4+213, this.height / 2 + 110, 80, 20, I18n.format("Zombies Bad Blood", new Object[0])));
		
		
		
		
		
		this.buttonList.add(new GuiButton(1008, this.width / 2 - -222, this.height / 2 + 140, 80, 20, I18n.format("Back", new Object[0])));
		
		
		
		//this.buttonList.add(new GuiButton(1024, this.width / 2 - 40, this.height / 2 + 50, 80, 20, I18n.format(Slime, new Object[0])));
		
	}
	
	


	private void func_146595_g() {
		this.field_146597_g.displayString = I18n.format("selectWorld.gameMode", new Object[0]) + " "
				+ I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
		this.field_146596_f.displayString = I18n.format("selectWorld.allowCommands", new Object[0]) + " ";

		if (this.field_146600_i) {
			this.field_146596_f.displayString = this.field_146596_f.displayString
					+ I18n.format("options.on", new Object[0]);
		} else {
			this.field_146596_f.displayString = this.field_146596_f.displayString
					+ I18n.format("options.off", new Object[0]);
		}
	}

	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
			break;

		case 1:
			boolean flag = this.mc.isIntegratedServerRunning();
			boolean flag1 = this.mc.func_181540_al();
			button.enabled = false;
			this.mc.theWorld.sendQuittingDisconnectingPacket();
			this.mc.loadWorld((WorldClient) null);

			if (flag) {
				this.mc.displayGuiScreen(new GuiMainMenu());
			} else if (flag1) {
				RealmsBridge realmsbridge = new RealmsBridge();
				realmsbridge.switchToRealms(new GuiMainMenu());
			} else {
				this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
			}

		case 2:
		case 3:
		default:
			break;

		case 4:
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
			break;

		case 5:
			this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
			break;

		case 6:
			this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
			break;
		case 7:
			this.mc.displayGuiScreen(new GuiShareToLan(this));
			break;
		
		case 1008:
			this.mc.displayGuiScreen(new ModQuickPlay(this));
			break;
		case 3000:
			this.mc.displayGuiScreen(new ArcadeQuickPlay(this));
			break;
		case 100:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/l a");
			break;
		case 101:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_hole_in_the_wall");
			break;
		case 102:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_soccer");
			break;
		case 103:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_bounty_hunters");
			break;
		case 104:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_pixel_painters");
			break;
		case 105:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_dragon_wars");
			break;
		case 106:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_ender_spleef");
			break;
		case 107:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_starwars");
			break;
		case 108:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_throw_out");
			break;
		case 109:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_pvp_ctw");
			break;
		case 110:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_party_games_1");
			break;
		case 112:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_farm_hunt");
			break;
		case 113:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_zombies_dead_end");
			break;
		case 114:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_zombies_bad_blood");
			break;
		case 115:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_zombies_alien_arcadium");
			break;
		case 116:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_hide_and_seek_prop_hunt");
			break;
		case 117:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_hide_and_seek_party_pooper");
			break;
		case 118:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_simon_says");
			break;
		case 119:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_mini_walls");
			break;
		case 121:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_day_one");
			break;
		case 122:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play arcade_pvp_ctw");
			break;
			
		
		
		}
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Arcade.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 130, this.height / 8 - 5, -1, 0, 53, 53, 53, 53);
		

		
		GlStateManager.pushMatrix();
        float scale2 = 0.5F;
       
        GlStateManager.popMatrix();
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		

	}
	  
   }