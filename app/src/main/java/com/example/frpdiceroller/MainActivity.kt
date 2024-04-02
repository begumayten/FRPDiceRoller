import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.FRPDiceRoller.R
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FRPDiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun FRPDiceRollerApp() {
    var selectedDice by remember { mutableStateOf(emptyList<Int>()) }
    var results by remember { mutableStateOf(emptyList<Int>()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DiceSelector(selectedDice) { newSelection ->
            selectedDice = newSelection
            results = emptyList()
        }

        Spacer(modifier = Modifier.height(3.dp))

        // Roll Button
        Button(onClick = {
            results = rollDice(selectedDice)
        }, modifier = Modifier
            .height(62.dp)
            .width(150.dp)

        ) {
            Text(
                text = "Roll",
                style = MaterialTheme.typography.headlineSmall
            )
        }


        Spacer(modifier = Modifier.height(32.dp))

        // Result Display
        if (results.isNotEmpty()) {
            results.forEachIndexed { index, result ->
                Text(
                    text = "Result for D${selectedDice[index]}: $result",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
fun DiceSelector(
    selectedDice: List<Int>,
    onSelectionChanged: (List<Int>) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            for (dice in listOf(4, 6, 8)) {
                Spacer(modifier = Modifier.width(1.dp))
                DiceCheckbox(dice, selectedDice, onSelectionChanged)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            for (dice in listOf(10, 12, 20)) {
                Spacer(modifier = Modifier.width(1.dp))
                DiceCheckbox(dice, selectedDice, onSelectionChanged)
            }
        }
    }
}

@Composable
fun DiceCheckbox(
    dice: Int,
    selectedDice: List<Int>,
    onSelectionChanged: (List<Int>) -> Unit
) {
    val isChecked = selectedDice.contains(dice)
    val imageResource = when (dice) {
        4 -> R.drawable.d4_image
        6 -> R.drawable.d6_image
        8 -> R.drawable.d8_image
        10 -> R.drawable.d10_image
        12 -> R.drawable.d12_image
        20 -> R.drawable.d20_image
        else -> R.drawable.ic_launcher_foreground
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                val newSelection = if (it) {
                    selectedDice + dice
                } else {
                    selectedDice - dice
                }
                onSelectionChanged(newSelection)
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "D$dice", style = MaterialTheme.typography.headlineSmall)
    }
}

fun rollDice(selectedDice: List<Int>): List<Int> {
    return selectedDice.map { Random.nextInt(1, it + 1) }
}

@Composable
@Preview(showBackground = true)
fun PreviewFRPDiceRollerApp() {
    FRPDiceRollerApp()
}