package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import components.Files;
import entities.Project;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadFilesTest {
    ClassLoader classLoader = ReadFilesTest.class.getClassLoader();
    final String FILE = "zipTest.zip";

    @Test
    void readCsvFromZip() throws IOException, CsvException {
        try (ZipInputStream zis = new ZipInputStream(Objects.requireNonNull(classLoader.getResourceAsStream(FILE)));
             CSVReader csvReader = new CSVReader(new InputStreamReader(zis, UTF_8))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (Files.getFileExtension(entry.getName()).equals("csv")) {
                    List<String[]> result = csvReader.readAll();
                    assertThat(result).contains(
                            new String[]{"teacher", "lesson", "date"},
                            new String[]{"Tuchs", "junit", "03.06"},
                            new String[]{"Eroshenko", "allure", "07.06"});
                }
            }
        }
    }

    @Test
    void readPdfFromZip() throws IOException {
        try (ZipInputStream zis = new ZipInputStream(Objects.requireNonNull(classLoader.getResourceAsStream(FILE)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (Files.getFileExtension(entry.getName()).equals("pdf")) {
                    PDF pdf = new PDF(zis.readAllBytes());
                    assertThat(pdf.text).contains(
                            "Сертифицированный тестировщик",
                            "Программа обучения Базового уровня",
                            "Версия 2018"
                    );
                }
            }
        }
    }

    @Test
    void readExcelFromZip() throws IOException {
        try (ZipInputStream zis = new ZipInputStream(Objects.requireNonNull(classLoader.getResourceAsStream(FILE)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (Files.getFileExtension(entry.getName()).equals("xls")) {
                    XLS xls = new XLS(zis.readAllBytes());
                    assertThat(
                            xls.excel.getSheetAt(0)
                                    .getRow(0)
                                    .getCell(1)
                                    .getStringCellValue()
                    ).contains("ИНН поставщика");
                }
            }
        }
    }

    @Test
    void readJson() throws IOException {
        try (InputStream is = classLoader.getResourceAsStream("testJson.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Project project = mapper.readValue(Objects.requireNonNull(is).readAllBytes(), Project.class);
            assertThat(project.getTests()).contains(
                    "HomeworkSelenide1Test",
                    "HomeworkSelenide2Test"
            );
            assertThat(project.getObjects().getPages()).contains(
                    "PracticeFormPage"
            );
        }
    }
}
