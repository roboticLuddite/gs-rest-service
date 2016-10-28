package hello;

import java.util.Calendar;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import hello.*;

public class LambdaFunctionHandler implements RequestHandler<Map<String,String>, String> {
    private GreetingController basicSample;
    public String handleRequest(Map<String,String> input, Context context) {
        
    	context.getLogger().log("AWS Request ID: " + context.getAwsRequestId());
    	context.getLogger().log("Input: " + input);
    	
    	basicSample = Application.getBean(GreetingController.class);
        
        //context.getLogger().log("Input: " + input + " at " + Calendar.getInstance().getTimeInMillis());
        
        Greeting response = basicSample.greeting("paul");
        
        return response.getContent() + response.getId();
    }
}


