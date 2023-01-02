package com.example;
import com.example.services.SOAPLoggingHandler;
import com.example.services.SubscriptionServiceImpl;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import java.util.List;


public class App {
    private static String publishURL = "http://0.0.0.0:8080/service/subscription";
    public static void main( String[] args )
    {
        // Endpoint.publish("http://127.0.0.1:8080/service/subscription", new SubscriptionServiceImpl());
        Endpoint ep = Endpoint.create(new SubscriptionServiceImpl());
        List<Handler> handlerChain = ep.getBinding().getHandlerChain();
        handlerChain.add(new SOAPLoggingHandler());
        ep.getBinding().setHandlerChain(handlerChain);
        ep.publish(publishURL);
    }
}
