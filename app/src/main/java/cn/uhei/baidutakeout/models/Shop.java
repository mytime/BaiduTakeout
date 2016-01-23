package cn.uhei.baidutakeout.models;

/**
 * Created by Administrator on 2016/1/23.
 *         <title>10内蒙古特产专营店(上下九店)</title>
 <mian>1</mian>
 <jian>1</jian>
 <quan>1</quan>
 <star>4</star>
 <sale>559</sale>
 <mi>995</mi>
 <qisong>20</qisong>
 <peisong>5</peisong>
 <time>45</time>
 */
public class Shop {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMian() {
        return mian;
    }

    public void setMian(int mian) {
        this.mian = mian;
    }

    public int getJian() {
        return jian;
    }

    public void setJian(int jian) {
        this.jian = jian;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getMi() {
        return mi;
    }

    public void setMi(int mi) {
        this.mi = mi;
    }

    public int getQisong() {
        return qisong;
    }

    public void setQisong(int qisong) {
        this.qisong = qisong;
    }

    public int getPeisong() {
        return peisong;
    }

    public void setPeisong(int peisong) {
        this.peisong = peisong;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private String title;
    private int mian;
    private int jian;
    private int quan;
    private int star;
    private int sale;
    private int mi;
    private int qisong;
    private int peisong;
    private int time;

    @Override
    public String toString() {
        return "shop{" +
                "title='" + title + '\'' +
                ", mian=" + mian +
                ", jian=" + jian +
                ", quan=" + quan +
                ", star=" + star +
                ", sale=" + sale +
                ", mi=" + mi +
                ", qisong=" + qisong +
                ", peisong=" + peisong +
                ", time=" + time +
                '}';
    }
}
