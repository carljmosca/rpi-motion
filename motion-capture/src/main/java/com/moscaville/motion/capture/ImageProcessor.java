/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.motion.capture;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moscac
 */
public class ImageProcessor {
    
    private final String IMAGE_DIRECTORY = "IMAGE_DIRECTORY";

    public void run() {
        try {
            String directory = System.getenv(IMAGE_DIRECTORY) != null ? System.getenv(IMAGE_DIRECTORY) : ".";
            List<Path> files = listSourceFiles(Paths.get(directory));
            for (Path file : files) {
                System.out.println(file.getFileName());
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private List<Path> listSourceFiles(Path dir) throws IOException {
        List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{jpeg,jpg}")) {
            for (Path entry : stream) {
                result.add(entry);
            }
        } catch (DirectoryIteratorException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
