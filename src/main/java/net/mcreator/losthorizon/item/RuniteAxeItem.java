
package net.mcreator.losthorizon.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.procedures.RuniteSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure;

public class RuniteAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 660, 9f, 0, 28, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:runite_axe_repair_items")));

	public RuniteAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 7f, 2f, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		RuniteSwordQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
