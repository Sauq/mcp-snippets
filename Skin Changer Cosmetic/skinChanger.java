package clientname.cosmetics.skinchanger;

import clientname.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class SkinChangerArmy implements LayerRenderer<AbstractClientPlayer>{
    private final RenderPlayer armyRenderer;
    private ModelBase armyModel = new ModelPlayer(0, true);

    public SkinChangerArmy(RenderPlayer renderPlayer) {
        this.armyRenderer = renderPlayer;
        this.armyModel = renderPlayer.getMainModel();
    }

    @Override
    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_1771412111, float p_1771413111,
            float partialTicks, float p_1771415111, float p_1771416111, float p_1771417111, float scale) {
        if(Client.SkinChangerArmy) {
        	String ign = Minecraft.getMinecraft().getSession().getProfile().getName();
        	if (entitylivingbaseIn.getName().equals(ign) && !entitylivingbaseIn.isInvisible()) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("army.png"));
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            this.armyModel.setModelAttributes(this.armyRenderer.getMainModel());
            this.armyModel.render(entitylivingbaseIn, p_1771412111, p_1771413111, p_1771415111, p_1771416111, p_1771417111, scale);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
        	
      }
        	
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }

}
