package net.fire_horse27.moretrapdoors.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fire_horse27.moretrapdoors.MoreTrapdoors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    public static void addItemsToItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            /*entries.addAfter(Items.CHERRY_HANGING_SIGN, AZALEA_SIGN);*/
        });
    }

    public static void registerModItems() {
        MoreTrapdoors.LOGGER.info("Registering Mod Items for " + MoreTrapdoors.MOD_ID);

        addItemsToItemGroup();
    }

    private static Identifier id(String path) {
        return Identifier.of(MoreTrapdoors.MOD_ID, path);
    }
}
