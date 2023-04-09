Created this project to learn and practice code!

On the first version I had to work a many to many with extra column relationship that was throwing a Stackoverflow error, this link helped me A LOT [https://github.com/tericcabrel/blog-tutorials/blob/main/springboot-many-to-many-2/src/main/java/com/tericcabrel/movie/entities/UserMovie.java]

After trying the solution what I learnt was:

1. First, we need to save the "owner" of the relation, on this example the Book entity.
2. After saving it, we'll need to build the many-to-many middle entity, on this example called AuthorsCut, which need an Embedded ID, which is called AuthorsCutId.
  Notice that we're not using the AuthorsCutId's constructor where the objects (Book and Author) are inserted, we only need their IDs and then we populate them after the object is instantiated.
3. After instantiating it, we can set the Author and Book objects and actually save it as an "extra" entity and it'll work perfectly.
  Note that we don't populate the "AuthorsCut" set on the Book entity and save it again, probably that'll throw the same exception but at this stage, our objective is completed.
