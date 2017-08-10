package com.yong.finance.constants;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Constants {

    //  全局配置
    public final static int False = 0;
    public final static int True = 1;

    public final static String kCode_Success        = "0";          //  成功
    public final static String kCode_Fail           = "1";          //  失败
    public final static String kCode_SessionError   = "1000";       //  登陆超时
    public final static String kCode_UnAuth         = "2000";       //  没有权限
    //  后台管理系统单页记录数量
    public final static int kAdmin_PageSize = 20;
    public final static int kApi_PageSize = 20;

    //  接口token缓存
    public static final long TOKEN_EXPIRES_DAY = 7;

    //  认证信息
    public static final String AUTHORIZATION_TOKEN_BEAN = "tokenBean";
    public static final String AUTHORIZATION_AUTH_TOKEN = "authToken";
    public static final String AUTHORIZATION_USER_UUID = "userUuid";
    public static final String AUTHORIZATION_USER_ID = "userUuid";

    //用户sessionkey
    public static final String SESSION_USER_KEY = "ACCOUNTENTITY";

    // 用户状态
    public static final int USER_STATE_NORMAL = 1;  //正常状态
    public static final int USER_STATE_FORBIDDEN = 2;   //用户禁用
    public static final int USER_STATE_CANCEL = 4;  //用户注销

}
