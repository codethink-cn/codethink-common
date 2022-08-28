package cn.codethink.common.util;

import java.io.IOException;
import java.io.Reader;

public class Readers {
    
    private Readers() {
        Exceptions.throwUtilClassInitializeException(Readers.class);
    }
    
    /**
     * 读取字符输入流的所有字符，不会关闭字符输入流
     *
     * @param reader 字符输入流
     * @return 所有字符
     * @throws IOException 读取时出现的异常
     */
    public static String readAll(Reader reader) throws IOException {
        Preconditions.objectNonNull(reader, "reader");
        
        int length;
        
        final StringBuilder stringBuilder = new StringBuilder();
        final char[] buffer = new char[1024];
        
        while ((length = reader.read(buffer)) != -1) {
            stringBuilder.append(buffer, 0, length);
        }
        return stringBuilder.toString();
    }
    
    /**
     * 读取字符输入流的所有字符，并关闭字符输入流
     *
     * @param reader 字符输入流
     * @return 所有字符
     * @throws IOException 读取时出现的异常
     */
    public static String readAllThenClose(Reader reader) throws IOException {
        final String string = readAll(reader);
        reader.close();
        return string;
    }
}
