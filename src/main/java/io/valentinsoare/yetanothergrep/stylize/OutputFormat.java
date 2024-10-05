package io.valentinsoare.yetanothergrep.stylize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class OutputFormat {
    private ObjectMapper jsonStyle;

    public OutputFormat() {}

    public ObjectMapper withJSONStyle() {
        if (jsonStyle == null) {
            jsonStyle = new ObjectMapper();
            jsonStyle.registerModule(new JavaTimeModule());
        }

        return jsonStyle;
    }
}
