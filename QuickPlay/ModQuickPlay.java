package century.mods.impl;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import CenturyClient.Client;
import century.gui.hud.HUDConfigScreen;
import century.guis.quickplay.ArcadeQuickPlay;
import century.guis.quickplay.BedwarsQuickPlay;
import century.guis.quickplay.BlitzSGQuickPlay;
import century.guis.quickplay.BuildBattleQuickPlay;
import century.guis.quickplay.ClassicGamesQuickPlay;
import century.guis.quickplay.CopsAndCrimsQuickPlay;
import century.guis.quickplay.DuelsQuickPlay;
import century.guis.quickplay.MegaWallsQuickPlay;
import century.guis.quickplay.MurderMysteryQuickPlay;
import century.guis.quickplay.SkywarsQuickPlay;
import century.guis.quickplay.SmashHeroesQuickPlay;
import century.guis.quickplay.TNTQuickPlay;
import century.guis.quickplay.UHCQuickPlay;
import century.guis.quickplay.WarlordsQuickPlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.TransparentButton;
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

public class ModQuickPlay extends GuiScreen {
	private final GuiScreen field_146598_addd;

	private GuiButton field_146596_f;
	private GuiButton field_146597_g;
	private String field_146599_h = "survival";
	private boolean field_146600_i;

	public ModQuickPlay(GuiScreen p_i1055_1_ddd) {
		this.field_146598_addd = p_i1055_1_ddd;
	}

	public void initGui() {

		int i = 24;
		int j = this.height / 4 - 147;

		GuiButton guibutton;

		this.buttonList
				.add(new TransparentButton(10001, this.width / 2 - 303, j + 63 + 10, 53, 55, I18n.format("", new Object[0]))); // Main
																														// Lobby
		this.buttonList
				.add(new TransparentButton(10002, this.width / 2 - 303, j + 63 + 76, 53, 55, I18n.format("", new Object[0]))); // Build
																														// Battle
		this.buttonList
				.add(new TransparentButton(10003, this.width / 2 - 303, j + 63 + 143, 53, 55, I18n.format("", new Object[0]))); // Housing
		this.buttonList
				.add(new TransparentButton(10004, this.width / 2 - 303, j + 63 + 207, 53, 55, I18n.format("", new Object[0]))); // Skyblock
		this.buttonList
				.add(new TransparentButton(10005, this.width / 2 - 303, j + 63 + 270, 53, 55, I18n.format("", new Object[0]))); // TNT

		// ------------------------------------------------------------------------------------------------------------------

		this.buttonList
				.add(new TransparentButton(10006, this.width / 2 - 145, j + 63 + 10, 53, 55, I18n.format("", new Object[0]))); // Arcade
		this.buttonList
				.add(new TransparentButton(10007, this.width / 2 - 145, j + 63 + 76, 53, 55, I18n.format("", new Object[0]))); // Classic
																														// Lobby
		this.buttonList
				.add(new TransparentButton(10008, this.width / 2 - 145, j + 63 + 143, 53, 55, I18n.format("", new Object[0]))); // Mega
																														// Walls
		this.buttonList
				.add(new TransparentButton(10009, this.width / 2 - 145, j + 63 + 207, 53, 55, I18n.format("", new Object[0]))); // SkyWars
		this.buttonList
				.add(new TransparentButton(10010, this.width / 2 - 145, j + 63 + 270, 53, 55, I18n.format("", new Object[0]))); // UHC
																														// Champions

		// ------------------------------------------------------------------------------------------------------------------

		this.buttonList
				.add(new TransparentButton(10011, this.width / 2 - 3, j + 63 + 10, 53, 55, I18n.format("", new Object[0]))); // Bedwars
		this.buttonList
				.add(new TransparentButton(10012, this.width / 2 - 3, j + 63 + 76, 53, 55, I18n.format("", new Object[0]))); // Cops
																														// And
																														  // Crims
		this.buttonList
				.add(new TransparentButton(10013, this.width / 2 - 3, j + 63 + 143, 53, 55, I18n.format("", new Object[0]))); // Murder
																														// Mystery
		this.buttonList
				.add(new TransparentButton(10014, this.width / 2 - 3, j + 63 + 207, 53, 55, I18n.format("", new Object[0]))); // Smash
																														// Heroes
		this.buttonList
				.add(new TransparentButton(10015, this.width / 2 - 3, j + 63 + 270, 53, 55, I18n.format("", new Object[0]))); // Warlords

		// ------------------------------------------------------------------------------------------------------------------

		this.buttonList
				.add(new TransparentButton(10016, this.width / 2 + 153, j + 63 + 10, 53, 55, I18n.format("", new Object[0]))); // Blitz
																														// SG
		this.buttonList
				.add(new TransparentButton(10017, this.width / 2 + 153, j + 63 + 76, 53, 55, I18n.format("", new Object[0]))); // Duels
		this.buttonList
				.add(new TransparentButton(10018, this.width / 2 + 153, j + 63 + 143, 53, 55, I18n.format("", new Object[0]))); // Prototype
		this.buttonList
				.add(new TransparentButton(10019, this.width / 2 + 153, j + 63 + 207, 53, 55, I18n.format("", new Object[0]))); // The
																														// Pit
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

		case 8:
			this.mc.displayGuiScreen(new ModQuickPlay(this));
			break;
		// ------------------------------------------------------------------------------------------------------------------
		case 10001:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/lobby");
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/lobby");
			break;
		case 10002:
			this.mc.displayGuiScreen(new BuildBattleQuickPlay(this));
			break;
		case 10003:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/home");
			break;
		case 10004:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/skyblock");
			break;
		case 10005:
			this.mc.displayGuiScreen(new TNTQuickPlay(this));
			break;
		// ------------------------------------------------------------------------------------------------------------------
		case 10006:
			this.mc.displayGuiScreen(new ArcadeQuickPlay(this));
			break;
		case 10007:
			this.mc.displayGuiScreen(new ClassicGamesQuickPlay(this));
			break;
		case 10008:
			this.mc.displayGuiScreen(new MegaWallsQuickPlay(this));
			break;
		case 10009:
			this.mc.displayGuiScreen(new SkywarsQuickPlay(this));
			break;
		case 10010:
			this.mc.displayGuiScreen(new UHCQuickPlay(this));
			break;

		// ------------------------------------------------------------------------------------------------------------------

		case 10011:
			this.mc.displayGuiScreen(new BedwarsQuickPlay(this));
			break;
		case 10012:
			this.mc.displayGuiScreen(new CopsAndCrimsQuickPlay(this));
			break;
		case 10013:
			this.mc.displayGuiScreen(new MurderMysteryQuickPlay(this));
			break;
		case 10014:
			this.mc.displayGuiScreen(new SmashHeroesQuickPlay(this));
			break;
		case 10015:
			this.mc.displayGuiScreen(new WarlordsQuickPlay(this));
			break;

		// ------------------------------------------------------------------------------------------------------------------

		case 10016:
			this.mc.displayGuiScreen(new BlitzSGQuickPlay(this));
			break;
		case 10017:
			this.mc.displayGuiScreen(new DuelsQuickPlay(this));
			break;
		case 10018:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/l ptl");
			break;
		case 10019:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play pit");
			break;
		case 10020:
			Minecraft.getMinecraft().thePlayer.sendChatMessage("/play pit");
			break;

		// ------------------------------------------------------------------------------------------------------------------

		}
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/MainLobby.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +36, this.height / 8 - 30, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Main Lobby", this.width / +3 - 130, this.height / 8 - 10,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Arcade.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 15, this.height / 8 - 30, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Arcade", this.width / +2 - 76, this.height / 8 - 10,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Bedwars.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 - 3, this.height / 8 - 30, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Bedwars", this.width / +2 + 60, this.height / 8 - 10,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Blitz.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 + 153, this.height / 8 - 30, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Blitz SG", this.width / +1 - 104, this.height / 8 - 10,
				-Color.darkGray.getRGB());

		// ------------------------------------------------------------------------------------------------------------------

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/BuildBattle.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +36, this.height / 8 + 35, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Build Battle", this.width / +3 - 130, this.height / 8 + 55,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/ClassicLobby.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 15, this.height / 8 + 35, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Classic Games", this.width / +2 - 79, this.height / 8 + 55,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/CopsAndCrims.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 - 3, this.height / 8 + 35, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Cops And Crims", this.width / +2 + 60, this.height / 8 + 55,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Duels.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 + 153, this.height / 8 + 35, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Duels", this.width / +1 - 104, this.height / 8 + 55,
				-Color.darkGray.getRGB());

		// ------------------------------------------------------------------------------------------------------------------

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Housing.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +36, this.height / 8 + 100, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Housing", this.width / +3 - 130, this.height / 8 + 119,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/MegaWalls.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 15, this.height / 8 + 100, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Mega Walls", this.width / +2 - 79, this.height / 8 + 119,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/MurderMystery.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 - 3, this.height / 8 + 100, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Murder Mystery", this.width / +2 + 60, this.height / 8 + 119,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Prototype.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 + 153, this.height / 8 + 100, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Prototype", this.width / +1 - 104, this.height / 8 + 119,
				-Color.darkGray.getRGB());

		// ------------------------------------------------------------------------------------------------------------------

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Skyblock.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +36, this.height / 8 + 165, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Skyblock", this.width / +3 - 130, this.height / 8 + 185,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/SkyWars.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 15, this.height / 8 + 165, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Skywars", this.width / +2 - 79, this.height / 8 + 185,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/SmashHeroes.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 - 3, this.height / 8 + 165, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Smash Heroes", this.width / +2 + 60, this.height / 8 + 185,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Pit.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 + 153, this.height / 8 + 165, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "The Pit", this.width / +1 - 104, this.height / 8 + 185,
				-Color.darkGray.getRGB());

		// ------------------------------------------------------------------------------------------------------------------

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/TNT.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +36, this.height / 8 + 230, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "TNT Games", this.width / +3 - 130, this.height / 8 + 251,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/UHC.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +4 + 15, this.height / 8 + 230, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "UHC Champions", this.width / +2 - 79, this.height / 8 + 251,
				-Color.darkGray.getRGB());

		this.mc.getTextureManager().bindTexture(new ResourceLocation("QuickPlay/Warlords.png"));
		Gui.drawModalRectWithCustomSizedTexture(this.width / +2 - 3, this.height / 8 + 230, -1, 0, 53, 53, 53, 53);
		this.drawString(fontRendererObj, "Warlords", this.width / +2 + 60, this.height / 8 + 251,
				-Color.darkGray.getRGB());

		// ------------------------------------------------------------------------------------------------------------------

		GlStateManager.pushMatrix();

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_BLEND);
		GlStateManager.popMatrix();

		super.drawScreen(mouseX, mouseY, partialTicks);

	}

	public void openQuickPlay() {
		mc.displayGuiScreen(new ModQuickPlay(this));
	} 

}
