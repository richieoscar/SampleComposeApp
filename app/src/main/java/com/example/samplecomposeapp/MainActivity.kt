package com.example.samplecomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           CardList()
        }
    }
}
data class User(
    val id:Int,
    val name:String
)

val users = listOf(
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),
    User(1, "Oscar"),


)

@Composable
fun CardList() {
    LazyColumn{
        items(users){user-> SideBar(user = user)}
    }

}

@Composable
fun SideBar(user: User) {
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(all = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                alignment = Alignment.Center
            )
            Column {
                Text(
                    text = user.name,
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 0.dp, 0.dp)
                        .wrapContentHeight()
                )
                Button(
                    onClick = {
                        Toast.makeText(context, "Ciick Me", Toast.LENGTH_SHORT).show()
                    }, modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(text = "Edit Profile", fontSize = 12.sp, color = Color.White)

                }

            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        SideBar(user = users.get(0))

    }

}
