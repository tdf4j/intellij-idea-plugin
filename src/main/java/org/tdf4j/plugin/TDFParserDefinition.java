package org.tdf4j.plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.tdf4j.plugin.psi.TDFFile;
import org.tdf4j.plugin.psi.TDFTokenType;

public class TDFParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(Language.<TDFLanguage>findInstance(TDFLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(final Project project) {
        return new TDFLexerAdapter();
    }

    @Override
    public PsiParser createParser(final Project project) {
        return new TDFParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return TDFTokenType.WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TDFTokenType.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(final ASTNode node) {
        return TDFTokenType.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(final FileViewProvider viewProvider) {
        return new TDFFile(viewProvider);
    }

    public SpaceRequirements spaceBetweenTokens(final ASTNode left, final ASTNode right) {
        return SpaceRequirements.MAY;
    }

}
