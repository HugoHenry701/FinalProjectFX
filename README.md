# FinalProjectFX

Setup section:
  1.Libraries:
      - JDK 10: https://www.oracle.com/java/technologies/java-archive-javase10-downloads.html
      - openjfx 11: https://gluonhq.com/products/javafx/
  2.Compile:
      - Add VM: 
          + Run/Debug Configurations/Modify options/Add VM options: paste this --module-path "${insert the path to the lib of openjfx}" --add-modules javafx.controls,javafx.fxml
