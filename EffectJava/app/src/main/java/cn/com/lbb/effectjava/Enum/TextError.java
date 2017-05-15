package cn.com.lbb.effectjava.Enum;

/**
 * Created by zengcheng on 2017/5/13.
 *
 * 此处使用位域,通过或运算将几个常量合并到一个集合里,debug的时候不好分析
 */

public class TextError {
    public static final int BOLD = 1 << 0;
    public static final int ITALIC = 1 << 1;
    public static final int UNDERLINE = 1 << 2;
    public static final int STRIKETHROUGH = 1 << 3;

    public void setStyles(int styles) {

    }

    public static void main(String[] args) {
        new TextError().setStyles(BOLD | ITALIC);
    }
}
