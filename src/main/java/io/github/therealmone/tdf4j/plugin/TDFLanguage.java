package io.github.therealmone.tdf4j.plugin;

import com.intellij.lang.Language;

public class TDFLanguage extends Language {
    public static final TDFLanguage INSTANCE = new TDFLanguage();

    private TDFLanguage(){
        super("Tdf");
    }
}
