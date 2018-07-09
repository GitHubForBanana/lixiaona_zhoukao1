package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.keng.lixiaona_zhoukao1.R;

/**
 * Created by Keng on 2018/7/9.
 */

public class TextView extends View {
    Paint paint;
    int textColor;
    int bgColor;
   /* private String text="刮刮看";*/

    public TextView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint=new Paint();
        //画笔颜色
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);

    }

    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        if(attrs!=null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TextView);
            textColor=typedArray.getColor(R.styleable.TextView_TextViewColor,Color.WHITE);
            bgColor=typedArray.getColor(R.styleable.TextView_TextViewBgColor,Color.LTGRAY);
            typedArray.recycle();
        }else {
          textColor=Color.WHITE;
          bgColor=Color.LTGRAY;
        }

    //初始化画笔
        paint=new Paint();
        paint.setColor(bgColor);
        paint.setStyle(Paint.Style.FILL);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文字
        paint.setColor(textColor);
        paint.setTextSize(90);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawText("刮刮看",350,500,paint);

    }
}
