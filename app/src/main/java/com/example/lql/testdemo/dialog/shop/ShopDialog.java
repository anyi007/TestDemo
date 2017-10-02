package com.example.lql.testdemo.dialog.shop;

/**
 * 类描述：
 * 作  者：Admin or 李小米
 * 时  间：2017/9/27
 * 修改备注：
 */
public class ShopDialog {

//    public static void empty(final Context mContext, final LoginCallBack mLoginCallBack) {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        View contentView = LayoutInflater.from(mContext).inflate(R.layout.dialog_login, null);
//        builder.setView(contentView);
//        final AlertDialog dialog = builder.show();
//
//        final EditText NameTv = (EditText) contentView.findViewById(R.id.dialog_login_name);
//        final EditText PwdTv = (EditText) contentView.findViewById(R.id.dialog_login_pwd);
//        final EditText AddressTv = (EditText) contentView.findViewById(R.id.dialog_login_address);
//        final EditText PortTv = (EditText) contentView.findViewById(R.id.dialog_login_port);
//
//        //关闭
//        TextView cancel = (TextView) contentView.findViewById(R.id.dialog_login_cancel);
//        //确定
//        TextView submit = (TextView) contentView.findViewById(R.id.dialog_login_submit);
//
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LastName = null;
//                LastPwd = null;
//                mLoginCallBack.LoginCallBack(LastName, LastPwd, LastAddress, LastPort);
//                dialog.dismiss();
//            }
//        });
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LastName = NameTv.getText().toString();
//                LastPwd = PwdTv.getText().toString();
//                LastAddress = AddressTv.getText().toString();
//                LastPort = PortTv.getText().toString();
//
//                if (TextUtils.isEmpty(LastName)) {
//                    T.shortToast(mContext, "请输入名称");
//                    return;
//                }
//                if (TextUtils.isEmpty(LastPwd)) {
//                    T.shortToast(mContext, "请输入密码");
//                    return;
//                }
//                if (TextUtils.isEmpty(LastAddress)) {
//                    T.shortToast(mContext, "请输入服务器IP地址");
//                    return;
//                }
//                if (TextUtils.isEmpty(LastPort)) {
//                    T.shortToast(mContext, "请输入服务器端口号");
//                    return;
//                }
//
//                mLoginCallBack.LoginCallBack(LastName, LastPwd, LastAddress, LastPort);
//                dialog.dismiss();
//            }
//        });
//
//    }


    /**
     * popupwindow 消失后的回调
     */
    public interface LoginCallBack {
        void LoginCallBack(String name, String pwd, String address, String port);
    }


}
