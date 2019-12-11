package com.example.duan_1.themnguoichoi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan_1.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter implements Filterable {
    List<Model> arrLop;
    List<Model> arrSortLop;
    private Filter lopFilter;
    public Activity context;
    public LayoutInflater inflater;
    DAO dao;
    public Adapter (List<Model> arrLop,Activity context){
        this.arrLop=arrLop;
        this.arrSortLop=arrLop;
        this.context=context;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dao=new DAO(context);
    }
    @Override
    public int getCount() {
        return arrLop.size();
    }

    @Override
    public Object getItem(int i) {
        return arrLop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class  ViewHoder{
        TextView T1;
        TextView T2,T3;
        ImageView del;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder;
        if(view==null){
            viewHoder=new ViewHoder();
            view=inflater.inflate(R.layout.item_nguoi_choi,null);
            viewHoder.T1=(TextView)view.findViewById(R.id.tvName);
            viewHoder.T2=(TextView)view.findViewById(R.id.tvName2);
            viewHoder.T3=(TextView)view.findViewById(R.id.tvName3);
            viewHoder.del=view.findViewById(R.id.ivDelete);
            viewHoder.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dao.Delete(arrLop.get(i).getT1());
                    arrLop.remove(i);
                    notifyDataSetChanged();
                }
            });
            view.setTag(viewHoder);
        }else

            viewHoder = (ViewHoder) view.getTag();
        Model _entry = (Model) arrLop.get(i);

        viewHoder.T1.setText(_entry.getT1());
        viewHoder.T2.setText(_entry.getT2());
        viewHoder.T3.setText(_entry.getT3());
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void chang(List<Model> items){
        this.arrLop = items;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        if(lopFilter==null){
            lopFilter= new CustomFilter();
        }
        return  lopFilter;
    }
    public class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (charSequence == null || charSequence.length() == 0) {
                results.values = arrSortLop;
                results.count = arrSortLop.size();
            } else {
                List<Model> lsSach = new ArrayList<>();
                for (Model p : arrLop) {
                    if (p.getT1().toUpperCase().startsWith(charSequence.toString().toUpperCase()))
                        lsSach.add(p);
                }
                results.values = lsSach;
                results.count = lsSach.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if(filterResults.count ==0){
                notifyDataSetInvalidated();
            }else{
                arrLop = ( List<Model>) filterResults.values;
                notifyDataSetChanged();
            }
        }
    }
}
