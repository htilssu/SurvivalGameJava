package org.htilssu.utils;

public final class Path {
    /**
     * String that contain absolute root path of project
     * <p>
     * <i>example: C:/htilssu/Game</i>
     */
    public static String rootPath = System.getProperty("user.dir").replace('\\', '/');

    /**
     * Return an {@link String} object that the absolute path of resource
     *
     * @return an {@link String} url
     */
    public static String getResourcePath() {
        return rootPath + "/src/main/resources";
    }
}
