package com.salesmanager.web.shop.controller.customer;

import com.salesmanager.core.business.shoppingcart.service.ShoppingCartService;
import com.salesmanager.web.entity.customer.SecuredCustomer;
import com.salesmanager.web.shop.controller.AbstractController;
import com.salesmanager.web.shop.controller.customer.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author evan
 * @Date 2016年02月15日T22:48
 */
@Controller
@RequestMapping("/shop/customer")
public class CustomerOpenIdController extends AbstractController {

    @Autowired
    private AuthenticationManager customerAuthenticationManager;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/openid/qq.html", method = RequestMethod.GET)
    public String redirectToQQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "";
    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/openid/weixin.html", method = RequestMethod.GET)
    public String redirectToWeixin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "";
    }


}