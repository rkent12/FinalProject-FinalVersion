package net.ryankent.practicemod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import java.util.Objects;


public class FirstQuestItem extends Item {



    public FirstQuestItem(Settings settings) {

        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity player = Objects.requireNonNull(context.getPlayer());



        return super.useOnBlock(context);
    }
}


