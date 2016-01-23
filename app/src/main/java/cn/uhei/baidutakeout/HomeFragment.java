package cn.uhei.baidutakeout;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.app.Fragment;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import cn.uhei.baidutakeout.models.Shop;

public class HomeFragment extends Fragment {

    private ListView lvHome;
    private List<Shop> newsList;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        System.out.println("____________");
        getXmlData(context);
        return v;


    }

//    getXML

    public void getXmlData(Context context) {
        try {

            //文档生成器工厂对象
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            //实例化一个新的文档生成器
            DocumentBuilder builder = null;

            builder = builderFactory.newDocumentBuilder();

            AssetManager am = getActivity().getAssets();

            //利用文档生成器解析xml
            Document document = builder.parse(am.open("shops.xml"));

            //获取根元素（Languages）
            Element element = document.getDocumentElement();
            //获取节点列表，获取子tag
            NodeList list = element.getElementsByTagName("shops");

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.getLength(); i++) {
                Element shops = (Element) list.item(i);
                sb.append(shops.getElementsByTagName("title").item(0).getTextContent());

            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+sb.toString());




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return newsList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Shop shop = newsList.get(position);
            View v = null;
            ViewHolder mHolder;

            if (convertView == null){
                v = View.inflate(getActivity(),R.layout.item_layout,null);
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
            }else{
                v = convertView;
                mHolder = (ViewHolder) v.getTag();
            }

            mHolder.tvTitle.setText(shop.getTitle());
            mHolder.mian.set
            mHolder.jian = (ImageView) v.findViewById(R.id.ivJian);
            mHolder.quan = (ImageView) v.findViewById(R.id.ivQuan);
            mHolder.star = (ImageView) v.findViewById(R.id.ivStar1);
            mHolder.sale = (TextView) v.findViewById(R.id.tvSale);
            mHolder.mi = (TextView) v.findViewById(R.id.tvMi);
            mHolder.qisong = (TextView) v.findViewById(R.id.tvQisong);



            return null;
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

    /**
     * private String title;
     private int mian;
     private int jian;
     private int quan;
     private int star;
     private int sale;
     private int mi;
     private int qisong;
     private int peisong;
     private int time;
     */
    class ViewHolder{
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
