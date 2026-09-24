import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {

    public static void main(String[] args) {

        // ==========================================
        // 1. FILE OBJECT
        // ==========================================

        File file = new File("eds-data/customer.txt");

        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());


        // ==========================================
        // 2. CHECK EXISTENCE
        // ==========================================

        System.out.println("Exists: " + file.exists());


        // ==========================================
        // 3. CREATE DIRECTORY
        // ==========================================

        File dir = new File("eds-data");

        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            System.out.println("Directory created: " + created);
        }


        // ==========================================
        // 4. CREATE FILE
        // ==========================================

        try {

            if (!file.exists()) {

                boolean created = file.createNewFile();

                System.out.println(
                        "File created: " + created
                );
            }

        } catch (IOException e) {

            e.printStackTrace();
        }


        // ==========================================
        // 5. FILE INFORMATION
        // ==========================================

        System.out.println("Is File: " + file.isFile());
        System.out.println("Is Directory: " + file.isDirectory());
        System.out.println("Size: " + file.length());
        System.out.println("Can Read: " + file.canRead());
        System.out.println("Can Write: " + file.canWrite());


        // ==========================================
        // 6. LIST DIRECTORY
        // ==========================================

        String[] names = dir.list();

        if (names != null) {

            for (String name : names) {

                System.out.println(name);
            }
        }


        // ==========================================
        // 7. LIST FILE OBJECTS
        // ==========================================

        File[] files = dir.listFiles();

        if (files != null) {

            for (File f : files) {

                System.out.println(
                        f.getName()
                        + " | File: "
                        + f.isFile()
                        + " | Directory: "
                        + f.isDirectory()
                );
            }
        }


        // ==========================================
        // 8. FILTER TXT FILES
        // ==========================================

        File[] txtFiles =
                dir.listFiles(
                        (d, name) ->
                                name.endsWith(".txt")
                );

        if (txtFiles != null) {

            for (File txtFile : txtFiles) {

                System.out.println(
                        "TXT File: "
                        + txtFile.getName()
                );
            }
        }


        // ==========================================
        // 9. FILE COPY - BUFFERED BYTE READING
        // ==========================================

        try (
                FileInputStream fis =
                        new FileInputStream("account.dat");

                FileOutputStream fos =
                        new FileOutputStream(
                                "account_copy.dat"
                        )
        ) {

            byte[] buffer = new byte[4096];

            int bytesRead;

            while (
                    (bytesRead = fis.read(buffer))
                            != -1
            ) {

                fos.write(
                        buffer,
                        0,
                        bytesRead
                );
            }

            System.out.println(
                    "File copied successfully."
            );

        } catch (IOException e) {

            e.printStackTrace();
        }


        // ==========================================
        // 10. DELETE FILE
        // ==========================================

        /*
        if (file.delete()) {
            System.out.println("File deleted.");
        } else {
            System.out.println("Delete failed.");
        }
        */
    }
}