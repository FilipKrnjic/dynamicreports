package com.home.report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;

public class ColReport {

    
    public static void main(String[] args) throws DRException {
        JasperReportBuilder repo = report();
        
        repo.pageHeader(cmp.text("Code Auswertung"));
        repo.detail(cmp.subreport(getSubReportAW()));
        repo.setDataSource(new JREmptyDataSource());
        repo.show();
            
    }
   
    public static JasperReportBuilder getSubReportAW() {
        JasperReportBuilder sub = report();
        sub.pageHeader(cmp.text("Kostenstelle: ......"));
        String [] dataString = new String [] {"a", "b", "c", "d", "e"};
         
               
        
        DRDataSource ds = new DRDataSource(dataString);
        ds.add("", "2", "3", "4", "5");
        ds.add("a", "b", "c", "d", "e");
        ds.add("", "B", "C", "D", "E");
        
        sub.setDataSource(ds);
        TextFieldBuilder tfb = cmp.text("asdf");
        
        TextColumnBuilder [] cb = new TextColumnBuilder [5];
        cb[0] =   col.column("a", "a", type.stringType());     
        cb[1] =   col.column("b", "b", type.stringType());
        cb[2] =   col.column("c", "c", type.stringType());
        cb[3] =   col.column("d", "d", type.stringType());
        cb[4] =   col.column("e", "e", type.stringType());
        
        
     
        ConditionalStyleBuilder csb = stl.conditionalStyle(cnd.equal(cb[0], "")).setBackgroundColor(Color.BLUE);
        StyleBuilder format = stl.style(stl.style().setBackgroundColor(Color.darkGray)).conditionalStyles(csb);
        
        cb[0].setStyle(format);
        
        
        sub.addColumn(cb[0]);
        sub.addColumn(cb[1]);
        sub.addColumn(cb[2]);
        sub.addColumn(cb[3]);
        sub.addColumn(cb[4]);
        
        return sub;
    }
}
