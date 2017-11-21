# Kohonen Clusterer
Given an M*N matrix of randomly coloured pixels, use a Kohonen Self-Organising map algorithm to cluster the pixels such
that same/similar coloured pixels appear together. Just run it, it's kinda cool to watch it iterate.

Much inspiration taken from [ai-junkie](http://www.ai-junkie.com/ann/som/som1.html).

# Build / Run
Simple Java app, uses Swing to show a basic UI. Although I used IntelliJ to build this you can do it all from the
commandline without any IDE. It uses maven and I compiled using JDK 1.8.

    mvn compile
    java -cp target/classes KohonenClusterer

# Options
In [KohonenClusterer](/src/main/java/KohonenClusterer.java).main() you can change the training sets to use some
hard-coded articles or a folder with some text files (articles). The idea here is to cluster similar articles together.
In this case we're not saying what the articles are about (ie. not assigning a label/category), just that based on the
words in the articles some are more similar to each other than others. I have been trying to assign colours to articles
so that during the clustering you can visually see the similar articles coming together. Clustering kinda works, the
colours don't. Call it a work in progress. Any suggestions?

Mousing over pixels shows you the words behind it.

In [MyPanel](src/main/java/com/tobyandzuzka/som/ui/MyPanel.java).iterationComplete there's a sleep() call to slow down the training so you can see what's going on better. If
you remove it then it'll train faster but won't look as fun.

In [MyPanel](src/main/java/com/tobyandzuzka/som/ui/MyPanel.java).foundBestMatchingUnit() you can comment out the drawSquare() and drawCircle() methods if you like. These just
show the cluster centroids and the "area of influence" for the centroid.
