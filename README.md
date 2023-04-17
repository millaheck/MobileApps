INTRODUCTION

  This assignment consisted in the development of a Movie Booking App where students had to create a Movie Class, obtain and fill in data 
from at least four movies, generate a random number between 0 and 15 for each movie and assign to seats_remaining, start with an initial 
default seats_selected value of 0 for all movies, build a Recycler View using the specified template, if any seats are selected, show 
how many seats are selected and hide remaining seats.

DEVELOPING THE MOVIE BOOKING APP

  The development of this application generated many difficulties, since it is much more complex than what the students previously had to 
develop in the classroom.
However the attempt, the error, generates learning and should also be valued, to reach a very good result, the professional often goes through 
many challenges until he succeeds. And this report is about that, it brings the difficulties and the results achieved.

   At first after completing the codes, there were many errors that prevented the file from running properly. So it was necessary to fix the errors 
one by one, a lot of time was spent on this. When the file had no more errors, it run properly, however the movie list was not showing. It took 
a lot more time doing research to find out the reason and try to solve it.

  The app uses the Retrofit library to make HTTP requests to the API and the Gson library to convert the JSON response into MovieResponse and 
Movie objects.
  The MovieApiInterface.kt file defines an interface with an HTTP GET request to the API endpoint that returns a list of popular movies.
  The MovieApiService.kt file defines a single Retrofit instance that uses MovieApiInterface.kt to create a MovieApiInterface service.
  The Movie.kt file defines the Movie data class with four properties: id, title, poster and release. As this was a first time building an 
application like this, the intention was to do a basic test and then include all the professor's requests.
  The MainActivity.kt file configures the RecyclerView and calls the getMovieData function which retrieves the list of popular movies from 
the API using the MovieApiInterface service. The app then uses the MovieAdapter to display the retrieved list of movies in the RecyclerView.
The MovieAdapter.kt file defines the MovieAdapter class which extends the RecyclerView.Adapter class and displays the list of movies in the 
RecyclerView. The onCreateViewHolder function inflates the movie_item.xml layout file that displays the movie's poster and title. The 
onBindViewHolder function binds the movie poster and title to ImageView and TextView respectively.

  The activity_main.xml file defines the UI for the application's main screen, while the movie_item.xml file defines the UI for each item in the 
movie list.
  The activity_main.xml file starts with the XML version declaration and the encoding used. Next, a ConstraintLayout is defined, which is a 
layout used to create flexible and responsive screens. The ConstraintLayout contains a NestedScrollView, which allows you to scroll when the 
content doesn't fit on the screen. Inside the NestedScrollView is a LinearLayout that contains various UI elements such as an image, two texts 
and a RecyclerView. 
  The RecyclerView is used to display a list of items, in this case the movie list. A RecyclerView is defined with the id "rv_movies_list". 
The movie_item.xml file defines the UI for each item in the movie list. It starts with the XML version declaration and the encoding used. Next, 
a ConstraintLayout with an ImageView and two TextViews is defined. The ImageView displays the movie poster and the TextViews display the movie 
title and release date.

CONCLUSION

Developing this application took a lot of work, it took a lot of time, many hours which consequently harmed other subjects, and the result was 
not as expected. Which generates some frustration since there was initial enthusiasm to create something cool, but after working a few weeks 
on it, it is expected that at least the effort and work done in terms of codes will be valued.


