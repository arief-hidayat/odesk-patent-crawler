package com.hida.uspto.page

import geb.Page

/**
 * Created by arief.hidayat on 12/20/13.
 */
class MainPage extends Page {
    static url = "https://ramps.uspto.gov/eram/patentMaintFees.do"
    static content = {
        errMsg { $('.errMsg').text() }
        form { $("form[name=mfInputForm]") }
        getBibliographicBtn { form.find("input[value='Get Bibliographic Data']")}
        retrieveFeeBtn { form.find("input[value='Retrieve Fees to Pay']")}
    }
    def fillForm(String patentNbr, String applicationNbr) {
        sleep(1000)
        form.patentNum = patentNbr
        sleep(1000)
        form.applicationNum = applicationNbr
        sleep(1000)
    }
    def getBibliographicData(String patentNbr, String applicationNbr) {
        fillForm(patentNbr, applicationNbr)
        println ">>> ${getBibliographicBtn.value()}"
        getBibliographicBtn.click()
    }
    def retrieveFeesToPay(String patentNbr, String applicationNbr) {
        fillForm(patentNbr, applicationNbr)
        println ">>> ${retrieveFeeBtn.value()}"
        retrieveFeeBtn.click()
    }
}
