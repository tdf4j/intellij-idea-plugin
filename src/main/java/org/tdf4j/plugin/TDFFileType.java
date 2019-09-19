package org.tdf4j.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class TDFFileType extends LanguageFileType {

    public static final TDFFileType INSTANCE = new TDFFileType();

    private TDFFileType() {
        super(TDFLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "TDF file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "TDF grammar file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "tdf";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TDFIcon.FILE;
    }
}
