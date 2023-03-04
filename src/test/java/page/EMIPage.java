package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMIPage {
    @FindBy(id = "com.continuum.emi.calculator:id/btnStart")
    public
    AndroidElement btnStart;
    @FindBy(id = "com.continuum.emi.calculator:id/etLoanAmount")
    AndroidElement txtLoanAmount;
    @FindBy(id = "com.continuum.emi.calculator:id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id = "com.continuum.emi.calculator:id/etMonths")
    AndroidElement txtPeriodMonth;
    @FindBy(id = "com.continuum.emi.calculator:id/etEMI")
    AndroidElement txtMonthlyEmi;

    @FindBy(id = "com.continuum.emi.calculator:id/etYears")
    AndroidElement txtPeriodYear;
    @FindBy(id = "com.continuum.emi.calculator:id/etFee")
    AndroidElement txtProcessingFee;

    @FindBy(id = "com.continuum.emi.calculator:id/btnCalculate")
    AndroidElement btnCalculate;


    @FindBy(id = "com.continuum.emi.calculator:id/monthly_emi_result")
    public
    AndroidElement txtEMIMonthlyAmountResult;
    @FindBy(id = "com.continuum.emi.calculator:id/total_interest_result")
    public
    AndroidElement txtTotalInterestResult;
    @FindBy(id = "com.continuum.emi.calculator:id/processing_fee_result")
    public
    AndroidElement txtProcessingFeeResult;
    @FindBy(id = "com.continuum.emi.calculator:id/total_payment_result")
    public
    AndroidElement txtTotalPaymentResult;

    @FindBy(id = "com.continuum.emi.calculator:id/rbPeriod")
    AndroidElement btnPeroidSelect;

    @FindBy(id = "com.continuum.emi.calculator:id/btnReset")
    public
    AndroidElement btnReset;

    public EMIPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void calculateEMI(int loanAmount, double interest,int periodYear,int PeriodMonth,double processingFee,double monthlyEmi ){

        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+interest+"");
        txtPeriodMonth.sendKeys(""+PeriodMonth+"");
        txtPeriodYear.sendKeys(""+periodYear+"");
        btnPeroidSelect.click();
        txtMonthlyEmi.sendKeys(""+monthlyEmi+"");
        txtProcessingFee.sendKeys(""+processingFee+"");
        btnCalculate.click();

    }
}
