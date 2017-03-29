package com.lawyee.myrecycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyRecycle
 * @Package com.lawyee.myrecycle
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/3/29 20:54
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

public class Fruitadapter extends RecyclerView.Adapter<Fruitadapter.ViewHolder> {


    private ArrayList<Fruit> mData;
    private Context mContext;
    private final LayoutInflater mInflater;

    public Fruitadapter(Context context,ArrayList<Fruit> mData) {
        this.mData = mData;
        this.mContext=context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mInflater.inflate(R.layout.fruit, null);
        final ViewHolder holder = new ViewHolder(inflate);
        holder.mTv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mData.get(position);
                Toast.makeText(mContext,""+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.mIv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                Toast.makeText(mContext,""+adapterPosition,Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mData.get(position);
        holder.mTv_show.setText(fruit.getName());
        holder.mIv_show.setImageResource(fruit.getImageid());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_show;
        private final ImageView mIv_show;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv_show = (ImageView) itemView.findViewById(R.id.iv_show);
            mTv_show = (TextView) itemView.findViewById(R.id.tv_show);
        }
    }
}
