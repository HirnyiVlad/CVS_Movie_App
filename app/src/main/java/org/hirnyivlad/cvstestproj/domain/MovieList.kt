package org.hirnyivlad.cvstestproj.domain

import org.hirnyivlad.cvstestproj.R
import org.hirnyivlad.cvstestproj.data.MovieEntity

object MovieList {
    val movies = listOf<MovieEntity>(
        MovieEntity(
            id = 1,
            image = R.drawable.tenet_img,
            title = "Tenet",
            description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a" +
                    "Protagonist journeys through a twilight world of international espionage on a mission that will" +
                    "unfold in something beyond real time.",
            rating = 7.8f,
            duration = "2h 30 min",
            genre = "Action, Sci-Fi",
            releasedDate = "2020, 3 September",
            link = "https://www.youtube.com/watch?v=LdOM0x0XDMo"
        ),
        MovieEntity(
            id = 2,
            image = R.drawable.spider_man_img,
            title = "Spider-Man: Into the Spider-Verse",
            description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five" +
                    "spider-powered individuals from other dimensions to stop a threat for all realities.",
            rating = 8.4f,
            duration = "1h 57min",
            genre = "Action, Animation, Adventure",
            releasedDate = "2018, 14 December",
            link = "https://www.youtube.com/watch?v=tg52up16eq0"
        ),
        MovieEntity(
            id = 3,
            image = R.drawable.knives_out_img,
            title = "Knives Out",
            description = "A detective investigates the death of a patriarch of an eccentric, combative family",
            rating = 7.9f,
            duration = "2h 10min",
            genre = "Comedy, Crime, Drama",
            releasedDate = "2019, 27 November",
            link = "https://www.youtube.com/watch?v=qGqiHJTsRkQ"
        ),
        MovieEntity(
            id = 4,
            image = R.drawable.guardians_img,
            title = "Guardians of the Galaxy",
            description = "A group of intergalactic criminals must pull together to stop a fanatical warrior with" +
                    "plans to purge the universe.",
            rating = 8.0f,
            duration = "2h 1min",
            genre = "Action, Adventure, Comedy",
            releasedDate = "2014, 1 August",
            link = "https://www.youtube.com/watch?v=d96cjJhvlMA"
        ),
        MovieEntity(
            id = 5,
            image = R.drawable.avengers_img,
            title = "Avengers: Age of Ultron",
            description = " When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping" +
                    "program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the" +
                    "villainous Ultron from enacting his terrible plan.",
            rating = 7.3f,
            duration = "2h 21min",
            genre = "Action, Adventure, Sci-Fi",
            releasedDate = "2015, 1 May",
            link = "https://www.youtube.com/watch?v=tmeOjFno6Do"
        ),
    )
}