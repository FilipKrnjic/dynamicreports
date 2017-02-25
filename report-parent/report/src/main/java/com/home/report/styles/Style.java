/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.report.styles;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

/**
 *
 * @author Filip
 */
public class Style {
    
    public StyleBuilder CenMidTxt = stl.style();
    
    public Style() {
        CenMidTxt.setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE)
                .setFontSize(20)
                .setFont(stl.font().bold());
        
    }
}
