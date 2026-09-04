package pe.edu.upc.easyvet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyvet.ui.theme.EasyVetTheme
import pe.edu.upc.easyvet.ui.visibility
import pe.edu.upc.easyvet.ui.visibilityOff

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val isHiddenPassword = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            placeholder = {
                Text(text = "Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text(text = "Password")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        isHiddenPassword.value = !isHiddenPassword.value
                    }
                ) {
                    Icon(
                        imageVector =
                            if (isHiddenPassword.value)
                                visibilityOff
                            else visibility,
                        contentDescription = "visibility"
                    )
                }
            },
            visualTransformation = if (isHiddenPassword.value)
                PasswordVisualTransformation()
            else VisualTransformation.None,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {

    EasyVetTheme(dynamicColor = false) {
        LoginScreen()
    }
}