package com.hida.uspto.page

import geb.Page

/**
 * Created by arief.hidayat on 12/20/13.
 */
class PatentBibliographicDataPage extends Page {
    static url = "https://ramps.uspto.gov/eram/getMaintFeesInfo.do"
    static at = {
        getCell(0,0) == "Patent Bibliographic Data"
    }
    static content = {
        tableData { $("table table", 0)}
    }
    String getCell(int row, int col) {
        tableData.find("tbody tr").eq(row).find("td").eq(col).text()?.trim()
    }
    String getPatentNbr() { getCell(1,1) }
    String getPatentName() { getCell(3, 1)}
    String getApplicationNbr() { getCell(1,3) }
    String getFeeAmtDue() { getCell(6,1) }
    String getSurchargeAmtDue() { getCell(6,3) }
    String getTotalAmtDue() { getCell(6,5) }
}
