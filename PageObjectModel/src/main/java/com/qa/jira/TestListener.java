package com.qa.jira;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		 ScriptMetaData meta = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ScriptMetaData.class);
         // get the annotation parameter value as a boolean
         boolean isTicketReady = meta.ticketReady();
         // Check if the annotation attribute value is productionReady=true
         if (isTicketReady) {
             // raise the jira ticket
        	 System.out.println("IS TICKET READY : "+isTicketReady);
             JiraServiceProvider jiraSP = new JiraServiceProvider(JiraUtil.JIRA_URL, JiraUtil.JIRA_USERNAME, JiraUtil.JIRA_PASSWORD, JiraUtil.JIRA_PROJECT);
             
             // Add the failed method name as the issue summary
             String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " was failed due to an exception";
             
             // get the error message from the exception to description
             String issueDescription = "Exception details : "+  result.getThrowable().getMessage() + "\n";
             // Append the full stack trace to the description.
             issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
             
             jiraSP.createJiraIssue("Bug", issueSummary, issueDescription, JiraUtil.JIRA_USERNAME);
         }
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
}
