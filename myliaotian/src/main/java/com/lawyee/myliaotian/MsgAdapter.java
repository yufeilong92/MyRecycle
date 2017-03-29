package com.lawyee.myliaotian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyRecycle
 * @Package com.lawyee.myliaotian
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/3/29 21:51
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;
    private Context context;
    private final LayoutInflater mInflater;

    public MsgAdapter(List<Msg> mMsgList, Context context) {
        this.mMsgList = mMsgList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
            //如果是收到消息，则显示左边的消息布局将右边屏蔽
            holder.mleft_layout.setVisibility(View.VISIBLE);
            holder.mRight_layout.setVisibility(View.GONE);
            holder.mTvLefeMsg.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SENT){
            holder.mRight_layout.setVisibility(View.VISIBLE);
            holder.mleft_layout.setVisibility(View.GONE);
            holder.mTvRightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout mleft_layout;
        private final LinearLayout mRight_layout;
        private final TextView mTvLefeMsg;
        private final TextView mTvRightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            mleft_layout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            mRight_layout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            mTvLefeMsg = (TextView) itemView.findViewById(R.id.tv_left_msg);
            mTvRightMsg = (TextView) itemView.findViewById(R.id.tv_right_mas);


        }

    }
}
