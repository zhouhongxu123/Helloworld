package com.example.hongxu.helloworld;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Field;

import javax.xml.transform.Source;

public class Text extends AppCompatActivity {
    private TextView textView;
    private Button button_t;
    private EditText editText;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        //Extra方法接受
        Intent intent = getIntent();
//        String text=intent.getStringExtra("text");
//        //Bundle方法接受
//        Bundle bundle=intent.getExtras();
//        String name=bundle.getString("name");
//        String age=bundle.getString("age");
//        String sex=bundle.getString("sex");

        //    Student zhangsan=(Student)intent.getParcelableExtra("student");
        textView = (TextView) findViewById(R.id.textView2);
        //  textView.setText(zhangsan.getName()+zhangsan.getSex()+zhangsan.getAge());

        // 给文本中设置图片
        String html = "你好<img src='header'></img>,带图片文本<img src='ic_launcher'></img>";
        Spanned spanned1 = Html.fromHtml(html, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = null;
                Class clazz = R.mipmap.class;
                try {
                    Field field = clazz.getDeclaredField(source);
                    int id = field.getInt(null);
                    drawable = getResources().getDrawable(id);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return drawable;
            }
        }, null);
        textView.setText(spanned1);


        //带返回值的Extra
        button_t = (Button) findViewById(R.id.button4);
        editText = (EditText) findViewById(R.id.editText_t);
        button_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("text", text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Text Page", // TODO: Define a title for the content shown.
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
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Text Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.hongxu.helloworld/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
