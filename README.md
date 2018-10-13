![Commusic Logo](/logo/smoothlogoV3.png)

Communal Music - HackUMassVI
Created by Garrison Taylor and Isaac Bleecker

Commusic allows a members of a group to individually queue up youtube videos and then play them all on a single shared computer. With Commusic, there's no need to fight over who can use the aux cord.

The project is split into three primary parts - an "input," an "output," and the backend. Input is a page that shows the current music queue and can add more songs to the queue. Output is the page that plays whatever video is next in the queue. The input and output are two webpages that can either be hosted or run directly as a file. The backend, which connects the input and output and stores the queue, is a Java application that needs to be run on a computer that is accessible by both input and output.

Multiple instances of all of them can run at the same time, all connecting to one backend, although running multiple instances of the output side will achieve potentially counterintuitive results.

To run the backend: 

1) Forward the port 8080, allowing connections to the server

  sudo ufw allow 8080/tcp

2) Run the server application

  cd backend
  ./gradlew bootRun

To run either the input or the output, change `input/commusic.html` and `output/outputpage.html` respectively, setting `backend_url` to the url of the backend, with ":8080/output" appended. Then, run either one in a webbrowser of your choice. For best results, open the output page in fullscreen.
