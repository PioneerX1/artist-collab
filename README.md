## Artist Collab

A Spark/Java-based web app that brings artists of all mediums together to collaborate, start projects, find team members, and provide on-going communication for the duration of their projects.

#### By _**Mick Sexton, Alena Golovina, Anna Kuznetsova, Anna Timofeyeva**_

### Description

Artist Collab is a web application for artists who want to find other like-minded creative individuals to collaborate with. Whether you want to jam or start a band, film a movie, take a painting class together, or code a video game, it takes a diverse range of talent and skills to bring a big project to fruition. Artist Collab can help you find talent across the globe or in your local community based on other artists' skills or proximity.

Or maybe you don't want to start a whole project yourself. Maybe you want to lend your amazing talents to someone in need. Whether you are an editing guy who wants to help out a local filmmaker, or an amazing banjo player willing to lend your dexterity on a studio track, or a talented mural painter looking for a spot to legally put up your work, Artist Collab can help you find the right avenue for your abilities and expertise.

### Setup

* `In psql CREATE DATABASE artist_collab;`
* `In separate terminal, run: psql artist_collab < media.sql;`
* `Gradle Run;`
* _Open a browser and go to localhost:4567_

## Code Specs

|Behavior - Plain English|Input|Output|
|---|---|---|
|User sees home page where they can join/create account, login, or access sidebar.|User clicks sidebar and then About to learn more about Artist-Collab.|User directed to About page.|
|User sees About page where they read about Artist-Collab.|User clicks Keep Calm and Collaborate On.|User is directed back to Home page.|
|User is on home page.|User fills out username and password in login.|User is directed to their account profile page if matching login.|
|User is on account profile page where they can access account info, update, delete account, etc.|User hits update.|User directed to update form where they can put in new information, swap out profile picture.|
|User hits Join Up from home page and sees form for adding a new user.|User fills out basic minimum details to start an account.|User directed to their new profile page once they submit.|
|User adds a project from profile page and sees a new project form.|User fills in basic requirements for new project.|User is directed to the project details page for this new project.|
|User selects add member to a project from project details page and is now on project-add-member form.|User types in a username, currently needs exact spelling and case, but also lists all users in database below for reference.|User is directed back to their project details page with the newly added user displayed.|
|After selecting remove project member, user is directed to a screen asking to type in a member and hit Remove.|User types in a member and hits Remove button.|User is directed back to project details page.|
|User is on the project details page.|If they are the host for the project, they can access options to delete project, add members, remove members, and update the project. If not they can simply view the details of project, and post a message or note down below. They post a note.|User's screen refreshes the page with the note added below.|
|User is on their profile page.|User clicks on search for users by clicking on that statement below or from the option in the sidebar on the left.|User is directed to a search form for users by skills or location.|
|User is on their profile page.|User clicks on search for projects by clicking on that statement below or from the option in the sidebar on the left.|User is directed to a search form for projects by keywords in description or location.|
|On either project or users search form, user sees options to search.|User types a word in skills, description, or location field.|Page refreshes with new search results based on their search term.|


## Known Bugs

_No known issues or bugs at this time_

## Support and contact details

_Please contact Mick Sexton at lacrookedbeat@hotmail.com for any questions, feedback, or concerns._

## Technologies Used

_Technologies used include Java, Atom, Git, Gradle, GitHub, Spark, CSS, J-Unit, Postgres, SQL database, and Velocity Template Engine_

### License

*This software operates under the MIT license.*

Copyright (c) 2017 **_Mick Sexton, Alena Golovina, Anna Kuznetsova, Anna Timofeyeva_**
