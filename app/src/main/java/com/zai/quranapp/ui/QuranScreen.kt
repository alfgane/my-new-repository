package com.zai.quranapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zai.quranapp.data.QuranData
import com.zai.quranapp.data.Surah
import com.zai.quranapp.ui.theme.QuranAppTheme

@Composable
fun QuranScreen() {
    QuranAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "القرآن الكريم") }
                )
            }
        ) { innerPadding ->
            QuranContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun QuranContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(QuranData.surahs) { surah ->
            SurahItem(surah = surah)
        }
    }
}

@Composable
fun SurahItem(surah: Surah) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${surah.name} (${surah.ayahs} آية)",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "عدد الآيات: ${surah.ayahs}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
