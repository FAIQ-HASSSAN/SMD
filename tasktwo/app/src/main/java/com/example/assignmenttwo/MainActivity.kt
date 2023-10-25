package com.example.assignmenttwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmenttwo.ui.theme.AssignmenttwoTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmenttwoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        NavigationBar()

                        WeatherDisplay()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = Color.White // Set icon color to white
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Lahore",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(173, 216, 230) // Set text color to white
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White // Set icon color to white
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.White // Set icon color to white
            )
        }
    }
}

@Composable
fun WeatherDayColumn(day: String, temperature: Int, iconResId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = day,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Image(
            painter = painterResource(id = iconResId), // Replace 'iconResId' with the actual image resource
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(4.dp)
        )
        Text(
            text = "$temperature°C",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
    }
}

@Composable
fun WeatherDisplay() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Text(
            text = "25°C" ,
            style = TextStyle(
                fontSize = 60.sp,
            ),
            color = Color.White
        )
        val dateFormat = SimpleDateFormat("EEE, MMM dd, yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val currentDate = dateFormat.format(Date())
        val currentTime = timeFormat.format(Date())



        Column (
        horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp, 20.dp, 10.dp, 5.dp)

        ){
            Text(
                text = currentDate,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = currentTime,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }




        Row (

            modifier = Modifier
                .fillMaxWidth()
        ){

            Image(
                painter = painterResource(id = R.drawable.building),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WeatherDayColumn("Sun", 31, R.drawable.cloud)
            WeatherDayColumn("Mon", 31, R.drawable.cloud)
            WeatherDayColumn("Tue", 32, R.drawable.cloud)
            WeatherDayColumn("Wed", 32, R.drawable.cloud)
        }
    }
}
