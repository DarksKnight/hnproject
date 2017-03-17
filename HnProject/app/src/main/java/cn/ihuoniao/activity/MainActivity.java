package cn.ihuoniao.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.ldoublem.loadingviewlib.view.LVCircularRing;

import cn.ihuoniao.Constant;
import cn.ihuoniao.R;
import cn.ihuoniao.base.BaseActivity;
import cn.ihuoniao.platform.webview.BridgeWebView;
import cn.ihuoniao.platform.webview.DefaultHandler;

public class MainActivity extends BaseActivity {

    private BridgeWebView bwvContent = null;
    private Button btn = null;
    private LVCircularRing lvc = null;

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
        lvc = getView(R.id.lvc_progress);

        lvc.setBarColor(getResources().getColor(R.color.colorTitle));
        lvc.startAnim();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                actionsCreator.sendNewClick("hello world");
                startActivity(new Intent(MainActivity.this, FirstDeployActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        bwvContent.setDefaultHandler(new DefaultHandler());
        bwvContent.getSettings().setJavaScriptEnabled(true);
        bwvContent.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

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

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress > 0) {
                    lvc.stopAnim();
                    lvc.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        bwvContent.loadUrl(Constant.APP_INFO.platformUrl);
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
