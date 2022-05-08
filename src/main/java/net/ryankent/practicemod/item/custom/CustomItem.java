package net.ryankent.practicemod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;

import java.io.IOException;
import java.util.Objects;
import okhttp3.*;


public class CustomItem extends Item {

    // This item was made because it was potentially going to be used to call the discord API, you can see I just have an example of calling a different API.
    // I just did not end up going down that route do to problems with the discord API.

    public CustomItem(Settings settings) {

        super(settings);
    }


    public static OkHttpClient client = new OkHttpClient();

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) { // Function that calls the API. This was working for this API, just would of been different for the discord API

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


