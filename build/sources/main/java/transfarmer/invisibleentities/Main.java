package transfarmer.invisibleentities;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.management.ManagementFactory;

@Mod(
        modid = Main.MOD_ID,
        name = Main.MOD_NAME,
        version = Main.VERSION
)
public class Main {
    public static final String MOD_ID = "invisibleentities";
    public static final String MOD_NAME = "cuboid entities";
    public static final String VERSION = "0.0.0-beta";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final boolean DEBUG = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
}
