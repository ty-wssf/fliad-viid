package com.fliad.core.config;

import io.nop.api.core.util.SourceLocation;
import io.nop.commons.util.StringHelper;
import io.nop.commons.util.objects.ValueWithLocation;
import io.nop.config.source.EnvConfigSourceLoader;
import io.nop.config.source.IConfigSource;
import io.nop.config.source.IConfigSourceLoader;
import io.nop.config.source.StaticConfigSource;
import org.noear.solon.Solon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyl
 * @date 2025年11月24日 22:23
 */
public class SolonConfigSourceLoader implements IConfigSourceLoader {

    private static final SourceLocation s_loc = SourceLocation.fromClass(SolonConfigSourceLoader.class);

    @Override
    public IConfigSource loadConfigSource(IConfigSource currentConfig) {
        Map<String, ValueWithLocation> ret = new HashMap<>();
        for (Map.Entry<Object, Object> entry : Solon.cfg().entrySet()) {
            String name = StringHelper.envToConfigVar(entry.getKey().toString());
            if (!StringHelper.isValidConfigVar(name))
                continue;

            String value = entry.getValue().toString();
            ret.put(name, ValueWithLocation.of(s_loc, value));
        }
        return new StaticConfigSource("solon", ret);
    }

}
