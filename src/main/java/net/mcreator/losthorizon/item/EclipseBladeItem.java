
package net.mcreator.losthorizon.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.losthorizon.procedures.EclipseBladeQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure;

import java.util.List;

public class EclipseBladeItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2100, 8f, 0, 12, TagKey.create(Registries.ITEM, ResourceLocation.parse("losthorizon:eclipse_blade_repair_items")));

	public EclipseBladeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4f, -2f, properties.fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		EclipseBladeQuandUneEntiteVivanteEstFrappeeAvecLoutilProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.losthorizon.eclipse_blade.description_0"));
		list.add(Component.translatable("item.losthorizon.eclipse_blade.description_1"));
		list.add(Component.translatable("item.losthorizon.eclipse_blade.description_2"));
	}
}
