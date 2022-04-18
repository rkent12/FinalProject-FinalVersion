package net.ryankent.practicemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ryankent.practicemod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okhttp3.*;


public class CustomItem extends Item {



    public CustomItem(Settings settings) {

        super(settings);
    }


    public static OkHttpClient client = new OkHttpClient();

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity player = Objects.requireNonNull(context.getPlayer());

        String url = "https://www.episodate.com/api/search?q=arrow&page=1";
        Request r = new Request.Builder()
                .url(url)
                .build();

        try {
            Response res = client.newCall(r).execute();
            player.sendMessage(new LiteralText(res.body().string()), false);
        } catch (IOException e) {
            e.printStackTrace();
        }



        return super.useOnBlock(context);
    }
}


