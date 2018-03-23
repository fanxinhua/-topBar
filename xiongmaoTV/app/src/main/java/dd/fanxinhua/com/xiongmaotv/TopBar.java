package dd.fanxinhua.com.xiongmaotv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dell on 2018/2/22.
 */

public class TopBar  extends RelativeLayout {
    //获得里面的控件
    private Button left,right;
    private TextView title;
    //给每个控件定义要用的属性

    //leftbutton

    private String leftText;
    private int leftTextColor;
    private float leftTextSize;
    private Drawable leftBackground;

    //rightbutton
    private String rightText;
    private int rightTextColor;
    private float rightTextSize;
    private Drawable rightBackground;

    //titleTextView
    private String titleText;
    private int titleColor;
    private float titleTextSize;

    //LayoutParams用来对控件进行操作，位置等。
    private LayoutParams leftparams,rightparams,titleparams;

    //类似Button的监听事件 自己定义接口，在setOnTopBarListener（自己定义的）方法中调用接口，new出listener之后需要重写leftonclick和rightonclick。
    private TopBarListener listener;

    public interface TopBarListener{
        void leftOnClick();
        void rightOnClick();
    }
    public void setOnTopBarListener(TopBarListener listener)
    {
        this.listener=listener;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        //通过TypedArray获得自己xml定义的属性并赋值给上面定义的属性。
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        titleText=ta.getString(R.styleable.TopBar_titleText);

        // 0是默认
        titleColor=ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleTextSize=ta.getDimension(R.styleable.TopBar_titleTextSize, 0   );

        leftText=ta.getString(R.styleable.TopBar_leftText);
        leftTextColor=ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground=ta.getDrawable(R.styleable.TopBar_leftTextbackgroung);
        leftTextSize=ta.getDimension(R.styleable.TopBar_leftTextSize, 0);

        rightText=ta.getString(R.styleable.TopBar_rightText);
        rightTextColor=ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground=ta.getDrawable(R.styleable.TopBar_rightTextbackgroung);
        rightTextSize=ta.getDimension(R.styleable.TopBar_rightTextSize, 0);

        //不要忘记给TypedArray回收一下。
        ta.recycle();

        //创建出3个控件
        left=new Button(context);
        right=new Button(context);
        title=new TextView(context);

        //给控件赋予属性
        left.setText(leftText);
        left.setTextColor(leftTextColor);
        left.setTextSize(leftTextSize);
        left.setBackground(leftBackground);

        right.setText(rightText);
        right.setTextColor(rightTextColor);
        right.setTextSize(rightTextSize);
        right.setBackground(rightBackground);

        title.setText(titleText);
        title.setTextColor(titleColor);
        title.setTextSize(titleTextSize);

        //好比xml的width和height的属性
        leftparams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

        //添加位置属性
        leftparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //将空间和添加的规则绑定
        addView(left,leftparams);

        rightparams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(right,rightparams);

        titleparams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleparams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(title,titleparams);

        left.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                listener.leftOnClick();
            }
        });

        right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                listener.rightOnClick();
            }
        });

    }

    //设置左右控件的隐藏
    public void setLeftVisibility(boolean is)
    {
        if(is)
        {
            left.setVisibility(View.VISIBLE);
        }else{
            left.setVisibility(View.INVISIBLE);
        }
    }

    public void setrightVisibility(boolean is)
    {
        if(is)
        {
            right.setVisibility(View.VISIBLE);
        }else{
            right.setVisibility(View.INVISIBLE);
        }
    }

}
