package com.sporting.admin.consts;

public interface UrlPath {
    //Common
    String VALIDATE_ACCOUNT = "/admin/validateLogin"; //Validate LoginPage
    String LOGIN_PAGE = "/login"; //Redirect to login page
    String REDIRECT_LOGIN_PAGE = "/"; //Redirect to login page
    String LOGOUT = "/admin/logout"; //Logout function

    //Accounts
    String ACCOUNT_GET_ALL = "/account/get-all"; //Get List All Account
    String ACCOUNT_GET_BY_UUID = "/account/get-by-uuid/{id}"; //Get Detail of Account
    String ACCOUNT_CREATE = "/account/create"; //Insert Account
    String ACCOUNT_UPDATE = "/account/update"; //Update Account
    String ACCOUNT_DELETE = "/account/delete/{id}"; //Delete Account
    String ACCOUNT_PERFORM_LOCK = "/account/perform-lock/{id}"; //Lock/Unlock Account
    String ACCOUNT_REDIRECT_INSERT_PAGE = "/account/redirect-insert"; //Redirect Page Insert Account

    //ProductService
    String PRODUCT_GET_ALL = "/product/get-all/{id}";
    String PRODUCT_GET_BY_UUID = "/product/get-by-uuid/{id}";
    String PRODUCT_CREATE = "/product/create";
    String PRODUCT_UPDATE = "/product/update";
    String PRODUCT_DELETE = "/product/delete/{id}";
    String PRODUCT_PERFORM_LOCK = "/product/perform-lock/{id}";
    String PRODUCT_REDIRECT_INSERT_PAGE = "/product/redirect-insert-page";

    //Cart Details
    String CART_DETAIL_GET_ALL = "/cartDetail/get-all";
    String CART_DETAIL_GET_BY_ID = "/cartDetail/get-by-uuid/{id}";
    String CART_DETAIL_PERFORM_LOCK = "/cartDetail/perform-lock/{id}";

    //CategoryService
    String CATEGORY_GET_ALL = "/category/get-all";
    String CATEGORY_GET_BY_ID = "/category/get-by-uuid/{id}";
    String CATEGORY_CREATE = "/category/create";
    String CATEGORY_UPDATE = "/category/update";
    String CATEGORY_DELETE = "/category/delete/{id}";
    String CATEGORY_PERFORM_LOCK = "/category/perform-lock/{id}";
    String CATEGORY_REDIRECT_INSERT_PAGE = "/category/redirect-insert-page";

    //Order Details
    String ORDER_DETAILS_GET_ALL = "/orderDetails/getAll";
    String ORDER_DETAILS_GET_BY_ID = "/orderDetails/get-by-uuid/{id}";
    String ORDER_DETAILS_PERFORM_LOCK = "/orderDetails/perform-lock/{id}";

    //PaymentService
    String PAYMENT_GET_ALL = "/payment/getAll";
    String PAYMENT_GET_BY_ID = "/payment/get-by-uuid/{id}";
    String PAYMENT_DELETE = "/payment/delete/{id}";

    //Upload File
    String UPLOAD_FILE = "/upload-file";
}


