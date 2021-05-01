package net.minecraft.client.gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class TransparentButton extends GuiButton {

	private int buttonId, x, y, widthIn, heightIn;
	private String buttonText;

	public TransparentButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);

		this.x = x;
		this.y = y;
		this.widthIn = widthIn;
		this.heightIn = heightIn;
		this.buttonText = buttonText;
	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
			mc.getTextureManager().bindTexture(buttonTextures);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width
					&& mouseY < this.yPosition + this.height;
			int i = this.getHoverState(this.hovered);
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.blendFunc(770, 771);
			int clr = 0x44000000;
			if(this.hovered) {
				clr = 0x54000000;
			}
			this.mouseDragged(mc, mouseX, mouseY);
			int j = 14737632;
			if (!this.enabled) {
				j = 10526880;
			} else if (this.hovered) {
				j = 16777120;
			}
			this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2,this.yPosition + (this.height - 8) / 2, 0xffffff);
		}
	}
}
