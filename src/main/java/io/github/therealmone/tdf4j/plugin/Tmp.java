package io.github.therealmone.tdf4j.plugin;

import io.github.therealmone.tdf4j.tdfparser.TdfParser;
import io.github.therealmone.tdf4j.tdfparser.TdfParserGenerator;

import java.io.IOException;

public class Tmp {
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("ConstantConditions")
        final TdfParser parser = new TdfParserGenerator(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar.tdf")
        ).generate();
        System.out.println(parser.meta().sourceCode());
    }
}
