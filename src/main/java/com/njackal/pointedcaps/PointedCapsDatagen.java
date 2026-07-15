package com.njackal.pointedcaps;

import com.njackal.pointedcaps.datagen.BlockLootTableProvider;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = PointedCaps.MODID)
public class PointedCapsDatagen {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent event) {
        PointedCaps.LOGGER.debug("Gather Client Data");

        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<LootTableProvider>) packOutput -> new LootTableProvider(
                        packOutput,
                        Set.of(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)
                        ),
                        event.getLookupProvider()
                )
        );
    }

}
