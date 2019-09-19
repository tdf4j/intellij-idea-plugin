package org.tdf4j.plugin;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.tdf4j.plugin.psi.TDFTokenType;

public class TDFLexer {

    String inputStream;
    int nextCharPointer;
    int currentCharPointer;
    int startIndex;
    int stopIndex;
    IElementType prevNonWhieSpaceToken;
    IElementType currentToken;
    boolean eof = false;

    public TDFLexer(String inputStream) {
        this.inputStream = inputStream;
    }

    private void consume() {
        nextCharPointer++;
        if ( nextCharPointer < inputStream.length() ) currentCharPointer = inputStream.charAt(nextCharPointer);
    }

    public IElementType getTokenType() {
        if( currentToken == null && !eof ) {
            nextToken();
        }
        return currentToken;
    }

    public IElementType nextToken() {
        int inputStreamLength = inputStream.length();
        if ( nextCharPointer >= inputStreamLength ) {
            currentToken = null;
            eof = true;
            return null;
        }
        IElementType currentToken;
        startIndex = currentCharPointer;
        if(isWhieSpace(currentCharPointer)) {
            while (nextCharPointer < inputStreamLength && isWhieSpace(currentCharPointer)) {
                consume();
            }
            stopIndex = nextCharPointer - 1;
            currentToken = TokenType.WHITE_SPACE;
        } else if (currentCharPointer == '\n') {
            consume();
            currentToken = TDFTokenType.CRLF;
        } else if (currentCharPointer == '\r') {
            consume();
            if (currentCharPointer == '\n') {
                consume();
            }
            currentToken = TDFTokenType.CRLF;
        } else if ( currentCharPointer == '#' || currentCharPointer == '!') {
            while (nextCharPointer < inputStreamLength && currentCharPointer != '\n') {
                consume();
            }
            stopIndex = nextCharPointer - 1;
            currentToken = TDFTokenType.COMMENT;
            prevNonWhieSpaceToken = currentToken;
        } else if (currentCharPointer == '=' || currentCharPointer == ':') {
            stopIndex = nextCharPointer;
            consume();
            currentToken = TDFTokenType.SEPARATOR;
            prevNonWhieSpaceToken = currentToken;
        } else {
            while (nextCharPointer < inputStreamLength && !isWhieSpace(currentCharPointer) && !isNL(currentCharPointer)) {
                if( currentCharPointer == '\\') {
                    consume();
                }
                consume();
            }
            stopIndex = nextCharPointer - 1;
            if (prevNonWhieSpaceToken == TDFTokenType.SEPARATOR) {
                currentToken = TDFTokenType.VALUE;
            } else {
                currentToken = TDFTokenType.KEY;
            }
            prevNonWhieSpaceToken = currentToken;
        }
        this.currentToken = currentToken;
        return currentToken;
    }

    private boolean isWhieSpace(int c) {
        return  c==' ' || c=='\t';
    }

    private boolean isNL(int c) {
        return c=='\r' || c=='\n';
    }
}