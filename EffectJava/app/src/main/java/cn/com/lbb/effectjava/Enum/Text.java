package cn.com.lbb.effectjava.Enum;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by zengcheng on 2017/5/13.
 * 利用EnumSet将若干个enum组合成一个组合,更方便易懂
 */

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    public enum Color {RED, BULE, GREEN}

    public void applyStyles(Set<Style> styles) {

    }

    public static void main(String[] args) {
        new Text().applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
