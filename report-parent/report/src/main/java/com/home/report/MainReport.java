package com.home.report;

import com.home.report.styles.Style;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.component.DRTextField;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.TotalPagesBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

public class MainReport {

    static int count = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DRException {
        Style style = new Style();
        JasperReportBuilder mainReport = report();
        TextFieldBuilder<String> topic = cmp.text("Gesamtübersicht").setStyle(style.CenMidTxt);
        HorizontalListBuilder reps = cmp.horizontalList();
        VerticalListBuilder vList1 = cmp.verticalList();
        VerticalListBuilder vList2 = cmp.verticalList();
        
        List<Kost> kost = new ArrayList();
        
        kost.add(new Kost("", ""));
        kost.add(new Kost("YES", "NO"));
        //kost.add(new Kost("SONNE", "MOND"));
        
        for(Kost k: kost ){
            vList1.add(cmp.subreport(getReport(k)));
            vList1.setStyle(stl.style().setBorder(stl.pen1Point()));
            vList1.setWidth(70);
        }

        reps.add(vList1);
        
//        mainReport.pageHeader(cmp.horizontalList(cmp.text("Header")).setStyle(stl.style().setBackgroundColor(Color.GRAY)));
//        mainReport.pageFooter(cmp.horizontalList(cmp.text("Footer")).setStyle(stl.style().setBackgroundColor(Color.GRAY)));
        mainReport.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        mainReport.detail(reps);
        mainReport.setDataSource(new JREmptyDataSource());
        mainReport.show();
    }
    
    public static JasperReportBuilder getReport(Kost kost) {
        JasperReportBuilder rep = report();
       
        rep.pageHeader(cmp.horizontalList(cmp.text(kost.getkID()), cmp.text(kost.getKost()), getWorker(kost.getArbeiter())));
        rep.columns(col.componentColumn("asfdd", cmp.verticalList(cmp.text(kost.getKost()))));
        
        rep.setPageFormat(PageType.A5, PageOrientation.PORTRAIT);
        rep.setDataSource(getDS());
       
        return rep;
    }

    private static ComponentBuilder<?,?> getWorker(List<String> arbeiter) {
        HorizontalListBuilder list = cmp.horizontalList();
        VerticalListBuilder vlist = cmp.verticalList();
        list.setHeight(100);
        list.setFixedWidth(50);
        list.setStyle(stl.style().setBorder(stl.pen1Point()));
              
        for(String a : arbeiter) {   
            list.add(cmp.text(a).setStyle(stl.style().setRotation(Rotation.LEFT)));
            System.out.println(a);
        }
        vlist.add(list);
        
        return vlist;
    }
    private static JRDataSource getDS() {
        return new JREmptyDataSource();
    }
    
}
