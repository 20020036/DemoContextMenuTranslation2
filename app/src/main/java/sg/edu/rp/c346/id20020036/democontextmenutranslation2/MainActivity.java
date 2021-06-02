package sg.edu.rp.c346.id20020036.democontextmenutranslation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslated;
    TextView tvTranslated2;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslated = findViewById(R.id.textViewTranslatedText);
        tvTranslated2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslated);
        registerForContextMenu(tvTranslated2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == tvTranslated)
        {
            wordClicked = "hello";
        }
        else if(v == tvTranslated2)
        {
            wordClicked = "bye";
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(wordClicked.equalsIgnoreCase("hello"))
        {
            if (item.getItemId() == R.id.EnglishSelection) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslated.setText("Hello!");
                return true;
            } else if (item.getItemId() == R.id.ItalianSelection) {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslated.setText("Ciao!");
                return true;
            }

        }
        else if(wordClicked.equalsIgnoreCase("bye"))
        {
            if(item.getItemId() == R.id.EnglishSelection)
            {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslated2.setText("Bye!");
                return true;
            }
            else if(item.getItemId() == R.id.ItalianSelection)
            {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslated2.setText("Addio!");
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}