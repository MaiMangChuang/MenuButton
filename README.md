# MenuButton
菜单按钮，一个可以隐藏显示其他按钮等控件的菜单按钮
==== 
使用方式：
-------  
<com.example.menubutton.view.SuroundButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    >
    //加入任意数量你的菜单按钮等控件，例如
      <Button
        android:layout_width="55dp"
        android:layout_height="55dp"
        android:background="@drawable/qq" />

    <TextView
        android:text="lalala"
        android:layout_width="55dp"
        android:layout_height="55dp"
         />

    <ImageView
        android:layout_width="55dp"
        android:layout_height="55dp"
        android:background="@drawable/chrome" />

    <ImageButton
        android:layout_width="55dp"
        android:layout_height="55dp"
        android:background="@drawable/codepen" />

    </com.example.menubutton.view.SuroundButton>
    
     <br>
      ![image]( https://github.com/MaiMangChuang/Myzhihu/blob/master/app/src/main/res/drawable/dome1.png)
      ![image]( https://github.com/MaiMangChuang/Myzhihu/blob/master/app/src/main/res/drawable/dome2.png)
      <br>
    
    ###1.可以设置展开角度：
   
    ####（1）展开最大角度：
    app:maxRain="360"
    ####（2）起始角度：
     app:startAngle="@integer/menuButton_StartAngle_Top"
     
    ###2.可以设置展开距离：
     -------  
     app:radius="550"
     
    ###3.可以设置展开动画：
     -------  
      app:closeScale="false" //关闭时是否执行缩小动画
      app:closeAlpha="false" //关闭时是否执行透明动画
      app:showScale="false" //显示时是否执行放大动画
      app:showAlpha="false" //显示时是否执行透明动画
      app:closeInterpolator="@string/menuButton_Interpolator_Bounce" //关闭时动画使用的插值器
      app:showInterpolator="@string/menuButton_Interpolator_Accelerate" //显示时动画使用的插值器
      app:showTime="2000"  //显示时动画执行时间
      app:closeTime="800"  //关闭时动画执行时间
      
      ###4.设置的菜单按钮背景：
      -------  
      app:mainIcon_show="@drawable/menu_s"  //显示时按钮
      app:mainIcon_close="@drawable/menu"   //关闭时按钮
        
      ###5.设置展开时是否出现蒙板：
      -------  
      app:obscuration="false"
      
      
      
     
