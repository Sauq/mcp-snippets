# Quick Play
- This took me ages so if you could subscribe (https://www.youtube.com/channel/UCasgtGl0LX5gTgvVAFpvr5g) That would be great! I upload alot of MCP and other useful things!

- Crediting would be nice but you dont have to!
- If you get any erros with GuiClientMenu just remove everything to do with it. If you need further support DM Me on Discord: Sauq#6292

## Instructions:
- Put the QuickPlay folder with images in your client assets folder
- Open the TransparentButton Folder and put the class in your client/src/net/minecraft/client/gui/
- Make a Keybind in GameSettings.java called CLIENT_QUICKPLAY
- Put all of the remaining classes into your mod packages
- Add this to the top of your Client.java class: private ModQuickPlay modQuickPlay;
- Add this to your Client.java in your onTick method 

if (Minecraft.getMinecraft().gameSettings.CLIENT_QUICKPLAY.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new ModQuickPlay(modQuickPlay));
		}
		
- Click your set keybind in game and it should come up!


![image](https://user-images.githubusercontent.com/69165251/116797025-23317100-aad9-11eb-82e0-b7402f472b05.png)
