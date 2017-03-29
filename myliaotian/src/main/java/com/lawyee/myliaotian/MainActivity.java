package com.lawyee.myliaotian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtInput;
    private Button mBtnSend;
    private RecyclerView mRecyclerviews;
   private List<Msg> list =new ArrayList<>();
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMsg();//初始化消息数据


    }

    private void initMsg() {
        Msg msg = new Msg("hello Work",Msg.TYPE_RECEIVED);
        list.add(msg);
        Msg msg1 = new Msg("Hello work ,who is what ?",Msg.TYPE_SENT);
        list.add(msg1);
        Msg msg2 = new Msg("This is Tom,Nice Talking to you ",Msg.TYPE_RECEIVED);
        list.add(msg2);

    }

    private void initView() {
        mEtInput = (EditText) findViewById(R.id.et_input);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        mRecyclerviews = (RecyclerView) findViewById(R.id.recyclerviews);
        mRecyclerviews.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerviews.setLayoutManager(linearLayoutManager);
        msgAdapter = new MsgAdapter(list,this);
        mRecyclerviews.setAdapter(msgAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                mBtnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = mEtInput.getText().toString().trim();
                        if (!"".equals(content)){
                            Msg msg = new Msg(content,Msg.TYPE_SENT);
                            list.add(msg);
                            msgAdapter.notifyItemInserted(list.size()-1);//当有消息时显示
                            //刷新listview
                            mRecyclerviews.scrollToPosition(list.size()-1);//将消息放到最后一行
                            mEtInput.setText("");
                        }
                    }
                });
                break;
        }
    }

}
