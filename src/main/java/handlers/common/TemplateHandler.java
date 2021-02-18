package handlers.common;

import java.io.PrintWriter;

public interface TemplateHandler {
    void replace(String name, PrintWriter pw);
}
