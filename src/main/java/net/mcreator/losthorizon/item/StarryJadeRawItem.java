
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StarryJadeRawItem extends Item {
	public StarryJadeRawItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(64));
	}
}
