package com.example.menubutton.animation;

import android.view.View;

/**
 * 类描述：
 *
 * @author maimanchuang
 * @date 2018/8/18
 */
public interface Animation {
   void closeAnimation(final View view, int index);
   void showAnimation(final View view, int index);
}
