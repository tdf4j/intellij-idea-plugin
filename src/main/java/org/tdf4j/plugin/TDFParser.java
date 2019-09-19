package org.tdf4j.plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import static org.tdf4j.plugin.psi.TDFTokenType.*;

public class TDFParser implements PsiParser {

    protected PsiBuilder builder;
    protected IElementType token;

    @NotNull
    @Override
    public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder) {
        this.builder = builder;
        token = builder.getTokenType();

        PsiBuilder.Marker rootMarker = builder.mark();
        while ( !builder.eof() && token!=null ) {
            item();
        }
        if( root != null ) {
            rootMarker.done(root);
        }
        return builder.getTreeBuilt();
    }

    public void item() {
        if( token == KEY ) {
            property();
        }
        else if ( token == CRLF ) {
            match(CRLF);
        }
        else {
            consume();
            builder.error("no alt at: " +builder.getTokenType());
        }
    }

    public void property() {
        PsiBuilder.Marker marker = builder.mark();
        match(KEY);
        match(SEPARATOR);
        match(VALUE);
        marker.done(PROPERTY);
    }

    public void match(IElementType ttype) {
        if( builder.getTokenType() != ttype) {
            builder.error("token error, expecting " + ttype + ", found " + builder.getTokenType());
        }
        consume();
    }

    public void consume() {
        builder.advanceLexer();
        token = builder.getTokenType();
    }
}
