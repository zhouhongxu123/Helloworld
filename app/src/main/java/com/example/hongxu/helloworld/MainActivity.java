package com.example.hongxu.helloworld;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏  先删掉AppCompat
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉状态栏

        setContentView(R.layout.activity_main);
        switch (getResources().getConfiguration().orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                System.out.println("横屏显示");
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                System.out.println("竖屏显示");
                break;
        }
        System.out.println("MainActivity运行到onCreat方法");
        //此处是按钮的点击事件，打开一个新的Activity

        textView2=(TextView) findViewById(R.id.textView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用Component属性显示的启动
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MainActivity.this, SecActivity.class));
                startActivity(intent);
            }
        });
        Button button_yin = (Button) findViewById(R.id.button2);
        button_yin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用action属性隐式的启动  使用系统自有的Action过滤
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:110"));
                startActivity(intent);
            }

        });

        Button button_ex= (Button) findViewById(R.id.button3);
        button_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Text.class);
                //Extra方法传递
//                intent.putExtra("text","启动第三个界面");

//                Bundle方法封装
//                Bundle bundle=new Bundle();
//                bundle.putString("name","张三");
//                bundle.putString("age","18");
//                bundle.putString("sex","男");
//                intent.putExtras(bundle);

                //Java序列化 封装  实现implements Serializable
//                Student zhangsan=new Student("张三","男","22");
//                intent.putExtra("student",zhangsan);

                startActivityForResult(intent,0x23);

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
        switch (requestCode){
            case 0x23:
                String text=data.getStringExtra("text");
                textView2.setText(text);
                break;
            default:
                break;
        }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        System.out.println("MainActivity运行到onStart方法");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.hongxu.helloworld/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println(" 横竖屏切换 ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("MainActivity运行到onRestart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity运行到onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity运行到 onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.hongxu.helloworld/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        System.out.println("MainActivity运行到onStop方法");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity运行到onDestroy方法");
    }
}
