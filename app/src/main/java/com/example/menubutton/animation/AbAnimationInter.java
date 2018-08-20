package com.example.menubutton.animation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;

import com.example.menubutton.view.SuroundButton;

/**
 * 类描述：
 *
 * @author maimanchuang
 * @date 2018/8/19
 */
public abstract class AbAnimationInter implements Animation{
    SuroundButton.Builder builder;
    public void setBuilder(SuroundButton.Builder builder) {
        this.builder = builder;
    }


    public Interpolator instanceInterpolator(String interpolatorName){
        if (interpolatorName != null && !"".equals(interpolatorName)) {
            Class aClass = null;
            try {
                aClass = Class.forName(interpolatorName);
                return (Interpolator) aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return  null;

    }

}
