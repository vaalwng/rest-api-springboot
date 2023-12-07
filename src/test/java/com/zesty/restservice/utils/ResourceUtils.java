package com.zesty.restservice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.parallel.Resources;

public interface ResourceUtils {

    /**
     * Reads the specified file and parses as a String, if possible
     * @param path file path
     * @return String conversion of file
     * @throws IOException
     */
    static String resourceToString(String path) throws IOException {
        return IOUtils.toString(resourceStream(path), StandardCharsets.UTF_8);
    }

    /**
     * Reads the specified file and parses as a byte array, if possible
     * @param path file path
     * @return bytes conversion of file
     * @throws IOException
     */
    static byte[] resourceToBytes(String path) throws IOException {
        return IOUtils.toByteArray(resourceStream(path));
    }

    /**
     * Gets resource based on specified file and returns an InputStream
     * @param path file path
     * @return InputStream of file
     */
    static InputStream resourceStream(String path) {
        return Resources.class.getResourceAsStream(path);
    }

    /**
     * Gets resource based on specified file and returns a URL
     * @param path file path
     * @return URL of file
     */
    static URL resourceUrl(String path) {
        return Resources.class.getResource(path);
    }

}
