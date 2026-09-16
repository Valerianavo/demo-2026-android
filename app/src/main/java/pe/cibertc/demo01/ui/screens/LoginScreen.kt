package pe.cibertc.demo01.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.cibertc.demo01.R
import pe.cibertc.demo01.ui.theme.Demo01Theme
import java.nio.file.WatchEvent
import kotlin.math.log

@Composable
fun LoginScreen(
    modifier : Modifier = Modifier
) {
    val context = LocalContext.current
    //vARIABLE MUTABLE QUE PERRSISTE LOS DATOS INGRESADOS EN EL INPUT
    var email by remember { mutableStateOf(value = "") }
    var clave by remember { mutableStateOf(value = "") }
    var claveVisible by remember { mutableStateOf(value = false) }

    //CONTENEDOR PRINCIPAL VERTICALMENTE ALINEADO
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 32.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        //COMPONENTES VISUAL DE TEXTO SIMPLE
        Text(
            text = "Cibertec Demo"
        )
        Text(
            text = "Lista de Compras"
        )

        Icon(
            modifier = Modifier.width(200.dp), // cambia el tam año
            painter =  painterResource(id = R.drawable.bolsa),
            contentDescription = "",
        )



        //COMPONENETE VISUAL DE INGRESO DE TEXTO
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            label = {
                Text(
                    text = "Correo Electronico"
                )
            },
            //cambiar la opcion del teclado
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.imgemail),
                        contentDescription = ""
                    )
                }
            },
            //NO DE JA QUE SE ALARGUIE EL INPUT Y SE DEFORME
            singleLine = true,
        )


        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it},
            label = {
                Text(
                    text = "Contraseña"
                )
            },

            //el texto se hace visible o no de la contraseña. ojiyo
            visualTransformation = if (claveVisible){
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },

            //cambiar la opcion del teclado
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),

            //IMPORTAMOS LOS SVG DE LOS OJOS Y REALIZAMOS LA FUNCIONALIDADS
            trailingIcon = {
                IconButton(
                    onClick = {
                        claveVisible = !claveVisible
                    }
                ) {
                    Icon(
                        painter = if(claveVisible){
                            painterResource(id = R.drawable.ojotachado)
                        } else {
                            painterResource(id = R.drawable.ojoabierto)
                        },
                        contentDescription = "",

                    )
                }
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.password),
                        contentDescription = ""
                    )
                }
            },
            singleLine = true,
        )

        //COMPONENTE BUTTON. SOLO ONCLICK PARAMETRO OBLIGATORIO
        Button(
            onClick = {
                Log.e("CIBERTEC_CLICK", "Mensaje")
                Toast.makeText(context, "Mensaje", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(
                text = "Iniciar Sesion"
            )
        }
    }
}

//Preview es importante para llamar a mi pantalla
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Demo01Theme {
        LoginScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
