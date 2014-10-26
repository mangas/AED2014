package tweets.backend;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by fa on 26/10/14.
 */
public class FileLoader {

    private String filename;
    private File file;
    private FileReader fr;
    private BufferedReader br;
    private boolean isClosed =false;


    public boolean isClosed() {
        return isClosed;
    }

    public FileLoader (String filename) throws FileNotFoundException {
        this.filename=filename;
        this.file=new File(filename);
        this.fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public String nextLine() {

        if (this.isClosed)
            throw new UnsupportedOperationException("File Loader is closed!");

        String res=null;

        try {
            res= br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
            close();
        }

        return res;
    }

    public String[] nextNLines(int n) {

        if (this.isClosed)
            throw new UnsupportedOperationException("File Loader is closed!");

        LinkedList<String> res = new LinkedList<String>();

        try {

            for (int i=0;i<n;i++) {
                String line = br.readLine();
                if (line==null)
                    break;
                res.addLast(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            close();
        }

        return (String[]) res.toArray();
    }

    public void close() {

        try {
            this.fr.close();
            this.br.close();
            isClosed=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
