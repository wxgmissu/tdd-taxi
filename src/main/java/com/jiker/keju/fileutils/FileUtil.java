package com.jiker.keju.fileutils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wxg
 * @creat 2020-03-01 15:54
 */
public class FileUtil {
    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public List<String> readTaxiInput(String fileName) {
        List<String> content = new ArrayList<>();
        try {
            Stream<String> linesStream = Files.lines(Paths.get(fileName));
            linesStream.forEach(line -> content.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 判断输入
     * @param input
     * @return
     */
    public List<String> judgeTaxiInput(String input) {
        List<String> taxiInput = new ArrayList<>();
        String miles = input.substring(0, input.indexOf(","));
        String waitTime = input.substring(input.indexOf(",") + 1, input.length());
        miles = (Character.isDigit(miles.charAt(1)) ? miles.substring(0, 2) : miles.substring(0, 1));
        taxiInput.add(miles);
        waitTime = ((Character.isDigit(waitTime.charAt(3)) ? waitTime.substring(2, 4) : waitTime.substring(2, 3)));
        taxiInput.add(waitTime);
        return taxiInput;
    }
}
