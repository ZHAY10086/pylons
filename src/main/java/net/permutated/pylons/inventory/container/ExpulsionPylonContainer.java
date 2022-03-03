package net.permutated.pylons.inventory.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.RegistryObject;
import net.permutated.pylons.ModRegistry;

public class ExpulsionPylonContainer extends AbstractPylonContainer {

    private final boolean allowedDimension;
    private final boolean allowedLocation;

    public ExpulsionPylonContainer(int windowId, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ModRegistry.EXPULSION_PYLON_CONTAINER.get(), windowId, playerInventory, packetBuffer);
        allowedDimension = packetBuffer.readBoolean();
        allowedLocation = packetBuffer.readBoolean();
    }

    @Override
    protected RegistryObject<Block> getBlock() {
        return ModRegistry.EXPULSION_PYLON;
    }

    public boolean isAllowedDimension() {
        return allowedDimension;
    }

    public boolean isAllowedLocation() {
        return allowedLocation;
    }

    @Override
    public boolean shouldRenderRange() {
        return true;
    }
}
