package lectura.application;

import java.io.File;

public interface FileRepository {

    public File recoverFile ();

    public void publishFile (File file);

}
