package jc.iakakpo.jcsectionedprogressindicator

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Isaac Akakpo
 * Created on 2/11/2022 7:22 PM
 */
class MainVieModel : ViewModel() {

    private val _progress = MutableLiveData<Float>(1F)
    val progress: LiveData<Float>
        get() = _progress

    init {
        val count = object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished / 1000
                val percentage = (100 * second) / 30
                _progress.value = (percentage.toDouble() / 100.0).toFloat()
                Log.d("Progress", (percentage.toDouble()).toString())

            }

            override fun onFinish() {

            }
        }.start()

    }

}