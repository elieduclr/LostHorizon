
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SilverRingItem extends Item {
	public SilverRingItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(64));
	}
}
