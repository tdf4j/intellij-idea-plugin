package org.tdf4j.plugin.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.tdf4j.plugin.TDFLanguage;

public class TDFElementType extends IElementType {
    public TDFElementType(@NotNull @NonNls String debugName) {
        super(debugName, TDFLanguage.INSTANCE);
    }
}
