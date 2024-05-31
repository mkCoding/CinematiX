package com.kryptopass.cinematix.ui.compose.movie.single

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import coil.compose.rememberAsyncImagePainter
import com.kryptopass.common.nav.MovieInput
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun MovieScreen(
    viewModel: MovieViewModel,
    input: MovieInput
) {

    //In order to display the image we need to combine the
    // base url-> (https://image.tmdb.org/t/p/w500)
    // endpoint-> (/gKkl37BQuKTanygYQG1pyYgLVgf.jpg) [sample image url retrieved from movie response]
    //is retrieved from response
    val baseUrl = "https://image.tmdb.org/t/p/w500"
    var endpoint = input.posterPath
    val fullPicURL = baseUrl + input.posterPath

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        Text(
//            text = "Movie Details Screen",
//            style = MaterialTheme.typography.headlineLarge
//        )
        //Display the title of the movie
        Text(
            text = "${input.originalTitle}",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            //AsyncImagePainter executes image request and processes the result
            painter = rememberAsyncImagePainter(fullPicURL),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))

        //Display the overview
        Text(
            text = "${input.overview}",
            fontSize = 15.sp,
            style = TextStyle(fontStyle = FontStyle.Italic),
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 10.dp, end= 10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Display Release Date

        Text(
            text = "Release Date",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 3.dp)
        )

        // Display the formatted release date
        Text(
            text = formatDate(input.releaseDate.toString()),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

    }

}

//method to properly format the release date
// Function to format the release date
fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}





