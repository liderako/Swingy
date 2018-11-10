package com.student.asvirido.swingy.module.file;
import java.io.*;

public class FileManager {
    static public final String fileName = "data.save";
    private static FileWriter writer;

    public FileManager() {
        try {
            createWriter();
        } catch(IOException e) {
            return ;
        }
    }

    public String readFile(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everyThing = sb.toString();
            br.close();
            return (everyThing);
        } catch(FileNotFoundException e) {
            throw new FileNotFoundException("not found file");
        }
    }

    public void writeFile(String line) throws IOException {
        try {
            writer.write(line);
        } catch(IOException ex){
            throw new IOException("Error writeFile");
        }
    }

    public void closeFile() throws IOException {
        try {
            writer.close();
        } catch(IOException ex){
            throw new IOException("Error closeFile");
        }
    }

    public void deleteFile() {
        File file = new File(fileName);

        file.delete();
    }

    private void createWriter() throws IOException {
        writer = new FileWriter(this.fileName, true);
    }

    public String getFileName() {
        return (fileName);
    }
}