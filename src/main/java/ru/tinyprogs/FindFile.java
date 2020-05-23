package ru.tinyprogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 14.10.2016.
 */
public class FindFile {

    private File fileFound = null;

    public FindFile() {
        Folder folder = new Folder("C://");
        File found = find(folder, "Mozilla Firefox.lnk");
        if (found == null) {
            System.out.println("File not found on a requested drive !");
        } else {
//            System.out.println(found.getName());
            System.out.println("File \"" + fileFound.getName()
                    + "\" is found in a folder \"" +
                    fileFound.getAbsolutePath().substring(0,
                            fileFound.getAbsolutePath().lastIndexOf('\\')) + "\"");
        }
    }

    private File find(Folder folder, String name) {

        Folder[] subFolders = folder.getSubFolders();
        File[] files = folder.getFiles();

        if (files != null)
            for (File file : files) {
//                System.out.println("\t|" + file.getName() + "|" + name);
                if (file.getName().equals(name)) {
                    fileFound = file;
                    return file;
                }
            }
        System.out.println("Not found in " + folder.getFolderName());
        if (subFolders != null
                && fileFound == null) {
            for (int i = 0; i < subFolders.length; i++) {
                find(subFolders[i], name);
            }
        }

        return fileFound;
    }
}

class Folder {

    private List<File> files = new ArrayList<>();
    private List<File> folders = new ArrayList<>();
    private File currentFolder;

    public Folder() {
    }

    public Folder(File file) {
        currentFolder = file;
    }

    public Folder(String path) {
        currentFolder = new File(path);
        if (!currentFolder.exists()) {
            System.out.println("No such folder - " + path);
            System.err.println("No such folder - " + path);
            System.exit(1);
        }
    }

    public void printStuff() {
        System.out.println("Files are: ");
        for (File file : files) {
            System.out.print(file + ", ");
        }
        System.out.println();
        System.out.println("Folders are: ");
        for (File file : folders) {
            System.out.print(file + ", ");
        }
    }

    public Folder[] getSubFolders() {
        List<Folder> folders = new ArrayList<>();
        Folder[] foldersArr;
        int i = 0;
        if (currentFolder.listFiles() == null) {
            return null;
        }
        for (File file : currentFolder.listFiles()) {
            if (file.isDirectory()) {
                folders.add(new Folder(file));
            }
        }
        foldersArr = new Folder[folders.size()];
        for (Folder folder : folders) {
            foldersArr[i] = folder;
            i++;
        }
        return foldersArr;
    }

    public File[] getFiles() {
        List<File> files = new ArrayList<>();
        File[] filesArr;
        int i = 0;
        if (currentFolder.listFiles() == null) {
            return null;
        }
        for (File file : currentFolder.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        filesArr = new File[files.size()];
        for (File file : files) {
            filesArr[i] = file;
            i++;
        }
        return filesArr;
    }

    public File getFolderName() {
        return currentFolder;
    }

}
