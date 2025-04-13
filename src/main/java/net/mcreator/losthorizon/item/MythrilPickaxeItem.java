
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class MythrilPickaxeItem extends PickaxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1800, 8f, 0, 13, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:mythril_pickaxe_repair_items")));

	public MythrilPickaxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4.5f, -2.8f, properties);
	}
}
