package io.github.thebluetropics.snowextras.helper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStackHelper {
  public static boolean isOf(ItemStack stack, Item... compareItems) {
    for (Item compareItem : compareItems) {
      if (stack.isOf(compareItem)) {
        return true;
      }
    }

    return false;
  }
}
