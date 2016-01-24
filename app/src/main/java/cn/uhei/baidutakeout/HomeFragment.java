package cn.uhei.baidutakeout;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.renderscript.ScriptGroup;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import cn.uhei.baidutakeout.models.Shop;

public class HomeFragment extends Fragment {

    private ListView lvHome;
    private List<Shop> shopList;
    private Context context;
    private Shop shop;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ListView lv = (ListView) getActivity().findViewById(R.id.lvShops);
            lv.setAdapter(new MyAdapter());
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        getXmlData();
        return v;
    }

//    getXML

    public void getXmlData() {

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
//                    File file  = new File();

                    //获得xml数据流
                    InputStream is = getActivity().getAssets().open("shops.xml");
                    parseShopXml(is);


//                    //文档生成器工厂对象
//                    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//                    //实例化一个新的文档生成器
//                    DocumentBuilder builder = null;
//
//                    builder = builderFactory.newDocumentBuilder();
//
//                    AssetManager am = getActivity().getAssets();

//                    //利用文档生成器解析xml
//                    Document document = builder.parse(am.open("shops.xml"));
//
//                    //获取根元素（Languages）
//                    Element element = document.getDocumentElement();
//                    //获取节点列表，获取子tag
//                    NodeList list = element.getElementsByTagName("shops");
//
//                    shop = new Shop();
////            StringBuffer sb = new StringBuffer();
//                    for (int i = 0; i < list.getLength(); i++) {
//                        Element shops = (Element) list.item(i);
////                sb.append(shops.getElementsByTagName("title").item(0).getTextContent());
//                        shop.setTitle(shops.getElementsByTagName("title").item(0).getTextContent());
//                        shop.setMian(Integer.parseInt(shops.getElementsByTagName("mian").item(0).getTextContent()));
//                        shop.setJian(Integer.parseInt(shops.getElementsByTagName("jian").item(0).getTextContent()));
//                        shop.setQuan(Integer.parseInt(shops.getElementsByTagName("quan").item(0).getTextContent()));
//                        shop.setStar(Integer.parseInt(shops.getElementsByTagName("star").item(0).getTextContent()));
//                        shop.setSale(Integer.parseInt(shops.getElementsByTagName("sale").item(0).getTextContent()));
//                        shop.setMi(Integer.parseInt(shops.getElementsByTagName("mi").item(0).getTextContent()));
//                        shop.setQisong(Integer.parseInt(shops.getElementsByTagName("qisong").item(0).getTextContent()));
//                        shop.setPeisong(Integer.parseInt(shops.getElementsByTagName("peisong").item(0).getTextContent()));
//                        shop.setTime(Integer.parseInt(shops.getElementsByTagName("time").item(0).getTextContent()));
//
//                        shopList.add(shop);
//                    }


                    /**
                     *  <title>1内蒙古特产专营店(上下九店)1</title>
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
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+sb.toString());
                    handler.sendEmptyMessage(1);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        };
        t.start();


    }

    //解析数据流
    private void parseShopXml(InputStream is) {

        XmlPullParser xp = Xml.newPullParser();
        try {
            //指定编码
            xp.setInput(is,"utf-8");
            //获取节点
            int type = xp.getEventType();
            //初始化
            Shop shop = null;

            //遍历节点
            while (type != XmlPullParser.END_DOCUMENT){
                switch (type){
                    case XmlPullParser.START_TAG:
                        if("shopslist".equals(xp.getName())) {
                    shopList = new ArrayList<Shop>();
                    }else if("shops".equals(xp.getName())){
                            //shop对象
                        shop = new Shop();
                    }else if("title".equals(xp.getName())){
                            String title = xp.nextText();
                            shop.setTitle(title);
                        }else if ("mian".equals(xp.getName())){
                            // TODO: 2016/1/24  

                        }
                }
            }




        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return shopList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            shop = shopList.get(position);
            View v = null;
            ViewHolder mHolder;

            if (convertView == null) {
                v = View.inflate(getActivity(), R.layout.item_layout, null);
                mHolder = new ViewHolder();

                mHolder.tvTitle = (TextView) v.findViewById(R.id.tvTitle);
                mHolder.mian = (ImageView) v.findViewById(R.id.ivMian);
                mHolder.jian = (ImageView) v.findViewById(R.id.ivJian);
                mHolder.quan = (ImageView) v.findViewById(R.id.ivQuan);
                mHolder.star = (ImageView) v.findViewById(R.id.ivStar1);
                mHolder.sale = (TextView) v.findViewById(R.id.tvSale);
                mHolder.mi = (TextView) v.findViewById(R.id.tvMi);
                mHolder.qisong = (TextView) v.findViewById(R.id.tvQisong);

                v.setTag(mHolder);
            } else {
                v = convertView;
                mHolder = (ViewHolder) v.getTag();
            }

            mHolder.tvTitle.setText(shop.getTitle());
            mHolder.mian.setImageResource(R.drawable.waimai_shoplist_item_icon_mian);
            mHolder.jian.setImageResource(R.drawable.waimai_shoplist_item_icon_jian);
            mHolder.quan.setImageResource(R.drawable.waimai_shoplist_item_icon_juan);
            mHolder.star.setImageResource(R.drawable.businesslistings_list_icon_star_full);
            mHolder.sale.setText(shop.getSale());
            mHolder.mi.setText(shop.getMi());
            mHolder.qisong.setText("起送"+shop.getQisong()+"配送:"+shop.getPeisong()+"平均用时"+shop.getTime());

            return v;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }

    class ViewHolder {
        TextView tvTitle;
        ImageView mian;
        ImageView jian;
        ImageView quan;
        ImageView star;
        TextView sale;
        TextView mi;
        TextView qisong;
        TextView peisong;
        TextView time;

    }

}
