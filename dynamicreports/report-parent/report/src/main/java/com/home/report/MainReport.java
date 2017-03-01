package com.home.report;

import com.home.report.model.DataRow;
import com.home.report.styles.Style;
import java.awt.Color;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

public class MainReport {

    static int count = 0;
    /**
     * @param args the command line arguments
     * @throws net.sf.dynamicreports.report.exception.DRException
     * @throws net.sf.jasperreports.engine.JRException
     */
    public static void main(String[] args) throws DRException, JRException {
        Style style = new Style();
        JasperReportBuilder mainReport = report();
        TextFieldBuilder<String> topic = cmp.text("Gesamtübersicht").setStyle(style.CenMidTxt);
        
        mainReport.setPageFormat(PageType.A5, PageOrientation.LANDSCAPE);
        mainReport.detail(cmp.subreport(getReport()), cmp.subreport(getReport()));
        mainReport.title(topic);
        mainReport.setDataSource(new JREmptyDataSource());
        mainReport.show();
    }
    
    public static JasperReportBuilder getReport() throws JRException {
        JasperReportBuilder rep = report();
        DataRow row = new DataRow();
        row.setPers(new String[] {"Filip", "Max", "Thomas"});
        row.setMate(new String[] {"mate1", "mate2", "mate3"});
        row.setGerat(new String[] {"gerat1", "gerat2", "gerat3"});
        
        HorizontalListBuilder pers = cmp.horizontalFlowList();
        HorizontalListBuilder gera = cmp.horizontalFlowList();
        HorizontalListBuilder mate = cmp.horizontalFlowList();
        HorizontalListBuilder rowHeader = cmp.horizontalList(pers, gera, mate);
        
        for(String p: row.getPers()) {
            pers.add(getCellLabel(p, Color.YELLOW));
        }
        
        for(String g: row.getGerat()) {
            gera.add(getCellLabel(g, Color.ORANGE));
        } 
        
        for(String p: row.getMate()) {
            mate.add(getCellLabel(p, Color.GREEN));
        } 
        
        rep.pageHeader(cmp.horizontalList(cmp.text("Kostenstelle"), cmp.horizontalList(rowHeader)));
        rep.detail(cmp.text("Daten.....................\n...................."));
       
        rep.setDataSource(new JREmptyDataSource());
        rep.setPageFormat(PageType.A5);
        return rep;
    }

    private static TextFieldBuilder getCellLabel(String label, Color color) {
        TextFieldBuilder tf = cmp.text(label);
        StyleBuilder style = stl
                .style(stl.style().setBorder(stl.penDotted()))
                .setBackgroundColor(color)
                .setRotation(Rotation.RIGHT);
        tf.setStyle(style.setTextAlignment(
                HorizontalTextAlignment.RIGHT, 
                VerticalTextAlignment.MIDDLE));
        tf.setFixedHeight(100);
        tf.setFixedWidth(25);
        return tf;
    }
    
}
