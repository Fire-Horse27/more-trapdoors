package net.fire_horse27.moretrapdoors.util;

import net.fire_horse27.moretrapdoors.MoreTrapdoors;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreTrapdoors.MOD_ID, name));
        }
    }

    public static class Items {
        /*public static final TagKey<Item> DEAD_CORAL_BLOCKS = createTag("dead_coral_blocks");*/

        private static TagKey<Item> createTag(String name) {


            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreTrapdoors.MOD_ID, name));
        }
    }
}
