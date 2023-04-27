package tw.edu.pu.tcyang.attractions

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.tcyang.attractions.ui.theme.AttractionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttractionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var Pics = arrayListOf(R.drawable.pic1, R.drawable.pic2,
        R.drawable.pic3, R.drawable.pic4, R.drawable.pic5)
    var Places = arrayListOf("高美濕地", "墾丁", "花動縱谷", "平溪", "澎湖")
    val context = LocalContext.current

    LazyColumn{
        item{
            Text(text = "台灣景點")
            Button(onClick = {
                context.startActivity(Intent(context, VideoActivity::class.java))
            }) {
                Text(text = "看見台灣")
            }

            Text(text = "")
        }
        
        items(5) { index ->  
            Text(text = Places[index % 5])
            Image(
                painter = painterResource(id = Pics[index % 5]),
                contentDescription = "景點圖片")
            Text(text = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AttractionsTheme {
        Greeting("Android")
    }
}