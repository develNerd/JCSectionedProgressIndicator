package jc.iakakpo.jcsectionedprogressindicator

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jc.iakakpo.jcsectionedprogressindicator.ui.theme.JCSectionedProgressIndicatorTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    val model: MainVieModel by viewModels()
    private val run = true
    private var a = 0
    private var countDown30Seconds = 30.0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JCSectionedProgressIndicatorTheme {
                // A surface container using the 'background' color from the theme

                var progressAntiClockWise by remember {
                    mutableStateOf(1F)
                }

                var progressClockWise by remember {
                    mutableStateOf(0F)
                }

              /*  */
                val coroutinesScope = rememberCoroutineScope()
                val listOfColors = listOf<Color>(Color.Red, Color.Green, Color.Blue,Color.LightGray,
                    Color.Yellow)

                LaunchedEffect(key1 = true){
                    coroutinesScope.launch {
                        val handler = Handler(Looper.myLooper()!!)
                        val runnable: Runnable = object : Runnable {
                            override fun run() {
                                if (progressClockWise < 1F){
                                    progressClockWise += (1 / countDown30Seconds) / 10
                                }else{
                                    progressClockWise = 0F
                                }

                                if (a/10.0F <= countDown30Seconds) {
                                   progressAntiClockWise = (countDown30Seconds - a.toFloat()/10.0F) / countDown30Seconds
                                    a++
                                    Log.d("Runnable",progressAntiClockWise.toString())
                                }else{
                                    a = 0
                                }
                                handler.postDelayed(this, 100)
                            }
                        }
                        handler.postDelayed(runnable, 100)
                    }
                }





                Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
                    var textColor = listOfColors[0]

                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 3,progressValue = progressAntiClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "3 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }

                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 4,progressValue = progressAntiClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "4 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }
                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 5,progressValue = progressAntiClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "5 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }

                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp),modifier = Modifier.padding(15.dp)) {
                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 3,progressValue = progressClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "3 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }

                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 4,progressValue = progressClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "4 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }
                        Column(verticalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.size(100.dp),contentAlignment = Alignment.Center) {
                                CircularSectionedIndicator(sections = 5,progressValue = progressClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)
                                Text(text = "${(countDown30Seconds - (a.toFloat()/10F).roundToInt()).toInt()}",color = textColor)
                            }
                            Text(text = "5 Sections",modifier = Modifier.padding(top = 10.dp).align(
                                Alignment.CenterHorizontally))
                        }

                    }


                    Button(onClick = {
                        a = 0
                        progressClockWise = 0F
                    },modifier = Modifier.padding(top = 20.dp),shape = RoundedCornerShape(100)) {
                        Text(text = "Reset",modifier = Modifier.padding(start = 15.dp,end = 15.dp))
                    }
                }



            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCSectionedProgressIndicatorTheme {
        Greeting("Android")
    }
}