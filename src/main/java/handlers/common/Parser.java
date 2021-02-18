package handlers.common;

import java.io.PrintWriter;

public class Parser {
    private static final String startSymbol = "[[";
    private static final String endSymbol = "]]";
    private StringBuilder stringBuilder;
    private PrintWriter printWriter;
    private TemplateHandler templateHandler;

    public Parser(StringBuffer stringBuffer, PrintWriter printWriter, TemplateHandler handler) {
        stringBuilder = new StringBuilder(stringBuffer.toString());
        this.printWriter = printWriter;
        templateHandler = handler;
    }

    public Parser(StringBuilder stringBuilder, PrintWriter printWriter, TemplateHandler handler) {
        this.stringBuilder = stringBuilder;
        this.printWriter = printWriter;
        templateHandler = handler;
    }

    public Parser() {
    }

    public void parse() {
        int indexOfEdnSymbol;
        int indexOfStartSymbol = stringBuilder.indexOf(startSymbol);
        while (indexOfStartSymbol >= 0) {
            printWriter.print(stringBuilder.substring(0, indexOfStartSymbol));
            printWriter.flush();

            stringBuilder.delete(0, indexOfStartSymbol + 2);

            indexOfEdnSymbol = stringBuilder.indexOf(endSymbol);

            if (indexOfEdnSymbol >= 0) {
                templateHandler.replace(stringBuilder.substring(0, indexOfEdnSymbol), printWriter);
                stringBuilder.delete(0, indexOfEdnSymbol + 2);
            }
            indexOfStartSymbol = stringBuilder.indexOf(startSymbol);
        }

        printWriter.print(stringBuilder.toString());
        printWriter.flush();
    }
}
