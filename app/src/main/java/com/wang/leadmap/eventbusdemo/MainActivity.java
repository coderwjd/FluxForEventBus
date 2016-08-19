package com.wang.leadmap.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wang.leadmap.eventbusdemo.actions.ActionsCreator;
import com.wang.leadmap.eventbusdemo.actions.MessageAction;
import com.wang.leadmap.eventbusdemo.actions.RepInfoAction;
import com.wang.leadmap.eventbusdemo.dispatcher.Dispatcher;
import com.wang.leadmap.eventbusdemo.stores.GetRepInfoStore;
import com.wang.leadmap.eventbusdemo.stores.MessageStore;
import com.wang.leadmap.eventbusdemo.stores.Store;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button button1;
    private EditText editText;
    private TextView textView;
    private TextView textView1;

    private Dispatcher dispatcher;
    private ActionsCreator actionsCreator;
//    private MessageStore store;
    private GetRepInfoStore repInfoStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EventBus.getDefault().register(this);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.text);
        textView1 = (TextView)findViewById(R.id.text1);
        button = (Button)findViewById(R.id.button);
        button1 = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        initDependencies();
    }

    private void initDependencies() {
        this.dispatcher = Dispatcher.getInstance();
        this.actionsCreator = ActionsCreator.getInstance(this,dispatcher);
//        this.store = new MessageStore();
        this.repInfoStore = new GetRepInfoStore();
//        this.dispatcher.register(store);
        this.dispatcher.register(repInfoStore);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        this.dispatcher.unregister(store);
        this.dispatcher.unregister(repInfoStore);
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        this.store.register(this);
        this.repInfoStore.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        this.store.unregister(this);
        this.repInfoStore.unregister(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            if (TextUtils.isEmpty(editText.getText().toString())){
                Toast.makeText(this,"请先输入你想说的",Toast.LENGTH_SHORT).show();
                return;
            }
            this.actionsCreator.sendMessage(editText.getText().toString());
            editText.setText(null);
        }else if (v.getId() == R.id.button1){

            this.actionsCreator.getRepInfo();
//            if (TextUtils.isEmpty(editText.getText().toString())){
//                Toast.makeText(this,"请先输入你想说的",Toast.LENGTH_SHORT).show();
//                return;
//            }
//            this.actionsCreator.sendOldMessage(editText.getText().toString());
//            editText.setText(null);
        }

    }

    private void render(MessageStore store){
        textView.setText(store.getMessage());
        textView1.setText(store.getOldString());
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event){
        switch (event.getType()){
            case MessageAction.ACTION_NEW_MESSAGE:
//                render(store);
                break;
            case RepInfoAction.ACTION_GET_REP_INFO:
                String Area = repInfoStore.getResponses().get(0).Area;
                textView1.setText(Area);
                break;
        }

    }
}
