package es.kankit.composeankit

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import es.kankit.composeankit.ui.theme.ComposeAnkitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Ankit")
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true,uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun defaultPre(){

        Text("Ankit", color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.subtitle2)

}