package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AvatarScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen() {
    // states
    var showEyes by remember { mutableStateOf(true) }
    var showBrows by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    val topBarColor = Color(0xFFE91E63) // pink
    val bgColor = Color(0xFFFCE9E9)     // soft background
    val checkboxCheckedColor = Color(0xFFFF9800)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "AvatarApp",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarColor // background pink
                )
            )
        },
        containerColor = bgColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(bgColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                val avatarSize = 300.dp

                Image(
                    painter = painterResource(id = R.drawable.head),
                    contentDescription = "Face",
                    modifier = Modifier.size(avatarSize * 1.55f),
                    contentScale = ContentScale.Fit
                )

                if (showBrows) {
                    Image(
                        painter = painterResource(id = R.drawable.brow),
                        contentDescription = "Brows",
                        modifier = Modifier
                            .size(avatarSize * 0.75f)
                            .offset(y = (-avatarSize * 0.12f)),
                        contentScale = ContentScale.Fit
                    )
                }

                if (showEyes) {
                    Image(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "Eyes",
                        modifier = Modifier
                            .size(avatarSize * 0.7f)
                            .offset(y = (-avatarSize * 0.005f)),
                        contentScale = ContentScale.Fit
                    )
                }

                if (showNose) {
                    Image(
                        painter = painterResource(id = R.drawable.nose),
                        contentDescription = "Nose",
                        modifier = Modifier
                            .size(avatarSize * 0.19f)
                            .offset(y = (avatarSize * 0.14f)),
                        contentScale = ContentScale.Fit
                    )
                }

                if (showMouth) {
                    Image(
                        painter = painterResource(id = R.drawable.mouth),
                        contentDescription = "Mouth",
                        modifier = Modifier
                            .size(avatarSize * 0.31f)
                            .offset(y = (avatarSize * 0.3f)),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(horizontal = 0.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy((-4).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SmallCheckboxWithLabel("Brow", showBrows, onCheckedChange = { showBrows = it }, checkedColor = checkboxCheckedColor)
                    SmallCheckboxWithLabel("Eye", showEyes, onCheckedChange = { showEyes = it }, checkedColor = checkboxCheckedColor)
                    SmallCheckboxWithLabel("Nose", showNose, onCheckedChange = { showNose = it }, checkedColor = checkboxCheckedColor)
                    SmallCheckboxWithLabel("Mouth", showMouth, onCheckedChange = { showMouth = it }, checkedColor = checkboxCheckedColor)
                }

                Spacer(modifier = Modifier.height(0.1.dp))
            }
        }
    }
}

@Composable
fun SmallCheckboxWithLabel(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkedColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                uncheckedColor = Color(0xFFBDBDBD),
                checkmarkColor = Color.White
            )
        )

        Text(
            text = label,
            fontSize = 13.sp,
            modifier = Modifier.offset(x = (-7).dp),
            textAlign = TextAlign.Start
        )
    }
}
