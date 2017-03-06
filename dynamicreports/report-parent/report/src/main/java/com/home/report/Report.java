package com.home.report;

import java.util.ArrayList;
import java.util.List;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

public class Report {

    public static void main(String[] args) throws DRException {
        JasperReportBuilder  repo = report();
        VerticalListBuilder details = cmp.verticalList();
        HorizontalListBuilder title = cmp.horizontalList();
        HorizontalListBuilder daten = cmp.horizontalList();
        FieldBuilder<String> [] fb = null;
        TextFieldBuilder<String> [] tfb = null;
        
        Object [] data = null;
        DRDataSource ds = null;
        String [] dataStr = null;
        
        List<Person> personen = getPersonen();
        
        dataStr = getDataStringPersonen(personen);
        int len = dataStr.length;
        fb = new FieldBuilder [len];
        tfb = new TextFieldBuilder [len];
        
        personen.stream().forEach(p-> {
            title.add(cmp.text(p.getZuname() + " " + p.getGrp()));
        });
        
        for(int i=0; i<len; i++) {
            fb[i] = field(dataStr[i], type.stringType()); 
            tfb[i] = cmp.text(fb[i]);
            daten.add(tfb[i]);
        }
           
        ds = new DRDataSource(dataStr);
        
        for(int i=0; i<len; i++) ds.add(getData(personen, i));
        
        repo.pageHeader(title);
        repo.detail(daten);
        repo.setDataSource(ds);
        repo.show();
        
    }

    private static List<Person> getPersonen() {
        List<Person> liste = new ArrayList();
        
        liste.add(new Person("Filip" , "Polier"));
        liste.add(new Person("Stefan" , "Bauleiter"));
        liste.add(new Person("Thomas" , "Techniker"));
        return liste;
    }

    private static String[] getDataStringPersonen(List<Person> personen) {
        List<String> pers = new ArrayList();
        
        personen.stream().forEach((p) -> {
            pers.add(p.getZuname());
        });
        
        return pers.toArray(new String[personen.size()]);
    }

    private static Object[] getData(List<Person> personen, int x) {
        List<String> ds = new ArrayList();
        
        personen.stream().forEach(p->{
            ds.add(String.valueOf(p.getZeit(x)));
        });
        
        return (Object []) ds.toArray(new String[ds.size()]);
    }
    
}
