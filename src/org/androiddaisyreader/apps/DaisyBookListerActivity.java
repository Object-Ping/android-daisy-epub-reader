package org.androiddaisyreader.apps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.androiddaisyreader.model.Daisy202Book;
import org.androiddaisyreader.model.NccSpecification;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaisyBookListerActivity extends Activity {
    private EditText filename;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button open = (Button)findViewById(R.id.openbook);
        open.setOnClickListener(openListener);
        
        filename = (EditText)findViewById(R.id.filename);
        
    }
    
    private OnClickListener openListener = new OnClickListener() {
    	public void onClick(View v) {
    		InputStream contents;
			try {
				contents = new FileInputStream(filename.getText().toString());
				Daisy202Book book = NccSpecification.readFromStream(contents);
				Toast.makeText(getBaseContext(), book.getTitle(), Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				e.printStackTrace();
			} 
    	}
    };
}