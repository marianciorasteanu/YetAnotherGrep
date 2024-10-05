package io.valentinsoare.yetanothergrep.Auxiliary;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.valentinsoare.yetanothergrep.errorAndException.ErrorBuilder;
import io.valentinsoare.yetanothergrep.errorAndException.ErrorMessage;
import io.valentinsoare.yetanothergrep.errorAndException.Severity;
import io.valentinsoare.yetanothergrep.stylize.OutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

@Component
public class AuxChecks implements Utilities {
    private final OutputFormat outputFormat;

    @Autowired
    public AuxChecks(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    @Override
    public boolean  isBinaryFile(Path path) {
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(5120);

            if (fileChannel.read(buffer) > 0) {
                buffer.flip();

                for (int i = 0; i < buffer.limit(); i++) {
                    byte b = buffer.get(i);

                    if (b < 0x09 || (b > 0x0D && b < 0x20) || b == 0x7F) {
                        return true;
                    }
                }

                buffer.clear();
                return false;
            }

            return false;
        } catch (IOException e) {
            ErrorMessage msg = ErrorBuilder.getBuilder()
                    .withSeverity(Severity.ERROR)
                    .withMethodName("isBinaryFile")
                    .withMessage(e.getMessage())
                    .withThreadName(Thread.currentThread().getName())
                    .withDateTime(Instant.now().toString())
                    .withClazzName(AuxChecks.class.getName())
                    .build();

            try {
                System.err.printf("%s %n", outputFormat.withJSONStyle().writeValueAsString(msg));
            } catch (JsonProcessingException ex) {
                System.err.printf("%n\033[1;31m%s - class: %s, method: %s, %s\0330m%n",
                        Severity.FATAL, AuxChecks.class.getName(), "isBinaryFile", ex.getMessage());
            }

            System.exit(0);
        }

        return false;
    }
}
