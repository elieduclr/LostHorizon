
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class LinkDaggerItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000, 6f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:link_dagger_repair_items")));

	public LinkDaggerItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 5f, -2.4f, properties);
	}
}
