/*
Chroma Chat - By Sauq
Credit would be Nice but not needed
*/

//Put this in Client.java

public static int RainbowEffect(int i, float f) {
		return Color.HSBtoRGB((float)(System.currentTimeMillis() % 20000L) / 1000.0F, 0.8F, 0.8F);
	}

//And Replace 'int i = this.isEnabled ? this.enabledColor : this.disabledColor;' with:

int i = this.isEnabled ? Client.RainbowEffect : this.disabledColor;
