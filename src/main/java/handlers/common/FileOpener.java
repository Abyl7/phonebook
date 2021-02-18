package handlers.common;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOpener {
    String name;
    private static final String folder = "templates/";
    private static String contextPath;

    public FileOpener(String fileName) {
        name = fileName;
    }

    public String readToString(ServletContext cntxt) {

        if (contextPath == null) {
            contextPath = cntxt.getRealPath(File.separator);
        }
        try {
            return new String(Files.readAllBytes(Paths.get(contextPath, folder + name)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static byte[] getBytes(Class<?> resourceClass,String fileName) throws IOException {
        InputStream inputStream = resourceClass.getResourceAsStream(fileName);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return bytes;
    }

    /**
     * opens file and reads it as a string
     * @param resourceClass - class that is located at the same package as the file
     * @param fileName file name that should be opened
     * @return content of the file as a string
     * @throws IOException
     */
    public static String getAsString(Class<?> resourceClass,String fileName) throws IOException {
        InputStream inputStream = resourceClass.getResourceAsStream(fileName);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public StringBuffer read(ServletContext cnxt) {
        StringBuffer result = new StringBuffer("");
        try {
            result = new StringBuffer(readToString(cnxt));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }

    public StringBuilder readStringBuilder(ServletContext cnxt) {
        StringBuilder result = new StringBuilder("");
        try {
            result = new StringBuilder(readToString(cnxt));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }

    public StringBuffer read(String fileName) {
        StringBuffer result = new StringBuffer("");

        try (FileInputStream fin = new FileInputStream(folder + File.separator + fileName)) {
            byte[] buffer = new byte[2048];
            int read = 0;
            while ((read = fin.read(buffer, 0, buffer.length)) > 0) {
                result.append(new String(buffer, 0, read));
            }

            if (result.length() > 0) {
                return result;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return null;
    }

    public StringBuffer read(String fileName, ServletContext cnxt) {
        StringBuffer result = new StringBuffer();

        try (FileInputStream fin = new FileInputStream(folder + File.separator + fileName)) {
                byte[] buffer = new byte[2048];
                int read;
                while ((read = fin.read(buffer, 0, buffer.length)) > 0) {
                    result.append(new String(buffer, 0, read));
                }

                if (result.length() > 0) {
                    return result;
                }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        try {
            InputStream inputStream = cnxt.getResourceAsStream(folder + name);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            result = new StringBuffer(new String(bytes, "utf8"));
            inputStream.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return result;
    }
}

