package net.scaryzombies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ScaryZombiesInit implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        System.out.println("Yo.");

        Registry.register(Registry.ITEM, new Identifier("scaryzombies", "fabric_item"), FABRIC_ITEM);

    }
}
