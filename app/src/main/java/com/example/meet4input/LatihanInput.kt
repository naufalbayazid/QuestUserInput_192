package com.example.meet4input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)

@Composable
fun LatihanInput(modifier: Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var datanama by remember { mutableStateOf("") }
    var dataEmail by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }
    var dataAlamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("") }
    val dataJK = listOf("Laki-Laki", "Perempuan")
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(28.dp))
        TextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Nama")

            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }

        )
        Row {
            dataJK.forEach { selectedJK ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("masukkan email anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = noHp,
            onValueChange = { noHp = it },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("No HP")
            },
            placeholder = {
                Text("Masukkan alamat anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan alamat anda")
            }

        )
        Button(
            onClick = {
                datanama = nama
                dataEmail = email
                dataNoHp = noHp
                dataJenisK =jenisK
                dataAlamat = alamat

            },
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text("Submit")
        }
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                CobaData(
                    judul = "Nama",
                    isinya = datanama,
                )

                CobaData(
                    judul = "Jenis Kelamin",
                    isinya = dataJenisK,
                )
                CobaData(
                    judul = "email",
                    isinya = dataEmail,
                )
                CobaData(
                    judul = "NoHp",
                    isinya = dataNoHp,
                )
                CobaData(
                    judul = "Alamat",
                    isinya = dataAlamat,
                )
            }
        }
    }
}

@Composable
fun CobaData(
    judul:String,
    isinya:String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}