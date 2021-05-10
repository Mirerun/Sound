package app.murauchi.mirerun.sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ドラムのサウンドファイルを読み込んで、プレイヤーを作る
        val drumSound = MediaPlayer.create(this, R.raw.drum_sound)
        //ドラムがタッチされたときに呼ばれる
        drumImage.setOnTouchListener { view, event ->

            //タッチが始まった時に
            if (event.action == MotionEvent.ACTION_DOWN){

                //ドラムが鳴っている画像に切り替える
                drumImage.setImageResource(R.drawable.drum_playing_image)

                //ドラムの音を巻き戻す(ドラム音源の再生位置を0に戻す)
                drumSound.seekTo(0)

                //ドラムの音を再生する
                drumSound.start()
            }
            //タッチが終わる時に
            else if (event.action == MotionEvent.ACTION_UP){

                //ドラムが鳴っていない画像に切り替える
                drumImage.setImageResource(R.drawable.drum_image)
            }

            true
        }

    }
}