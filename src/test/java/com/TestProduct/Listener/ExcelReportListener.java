package com.TestProduct.Listener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.ScreenshotUtils;

/**
 * ExcelReportListener
 * ────────────────────
 * Writes test results to an Excel file after every run.
 *
 * HOW TO ATTACH (add to your testng.xml):
 * ─────────────────────────────────────────
 *   <listeners>
 *     <listener class-name="com.TestProduct.Listener.ExcelReportListener"/>
 *   </listeners>
 *
 * EXCEL OUTPUT
 * ─────────────
 *   Sheet 1 — Summary      : suite name, start/end time, pass/fail counts
 *   Sheet 2 — Test Results : one row per test
 *                            columns: #, Test Method, Class, Status,
 *                                     Duration, Step That Failed,
 *                                     Error Message, Screenshot Path
 *
 * FILE SAVED TO
 * ─────────────
 *   Reports/ExcelReport_HH_mm_ss_dd_MMM_yyyy.xlsx
 */
public class ExcelReportListener implements ITestListener {

    private Workbook workbook;
    private Sheet    summarySheet;
    private Sheet    resultsSheet;

    private int detailRow  = 1;   // next row to write in Test Results sheet
    private int totalCount = 0;
    private int passCount  = 0;
    private int failCount  = 0;
    private int skipCount  = 0;

    private String suiteStartTime;
    private String suiteName;

    // ── Suite starts ──────────────────────────────────────────────────────────
    @Override
    public void onStart(ITestContext context) {
        suiteName      = context.getSuite().getName();
        suiteStartTime = timestamp();

        workbook = new XSSFWorkbook();
        buildSummarySheet();
        buildResultsSheet();
    }

    // ── Each test starts ──────────────────────────────────────────────────────
    @Override
    public void onTestStart(ITestResult result) {
        totalCount++;
        BaseClass.currentStep = "Test started";
    }

    // ── Test passed ───────────────────────────────────────────────────────────
    @Override
    public void onTestSuccess(ITestResult result) {
        passCount++;
        writeResultRow(result, "PASS", "", null, null);
    }

    // ── Test failed ───────────────────────────────────────────────────────────
    // Step 9: failure screenshot is taken here and its path goes into the Excel
    @Override
    public void onTestFailure(ITestResult result) {
        failCount++;

        String errorMsg = result.getThrowable() != null
                ? result.getThrowable().getMessage() : "Unknown error";

        // Take failure screenshot — path is stored in Excel (Step 9)
        String screenshotPath = ScreenshotUtils.captureOnFailure(
                BaseClass.driver,
                result.getMethod().getMethodName(),
                BaseClass.currentStep,
                result.getThrowable());

        writeResultRow(result, "FAIL", errorMsg, screenshotPath,
                BaseClass.currentStep);
    }

    // ── Test skipped ──────────────────────────────────────────────────────────
    @Override
    public void onTestSkipped(ITestResult result) {
        skipCount++;
        writeResultRow(result, "SKIP", "Skipped", null, null);
    }

    // ── Suite finishes — fill summary and save file ───────────────────────────
    @Override
    public void onFinish(ITestContext context) {
        // Fill in summary values now that the run is done
        summarySheet.getRow(4).getCell(1).setCellValue(timestamp());
        summarySheet.getRow(6).getCell(1).setCellValue(totalCount);
        summarySheet.getRow(7).getCell(1).setCellValue(passCount);
        summarySheet.getRow(8).getCell(1).setCellValue(failCount);
        summarySheet.getRow(9).getCell(1).setCellValue(skipCount);

        saveFile();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Build Sheet 1 — Summary
    // ─────────────────────────────────────────────────────────────────────────
    private void buildSummarySheet() {
        summarySheet = workbook.createSheet("Summary");
        summarySheet.setColumnWidth(0, 7000);
        summarySheet.setColumnWidth(1, 8000);

        // Title
        Row title = summarySheet.createRow(0);
        Cell titleCell = title.createCell(0);
        titleCell.setCellValue("PrimaDiagnostics – Test Execution Report");
        titleCell.setCellStyle(makeTitleStyle());
        summarySheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));

        // Labels (values filled later in onFinish)
        labelRow(summarySheet, 2, "Suite Name",   suiteName);
        labelRow(summarySheet, 3, "Start Time",   suiteStartTime);
        labelRow(summarySheet, 4, "End Time",      "");
        labelRow(summarySheet, 6, "Total Tests",  "");
        labelRow(summarySheet, 7, "Passed",        "");
        labelRow(summarySheet, 8, "Failed",        "");
        labelRow(summarySheet, 9, "Skipped",       "");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Build Sheet 2 — Test Results header row
    // ─────────────────────────────────────────────────────────────────────────
    private void buildResultsSheet() {
        resultsSheet = workbook.createSheet("Test Results");
        resultsSheet.setColumnWidth(0,  1500);   // #
        resultsSheet.setColumnWidth(1,  6000);   // Test Method
        resultsSheet.setColumnWidth(2,  5000);   // Class
        resultsSheet.setColumnWidth(3,  3000);   // Status
        resultsSheet.setColumnWidth(4,  3500);   // Duration
        resultsSheet.setColumnWidth(5,  5000);   // Step That Failed
        resultsSheet.setColumnWidth(6,  10000);  // Error Message
        resultsSheet.setColumnWidth(7,  14000);  // Screenshot Path

        String[] headers = {
            "#", "Test Method", "Class", "Status",
            "Duration", "Step That Failed", "Error Message", "Screenshot Path"
        };
        Row header = resultsSheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell c = header.createCell(i);
            c.setCellValue(headers[i]);
            c.setCellStyle(makeHeaderStyle());
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Write one row into Test Results sheet
    // ─────────────────────────────────────────────────────────────────────────
    private void writeResultRow(ITestResult result,
                                String status,
                                String errorMsg,
                                String screenshotPath,
                                String failedStep) {
        Row row = resultsSheet.createRow(detailRow++);

        long ms = result.getEndMillis() - result.getStartMillis();

        row.createCell(0).setCellValue(detailRow - 1);
        row.createCell(1).setCellValue(result.getMethod().getMethodName());
        row.createCell(2).setCellValue(shortClassName(result.getTestClass().getName()));
        row.createCell(3).setCellValue(status);
        row.createCell(4).setCellValue(formatDuration(ms));
        row.createCell(5).setCellValue(failedStep   != null ? failedStep   : "");
        row.createCell(6).setCellValue(errorMsg     != null ? errorMsg     : "");
        row.createCell(7).setCellValue(screenshotPath != null ? screenshotPath : "");

        row.getCell(3).setCellStyle(makeStatusStyle(status));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Save workbook to disk
    // ─────────────────────────────────────────────────────────────────────────
    private void saveFile() {
        String fileName = "ExcelReport_" +
                new SimpleDateFormat("HH_mm_ss_dd_MMM_yyyy").format(new Date()) + ".xlsx";
        String path = System.getProperty("user.dir") + "/Reports/" + fileName;

        new File(System.getProperty("user.dir") + "/Reports").mkdirs();

        try (FileOutputStream out = new FileOutputStream(path)) {
            workbook.write(out);
            workbook.close();
            System.out.println("[ExcelReportListener] Report saved → " + path);
        } catch (IOException e) {
            System.err.println("[ExcelReportListener] Could not save report: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Style helpers
    // ─────────────────────────────────────────────────────────────────────────
    private CellStyle makeTitleStyle() {
        CellStyle s = workbook.createCellStyle();
        Font f = workbook.createFont();
        f.setBold(true);
        f.setFontHeightInPoints((short) 13);
        f.setColor(IndexedColors.WHITE.getIndex());
        s.setFont(f);
        s.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.CENTER);
        return s;
    }

    private CellStyle makeHeaderStyle() {
        CellStyle s = workbook.createCellStyle();
        Font f = workbook.createFont();
        f.setBold(true);
        f.setColor(IndexedColors.WHITE.getIndex());
        s.setFont(f);
        s.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setBorderBottom(BorderStyle.THIN);
        s.setAlignment(HorizontalAlignment.CENTER);
        return s;
    }

    private CellStyle makeStatusStyle(String status) {
        CellStyle s = workbook.createCellStyle();
        Font f = workbook.createFont();
        f.setBold(true);
        f.setColor(IndexedColors.WHITE.getIndex());
        s.setFont(f);
        s.setAlignment(HorizontalAlignment.CENTER);
        switch (status) {
            case "PASS": s.setFillForegroundColor(IndexedColors.GREEN.getIndex());  break;
            case "FAIL": s.setFillForegroundColor(IndexedColors.RED.getIndex());    break;
            default:     s.setFillForegroundColor(IndexedColors.ORANGE.getIndex()); break;
        }
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return s;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Small utilities
    // ─────────────────────────────────────────────────────────────────────────
    private void labelRow(Sheet sheet, int rowNum, String label, String value) {
        Row row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(label);
        row.createCell(1).setCellValue(value);
    }

    private String timestamp() {
        return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    }

    private String formatDuration(long ms) {
        return (ms / 1000) + "s " + (ms % 1000) + "ms";
    }

    private String shortClassName(String fullName) {
        return fullName.contains(".") ? fullName.substring(fullName.lastIndexOf('.') + 1) : fullName;
    }
}
