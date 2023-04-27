package tw.edu.pu.tcyang.attractions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import tw.edu.pu.tcyang.attractions.ui.theme.AttractionsTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttractionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current

    val link = "https://rr3---sn-n4v7snls.googlevideo.com/videoplayback?expire=1682576170&ei=yr5JZNagII698wSN-Ii4Bg&ip=198.199.101.47&id=o-AFaNbfHZVPp_W9-9-YyRE9A1poUuMMD1jQSXt88TkwO1&itag=18&source=youtube&requiressl=yes&mh=PD&mm=31,26&mn=sn-n4v7snls,sn-q4fzen7e&ms=au,onr&mv=m&mvi=3&pl=24&initcwndbps=166250&spc=qEK7BybikRQBTyjjd91VKreM5u2Z1A0Hw4e96f0H_w&vprv=1&mime=video/mp4&ns=GPg36ZskBGgKC8FRiw3muyYN&cnr=14&ratebypass=yes&dur=171.223&lmt=1663017120319648&mt=1682554134&fvip=4&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=5318224&n=TNkdWZMouVzL0LkMfLl&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&sig=AOq0QJ8wRAIgGmctUXM5CAARc9krfpl8ZnQvM5Ue2r7QH4pQV9kmQzYCIEW9yCr80DD63hY0WiNXCXwmlAEfUawQG6sRaeXkw9Ll&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRgIhAOfqeJq7ng8YxhJE6TT5izEFdLkWbd8V4QdTirwiVhzfAiEA6tgN37nINNYl8mrUsLYgiwMlKKAU-g-Uzib26VxrH3U=&title=%E3%80%90%E7%82%BA%E5%8F%B0%E7%81%A3%E6%8B%8D%E6%89%8B%EF%BD%9C%E5%90%91%E9%98%BF%E8%B2%AB%E8%80%81%E5%B8%AB%E8%88%87%E9%BD%8A%E6%9F%8F%E6%9E%97%E5%B0%8E%E6%BC%94%E8%87%B4%E6%95%AC%E3%80%91%E8%AE%93%E4%B8%96%E7%95%8C%E8%81%BD%E8%A6%8B%E7%8E%89%E5%B1%B1%E5%9C%A8%E5%94%B1%E6%AD%8C"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer

    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AttractionsTheme {
        Greeting2("Android")
    }
}