package org.github.therealmone.tdf4j;

import io.github.therealmone.tdf4j.tdfparser.TdfParser;
import io.github.therealmone.tdf4j.tdfparser.TdfParserGenerator;
import org.junit.Test;

import java.io.IOException;

public class TDFParsingTest {

    @Test
    public void tmp() throws IOException {
        @SuppressWarnings("ConstantConditions")
        final TdfParser parser = new TdfParserGenerator(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar.tdf")
        ).generate();
        System.out.println(parser.meta().sourceCode());
    }

}
