package org.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.model.TbStudent;

import com.opensymphony.xwork2.ActionContext;

public class DataToExcelFile {
    public boolean readDataToExcelFile(List<TbStudent> list,OutputStream os){
		
		 //	FileInputStream fs=new FileInputStream(xlsFile);
		//	WritableWorkbook book=Workbook.createWorkbook(file);		
  //  		WritableWorkbook book =  Workbook.createWorkbook(xlsFile, Workbook.getWorkbook(xlsFile)); //这样你就可以操作你之前已存在的表。
    	//	WritableWorkbook book=Workbook.createWorkbook(Workbook.getWorkbook(xlsFile));		
    //	 	WritableWorkbook book=Workbook.createWorkbook(new File("E:\\test\\学生成绩.xls"));

            // 生成EXCEL文件  
    		WritableWorkbook book = null;  
    		try {  
    	    book = Workbook.createWorkbook(os);  
     		WritableSheet sheet=book.createSheet("学生成绩", 0);
    		jxl.write.WritableFont font=new jxl.write.WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN);
    		jxl.write.WritableCellFormat cellFormat=new jxl.write.WritableCellFormat(font);
    		cellFormat.setAlignment(Alignment.CENTRE);
    		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
    		cellFormat.setBackground(Colour.BLUE_GREY);
    		Label label_title=new Label(0,0,"学生成绩表",cellFormat);
    		sheet.mergeCells(0,0,3,0);
    		sheet.setRowView(0,500,false);
    		Label label_id=new Label(0,1,"学号");
    		Label label_name=new Label(1,1,"姓名");
    		Label label_class=new Label(2,1,"班级");
    		Label label_grade=new Label(3,1,"成绩");
    		sheet.setColumnView(4,15);
    		sheet.addCell(label_title);
    		sheet.addCell(label_id);
    		sheet.addCell(label_name);
    		sheet.addCell(label_class);
    		sheet.addCell(label_grade);
    		for(int i=0;i<list.size();i++){
    			TbStudent stu=list.get(i);
    			Label id_value=new Label(0,i+2,stu.getStudentId());
    			Label name_value=new Label(1,i+2,stu.getStudentName());
    			Label class_value=new Label(2,i+2,stu.getTbclass().getClassName()); //改
    			Label grade_value;
    			if(stu.getTotalGrade()==null){
    				grade_value=new Label(3,i+2,"0");
    			}
    			else{
    			grade_value=new Label(3,i+2,stu.getTotalGrade().toString());
    			}
    			sheet.addCell(id_value);
    			sheet.addCell(name_value);
    			sheet.addCell(class_value);
    			sheet.addCell(grade_value);
    			
    		} 
       		book.write(); //从内存中写入文件中   
    		book.close(); //关闭资源，释放内存      
    		os.flush();
    		os.close();
    		return true;
    	  
    		
    	}catch(Exception e){
    		System.out.println("异常信息："+e.getMessage());
    		e.printStackTrace();
    	return false;
    	
    	}
		
    	
    }
}
