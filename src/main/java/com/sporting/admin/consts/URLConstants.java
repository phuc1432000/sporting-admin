package com.sporting.admin.consts;

public class URLConstants {
    private static String API = "/api/v1";

    //Accounts
    public static String ACCOUNT_GET_ALL = API + "/account/get-all";
    public static String ACCOUNT_GET_UUID = API + "/account/get-by-uuid";
    public static String ACCOUNT_CREATE = API + "/account/create";
    public static String ACCOUNT_DELETE = API + "/account/delete";
    public static String ACCOUNT_UPDATE = API + "/account/update";
    public static String ACCOUNT_PERFORM_LOCK = API + "/account/perform-lock";
    public static String ACCOUNT_VALIDATE_LOGIN = API + "/account/validate-login";

    //Cart Detail
    public static String CART_DETAIL_GET_ALL = API + "/cart-detail/get-all";
    public static String CART_DETAIL_GET_UUID = API + "/cart-detail/get-by-uuid";
    public static String CART_DETAIL_PERFORM_LOCK = API + "/cart-detail/perform-lock";

    //Category
    public static String CATEGORY_GET_ALL = API + "/category/get-all";
    public static String CATEGORY_GET_UUID = API + "/category/get-by-uuid";
    public static String CATEGORY_CREATE = API + "/category/create";
    public static String CATEGORY_DELETE = API + "/category/delete";
    public static String CATEGORY_UPDATE = API + "/category/update";
    public static String CATEGORY_PERFORM_LOCK = API + "/category/perform-lock";

    //Order Detail
    public static String ORDER_DETAIL_GET_ALL = API + "/order-detail/get-all";
    public static String ORDER_DETAIL_GET_UUID = API + "/order-detail/get-by-uuid";
    public static String ORDER_DETAIL_PERFORM_LOCK = API + "/order-detail/perform-lock";
    public static String ORDER_DETAIL_CREATE = API + "/order-detail/create";
    public static String ORDER_DETAIL_DELETE = API + "/order-detail/delete";

    //Payment
    public static String PAYMENT_GET_ALL = API + "/payment/get-all";
    public static String PAYMENT_GET_UUID = API + "/payment/get-by-uuid";
    public static String PAYMENT_DELETE = API + "/payment/delete";

    public static String PAYMENT_PERFORM_LOCK = API + "/payment/perform-lock";

    //Product
    public static String PRODUCT_GET_ALL = API + "/product/get-all";
    public static String PRODUCT_GET_CATE_ID = API + "/product/get-by-cateId";
    public static String PRODUCT_GET_UUID = API + "/product/get-by-uuid";
    public static String PRODUCT_CREATE = API + "/product/create";
    public static String PRODUCT_DELETE = API + "/product/delete";
    public static String PRODUCT_UPDATE = API + "/product/update";
    public static String PRODUCT_PERFORM_LOCK = API + "/product/perform-lock";

    // upload file
    public static String UPLOAD_FILE = API + "/upload-file";


}
