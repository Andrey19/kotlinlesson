
data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val isAdmin: Boolean,
    val context: String,
    val likes: Int,
)

object wallService{
    var posts = emptyArray<Post>()

    fun addPost(post: Post): Post{
        posts += post
        return posts.last()
    }

    fun printPosts(){
        println("------------------------------------------------------------")
        println("---------------------Posts---------------------------")
        for (post in posts){
            println(post)
        }
    }

}



fun main() {

    val post1 = Post( 1,1,"kolya", true,"", 0)
    println(post1)
    println()
    val post2 = Post( 2,2,"Vity", true,"", 3)
    println(post2)
    println("-------------------------------------------")
    wallService.addPost(post1)
    wallService.addPost(post2)
    wallService.printPosts()





}