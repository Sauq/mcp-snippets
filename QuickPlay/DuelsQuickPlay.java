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

public class DuelsQuickPlay extends GuiScreen  {
	private final GuiScreen field_146598_aaaaa;


	private GuiButton field_146596_f;
	private GuiButton field_146597_g;
	private String field_146599_h = "survival";
	private boolean field_146600_i;

	public DuelsQuickPlay(GuiScreen p_i1055_1_dada_) {
		this.field_146598_aaaaa = p_i1055_1_dada_;
	}

	public void initGui() {

		GuiButton guibutton;

		this.buttonList.add(new GuiButton(100, this.width / 4+117, this.height / 2 - 70, 80, 20, I18n.format("Lobby", new Object[0])));

		this.buttonList.add(new GuiButton(101, this.width / 4+117, this.height / 2 - 40, 80, 20, I18n.format("Classic", new Object[0])));

		this.buttonList.add(new GuiButton(102, this.width / 4+117, this.height / 2 - 10, 80, 20, I18n.format("Solo SkyWars", new Object[0])));

		this.buttonList.add(new GuiButton(103, this.width / 4+117, this.height / 2 + 20, 80, 20, I18n.format("Doubles SkyWars", new Object[0])));

		this.buttonList.add(new GuiButton(104, this.width / 4+117, this.height / 2 + 50, 80, 20, I18n.format("Solo Bow", new Object[0])));

		this.buttonList.add(new GuiButton(105, this.width / 4+117, this.height / 2 + 80, 80, 20, I18n.format("Solo UHC", new Object[0])));

		this.buttonList.add(new GuiButton(106, this.width / 4+117, this.height / 2 + 110, 80, 20, I18n.format("Double UHC", new Object[0])));

		//-------------------------------------------------------------------------------------------------------------------------------------------

		this.buttonList.add(new GuiButton(107, this.width / 4+20, this.height / 2 - 70, 80, 20, I18n.format("Teams UHC", new Object[0])));

		this.buttonList.add(new GuiButton(108, this.width / 4+20, this.height / 2 - 40, 80, 20, I18n.format("Deathmatch UHC", new Object[0])));

		this.buttonList.add(new GuiButton(109, this.width / 4+20, this.height / 2 - 10, 80, 20, I18n.format("Solo NoDebuff", new Object[0])));

		this.buttonList.add(new GuiButton(110, this.width / 4+20, this.height / 2 + 20, 80, 20, I18n.format("Solo Combo", new Object[0])));

		this.buttonList.add(new GuiButton(112, this.width / 4+20, this.height / 2 + 50, 80, 20, I18n.format("Solo Potion", new Object[0])));

		this.buttonList.add(new GuiButton(113, this.width / 4+20, this.height / 2 + 80, 80, 20, I18n.format("Solo OP", new Object[0])));

		this.buttonList.add(new GuiButton(114, this.width / 4+20, this.height / 2 + 110, 80, 20, I18n.format("Doubles OP", new Object[0])));

		//-------------------------------------------------------------------------------------------------------------------------------------------

		this.buttonList.add(new GuiButton(115, this.width / 4+230, this.height / 2 - 70, 80, 20, I18n.format("Solo Mega Walls", new Object[0])));

		this.buttonList.add(new GuiButton(116, this.width / 4+230, this.height / 2 - 40, 80, 20, I18n.format("Doubles Mega Walls", new Object[0])));

		this.buttonList.add(new GuiButton(117, this.width / 4+230, this.height / 2 - 10, 80, 20, I18n.format("Sumo", new Object[0])));

		this.buttonList.add(new GuiButton(118, this.width / 4+230, this.height / 2 + 20, 80, 20, I18n.format("Solo Blitz", new Object[0])));

		this.buttonList.add(new GuiButton(119, this.width / 4+230, this.height / 2 + 50, 80, 20, I18n.format("Solo Bow Spleef", new Object[0])));

		this.buttonList.add(new GuiButton(121, this.width / 4+230, this.height / 2 + 80, 80, 20, I18n.format("Bridge 1v1", new Object[0])));

	    this.buttonList.add(new GuiButton(122, this.width / 4+230, this.height / 2 + 110, 80, 20, I18n.format("Bridge 2v2", new Object[0])));

	    //------------------------------------------------------------------------

	    this.buttonList.add(new GuiButton(123, this.width / 4-80, this.height / 2 - 70, 80, 20, I18n.format("Bridge 4v4", new Object[0])));

	    this.buttonList.add(new GuiButton(124, this.width / 4-80, this.height / 2 - 40, 80, 20, I18n.format("Bridge 2v2v2v2", new Object[0])));

	    this.buttonList.add(new GuiButton(125, this.width / 4-80, this.height / 2 - 10, 80, 20, I18n.format("Bridge 3v3v3v3", new Object[0])));



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
			this.mc.displayGuiScreen(new DuelsQuickPlay(this));
			break;
		case 100:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/l 1v1");
			break;
		case 101:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_classic_duel");
			break;
		case 102:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_sw_duel");
			break;
		case 103:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_sw_doubles");
			break;
		case 104:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bow_duel");
			break;
		case 105:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_uhc_duel");
			break;
		case 106:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_uhc_doubles");
			break;
		case 107:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_uhc_four");
			break;
		case 108:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_uhc_meetup");
			break;
		case 109:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_potion_duel");
			break;
		case 110:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_combo_duel");
			break;
		case 112:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_potion_duel");
			break;
		case 113:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_op_duel");
			break;
		case 114:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_op_doubles");
			break;
		case 115:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_mw_duel");
			break;
		case 116:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_mw_doubles");
			break;
		case 117:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_sumo_duel");
			break;
		case 118:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_blitz_duel");
			break;
		case 119:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("play duels_bowspleef_duel");
			break;
		case 121:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bridge_duel");
			break;
		case 122:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bridge_doubles");
			break;
		case 123:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bridge_four");
			break;
		case 124:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bridge_2v2v2v2");
			break;
		case 125:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play duels_bridge_3v3v3v3");
			break;



		}
	}

  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Duels.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 130, this.height / 8 - 5, -1, 0, 53, 53, 53, 53);

		GlStateManager.pushMatrix();
		float scale2 = 0.5F;

		GlStateManager.popMatrix();

		super.drawScreen(mouseX, mouseY, partialTicks);

	}

   }
