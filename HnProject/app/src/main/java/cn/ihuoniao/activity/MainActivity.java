package cn.ihuoniao.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Button;

import cn.ihuoniao.R;
import cn.ihuoniao.base.BaseActivity;
import cn.ihuoniao.platform.webview.BridgeWebView;
import cn.ihuoniao.platform.webview.DefaultHandler;
import cn.ihuoniao.store.ClickStore;

public class MainActivity extends BaseActivity {

    private BridgeWebView bwvContent = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void initView() {
        super.initView();

        bwvContent = getView(R.id.bwv_content);
        btn = getView(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstDeployActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        addStore(new ClickStore());

        bwvContent.setDefaultHandler(new DefaultHandler());

        bwvContent.setWebChromeClient(new WebChromeClient() {

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType, String capture) {
                this.openFileChooser(uploadMsg);
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType) {
                this.openFileChooser(uploadMsg);
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg) {

            }
        });

        bwvContent.loadUrl("http://ihuoniao.cn");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && bwvContent.canGoBack()) {
            bwvContent.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
