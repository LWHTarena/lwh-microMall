package com.lwhtarena.microMall.provider.main;

import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;

import java.util.List;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/11 22:04
 **/
public class PaginationPlugin extends PluginAdapter {
    /**
     * Validate boolean.
     *
     * @param warnings the warnings
     *
     * @return the boolean
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    private static void generate() {
        String config = PaginationPlugin.class.getClassLoader().getResource("generator/generatorConfig-B.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        generate();
    }
}
