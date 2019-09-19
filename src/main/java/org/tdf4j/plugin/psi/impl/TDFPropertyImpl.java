package org.tdf4j.plugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.tdf4j.plugin.psi.TDFProperty;
import org.tdf4j.plugin.psi.TDFVisitor;

public class TDFPropertyImpl extends ASTWrapperPsiElement implements TDFProperty {

    public TDFPropertyImpl(@NotNull final ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if ( visitor instanceof TDFVisitor ) ((TDFVisitor) visitor).visitProperty(this);
        else super.accept(visitor);
    }
}
