package com.github.mdssjc.fpij;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFiles {

  public static void main(String[] args) throws IOException {

    {
      final String[] files = new File("fpij").list(
          new java.io.FilenameFilter() {

            public boolean accept(final File dir, final String name) {
              return name.endsWith(".java");
            }
          });
      /*
       * System.out.println(files);
       */
    }

    Files.newDirectoryStream(
        Paths.get("fpij"), path -> path.toString()
                                       .endsWith(".java"))
         .forEach(System.out::println);
  }
}
