
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class MythrilAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1800, 8.5f, 0, 13, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:mythril_axe_repair_items")));

	public MythrilAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 8.5f, -3f, properties);
	}
}
