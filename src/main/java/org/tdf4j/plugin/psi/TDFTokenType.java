package org.tdf4j.plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.tdf4j.plugin.TDFLanguage;
import org.tdf4j.plugin.psi.impl.TDFPropertyImpl;

public class TDFTokenType extends IElementType {

    public static final IElementType PROPERTY = new TDFElementType("PROPERTY");
    public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
    public static final TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE);
    public static final IElementType COMMENT = new TDFTokenType("COMMENT");
    public static final TokenSet COMMENTS = TokenSet.create(COMMENT);
    public static final IElementType CRLF = new TDFTokenType("CRLF");
    public static final IElementType KEY = new TDFTokenType("KEY");
    public static final IElementType SEPARATOR = new TDFTokenType("SEPARATOR");
    public static final IElementType VALUE = new TDFTokenType("VALUE");
    
    public TDFTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TDFLanguage.INSTANCE);
    }

    public static class Factory {
        public static PsiElement createElement(ASTNode node) {
            System.out.println("createElement from" + node);
            IElementType type = node.getElementType();
            if (type == PROPERTY) {
                return new TDFPropertyImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
