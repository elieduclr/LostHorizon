
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GoldRingItem extends Item {
	public GoldRingItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(64));
	}
}
