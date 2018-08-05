/**
 * 
 */
package com.zxz.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author zhaoxuezhong
 *
 */
public class ExportData {

	/**
	 * @param head
	 *            数据头
	 * @param body
	 *            主体数据 创建excel并填入数据
	 * @throws ClassNotFoundException
	 */
	public HSSFWorkbook expExcel(List<String> heads, List<List<Object>> bodys, String excelName)
			throws ClassNotFoundException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(excelName);

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		setBorderStyle(cellStyle, BorderStyle.THIN);
		cellStyle.setFont(setFontStyle(workbook, "黑体", (short) 14));
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		for (int i = 0; i < heads.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(heads.get(i));
			cell.setCellStyle(cellStyle);
		}

		HSSFCellStyle cellStyle2 = workbook.createCellStyle();
		setBorderStyle(cellStyle2, BorderStyle.THIN);
		cellStyle2.setFont(setFontStyle(workbook, "宋体", (short) 12));
		cellStyle2.setAlignment(HorizontalAlignment.CENTER);
		for (int i = 0, isize = bodys.size(); i < isize; i++) {
			row = sheet.createRow(i + 1);
			List<Object> info = (List<Object>) bodys.get(i);
			for (int j = 0, jsize = info.size(); j < jsize; j++) {
				cell = row.createCell(j);
				Object obj = info.get(j);
				if (obj instanceof Number) {
					cell.setCellValue(((Number) obj).doubleValue());
				} else if (obj instanceof String) {
					cell.setCellValue(obj.toString());
				} else if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				}
				cell.setCellStyle(cellStyle2);
			}
		}
		for (int i = 0, isize = heads.size(); i < isize; i++) {
			sheet.autoSizeColumn(i);
		}
		return workbook;
	}

	/**
	 * 文件输出
	 * 
	 * @param workbook
	 *            填充好的workbook
	 * @param path
	 *            存放的位置
	 */
	public void outFile(HSSFWorkbook workbook, String path) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File(path));
			workbook.write(os);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置字体样式
	 * 
	 * @param workbook
	 *            工作簿
	 * @param name
	 *            字体类型
	 * @param height
	 *            字体大小
	 * @return HSSFFont
	 */
	private HSSFFont setFontStyle(HSSFWorkbook workbook, String name, short height) {
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints(height);
		font.setFontName(name);
		return font;
	}

	/**
	 * 设置单元格样式
	 * 
	 * @param workbook
	 *            工作簿
	 * @param border
	 *            border样式
	 */
	private void setBorderStyle(HSSFCellStyle cellStyle, BorderStyle border) {
		cellStyle.setBorderBottom(border); // 下边框
		cellStyle.setBorderLeft(border);// 左边框
		cellStyle.setBorderTop(border);// 上边框
		cellStyle.setBorderRight(border);// 右边框
	}

	/**
	 * 导出pdf
	 */
	public void exportPDF(int width,String headName, String path, List<String> heads, List<List<Object>> bodys) {
		BaseFont bfChinese = null;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		Font FontChinese = new Font(bfChinese, 22, Font.BOLDITALIC);
		Font FontChinese1 = new Font(bfChinese, 18, Font.BOLD);
		// 这里设置需要的的字体类型，在初始的字体里面修改，保证一下统一以便字体结构清晰。
		Font FontChinese2 = new Font(bfChinese, 13, Font.NORMAL);
		// 第一步，创建document对象
		Rectangle rectPageSize = new Rectangle(PageSize.A4);// 这里可以查查，有很多其他的
		// 下面代码设置页面横置
		rectPageSize = rectPageSize.rotate();
		// 创建document对象并指定边距
		Document document1 = new Document(rectPageSize);
		// 将Document实例和文件输出流用PdfWriter类绑定在一起，从而完成向Document写，即写入PDF文档
		try {
			PdfWriter.getInstance(document1, new FileOutputStream(path));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (DocumentException e1) {
			e1.printStackTrace();
		} // 创建到哪个路径文件中
			// 打开文档
		document1.open();
		
		PdfPTable table = new PdfPTable(width);// 这个可以在页面画一个table，很方便并且比较好的方法

		table.setWidthPercentage(100);// 设置占比
		table.setSpacingBefore(10);// 设置上边距离上个Paragraph的距离
		table.setSpacingAfter(10);// 设置下边距离下个Paragraph的距离

		PdfPCell cell = new PdfPCell();
		cell.setColspan(3);
		cell.setBackgroundColor(new BaseColor(239,239,239));
		Paragraph p=new Paragraph(headName, FontChinese);
		p.setAlignment(Element.ALIGN_MIDDLE);
		p.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(p);
		table.addCell(cell);
		for (int i = 0; i < heads.size(); i++) {
			PdfPCell cell1 = new PdfPCell();
			Paragraph p1=new Paragraph(heads.get(i), FontChinese1);
			p1.setAlignment(Element.ALIGN_CENTER);
			cell1.addElement(p1);
			table.addCell(cell1);
		}
		
		for (int i = 0; i < bodys.size(); i++) {
			List<Object> info = (List<Object>) bodys.get(i);
			for (int j = 0; j< info.size(); j++) {
				PdfPCell cell1 = new PdfPCell();
				Paragraph p2=new Paragraph(info.get(j).toString(), FontChinese2);
				p2.setAlignment(Element.ALIGN_CENTER);
				cell1.addElement(p2);
				table.addCell(cell1);
			}
		}

		try {
			document1.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 关闭document
		document1.close();

	}
}
