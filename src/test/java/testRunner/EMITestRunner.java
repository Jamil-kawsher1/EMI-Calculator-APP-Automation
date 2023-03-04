package testRunner;

import dataset.DataSet;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.EMIPage;
import setup.Setup;

public class EMITestRunner extends Setup {
    @BeforeTest
    public void startEMICalc () {
        EMIPage emiPage = new EMIPage(driver);
        emiPage.btnStart.click();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DataSet.class)
    public void calculateEMI (int loanAmount, double interest,int emi,double processingFee,double monthlyEmi,double totalWithInterest,double processingfeetotal,double totalPyament,int periodYear,int PeriodMonth) {
        EMIPage emiPage = new EMIPage(driver);
        emiPage.calculateEMI(loanAmount, interest, periodYear,PeriodMonth, processingFee,monthlyEmi);

        double monthlyEMIActual = Double.parseDouble(emiPage.txtEMIMonthlyAmountResult.getText().replace(",", ""));
        double totalInterestActual = Double.parseDouble(emiPage.txtTotalInterestResult.getText().replace(",", ""));
        double totalProcessingFeeActual = Double.parseDouble(emiPage.txtProcessingFeeResult.getText().replace(",", ""));
        double totalPaymentActual = Double.parseDouble(emiPage.txtTotalPaymentResult.getText().replace(",", ""));


        Assert.assertEquals(monthlyEMIActual, monthlyEmi);
        Assert.assertEquals(totalInterestActual, totalWithInterest);
        Assert.assertEquals(totalProcessingFeeActual, processingfeetotal);
        Assert.assertEquals(totalPaymentActual, totalPyament);

        emiPage.btnReset.click();
    }
}
