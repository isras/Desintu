/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.resources;

import java.io.File;
import java.net.URL;

/**
 *
 * @author Isra
 */
public class Utilidades {

    /** Devuelve la direccion completa del path de la aplicacion */
    private static File WORKING_DIRECTORY;

    public static File dirPath() {
        if (WORKING_DIRECTORY == null) {
            try {
                URL url = Utilidades.class.getResource("");
                if (url.getProtocol().equals("file")) {
                    File f = new File(url.toURI());
                    f=f.getParentFile().getParentFile().getParentFile();
                    WORKING_DIRECTORY = f;
                } else if (url.getProtocol().equals("jar")) {
                    String s = url.toString();
                    s = s.substring(4);
                    s = s.substring(0, s.length());
                    File f = new File(new URL(s).toURI());
                    f=f.getParentFile().getParentFile();
                    WORKING_DIRECTORY = f;
                }
            } catch (Exception e) {
                WORKING_DIRECTORY = new File(".");
            }
        }
        return WORKING_DIRECTORY;
    }    
}
