package homework.Lesson11;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class Lesson11_1 {
    private static @Nullable String searchForFile(@NotNull File currentFolder, String fileName) {
        File[] children = currentFolder.listFiles();
        if (children == null)
            return null;
        for (File child : children) {
            if (child.isFile() && child.getName().contentEquals(fileName))
                return child.getAbsolutePath();
            if (child.isDirectory()) {
                String ans = searchForFile(child, fileName);
                if (ans != null)
                    return ans;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        final String rootPath = "D:/", fileName = "卸载程序.exe";
        File root = new File(rootPath);
        System.out.println(searchForFile(root, fileName));
    }
}
