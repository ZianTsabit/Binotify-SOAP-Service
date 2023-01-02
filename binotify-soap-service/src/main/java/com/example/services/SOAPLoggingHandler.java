package com.example.services;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        logToConsole(soapMessageContext);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        return true;
    }

    @Override
    public void close(MessageContext messageContext) {

    }

    private void logToConsole(SOAPMessageContext smc){
        Boolean outboundProperty = (Boolean)
                smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);


        if (outboundProperty) {
            System.out.println("\nOutbound message:");
        } else {
            System.out.println("\nInbound message:");
        }

        SOAPMessage message = smc.getMessage();
        Map<String, List<String>> reqHeaders = (Map<String, List<String>>) smc.get(MessageContext.HTTP_REQUEST_HEADERS);
        Map<String, List<String>> resHeaders = (Map<String, List<String>>) smc.get(MessageContext.HTTP_RESPONSE_HEADERS);

        try {
            message.writeTo(System.out);
            reqHeaders.forEach((x, y) -> {
                System.out.println(x);
                System.out.println(y);
            });
            resHeaders.forEach((x, y) -> {
                System.out.println(x);
                System.out.println(y);
            });
            System.out.println("");   // just to add a newline
        } catch (Exception e) {
            System.out.println("Exception in handler: " + e);
        }
    }

    private void logToDatabase(SOAPMessageContext smc){

    }
}
