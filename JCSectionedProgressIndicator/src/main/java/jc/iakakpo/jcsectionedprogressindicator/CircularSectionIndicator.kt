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





@Composable
fun CircularSectionedIndicator(
    modifier: Modifier = Modifier,
    sections: Int = 3,
    progressValue: Float,
    listOfColors: List<Color>,
    strokeValue: Dp = 3.dp,
    strokeShape: StrokeCap = StrokeCap.Butt,
    indicatorSize: Dp = 40.dp,) {


    val progress by animateFloatAsState(targetValue = progressValue * 360F)



    require(sections <= listOfColors.size) { "The number of sections must be equal to number of colors" }

    BoxWithConstraints(modifier = modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        val density = LocalDensity.current

        Canvas(modifier = Modifier
            .defaultMinSize(minWidth = 40.dp, minHeight = 40.dp)
            .size(indicatorSize)
            .padding(10.dp),
            onDraw = {
                val innerRadius = (size.minDimension - strokeValue.toPx()) / 2
                val halfSize = size / 2.0f
                val topLeft = Offset(
                    halfSize.width - innerRadius,
                    halfSize.height - innerRadius
                )
                val size = Size(innerRadius * 2, innerRadius * 2)
                val sweepAngle = 360F / sections
                var startAngle = -90F




                for (index in 0 until sections) {
                    drawProgressSections(
                        index = index,
                        listOfColors = listOfColors,
                        drawScope = this,
                        sections = sections,
                        topLeft = topLeft,
                        strokeValue = strokeValue,
                        startAngle = startAngle,
                        progress = progress,
                        density = density,
                        strokeType = strokeShape,
                    )
                    startAngle += sweepAngle

                }


            })
    }

}



fun drawProgressSections(
    index: Int,
    listOfColors: List<Color>,
    drawScope: DrawScope,
    sections: Int,
    topLeft: Offset,
    strokeValue: Dp,
    startAngle: Float,
    progress: Float,
    density: Density,
    strokeType: StrokeCap
) {
    val circleDivision = (360F / sections)

    val stroke = with(density) { Stroke(strokeValue.toPx(), cap = strokeType) }
    val realSweepAngle = (index) * circleDivision


    drawScope.inset {
        var trueStartAngle = if (index == 0) -90F else startAngle
        var sweepAngle =
            if (progress in realSweepAngle..progress) (progress - realSweepAngle) else 0F


        drawArc(
            color = listOfColors[index],
            startAngle = trueStartAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = stroke
        )


    }

}

