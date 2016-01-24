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

    private String title;
    private String mian;
    private String jian;
    private String quan;
    private String star;
    private String sale;
    private String mi;
    private String qisong;
    private String peisong;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMian() {
        return mian;
    }

    public void setMian(String mian) {
        this.mian = mian;
    }

    public String getJian() {
        return jian;
    }

    public void setJian(String jian) {
        this.jian = jian;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getQisong() {
        return qisong;
    }

    public void setQisong(String qisong) {
        this.qisong = qisong;
    }

    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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
