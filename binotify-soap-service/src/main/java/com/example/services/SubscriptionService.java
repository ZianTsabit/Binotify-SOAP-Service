package com.example.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SubscriptionService {
    @WebMethod
    public String createSubscriptionDatabase();

    @WebMethod
    public String addSubscription(@WebParam(name = "creator_id") Integer creator_id, @WebParam(name = "subscriber_id") Integer subscriber_id, @WebParam(name = "status") String status);

    @WebMethod
    public String rejectSubscription(Integer creator_id, Integer subscriber_id);

    @WebMethod
    public String acceptSubscription(Integer creator_id, Integer subscriber_id);


}
