package com.heyufei.common.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeYuFei
 * @since 2023-03-30  10:07
 */
public class SafeUtil {

    private SafeUtil() {
    }

    /**
     * 允许上传的安全后缀常量
     */
    private static final List<String> SAFE_FILE_SUFFIXES = Arrays.asList("xml", "dat", "html", "txt",
            "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf",
            "zip", "rar", "7z", "cert",
            "bmp", "jpg", "gif", "png", "jpeg", "svg", "psd", "bak", "tif", "tiff", "ico");

    /**
     * 判断路径是否有效(不包括文件名)
     *
     * @param path 路径
     */
    public static boolean safePath(String path) {
        if (path.contains("../") || path.contains("..\\") || path.contains("./ \\.") || path.contains("..\\/") ||
                path.contains(">") || path.contains("<") || path.contains(":") || path.contains("?") || path.contains("*") ||
                path.contains("|") || path.contains("&") ||
                path.contains("%2e%2e%2f") ||
                path.contains("%252e%252e%252f") || path.contains("%c0%ae%c0%ae%c0%af") ||
                path.contains("%uff0e%uff0e%u2215") || path.contains("%uff0e%uff0e%u2216")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean safeIds(String ids) {
        String whiteList = "[1234567890,]";
        if (ids != null) {
            char[] safeCommandChars = ids.toCharArray();
            for (char safeCommandChar : safeCommandChars) {
                int whiteListIndex = whiteList.indexOf(safeCommandChar);
                if (-1 == whiteListIndex) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断文件名是否有效(不包括文件路径和扩展名)
     *
     * @param fileName 文件名
     */
    public static boolean safeFile(String fileName) {
        if (fileName.contains("../") || fileName.contains("..\\") || fileName.contains("./ \\.") ||
                fileName.contains("..\\/") || fileName.contains("%2e%2e%2f") ||
                fileName.contains("%252e%252e%252f") || fileName.contains("%c0%ae%c0%ae%c0%af") ||
                fileName.contains("%uff0e%uff0e%u2215") || fileName.contains("%uff0e%uff0e%u2216")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 校验 文件名+文件扩展名 的合法性
     *
     * @param fileName 文件名
     */
    public static boolean safeNameAndSuffix(String fileName) {
        if (fileName == null) {
            return false;
        }
        //效验文件名
        if (!safeFile(fileName)) {
            return false;
        }
        //效验扩展名
        if (!safeFileSuffix(fileName)) {
            return false;
        }
        return true;
    }

    /**
     * 效验文件名的扩展名
     *
     * @param fileName 文件名
     * @return
     */
    public static boolean safeFileSuffix(String fileName) {
        //取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase().trim();

        if (!SAFE_FILE_SUFFIXES.contains(fileSuffix)) {
            return false;
        }
        return true;
    }


    /**
     * 判断链接是否有效
     *
     * @param urlString          url
     * @param timeOutMillSeconds 超时时间
     */
    public static boolean safeUrl(String urlString, int timeOutMillSeconds) {
        URL url;
        try {
            url = new URL(urlString);
            URLConnection co = url.openConnection();
            co.setConnectTimeout(timeOutMillSeconds);
            co.connect();
            return true;
        } catch (Exception e1) {
            return false;
        }
    }

}
