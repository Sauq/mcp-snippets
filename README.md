fov mod
-doesnt change fov when sprinting / with speed

**MAKE SURE TO DELETE THIS LINE IN net.minecraft.client.entity.AbstractClientPlayer**
Delete: f = (float)((double)f * ((iattributeinstance.getAttributeValue() / (double)this.capabilities.getWalkSpeed() + 1.0D) / 2.0D));
