
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class RunitePickaxeItem extends PickaxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 800, 9.5f, 0, 18, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:runite_pickaxe_repair_items")));

	public RunitePickaxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 6f, -2.7f, properties);
	}
}
