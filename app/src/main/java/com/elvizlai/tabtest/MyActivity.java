package com.elvizlai.tabtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;


public class MyActivity extends TabActivity {
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        mTabHost = getTabHost();

        addTab();
        mTabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
       // mTabHost.setBackgroundResource(R.drawable.ic_launcher);
        mTabHost.setCurrentTab(0);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
                Dialog dialog;
                builder.setTitle("提示");
                builder.setMessage("当前选中了" + tabId + "标签");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void addTab() {
        mTabHost.addTab(mTabHost.newTabSpec("分组").setIndicator("分组", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.textview1));
        mTabHost.addTab(mTabHost.newTabSpec("全部").setIndicator("全部", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.textview2));
    }


}
