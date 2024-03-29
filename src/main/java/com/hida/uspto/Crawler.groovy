package com.hida.uspto

import com.hida.uspto.page.MainPage
import com.hida.uspto.page.PatentBibliographicDataPage
import com.hida.uspto.page.PatentMaintenanceFeePage
import geb.Browser
import geb.waiting.WaitTimeoutException

/**
 * Created by arief.hidayat on 12/20/13.
 */
class Crawler {
    public static void main(String[] args) {
        if(args == null || args.length != 2) {
            args = new String[2]
            args[0] = "7730526"; args[1] = "11421170";
        }
        if(args  != null && args.length == 2) {
            String patentNum = args[0], applicationNbr = args[1]
            Browser.drive {
                to MainPage
                retrieveFeesToPay(patentNum, applicationNbr)
                try {
                    waitFor(FEW_SECONDS){ at(PatentMaintenanceFeePage) }
                    println "retrieved patent number    : ${getPatentNbr()}"
                    println "retrieved appl. number     : ${getApplicationNbr()}"
                    println "retrieved total amt due    : ${getFeeAmtDue()}"
                } catch(WaitTimeoutException wte) {
                    if(page instanceof MainPage)
                        println "errMgs : ${errMsg}"
                }

                to MainPage
                getBibliographicData(patentNum, applicationNbr)
                try {
                    waitFor(FEW_SECONDS) { at(PatentBibliographicDataPage) }
                    println "retrieved patent number    : ${getPatentNbr()}"
                    println "retrieved appl. number     : ${getApplicationNbr()}"
                    println "retrieved patent title     : ${getPatentName()}"
                    println "retrieved total amt due    : ${getTotalAmtDue()}"
                } catch(WaitTimeoutException wte) {
                    if(page instanceof MainPage)
                        println "errMgs : ${errMsg}"
                }
            }.quit()
        } else {
            println("Please key in patent number and application number")
        }
    }
    private static final int FEW_SECONDS = 5
}
