package org.tdf4j.plugin;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TDFLexerAdapter extends LexerBase {

    TDFLexer lexer;
    CharSequence buffer;
    int startOffset;
    int endOffset;
    int initialState;

    @Override
    public void advance(){
        IElementType currentToken = lexer.nextToken();
    }


    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        this.buffer = buffer;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.initialState = initialState;
        lexer = new TDFLexer(buffer.subSequence(startOffset, endOffset).toString());
    }

    @Override
    public int getState() {
        return initialState;
    }

    @Nullable
    @Override
    public IElementType getTokenType() {
        IElementType type = lexer.getTokenType();
        return type;
    }

    @Override
    public int getTokenStart() {
        return 0;
    }

    @Override
    public int getTokenEnd() {
        return 0;
    }

    @NotNull
    @Override
    public CharSequence getBufferSequence() {
        return buffer;
    }

    @Override
    public int getBufferEnd() {
        return endOffset;
    }
}
