package com.cakestore.qlbanh.utilities.excel;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.cakestore.qlbanh.bus.KhuyenMaiBUS;
import com.cakestore.qlbanh.models.KhuyenMaiModel;

public class KhuyenMaiExcelUtil extends ExcelUtil {

    private static final String[] EXCEL_EXTENSIONS = { "xls", "xlsx", "xlsm" };
    private static final Logger LOGGER = Logger.getLogger(KhuyenMaiExcelUtil.class.getName());

    public static List<KhuyenMaiModel> readKhuyenMaiModelsFromExcel() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File", EXCEL_EXTENSIONS);
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            String filePath = inputFile.getAbsolutePath();

            try {
                List<List<String>> data = ExcelUtil.readExcel(filePath, 0);
                List<KhuyenMaiModel> KhuyenMaiModels = convertToKhuyenMaiModelList(data);

                JOptionPane.showMessageDialog(null,
                        "Data has been read successfully from " + inputFile.getName() + ".");
                return KhuyenMaiModels;
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error occurred while reading data from file: " + inputFile.getName(), e);
                showErrorDialog(e.getMessage(), "File Input Error");
                throw e;
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.SEVERE, "Error occurred while converting data to KhuyenMaiModel: " + e.getMessage());
                showErrorDialog(e.getMessage(), "Data Conversion Error");
                throw e;
            }
        }

        return null;
    }

    private static void showErrorDialog(String message, String title) {
        LOGGER.log(Level.WARNING, "Error occurred: " + message);
        JOptionPane.showMessageDialog(null, "Error: " + message, title, JOptionPane.ERROR_MESSAGE);
    }

    private static List<KhuyenMaiModel> convertToKhuyenMaiModelList(List<List<String>> data) {
        List<KhuyenMaiModel> KhuyenMaiModels = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            String id = row.get(0);
            String tenKhuyenMai = row.get(1);
            float dieuKien;
            try {
                dieuKien = Integer.parseInt(row.get(2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid integer value in input data", e);
            }
            float phanTramGiamGia;
            try {
                phanTramGiamGia = Integer.parseInt(row.get(3));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid integer value in input data", e);
            }
            Date ngayBatDau;
            try {
                ngayBatDau = (Date) dateFormat.parse(row.get(4));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date value in input data", e);
            }
            Date ngayKetThuc;
            try {
                ngayKetThuc = (Date) dateFormat.parse(row.get(5));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date value in input data", e);
            }

            KhuyenMaiModel model = new KhuyenMaiModel(id, tenKhuyenMai, dieuKien, phanTramGiamGia, ngayBatDau,
                    ngayKetThuc);
            KhuyenMaiModels.add(model);
            KhuyenMaiBUS.getInstance().addModel(model);
        }

        return KhuyenMaiModels;
    }

    public static void writeKhuyenMaiModelsToExcel(List<KhuyenMaiModel> KhuyenMaiModels) throws IOException {
        List<List<String>> data = new ArrayList<>();

        // Create header row
        List<String> headerValues = Arrays.asList("Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện", "% giảm giá",
                "Ngày bắt đầu", "Ngày kết thúc");
        data.add(headerValues);

        // Write data rows
        for (KhuyenMaiModel KhuyenMaiModel : KhuyenMaiModels) {
            List<String> values = Arrays.asList(
                    String.valueOf(KhuyenMaiModel.getId()),
                    KhuyenMaiModel.getTenKhuyenMai(),
                    String.valueOf(KhuyenMaiModel.getDieuKien()),
                    String.valueOf(KhuyenMaiModel.getPhanTramGiamGia()),
                    String.valueOf(KhuyenMaiModel.getNgayBatDau()),
                    String.valueOf(KhuyenMaiModel.getNgayKetThuc()));
            data.add(values);
        }

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File", EXCEL_EXTENSIONS);
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File outputFile = fileChooser.getSelectedFile();
            String filePath = outputFile.getAbsolutePath();

            if (!filePath.endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            if (outputFile.exists()) {
                int overwriteOption = JOptionPane.showConfirmDialog(null,
                        "The file already exists. Do you want to overwrite it?", "File Exists",
                        JOptionPane.YES_NO_OPTION);
                if (overwriteOption == JOptionPane.NO_OPTION) {
                    return;
                }
            }

            try {
                writeExcel(data, filePath, "Danh sach Khuyen Mai");
                JOptionPane.showMessageDialog(null,
                        "Data has been written successfully to " + outputFile.getName() + ".");
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error occurred while writing data to file: " + outputFile.getName(), e);
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Output Error",
                        JOptionPane.ERROR_MESSAGE);
                throw e;
            }
        }
    }

}