package net.fire_horse27.moretrapdoors.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<Item> MATERIAL = List.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, Items.COPPER_INGOT, Items.IRON_INGOT);

    private static final List<Item> TRAPDOORS = List.of(Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.BIRCH_TRAPDOOR,
            Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR,
            Items.CHERRY_TRAPDOOR, Items.BAMBOO_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR,
            Items.COPPER_TRAPDOOR, Items.IRON_TRAPDOOR);

    @Override
    public void generate(RecipeExporter exporter) {
        for(int i = 0; i < 11; i++) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, TRAPDOORS.get(i), 6)
                    .pattern("###")
                    .pattern("###")
                    .group("wooden_trapdoor")
                    .input('#', MATERIAL.get(i))
                    .criterion(hasItem(MATERIAL.get(i)), conditionsFromItem(MATERIAL.get(i)))
                    .offerTo(exporter);
        }

        for(int i = 11; i < 13; i++) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, TRAPDOORS.get(i), 6)
                    .pattern("###")
                    .pattern("###")
                    .input('#', MATERIAL.get(i))
                    .criterion(hasItem(MATERIAL.get(i)), conditionsFromItem(MATERIAL.get(i)))
                    .offerTo(exporter);
        }
    }
}
