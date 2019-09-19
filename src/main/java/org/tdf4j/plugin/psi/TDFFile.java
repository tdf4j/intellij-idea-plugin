package org.tdf4j.plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.tdf4j.plugin.TDFFileType;
import org.tdf4j.plugin.TDFLanguage;

import javax.swing.*;

public class TDFFile extends PsiFileBase {

    public TDFFile(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, TDFLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TDFFileType.INSTANCE;
    }

    @Override
    public String toString() { return "TDF File"; }

    @Override
    public Icon getIcon(int flags) { return  super.getIcon(flags); }
}
