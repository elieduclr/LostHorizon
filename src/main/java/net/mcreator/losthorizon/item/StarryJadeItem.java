
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StarryJadeItem extends Item {
	public StarryJadeItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(64));
	}
}
