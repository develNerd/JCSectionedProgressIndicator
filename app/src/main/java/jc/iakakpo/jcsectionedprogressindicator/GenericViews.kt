package jc.iakakpo.jcsectionedprogressindicator

import android.content.res.Resources
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Isaac Akakpo
 * Created on 2/10/2022 2:40 PM
 */


@Preview(showBackground = true)
@Composable
fun SampleDrawPreview() {

    BoxWithConstraints(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val stroke = with(LocalDensity.current) { Stroke(5.dp.toPx()) }

        val sections = 3
        val listOfColors = listOf<Color>(Color.Red, Color.Green, Color.Blue)
        val density = LocalDensity.current
        Canvas(modifier = Modifier
            .size(400.dp)
            .padding(10.dp), onDraw = {
            val innerRadius = (size.minDimension - stroke.width) / 2
            val halfSize = size / 2.0f
            val topLeft = Offset(
                halfSize.width - innerRadius,
                halfSize.height - innerRadius
            )
            val size = Size(innerRadius * 2, innerRadius * 2)

            var startAngle = -90F

            var progress = 360F
            val sweepAngle2 = (360F / sections)

            /*repeat(sections){ currentSection ->
                drawArc(
                    color = listOfColors.random(),
                    startAngle = if (currentSection == 0) -90F else startAngle + 1F,
                    sweepAngle = sweepAngle - 1F,
                    useCenter = false,
                    topLeft = topLeft,
                    size = size,
                    style = stroke
                )
                startAngle += sweepAngle2
            }*/

            for (index in 0 until sections) {
                val sweepAngle = (360F / sections)

                startAngle += sweepAngle
            }

        })
    }

}




