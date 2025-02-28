package com.example.application_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.TypedValueCompat.ComplexDimensionUnit
import com.example.application_2.ui.theme.Application2Theme
import kotlin.math.E
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.ui.res.colorResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
           var value by remember{
               mutableFloatStateOf(0f)
           }

            Application2Theme {
                Column (
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                ) {
                    SimpleButton()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    ElevatedButtonType()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    FilledTonalButtonType()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    OutlinedButtonType()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    FloatingActionType()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    SliderMinimalExample()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    AssistChipExample()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    FilterChipExample()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    SwitchTest()
                    HorizontalDivider(thickness = 2.dp, color = Color.Blue)
                    CardTest()

                }

            }
        }
    }
}
@Composable
fun SimpleButton()  {
    Button(onClick = {
    /*TODO*/ },

        colors = ButtonDefaults.buttonColors( Color.Yellow)) {

       Text(text = "click me", color= Color.Blue)
    }
}

@Composable
fun ElevatedButtonType() {
    ElevatedButton(
        onClick = {
            /*TODO*/
        },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors( Color.Green)) {
        Text(text="Button", color=Color.Black)



    }

}

@Composable
fun FilledTonalButtonType() {
    FilledTonalButton(
        onClick = {
            /*TODO*/
        },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color.Magenta)
    ) {
        Icon(
            Icons.Rounded.AddCircle,
            contentDescription = ""
        )
        Text(text = "Add", color = Color.Blue)
    }
}


@Composable
fun OutlinedButtonType() {
    OutlinedButton(
        onClick = {
            /*TODO*/
        },
        shape = CircleShape
    ) {
        Text(text = "Outlined",color=Color.Cyan)
    }
}


@Composable
fun FloatingActionType() {
    FloatingActionButton(onClick = { /*TODO*/ },
        containerColor = Color.Red) {
        Icon(
             Icons.Rounded.Edit,
            contentDescription = ""

        )
    }
}

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Red,
                inactiveTrackColor = Color.Blue.copy(alpha = 0.24f)
            )
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AssistChipExample() {
    AssistChip(
        onClick = { Log.d("Assist chip", "hello world") },
        label = { Text("Assist chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun SwitchTest() {

    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

@Composable
fun CardTest() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.flipkart),
            contentColor = Color.Black

        ),
        modifier = Modifier
            .size(width = 100.dp, height = 200.dp)
    ) {
        Text(text = "Hello Card")
        Text(text = "I am Inside Card")
    }
}






