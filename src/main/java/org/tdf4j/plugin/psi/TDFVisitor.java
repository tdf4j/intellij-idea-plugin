package org.tdf4j.plugin.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class TDFVisitor extends PsiElementVisitor {

    public void visitProperty(@NotNull TDFProperty o) { visitElement(o); }

    public void visitElement(@NotNull PsiElement o) { visitElement(o);}

}
