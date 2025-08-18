package tests;

import com.opencsv.CSVReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.apache.pdfbox.Loader;

public class FilesInZipParsingTest {

  private final ClassLoader cl = FilesInZipParsingTest.class.getClassLoader();

  private byte[] readEntryBytes(ZipInputStream zis) throws Exception {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    byte[] temp = new byte[1024];
    int read;
    while ((read = zis.read(temp)) != -1) {
      buffer.write(temp, 0, read);
    }
    return buffer.toByteArray();
  }

  @Test
  void zipFileParsingTest() throws Exception {
    try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("test_data/sample.zip"))) {
      ZipEntry entry;

      while ((entry = zis.getNextEntry()) != null) {
        if (entry.getName().equals("SearchResultShouldContainExpectedUrl.csv")) {
          byte[] csvBytes = readEntryBytes(zis);
          try (CSVReader csvReader = new CSVReader(
              new InputStreamReader(new ByteArrayInputStream(csvBytes), StandardCharsets.UTF_8))) {
            List<String[]> data = csvReader.readAll();
            Assertions.assertEquals(2, data.size());
            Assertions.assertArrayEquals(new String[]{"Selenide", "https://selenide.org"},
                data.get(0));
            Assertions.assertArrayEquals(new String[]{"JUnit 5", "https://junit.org"}, data.get(1));
          }
          if (entry.getName().equals("toDoList.xlsx")) {
            byte[] xlsxBytes = readEntryBytes(zis);
            try (XSSFWorkbook xlsx = new XSSFWorkbook(new ByteArrayInputStream(xlsxBytes))) {
              String actualValue = xlsx.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
              Assertions.assertTrue(actualValue.contains("Список"));
            }
          }
          if (entry.getName().equals("Pushkin_Evgenyi_Onegin.pdf")) {
            byte[] pdfBytes = readEntryBytes(zis);
            try (PDDocument pdf = Loader.loadPDF(pdfBytes)) {
              PDFTextStripper pdfStripper = new PDFTextStripper();
              String text = pdfStripper.getText(pdf);
              Assertions.assertTrue(text.contains("Роман в стихах 1823-1831"));
              Assertions.assertEquals("Александр Пушкин", pdf.getDocumentInformation().getAuthor());
            }
          }
        }
      }
    }
  }
}
