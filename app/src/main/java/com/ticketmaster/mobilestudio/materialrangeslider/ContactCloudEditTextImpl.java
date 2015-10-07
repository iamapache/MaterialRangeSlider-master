package com.ticketmaster.mobilestudio.materialrangeslider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/7.
 */
public class ContactCloudEditTextImpl extends CloudEditText {

    public ContactCloudEditTextImpl(Context context) {
        super(context);
    }

    public ContactCloudEditTextImpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContactCloudEditTextImpl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean checkInputSpan(String showText, String returnText) {
        if(returnText.contains("@")){
            boolean result = CheckUtils.checkEmail(returnText);
            if(!result){
                Toast.makeText(getContext(), "请输入一个邮箱", Toast.LENGTH_LONG);
            }
            return result;
        }else{
            if(returnText.contains("+")){
                Toast.makeText(getContext(), "手机号前请不要加区号", Toast.LENGTH_LONG);
                return false;
            }else{
                boolean result = CheckUtils.checkMobile(returnText);
                if(!result){
                    Toast.makeText(getContext(), "请输入一个手机号", Toast.LENGTH_LONG);
                }
                return result;
            }
        }
    }
}