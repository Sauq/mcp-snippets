public void sendChatMessage(String msg) {
  if(msg.equalsIgnoreCase(".Hi")) {
    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("Hello " + Minecraft.getMinecraft().getSession().getUsername();))
  }else {
    this.sendChatMessage(msg, true);
  }
}
