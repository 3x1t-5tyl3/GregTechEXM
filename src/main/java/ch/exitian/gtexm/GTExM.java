package ch.exitian.gtexm;

import ch.exitian.gtexm.config.Config;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.client.ClientProxy;
import com.gregtechceu.gtceu.common.CommonProxy;
import com.tterrag.registrate.util.RegistrateDistExecutor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(GTExM.MODID)
public class GTExM {
    public static final String MODID = "gtexm";

    public static CommonProxy proxy;
    public GTExM(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.register(EventHandler.class);
        proxy = RegistrateDistExecutor.unsafeRunWhenOn(() -> ClientProxy::new, () -> new CommonProxy()::new);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
