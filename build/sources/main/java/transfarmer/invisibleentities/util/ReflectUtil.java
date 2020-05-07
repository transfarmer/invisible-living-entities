package transfarmer.invisibleentities.util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import transfarmer.invisibleentities.Main;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static transfarmer.invisibleentities.Main.DEBUG;

@SuppressWarnings("ConstantConditions")
public class ReflectUtil {
    public static final Method renderLivingLabel = getMethod(Render.class, DEBUG ? "renderLivingLabel" : "func_147906_a", Entity.class, String.class, double.class, double.class, double.class, int.class);

    public static void invoke(final Method method, final Object object, final Object... args) {
        try {
            method.invoke(object, args);
        } catch (final IllegalAccessException | InvocationTargetException exception) {
            Main.LOGGER.error(exception);
        }
    }

    @Nonnull
    public static Method getMethod(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
        try {
            final Method method = clazz.getDeclaredMethod(name, parameterTypes);

            method.setAccessible(true);

            return method;
        } catch (final NoSuchMethodException exception) {
            Main.LOGGER.error(exception);
        }

        return null;
    }
}
