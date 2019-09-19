package org.tdf4j.plugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.sun.istack.NotNull;

public class TDFFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull final FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(TDFFileType.INSTANCE, "tdf");
    }
}
