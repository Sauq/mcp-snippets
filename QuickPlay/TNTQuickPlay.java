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

public class TNTQuickPlay extends GuiScreen  {
	private final GuiScreen field_146598_aaaaa;


	private GuiButton field_146596_f;
	private GuiButton field_146597_g;
	private String field_146599_h = "survival";
	private boolean field_146600_i;

	public TNTQuickPlay(GuiScreen p_i1055_1_dada_) {
		this.field_146598_aaaaa = p_i1055_1_dada_;
	}

	public void initGui() {

		GuiButton guibutton;

		this.buttonList.add(new GuiButton(100, this.width / 4+117, this.height / 2 - 70, 80, 20, I18n.format("Lobby", new Object[0])));

		this.buttonList.add(new GuiButton(101, this.width / 4+117, this.height / 2 - 40, 80, 20, I18n.format("TNT Run", new Object[0])));

		this.buttonList.add(new GuiButton(102, this.width / 4+117, this.height / 2 - 10, 80, 20, I18n.format("PVP Run", new Object[0])));

		this.buttonList.add(new GuiButton(103, this.width / 4+117, this.height / 2 + 20, 80, 20, I18n.format("Bow Spleef", new Object[0])));

		this.buttonList.add(new GuiButton(104, this.width / 4+117, this.height / 2 + 50, 80, 20, I18n.format("TNT Tag", new Object[0])));

		this.buttonList.add(new GuiButton(105, this.width / 4+117, this.height / 2 + 80, 80, 20, I18n.format("TNT Wizards", new Object[0])));

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
			this.mc.displayGuiScreen(new TNTQuickPlay(this));
			break;
		case 100:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/l tnt");
			break;
		case 101:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play tnt_tntrun");
			break;
		case 102:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play tnt_pvprun");
			break;
		case 103:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play tnt_bowspleef");
			break;
		case 104:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play tnt_tntag");
			break;
		case 105:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play tnt_capture");
			break;


		}
	}

  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    this.drawDefaultBackground();

    this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/TNT.png"));
    Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 130, this.height / 8 - 5, -1, 0, 53, 53, 53, 53);

    GlStateManager.pushMatrix();
    float scale2 = 0.5F;

    GlStateManager.popMatrix();

    super.drawScreen(mouseX, mouseY, partialTicks);

  }

   }
