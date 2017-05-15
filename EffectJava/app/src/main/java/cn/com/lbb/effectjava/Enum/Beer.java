package cn.com.lbb.effectjava.Enum;

/**
 * Created by zengcheng on 2017/5/12.
 */

public enum Beer {
    WHITE_BEER(13.5f, 5.8f),
    PINK_KILLER(8.3f, 14.3f);
    private final float alcoholDegree, wortDegree;

    Beer(float alcoholDegree, float wortDegree) {
        this.alcoholDegree = alcoholDegree;
        this.wortDegree = wortDegree;

    }

    public float getAlcoholDegree() {
        return alcoholDegree;
    }

    public float getWortDegree() {
        return wortDegree;
    }

}
