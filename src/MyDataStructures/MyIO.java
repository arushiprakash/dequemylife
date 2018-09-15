package MyDataStructures;
import java.io.*;

public class MyIO {
    FileReader in = null;
    FileWriter out = null;

    public MyIO (Queue Q) throws IOException
    {
        File desktopDir = new File(System.getProperty("user.home"), "Desktop");
        File savedQueue = new File(desktopDir,"helloQueue.txt");

        try {
            out = new FileWriter(savedQueue.getName());
            out.write(Q.printQueue());
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
