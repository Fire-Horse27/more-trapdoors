package net.fire_horse27.moretrapdoors.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
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

    private static final int WOODCOUNT = 12;

    private static final List<Item> MATERIAL = List.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, Items.PALE_OAK_PLANKS);

    private static final List<Item> TRAPDOORS = List.of(Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.BIRCH_TRAPDOOR,
            Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR,
            Items.CHERRY_TRAPDOOR, Items.BAMBOO_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR,
            Items.PALE_OAK_TRAPDOOR);

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                for (int i = 0; i < WOODCOUNT; i++) {
                    createShaped(RecipeCategory.REDSTONE, TRAPDOORS.get(i), 6)
                            .pattern("###")
                            .pattern("###")
                            .group("wooden_trapdoor")
                            .input('#', MATERIAL.get(i))
                            .criterion(hasItem(MATERIAL.get(i)), conditionsFromItem(MATERIAL.get(i)))
                            .offerTo(exporter);
                }

                createShaped(RecipeCategory.REDSTONE, Items.IRON_TRAPDOOR, 2)
                    .pattern("###")
                    .pattern("###")
                    .input('#', Items.IRON_INGOT)
                    .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.IRON_BARS, 16)
                        .pattern("# #")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.REDSTONE, Items.COPPER_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.COPPER_BARS.unaffected(), 16)
                        .pattern("# #")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}